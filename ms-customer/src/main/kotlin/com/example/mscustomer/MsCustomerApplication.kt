package com.example.mscustomer

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

class MsCustomerApplication {
	@Bean
	fun converter(): Jackson2JsonMessageConverter {
		return Jackson2JsonMessageConverter()
	}
}

fun main(args: Array<String>) {
	runApplication<MsCustomerApplication>(*args)
}
