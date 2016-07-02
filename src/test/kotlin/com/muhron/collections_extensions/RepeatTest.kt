package com.muhron.collections_extensions

import com.taroid.knit.should
import org.junit.Assert
import org.junit.Test

class RepeatTest {
    @Test
    fun testRepeat() {
        repeat(1).take(3).toList().should be listOf(1, 1, 1)
    }
}
