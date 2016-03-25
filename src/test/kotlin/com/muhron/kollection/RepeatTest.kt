package com.muhron.kollection

import com.taroid.knit.should
import org.junit.Assert
import org.junit.Test

class RepeatTest {
    @Test
    fun testRepeat() {
        repeat(1).take(3).toList().should be listOf(1, 1, 1)
    }
}
