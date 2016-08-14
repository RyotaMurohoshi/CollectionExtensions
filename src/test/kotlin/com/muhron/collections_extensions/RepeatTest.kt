package com.muhron.collections_extensions

import org.junit.Assert
import org.junit.Test

class RepeatTest {
    @Test
    fun testRepeat() {
        Assert.assertEquals(listOf(1, 1, 1), repeat(1).take(3).toList())
    }
}
