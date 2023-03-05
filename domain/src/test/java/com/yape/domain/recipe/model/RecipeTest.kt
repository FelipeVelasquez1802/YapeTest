package com.yape.domain.recipe.model

import com.yape.domain.databuilder.recipe.RecipeDataBuilder
import com.yape.domain.exception.BadUrlException
import com.yape.domain.exception.EmptyListException
import com.yape.domain.exception.EmptyValueException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

internal class RecipeTest {

    private fun buildDataBuilder() = RecipeDataBuilder()

    @Test
    fun `Given the creation Recipe When is empty Name Then return EmptyValueException`() {
        val emptyName = ""
        val dataBuilder = buildDataBuilder().withName(name = emptyName)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation Recipe When is empty Description Then return EmptyValueException`() {
        val emptyDescription = ""
        val dataBuilder = buildDataBuilder().withDescription(description = emptyDescription)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation Recipe When is empty Image Then return EmptyValueException`() {
        val emptyImage = ""
        val dataBuilder = buildDataBuilder().withImage(image = emptyImage)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation Recipe When is bad url Image Then return BadUrlException`() {
        val badImage = "badImage"
        val dataBuilder = buildDataBuilder().withImage(image = badImage)
        try {
            dataBuilder.build()
            fail("Expected ${BadUrlException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is BadUrlException)
        }
    }

    @Test
    fun `Given the creation Recipe When is empty Ingredients Then return EmptyListException`() {
        val emptyIngredients: List<Ingredient> = emptyList()
        val dataBuilder = buildDataBuilder().withIngredients(emptyIngredients)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyListException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyListException)
        }
    }

    @Test
    fun `Given the creation Recipe When is all correct field Then return Object`() {
        val name = "Name"
        val description = "Description"
        val image = "www.image.com/image.png"
        val recipe = buildDataBuilder()
            .withName(name)
            .withDescription(description)
            .withImage(image)
            .build()
        assertEquals(name, recipe.name)
        assertEquals(description, recipe.description)
        assertEquals(image, recipe.image)
    }
}