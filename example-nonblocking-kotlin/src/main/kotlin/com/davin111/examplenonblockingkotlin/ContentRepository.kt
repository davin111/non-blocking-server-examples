package com.davin111.examplenonblockingkotlin

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContentRepository : CoroutineCrudRepository<Content, Long> {
    suspend fun findByIsPremiumFalse(): List<Content>
    suspend fun findByIsPremiumTrue(): List<Content>
}
