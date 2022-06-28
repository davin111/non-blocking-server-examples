package com.davin111.examplenonblockingkotlin

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("content")
class Content(
    @Id
    val id: Long,

    val name: String,

    val isPremium: Boolean,

    val imageUrl: String?,

    val videoUrl: String?,
)
