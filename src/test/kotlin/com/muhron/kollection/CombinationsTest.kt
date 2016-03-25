package com.muhron.kollection

import com.muhron.kollection.Attribute.*
import com.muhron.kollection.Rank.*
import com.taroid.knit.should
import org.junit.Assert
import org.junit.Test

class CombinationsTest {
    @Test
    fun testCombinationsPair() {
        val actual: List<Pair<String, Attribute>> = combinations(names, Attribute.values().toList())
        val expected = listOf(
                "Honoka" to Smile,
                "Honoka" to Pure,
                "Honoka" to Cool,
                "Eli" to Smile,
                "Eli" to Pure,
                "Eli" to Cool,
                "Kotori" to Smile,
                "Kotori" to Pure,
                "Kotori" to Cool,
                "Umi" to Smile,
                "Umi" to Pure,
                "Umi" to Cool,
                "Rin" to Smile,
                "Rin" to Pure,
                "Rin" to Cool,
                "Maki" to Smile,
                "Maki" to Pure,
                "Maki" to Cool,
                "Nozomi" to Smile,
                "Nozomi" to Pure,
                "Nozomi" to Cool,
                "Hanayo" to Smile,
                "Hanayo" to Pure,
                "Hanayo" to Cool,
                "Nico" to Smile,
                "Nico" to Pure,
                "Nico" to Cool
        )

        actual.should be expected
    }

    @Test
    fun testCombinationsTriple() {
        val actual: List<Triple<String, Attribute, Rank>> =
                combinations(names, Attribute.values().toList(), Rank.values().toList())

        val expected = listOf(
                Triple("Honoka", Smile, R),
                Triple("Honoka", Smile, SR),
                Triple("Honoka", Smile, UR),
                Triple("Honoka", Pure, R),
                Triple("Honoka", Pure, SR),
                Triple("Honoka", Pure, UR),
                Triple("Honoka", Cool, R),
                Triple("Honoka", Cool, SR),
                Triple("Honoka", Cool, UR),
                Triple("Eli", Smile, R),
                Triple("Eli", Smile, SR),
                Triple("Eli", Smile, UR),
                Triple("Eli", Pure, R),
                Triple("Eli", Pure, SR),
                Triple("Eli", Pure, UR),
                Triple("Eli", Cool, R),
                Triple("Eli", Cool, SR),
                Triple("Eli", Cool, UR),
                Triple("Kotori", Smile, R),
                Triple("Kotori", Smile, SR),
                Triple("Kotori", Smile, UR),
                Triple("Kotori", Pure, R),
                Triple("Kotori", Pure, SR),
                Triple("Kotori", Pure, UR),
                Triple("Kotori", Cool, R),
                Triple("Kotori", Cool, SR),
                Triple("Kotori", Cool, UR),
                Triple("Umi", Smile, R),
                Triple("Umi", Smile, SR),
                Triple("Umi", Smile, UR),
                Triple("Umi", Pure, R),
                Triple("Umi", Pure, SR),
                Triple("Umi", Pure, UR),
                Triple("Umi", Cool, R),
                Triple("Umi", Cool, SR),
                Triple("Umi", Cool, UR),
                Triple("Rin", Smile, R),
                Triple("Rin", Smile, SR),
                Triple("Rin", Smile, UR),
                Triple("Rin", Pure, R),
                Triple("Rin", Pure, SR),
                Triple("Rin", Pure, UR),
                Triple("Rin", Cool, R),
                Triple("Rin", Cool, SR),
                Triple("Rin", Cool, UR),
                Triple("Maki", Smile, R),
                Triple("Maki", Smile, SR),
                Triple("Maki", Smile, UR),
                Triple("Maki", Pure, R),
                Triple("Maki", Pure, SR),
                Triple("Maki", Pure, UR),
                Triple("Maki", Cool, R),
                Triple("Maki", Cool, SR),
                Triple("Maki", Cool, UR),
                Triple("Nozomi", Smile, R),
                Triple("Nozomi", Smile, SR),
                Triple("Nozomi", Smile, UR),
                Triple("Nozomi", Pure, R),
                Triple("Nozomi", Pure, SR),
                Triple("Nozomi", Pure, UR),
                Triple("Nozomi", Cool, R),
                Triple("Nozomi", Cool, SR),
                Triple("Nozomi", Cool, UR),
                Triple("Hanayo", Smile, R),
                Triple("Hanayo", Smile, SR),
                Triple("Hanayo", Smile, UR),
                Triple("Hanayo", Pure, R),
                Triple("Hanayo", Pure, SR),
                Triple("Hanayo", Pure, UR),
                Triple("Hanayo", Cool, R),
                Triple("Hanayo", Cool, SR),
                Triple("Hanayo", Cool, UR),
                Triple("Nico", Smile, R),
                Triple("Nico", Smile, SR),
                Triple("Nico", Smile, UR),
                Triple("Nico", Pure, R),
                Triple("Nico", Pure, SR),
                Triple("Nico", Pure, UR),
                Triple("Nico", Cool, R),
                Triple("Nico", Cool, SR),
                Triple("Nico", Cool, UR)
        )

        actual.should be expected
    }

    @Test
    fun testCombinationsPairEmpty() {
        val emptyList = emptyList<Pair<String, Attribute>>()

        combinations(names, emptyList<Attribute>()).should be emptyList
        combinations(emptyList<String>(), Attribute.values().toList()).should be emptyList
        combinations(emptyList<String>(), emptyList<Attribute>()).should be emptyList
    }

    @Test
    fun testCombinationsTripleEmpty() {
        val emptyList = emptyList<Triple<String, Attribute, Rank>>()
        val attributes = Attribute.values().toList()
        val ranks = Rank.values().toList()

        val emptyNames = emptyList<String>()
        val emptyAttributes = emptyList<Attribute>()
        val emptyRanks = emptyList<Rank>()

        combinations(names, attributes, emptyRanks).should be emptyList
        combinations(names, emptyAttributes, ranks).should be emptyList
        combinations(names, emptyAttributes, emptyRanks).should be emptyList
        combinations(emptyNames, attributes, ranks).should be emptyList
        combinations(emptyNames, attributes, emptyRanks).should be emptyList
        combinations(emptyNames, emptyAttributes, ranks).should be emptyList
        combinations(emptyNames, emptyAttributes, emptyRanks).should be emptyList
    }

    @Test
    fun testCombinationsList() {
        val listA = listOf("This", "That")
        val listB = listOf("is")
        val listC = listOf("good", "bad")
        val listD = listOf(".", "!")

        val actual = combinations(listA, listB, listC, listD)
        val expected = listOf(
                listOf("This", "is", "good", "."),
                listOf("This", "is", "good", "!"),
                listOf("This", "is", "bad", "."),
                listOf("This", "is", "bad", "!"),
                listOf("That", "is", "good", "."),
                listOf("That", "is", "good", "!"),
                listOf("That", "is", "bad", "."),
                listOf("That", "is", "bad", "!")
        )

        actual.should be expected
    }

    @Test
    fun testCombinationsListEmpty() {
        val listA = listOf("This", "That")
        val listB = listOf("is")
        val listC = listOf("good", "bad")
        val listD = emptyList<String>()

        val actual = combinations(listA, listB, listC, listD)
        val expected = emptyList<List<String>>()

        actual.should be expected
    }
}

