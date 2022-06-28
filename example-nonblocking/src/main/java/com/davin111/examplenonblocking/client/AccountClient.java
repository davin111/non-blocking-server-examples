package com.davin111.examplenonblocking.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AccountClient {

    private WebClient.Builder webClientBuilder;

//    private WebClient webClient = webClientBuilder.build();

    public Mono<AccountResponse> getAccountResponse(Long userId) {
        return Mono.just(new AccountResponse(true)).delayElement(Duration.ofSeconds(3));
    }
}
