package com.davin111.examplenonblockingkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExampleNonblockingKotlinApplication

fun main(args: Array<String>) {
	runApplication<ExampleNonblockingKotlinApplication>(*args)
}
