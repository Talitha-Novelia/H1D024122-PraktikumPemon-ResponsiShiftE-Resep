package com.pemob.utspemob.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemob.utspemob.ui.detail.DetailScreen
import com.pemob.utspemob.ui.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(onNavigateToDetail = { idMeal ->
                navController.navigate("detail/$idMeal")
            })
        }
        composable(
            route = "detail/{idMeal}",
            arguments = listOf(navArgument("idMeal") { type = NavType.StringType })
        ) { backStackEntry ->
            val idMeal = backStackEntry.arguments?.getString("idMeal") ?: return@composable
            DetailScreen(
                idMeal = idMeal,
                onNavigateBack = { navController.navigateUp() }
            )
        }
    }
}
