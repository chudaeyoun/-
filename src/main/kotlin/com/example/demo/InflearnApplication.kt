package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class InflearnApplication

fun main(args: Array<String>) {
    runApplication<InflearnApplication>(*args)
}
