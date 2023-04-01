package com.example.mscustomer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class TokenResponseDto (
    val access_token: String,
    val expires_in: Long,
    val refresh_expires_in: Long,
    val token_type: String,
    val scope: String
)
