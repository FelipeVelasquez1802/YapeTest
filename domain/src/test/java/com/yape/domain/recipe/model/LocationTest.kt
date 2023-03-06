package com.yape.domain.recipe.model

import com.yape.domain.databuilder.recipe.LocationDataBuilder
import com.yape.domain.exception.EmptyValueException
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

internal class LocationTest {
    @Test
    fun `Given the creation Location When is empty Name Then return EmptyValueException`() {
        val emptyName = ""
        val dataBuilder = LocationDataBuilder().withName(emptyName)
        try {
            dataBuilder.build()
            fail("Expected ${EmptyValueException::class.java.name}")
        } catch (exception: Exception) {
            assertTrue(exception is EmptyValueException)
        }
    }
}