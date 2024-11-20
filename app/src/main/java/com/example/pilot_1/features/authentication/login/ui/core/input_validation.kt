package com.example.pilot_1.features.authentication.login.ui.core

object InputValidation{
    fun validateUsername(value:String) : String {
        return when{
            value.isEmpty() -> "Please write your email"
            value.length <= 3 -> "should be more than 3 characters"
            else -> ""
        }
    }
    fun validateEmail(value:String) : String {
        return when{
            value.isEmpty() -> "Please write your email"
            Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})").matches(value).not() -> "Please enter a valid email"
            else -> ""
        }
    }
    fun validatePassword(value:String) : String {
        return when{
            value.isEmpty() -> "Please enter the password"
            value.length <= 6 -> "should be more than 6 characters"
            else -> ""
        }
    }
}