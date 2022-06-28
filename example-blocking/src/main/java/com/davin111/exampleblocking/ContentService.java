package com.davin111.exampleblocking;

import com.davin111.exampleblocking.client.AccountClient;
import com.davin111.exampleblocking.client.AccountResponse;
import com.davin111.exampleblocking.client.MembershipClient;
import com.davin111.exampleblocking.client.MembershipResponse;
import com.davin111.exampleblocking.dto.ContentDto;
import com.davin111.exampleblocking.dto.ContentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final AccountClient accountClient;
    private final MembershipClient membershipClient;

    public ContentsDto getContentsFree() {
        List<ContentDto> contents = contentRepository.findByIsPremiumFalse().stream()
                .map(ContentDto::new).toList();

        return new ContentsDto(contents);
    }

    public ContentsDto getContentsPremium(Long userId) {
        AccountResponse accountResponse = accountClient.getAccountResponse(userId);
        MembershipResponse membershipResponse = membershipClient.getMembershipResponse(userId);

        List<ContentDto> contents;
        if (accountResponse.getIsActive() && membershipResponse.getHasMembership()) {
            contents = contentRepository.findByIsPremiumTrue().stream()
                    .map(ContentDto::new).toList();
        } else {
            contents = Collections.emptyList();
        }
        return new ContentsDto(contents);
    }
}
