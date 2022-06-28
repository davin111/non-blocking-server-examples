package com.davin111.examplenonblockingkotlin

import com.davin111.examplenonblockingkotlin.client.AccountClient
import com.davin111.examplenonblockingkotlin.client.MembershipClient
import com.davin111.examplenonblockingkotlin.dto.ContentDto
import com.davin111.examplenonblockingkotlin.dto.ContentsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service

@Service
class ContentService(
    private val contentRepository: ContentRepository,
    private val accountClient: AccountClient,
    private val membershipClient: MembershipClient,
) {
    suspend fun getContentsFree(): ContentsDto {
        return ContentsDto(contentRepository.findByIsPremiumFalse().map { ContentDto(it) })
    }

    suspend fun getContentsPremium(userId: Long): ContentsDto {
        val deferredBooleans = coroutineScope {
            listOf(
                async(Dispatchers.IO) {
                    accountClient.getAccountResponse(userId).isActive
                },
                async(Dispatchers.IO) {
                    membershipClient.getMembershipResponse(userId).hasMembership
                }
            )
        }.awaitAll()

        val contents = if (deferredBooleans.all { it }) contentRepository.findByIsPremiumTrue() else emptyList()
        return ContentsDto(contents.map { ContentDto(it) })
    }
}
