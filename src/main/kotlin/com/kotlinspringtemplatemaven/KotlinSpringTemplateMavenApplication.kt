package com.kotlinspringtemplatemaven

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class KotlinSpringTemplateMavenApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinSpringTemplateMavenApplication::class.java, *args)
}
