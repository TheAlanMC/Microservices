package com.example.mscustomer.consumer

import com.example.mscustomer.dto.NotificationDto
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class NotificationConsumer {

    @RabbitListener (queues = ["notification2Queue"])
    fun consumeNotification(notificationDto: NotificationDto){
        println("Message received: $notificationDto")
    }
}