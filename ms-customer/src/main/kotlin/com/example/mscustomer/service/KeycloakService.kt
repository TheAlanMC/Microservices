package com.example.mscustomer.service

import com.example.mscustomer.dto.TokenRequestDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "ms-security", url= "http://localhost:8090/realms/software/protocol/openid-connect")
interface KeycloakService {

    @PostMapping("/token", consumes = ["application/x-www-form-urlencoded"])
    fun getToken(tokenRequestDto: TokenRequestDto): String
}

