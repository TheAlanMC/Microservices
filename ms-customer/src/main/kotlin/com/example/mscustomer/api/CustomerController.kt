package com.example.mscustomer.api

import com.example.mscustomer.dto.TokenResponseDto
import com.example.mscustomer.dto.TokenRequestDto

import com.example.mscustomer.service.AccountService
import com.example.mscustomer.service.CurrencyService
import com.example.mscustomer.service.KeycloakService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/customer")
class CustomerController @Autowired constructor(val accountService: AccountService, val keycloakService: KeycloakService,val currencyService: CurrencyService) {

    @Value("\${server.port}")
    lateinit var port: String

    @RequestMapping("/test")
    fun test():String{
        val accountPort:String = accountService.test()
        return ("Customer: $port - Account: $accountPort")
    }

    @RequestMapping("/list")
    fun getCustomers(): List<String> {
        val customerList:List<String> = listOf("Customer 1", "Customer 2", "Customer 3")
        val accountList:List<String> = accountService.getAccounts()
        return customerList + accountList
    }

    @RequestMapping("/token")
    fun getToken(): TokenResponseDto {
        val tokenRequestDto =
            TokenRequestDto("code", "client_credentials", "backend", "RQ7Fdx7IHKHjbQu8hVDjmKINk8DlLQqp")
        return keycloakService.getToken(tokenRequestDto)
    }

    @RequestMapping("/currency")
    fun getCurrency(
        @RequestParam to: String,
        @RequestParam from: String,
        @RequestParam amount: BigDecimal
    ): String {
        val tokenResponseDto = getToken()
        val token = tokenResponseDto.token_type + " " + tokenResponseDto.access_token
        return try {
            currencyService.getCurrency(to, from, amount, token)
        } catch (e: Exception) {
            e.message.toString()
        }
    }

}