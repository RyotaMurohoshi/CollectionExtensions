package com.muhron.collections_extensions

import com.taroid.knit.should
import org.junit.Assert
import org.junit.Test

class BufferTest {
    @Test
    fun testBufferCount() {
        val actual = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).buffer(3)
        val expected = listOf(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8), listOf(9))

        actual.should be expected
    }

    @Test
    fun testBufferCountSmallList() {
        val actual = listOf(0, 1).buffer(3)
        val expected = listOf(listOf(0, 1))

        actual.should be expected
    }

    @Test
    fun testBufferCountEmpty() {
        val actual = emptyList<Int>().buffer(3)
        val expected = emptyList<List<Int>>()

        actual.should be expected
    }

    @Test
    fun testBufferCount3Skip2() {
        val actual = listOf(0, 1, 2, 3, 4, 5, 6).buffer(count = 3, skip = 2)
        val expected = listOf(listOf(0, 1, 2), listOf(2, 3, 4), listOf(4, 5, 6), listOf(6))

        actual.should be expected
    }

    @Test
    fun testBufferCount3Skip4() {
        val actual = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8).buffer(count = 3, skip = 4)
        val expected = listOf(listOf(0, 1, 2), listOf(4, 5, 6), listOf(8))

        actual.should be expected
    }

    @Test
    fun testBufferCount3Skip1SmallList() {
        val actual = listOf(0, 1).buffer(3, 1)
        val expected = listOf(listOf(0, 1), listOf(1))

        actual.should be expected
    }

    @Test
    fun testBufferCount2Skip3SmallList() {
        val actual = listOf(0, 1).buffer(2, 3)
        val expected = listOf(listOf(0, 1))

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun testBufferCount3Skip2Empty() {
        val actual = emptyList<Int>().buffer(3, 2)
        val expected = emptyList<List<Int>>()

        actual.should be expected
    }

    @Test
    fun testBufferCount3Skip4Empty() {
        val actual = emptyList<Int>().buffer(3, 4)
        val expected = emptyList<List<Int>>()

        actual.should be expected
    }
}
