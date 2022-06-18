package com.kotlinspring.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingService {

    //lateinit : spring 뜨고 나서 초기화됨.
    @Value("\${message}")
    lateinit var message: String
    fun retrieveGreeting(name : String) = "$name, $message"
}