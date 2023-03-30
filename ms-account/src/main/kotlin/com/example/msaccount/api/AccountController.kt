package com.example.msaccount.api

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController {

    @Value("\${server.port}")
    lateinit var port: String

    @GetMapping("/test")
    fun test():String{
        return port;
    }

    @GetMapping("/list")
    fun getAccounts(): List<String> {
        return listOf("Account 1", "Account 2", "Account 3")
    }

}