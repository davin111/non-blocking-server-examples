package com.davin111.exampleblocking.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class AccountClient {

    private final WebClient.Builder webClientBuilder;

//    private WebClient webClient = webClientBuilder.build();

    public AccountResponse getAccountResponse(Long userId) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new AccountResponse(true);
    }
}
