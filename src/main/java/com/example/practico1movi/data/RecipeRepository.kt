package com.example.practicomovi.data

import androidx.compose.runtime.mutableStateListOf

object RecipeRepository {

    private val recipes = mutableStateListOf(
        Recipe("Majadito", listOf("Arroz", "Carne", "Huevo"), "Cocer el arroz, freír la carne, mezclar."),
        Recipe("Arroz a la Valenciana", listOf("Arroz", "Pollo", "Verduras"), "Freír pollo y verduras, añadir arroz."),
        Recipe("Sopa de Mani", listOf("Maní", "Papas", "Carne"), "Hervir maní molido con carne y papas.")
    )

    fun getAll(): List<Recipe> = recipes

    fun findByIngredients(selected: List<String>): List<Recipe> {
        if (selected.isEmpty()) return emptyList()
        val selectedLower = selected.map { it.trim().lowercase() }
        return recipes.filter { recipe ->
            val recipeLower = recipe.ingredients.map { it.trim().lowercase() }
            selectedLower.all { it in recipeLower }
        }
    }

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }
}
