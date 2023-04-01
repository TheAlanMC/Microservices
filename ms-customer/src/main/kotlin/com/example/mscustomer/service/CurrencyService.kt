package com.example.mscustomer.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigDecimal

@FeignClient(name = "currency-converter")
interface CurrencyService {

    @GetMapping("/v1/api/currency", consumes = ["application/json"])
    fun getCurrency(
        @RequestParam to: String,
        @RequestParam from: String,
        @RequestParam amount: BigDecimal,
        @RequestHeader("Authorization") token: String
    ): String

}

