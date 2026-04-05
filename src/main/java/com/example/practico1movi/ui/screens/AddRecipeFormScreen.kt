package com.example.practicomovi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practico2.viewmodels.RecipeViewModel

@Composable
fun AddRecipeFormScreen(navController: NavController, vm: RecipeViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 48.dp)) {
        Text("Nueva Receta", style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = vm.newName.value,
            onValueChange = { vm.newName.value = it },
            label = { Text("Nombre de la receta") }
        )

        Spacer(Modifier.height(16.dp))
        Row {
            OutlinedTextField(
                value = vm.newIngredient.value,
                onValueChange = { vm.newIngredient.value = it },
                label = { Text("Ingrediente") },
                modifier = Modifier.weight(1f)
            )
            Spacer(Modifier.width(8.dp))
            Button(onClick = { vm.addIngredientToNewRecipe() }) {
                Text("Agregar")
            }
        }

        LazyColumn {
            items(vm.newIngredients) { ing ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(ing)
                    TextButton(onClick = { vm.removeIngredientFromNewRecipe(ing) }) {
                        Text("Eliminar")
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        OutlinedTextField(
            value = vm.newPreparation.value,
            onValueChange = { vm.newPreparation.value = it },
            label = { Text("Preparación") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            vm.saveNewRecipe()
            navController.popBackStack("ingredientes", inclusive = false)
        }) {
            Text("Guardar Receta")
        }
    }
}
