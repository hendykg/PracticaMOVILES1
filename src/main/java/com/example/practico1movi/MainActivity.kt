package com.example.practico2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practico2.screens.AddRecipeFormScreen
import com.example.practico2.screens.AddRecipeScreen
import com.example.practico2.screens.IngredientScreen
import com.example.practico2.screens.RecipeDetailScreen
import com.example.practico2.screens.ResultScreen
import com.example.practico2.ui.theme.Practico2Theme
import com.example.practico2.viewmodels.RecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practico2Theme {
                val navController = rememberNavController()
                val vm: RecipeViewModel = viewModel() // ✅ ViewModel compartido

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "ingredientes") {
                        composable("ingredientes") { IngredientScreen(navController, vm) }
                        composable("recetas_disponibles") { ResultScreen(navController, vm) }
                        composable("detalle_receta") { RecipeDetailScreen(navController, vm) }
                        composable("sin_resultados") { AddRecipeScreen(navController, vm) }
                        composable("agregar_receta") { AddRecipeFormScreen(navController, vm) }
                    }
                }
            }
        }
    }
}
