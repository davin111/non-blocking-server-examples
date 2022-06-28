package com.davin111.examplenonblocking;

import com.davin111.examplenonblocking.client.AccountClient;
import com.davin111.examplenonblocking.client.AccountResponse;
import com.davin111.examplenonblocking.client.MembershipClient;
import com.davin111.examplenonblocking.client.MembershipResponse;
import com.davin111.examplenonblocking.dto.ContentDto;
import com.davin111.examplenonblocking.dto.ContentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final AccountClient accountClient;
    private final MembershipClient membershipClient;

    public Mono<ContentsDto> getContentsFree() {
        return contentRepository.findByIsPremiumFalse()
                .map(ContentDto::new)
                .collectList()
                .map(ContentsDto::new);
    }

    public Mono<ContentsDto> getContentsPremium(Long userId) {
        Mono<Boolean> isActiveMono = accountClient.getAccountResponse(userId)
                .map(AccountResponse::getIsActive);
        Mono<Boolean> hasMembershipMono = membershipClient.getMembershipResponse(userId)
                .map(MembershipResponse::getHasMembership);

        return Mono.zip(isActiveMono, hasMembershipMono)
                .flatMapMany(tuple -> {
                    if (tuple.getT1() && tuple.getT2()) {
                        return contentRepository.findByIsPremiumTrue();
                    }
                    return Flux.empty();
                })
                .map(ContentDto::new).collectList()
                .map(ContentsDto::new);
    }

    public Mono<ContentsDto> getContentsPremiumWrong(Long userId) {
        Boolean isActive = accountClient.getAccountResponse(userId)
                .map(AccountResponse::getIsActive).block();
        Boolean hasMembership = membershipClient.getMembershipResponse(userId)
                .map(MembershipResponse::getHasMembership).block();

        return Mono.zip(Mono.just(true), Mono.just(true))
                .flatMapMany(tuple -> {
                    if (tuple.getT1() && tuple.getT2()) {
                        return contentRepository.findByIsPremiumTrue();
                    }
                    return Flux.empty();
                })
                .map(ContentDto::new).collectList()
                .map(ContentsDto::new);
    }
}
