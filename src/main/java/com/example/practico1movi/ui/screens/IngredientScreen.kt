package com.example.practicomovi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practico2.viewmodels.RecipeViewModel

@Composable
fun IngredientScreen(navController: NavController, vm: RecipeViewModel) {
    val ingredientes = listOf("Arroz", "Carne", "Huevo", "Pollo", "Verduras", "Maní", "Papas")

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 48.dp)) {
        Text("Selecciona los ingredientes:", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        ingredientes.forEach { ing ->
            val isSelected = vm.selectedIngredients.any { it.equals(ing, ignoreCase = true) }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(ing)
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = { vm.toggleIngredient(ing) }
                )
            }
        }

        Spacer(Modifier.height(20.dp))
        Button(onClick = {
            vm.searchRecipes()
            if (vm.foundRecipes.isEmpty()) {
                navController.navigate("sin_resultados")
            } else {
                navController.navigate("recetas_disponibles")
            }
        }) {
            Text("Buscar Recetas")
        }
    }
}
