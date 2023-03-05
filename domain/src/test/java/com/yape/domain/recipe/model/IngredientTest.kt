package com.yape.domain.recipe.model

import com.yape.domain.databuilder.recipe.IngredientDataBuilder
import com.yape.domain.exception.EmptyValueException
import com.yape.domain.exception.NegativeNumberException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

internal class IngredientTest {

    private fun buildDataBuilder() = IngredientDataBuilder()

    @Test
    fun `Given the creation Ingredient When is empty Name Then return EmptyValueException`() {
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
    fun `Given the creation Ingredient When is negative Amount Then return NegativeNumberException`() {
        val negativeAmount = -1.0
        val dataBuilder = buildDataBuilder().withAmount(amount = negativeAmount)
        try {
            dataBuilder.build()
            fail("Expected ${NegativeNumberException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is NegativeNumberException)
        }
    }

    @Test
    fun `Given the creation Ingredient When is empty Unit Then return EmptyValueException`() {
        val emptyUnit = ""
        val dataBuilder = buildDataBuilder().withUnit(unit = emptyUnit)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }

    @Test
    fun `Given the creation Ingredient When is corret fields Then return Object`() {
        val name = "apple"
        val amount = 0.26
        val unit = "cup"
        val ingredient = buildDataBuilder()
            .withName(name)
            .withAmount(amount)
            .withUnit(unit)
            .build()
        assertEquals(name, ingredient.name)
        assertEquals(amount, ingredient.amount, 0.0)
        assertEquals(unit, ingredient.unit)
    }
}