package com.example.practicomovi.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.practico2.data.Recipe
import com.example.practico2.data.RecipeRepository

class RecipeViewModel : ViewModel() {

    val selectedIngredients = mutableStateListOf<String>()
    val foundRecipes = mutableStateListOf<Recipe>()

    val newName = mutableStateOf("")
    val newIngredient = mutableStateOf("")
    val newIngredients = mutableStateListOf<String>()
    val newPreparation = mutableStateOf("")

    val selectedRecipe = mutableStateOf<Recipe?>(null)

    fun toggleIngredient(ingredient: String) {
        val normalized = ingredient.trim()
        if (selectedIngredients.any { it.equals(normalized, ignoreCase = true) }) {
            selectedIngredients.removeAll { it.equals(normalized, ignoreCase = true) }
        } else {
            selectedIngredients.add(normalized)
        }
    }

    fun searchRecipes() {
        foundRecipes.clear()
        val results = RecipeRepository.findByIngredients(selectedIngredients)
        foundRecipes.addAll(results)
    }

    fun addIngredientToNewRecipe() {
        val ing = newIngredient.value.trim()
        if (ing.isNotEmpty() && !newIngredients.any { it.equals(ing, ignoreCase = true) }) {
            newIngredients.add(ing)
        }
        newIngredient.value = ""
    }

    fun removeIngredientFromNewRecipe(ing: String) {
        newIngredients.remove(ing)
    }

    fun saveNewRecipe() {
        val name = newName.value.trim()
        val prep = newPreparation.value.trim()
        if (name.isNotEmpty() && newIngredients.isNotEmpty()) {
            RecipeRepository.addRecipe(
                Recipe(name = name, ingredients = newIngredients.toList(), preparation = prep)
            )
            newName.value = ""
            newIngredients.clear()
            newPreparation.value = ""
        }
    }

    fun selectRecipe(recipe: Recipe) {
        selectedRecipe.value = recipe
    }
}
