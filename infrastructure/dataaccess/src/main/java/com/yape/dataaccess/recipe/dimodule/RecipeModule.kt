package com.yape.dataaccess.recipe.dimodule

import com.yape.dataaccess.recipe.RecipeAdapter
import com.yape.dataaccess.recipe.repository.RecipeRepositoryImpl
import com.yape.domain.recipe.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal class RecipeModule {

    @Provides
    fun provideRecipeRepository(recipeAdapter: RecipeAdapter): RecipeRepository =
        RecipeRepositoryImpl(recipeAdapter)
}