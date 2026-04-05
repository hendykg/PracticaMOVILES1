package com.example.practicomovi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practico2.viewmodels.RecipeViewModel

@Composable
fun AddRecipeScreen(navController: NavController, vm: RecipeViewModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 48.dp)) {
        Text("No se encontraron recetas.", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { navController.navigate("agregar_receta") }) {
            Text("Agregar nueva receta")
        }
    }
}
