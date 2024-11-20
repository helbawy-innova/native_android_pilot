package com.example.pilot_1.navigation

data class Route(
    val routeName: String,
    val arguments: Any? = null,
)

interface AppRoutes{
    companion object{
        const val login : String = "/login"
        const val splash: String = "/splash"
        const val home: String = "/home"
    }
}