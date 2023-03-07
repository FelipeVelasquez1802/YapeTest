package com.yape.recipebooktest.map.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yape.domain.recipe.model.Location
import com.yape.recipebooktest.R
import com.yape.recipebooktest.common.screen.AppBarScreen
import com.yape.recipebooktest.common.screen.ErrorScreen
import com.yape.recipebooktest.map.mapper.LocationMapper
import com.yape.recipebooktest.map.model.KeyLocationFieldEnum
import com.yape.recipebooktest.map.model.LocationView
import com.yape.recipebooktest.map.screen.MapScreen
import com.yape.recipebooktest.ui.theme.RecipeBookTestTheme

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
                    val onUpdate: ()->Unit = {
                        recreate()
                    }
                    val location = intent.getLocationOrNull()
                    location?.let { Map(location = it) } ?: run {
                        ErrorScreen(onUpdate = onUpdate)
                    }
                }
            }
        }
    }

    private fun Intent.getLocationOrNull(): Location? {
        val location: LocationView? = extras?.getParcelable(KeyLocationFieldEnum.LOCATION_KEY.name)
        return location?.let { LocationMapper.fromViewToDomain(location) }
    }
}

@Composable
private fun Map(location: Location) {
    Column {
        AppBarScreen(titleRes = R.string.title_map)
        MapScreen(location = location)
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