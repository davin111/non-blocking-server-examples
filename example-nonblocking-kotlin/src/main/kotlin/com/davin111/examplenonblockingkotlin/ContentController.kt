package com.davin111.examplenonblockingkotlin

import com.davin111.examplenonblockingkotlin.dto.ContentsDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ContentController(
    private val contentService: ContentService,
) {

    @GetMapping("/v1/contents/free")
    suspend fun contentsFree(): ContentsDto {
        return contentService.getContentsFree()
    }

    @GetMapping("/v1/contents/premium")
    suspend fun contentsPremium(): ContentsDto {
        val userId = 0L
        return contentService.getContentsPremium(userId)
    }
}
