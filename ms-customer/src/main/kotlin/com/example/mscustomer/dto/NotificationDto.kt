package com.example.mscustomer.dto

import java.util.*

data class NotificationDto (
    var message: String = "",
    var type: String = "",
    var date: Date = Date()
)