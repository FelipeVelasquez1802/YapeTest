package com.yape.recipebooktest.map.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yape.domain.recipe.model.Location
import com.yape.recipebooktest.map.activity.ui.theme.RecipeBookTestTheme
import com.yape.recipebooktest.recipe.mapper.LocationMapper
import com.yape.recipebooktest.recipe.model.KeyFieldEnum
import com.yape.recipebooktest.recipe.model.LocationView
import com.yape.recipebooktest.recipe.screen.MapScreen

class MapActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeBookTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val location = intent.getLocationOrNull()
                    location?.let { MapScreen(location = it) } ?: run {
                        // TODO: Agregar mensaje de error
                    }
                }
            }
        }
    }

    private fun Intent.getLocationOrNull(): Location? {
        val location: LocationView? = extras?.getParcelable(KeyFieldEnum.LOCATION_KEY.name)
        return location?.let { LocationMapper.fromViewToDomain(location) }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    val location = Location(
        name = "Singapore",
        description = "Marker in Singapore",
        latitude = 1.35,
        longitude = 103.87
    )
    RecipeBookTestTheme {
        MapScreen(location = location)
    }
}