package com.yape.recipebooktest.recipe.router

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import com.yape.domain.recipe.model.Location
import com.yape.domain.recipe.model.Recipe
import com.yape.recipebooktest.YapeApplication
import com.yape.recipebooktest.map.activity.MapActivity
import com.yape.recipebooktest.map.mapper.LocationMapper
import com.yape.recipebooktest.map.model.KeyLocationFieldEnum
import com.yape.recipebooktest.recipe.activity.RecipeDetailActivity
import com.yape.recipebooktest.recipe.mapper.RecipeMapper
import com.yape.recipebooktest.recipe.model.KeyRecipeFieldEnum

internal class RecipeRouter {
    private val context = YapeApplication.getContext()
    fun goToRecipeDetail(recipe: Recipe) {
        context?.apply {
            val recipeView = RecipeMapper.fromDomainToView(recipe)
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(KeyRecipeFieldEnum.RECIPE_KEY.name, recipeView)
            startActivity(intent)
        }
    }

    fun goToMap(location: Location) {
        context?.apply {
            val locationView = LocationMapper.fromDomainToView(location)
            val intent = Intent(this, MapActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra(KeyLocationFieldEnum.LOCATION_KEY.name, locationView)
            startActivity(intent)
        }
    }

    fun goToBack(context: Context) {
        when (context) {
            is ComponentActivity -> context.finish()
        }
    }
}