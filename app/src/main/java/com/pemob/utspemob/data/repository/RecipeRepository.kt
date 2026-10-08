package com.pemob.utspemob.data.repository

import com.pemob.utspemob.data.api.RetrofitClient
import com.pemob.utspemob.data.model.Meal

class RecipeRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun searchMeals(query: String): List<Meal>? {
        return try {
            val response = apiService.searchMeals(query)
            response.meals
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getMealById(id: String): Meal? {
        return try {
            val response = apiService.getMealById(id)
            response.meals?.firstOrNull()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
