package com.example.mscustomer.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigDecimal

@FeignClient(name = "ms-currency", url= "http://localhost:8080/v1/api/currency")
interface CurrencyService {

    @GetMapping("", consumes = ["application/json"])
    fun getCurrency(
        @RequestParam to: String,
        @RequestParam from: String,
        @RequestParam amount: BigDecimal,
        @RequestHeader("Authorization") token: String
    ): String

}

