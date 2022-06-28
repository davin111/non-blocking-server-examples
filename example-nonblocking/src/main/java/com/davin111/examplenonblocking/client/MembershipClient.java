package com.davin111.examplenonblocking.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class MembershipClient {

    private WebClient.Builder webClientBuilder;

//    private WebClient webClient = webClientBuilder.build();

    public Mono<MembershipResponse> getMembershipResponse(Long userId) {
        return Mono.just(new MembershipResponse(true)).delayElement(Duration.ofSeconds(5));
    }
}
