package com.yape.dataaccess.recipe

import com.yape.dataaccess.recipe.dto.IngredientDto
import com.yape.dataaccess.recipe.dto.LocationDto
import com.yape.dataaccess.recipe.dto.RecipeDto
import javax.inject.Inject

internal class RecipeAdapter @Inject constructor() {
    fun getRecipes(): List<RecipeDto> {
        val ingredients = listOf(
            IngredientDto(name = "banana", amount = 0.25, unit = "cup")
        )
        val location = LocationDto(
            name = "Singapore",
            description = "Marker in Singapore",
            latitude = 1.35,
            longitude = 103.87
        )
        return listOf(
            RecipeDto(
                name = "Ensalada César",
                description = """
                    La Ensalada César es una receta clásica y muy popular en todo el mundo, originaria de México. Esta ensalada se prepara con una base de lechuga romana fresca, crujientes crutones de pan tostado, tiras de pollo a la parrilla y queso parmesano rallado. La ensalada se sirve con una deliciosa salsa César cremosa y llena de sabor, hecha con anchoas, ajo, aceite de oliva, jugo de limón, mostaza dijon, yema de huevo, sal y pimienta.

                    Para preparar la ensalada, primero debes cortar las pechugas de pollo en tiras y sazonarlas con sal y pimienta al gusto. Luego, cocínalas en una parrilla o sartén caliente hasta que estén doradas y cocidas por completo. Una vez que el pollo esté listo, déjalo reposar mientras preparas el resto de la ensalada.

                    A continuación, corta la lechuga romana en trozos grandes y colócalos en un tazón grande para ensalada. Agrega los crutones y el queso parmesano rallado encima de la lechuga.

                    Para hacer la salsa César, primero debes triturar las anchoas y el ajo en un mortero o procesador de alimentos hasta que estén bien combinados. Luego, agrega el aceite de oliva, el jugo de limón, la mostaza dijon y la yema de huevo y bate todo junto hasta que esté suave y cremoso. Agrega sal y pimienta al gusto.

                    Por último, agrega las tiras de pollo a la ensalada y vierte la salsa César por encima. Mezcla todo bien para asegurarte de que la ensalada esté bien cubierta con la salsa. Sirve inmediatamente y disfruta de una deliciosa ensalada César fresca y llena de sabor.
                """,
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                ingredients = ingredients,
                location = location
            ),
            RecipeDto(
                name = "Example 2",
                description = "Description 2",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                ingredients = ingredients,
                location = location
            ),
            RecipeDto(
                name = "Example 3",
                description = "Description 3",
                image = "https://spoonacular.com/recipeImages/716426-312x231.jpg",
                ingredients = ingredients,
                location = location
            ),
            RecipeDto(
                name = "Example 4",
                description = "Description 4",
                image = "www.image.com/image4.png",
                ingredients = ingredients,
                location = location
            )
        )
    }
}