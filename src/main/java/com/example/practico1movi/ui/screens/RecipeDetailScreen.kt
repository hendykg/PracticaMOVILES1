package com.example.practicomovi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practico2.viewmodels.RecipeViewModel

@Composable
fun RecipeDetailScreen(navController: NavController, vm: RecipeViewModel) {
    val recipe = vm.selectedRecipe.value
    if (recipe == null) {
        Text("No se encontró la receta.")
        return
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 48.dp)) {
        Text(recipe.name, style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        Text("Ingredientes: ${recipe.ingredients.joinToString(", ")}")
        Spacer(Modifier.height(8.dp))
        Text("Preparación: ${recipe.preparation}")
    }
}
