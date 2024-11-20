package com.example.pilot_1.configurations

interface AppStates{}

class LoadingState : AppStates{}
class ErrorState(val message:String? = null) : AppStates{}
class SuccessState : AppStates{}
class EmptyState : AppStates{}
class InitState : AppStates{}
