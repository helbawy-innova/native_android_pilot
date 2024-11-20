package com.example.pilot_1.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pilot_1.features.authentication.login.data.repos.AuthenticationRepoImp
import com.example.pilot_1.features.authentication.login.ui.screens.LoginScreen
import com.example.pilot_1.features.authentication.login.ui.viewmodels.LoginViewModel
import com.example.pilot_1.features.home.data.repo.HomeRepoImp
import com.example.pilot_1.features.home.ui.screens.HomeScreen
import com.example.pilot_1.features.home.ui.viewmodels.HomeViewModel
import com.example.pilot_1.features.splash.ui.screens.SplashScreen

object Navigator {
    private lateinit var _navController: NavHostController
    private var arguments: Any? = null
    fun push(route: Route, replacement: Boolean = false, clear: Boolean = false) {
        arguments = route.arguments
        _navController.navigate(route.routeName){
            if(replacement) {
                popUpTo(_navController.currentBackStackEntry?.destination?.route ?: "") {
                    inclusive = true
                }
            }
            else if(clear) {
                Log.d("Helbawy", "replacement")
                popUpTo(_navController.graph.startDestinationId) { inclusive = true }
                launchSingleTop = true
            }
        }

    }


    @Composable
    fun navigationComponent() {
        _navController = rememberNavController()
        NavHost(navController = _navController, startDestination = AppRoutes.splash) {
            composable(AppRoutes.splash) {
                SplashScreen()
            }
            composable(AppRoutes.login) {
                LoginScreen(LoginViewModel(authenticationRepo = AuthenticationRepoImp()))
            }
            composable(AppRoutes.home) {
                HomeScreen(HomeViewModel(repo = HomeRepoImp()))
            }

        }
    }
}

