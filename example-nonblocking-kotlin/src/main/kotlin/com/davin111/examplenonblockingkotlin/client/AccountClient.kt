package com.davin111.examplenonblockingkotlin.client

import kotlinx.coroutines.delay
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class AccountClient(
    private val webClientBuilder: WebClient.Builder,
) {

    suspend fun getAccountResponse(userId: Long?): AccountResponse {
        delay(3000)
        return AccountResponse(true)
    }
}
