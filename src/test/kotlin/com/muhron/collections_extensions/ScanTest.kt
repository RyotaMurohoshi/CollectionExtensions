package com.muhron.collections_extensions

import com.muhron.collections_extensions.Direction.*
import com.taroid.knit.should
import org.junit.Assert
import org.junit.Test

class ScanTest {
    @Test
    fun testTSource() {
        val actual = listOf(1, 2, 3, 4, 5).scan { acc: Int, elem: Int -> acc + elem }
        val expected = listOf(3, 6, 10, 15)
        actual.should be expected
    }

    @Test
    fun testTSourceSingle() {
        val actual = listOf(1).scan { acc: Int, elem: Int -> acc + elem }
        val expected = emptyList<Int>()
        actual.should be expected
    }

    @Test
    fun testTSourceEmpty() {
        val actual = emptyList<Int>().scan { acc: Int, elem: Int -> acc + elem }
        val expected = emptyList<Int>()
        actual.should be expected
    }

    @Test
    fun testTSourceTAccumulate() {
        val actual = listOf(Up, Right, Down, Down, Left, Left, Up, Up, Right, Down).scan(
                seed = Point(0, 0),
                accumulator = { point, direction -> point.move(direction) })

        val expected = listOf(
                Point(0, 1),
                Point(1, 1),
                Point(1, 0),
                Point(1, -1),
                Point(0, -1),
                Point(-1, -1),
                Point(-1, 0),
                Point(-1, 1),
                Point(0, 1),
                Point(0, 0)
        )

        actual.should be expected
    }

    @Test
    fun testTSourceTAccumulateSingle() {
        val actual = listOf(Up).scan(
                seed = Point(0, 0),
                accumulator = { point, direction -> point.move(direction) })

        val expected = listOf(Point(0, 1))

        actual.should be expected
    }

    @Test
    fun testTSourceTAccumulateEmpty() {
        val actual = emptyList<Direction>().scan(
                seed = Point(0, 0),
                accumulator = { point, direction -> point.move(direction) })

        val expected = emptyList<Point>()

        actual.should be expected
    }
}