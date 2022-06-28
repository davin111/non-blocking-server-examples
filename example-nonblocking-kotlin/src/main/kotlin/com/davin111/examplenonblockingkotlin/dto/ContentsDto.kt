package com.davin111.examplenonblockingkotlin.dto

import com.davin111.examplenonblockingkotlin.Content

data class ContentsDto(
    val contents: List<ContentDto>
)

data class ContentDto(
    val id: Long,

    val name: String,

    val isPremium: Boolean,

    val imageUrl: String?,

    val videoUrl: String?,
) {
    constructor(content: Content): this(
        content.id,
        content.name,
        content.isPremium,
        content.imageUrl,
        content.videoUrl,
    )
}
