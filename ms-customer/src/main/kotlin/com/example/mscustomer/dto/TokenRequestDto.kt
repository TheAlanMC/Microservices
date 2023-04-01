package com.example.mscustomer.dto

import feign.form.FormProperty

class TokenRequestDto  (
    @FormProperty("response_type")
    var responseType: String,
    @FormProperty("grant_type")
    var grantType: String,
    @FormProperty("client_id")
    var clientId: String,
    @FormProperty("client_secret")
    var clientSecret: String
)