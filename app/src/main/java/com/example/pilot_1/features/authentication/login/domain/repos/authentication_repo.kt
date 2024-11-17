package com.example.pilot_1.features.authentication.login.domain.repos

interface AuthenticationRepo {
    suspend fun login(username:String,password:String):Boolean
}
