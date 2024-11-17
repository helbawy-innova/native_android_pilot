package com.example.pilot_1.configurations

interface AppState{}

class LoadingState : AppState{}
class ErrorState(val message:String? = null) : AppState{}
class SuccessState : AppState{}
class EmptyState : AppState{}
class InitState : AppState{}
