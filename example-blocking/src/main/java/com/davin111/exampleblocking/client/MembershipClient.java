package com.davin111.exampleblocking.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class MembershipClient {

    private WebClient.Builder webClientBuilder;

//    private WebClient webClient = webClientBuilder.build();

    public MembershipResponse getMembershipResponse(Long userId) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new MembershipResponse(true);
    }
}
