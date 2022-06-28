package com.davin111.examplenonblockingkotlin.client

import kotlinx.coroutines.delay
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class MembershipClient(
    private val webClientBuilder: WebClient.Builder,
) {

    suspend fun getMembershipResponse(userId: Long?): MembershipResponse {
        delay(5000)
        return MembershipResponse(true)
    }
}
