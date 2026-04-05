package com.example.practicomovi.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practico2.viewmodels.RecipeViewModel

@Composable
fun ResultScreen(navController: NavController, vm: RecipeViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 48.dp)) {
        Text("Recetas Encontradas:", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        vm.foundRecipes.forEach { recipe ->
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        vm.selectRecipe(recipe)
                        navController.navigate("detalle_receta")
                    }
            ) {
                Text(
                    recipe.name,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
