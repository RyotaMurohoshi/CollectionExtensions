package com.muhron.collections_extensions

import com.taroid.knit.should
import org.junit.Test

class MultiGroupByTest {

    @Test
    fun testUnitsJoinPersons() {
        val actual: Map<MonsterType, List<Monster>> = monsters.multiGroupBy { it.types }

        val expected = mapOf(
                MonsterType.Grass to listOf(
                        Monster(number = 1, name = "フシギナターネ", types = listOf(MonsterType.Grass, MonsterType.Poison)),
                        Monster(number = 2, name = "フシギナソーウ", types = listOf(MonsterType.Grass, MonsterType.Poison)),
                        Monster(number = 3, name = "フシギナハーナ", types = listOf(MonsterType.Grass, MonsterType.Poison))
                ),
                MonsterType.Poison to listOf(
                        Monster(number = 1, name = "フシギナターネ", types = listOf(MonsterType.Grass, MonsterType.Poison)),
                        Monster(number = 2, name = "フシギナソーウ", types = listOf(MonsterType.Grass, MonsterType.Poison)),
                        Monster(number = 3, name = "フシギナハーナ", types = listOf(MonsterType.Grass, MonsterType.Poison))
                ),
                MonsterType.Fire to listOf(
                        Monster(number = 4, name = "ヒノトカゲ", types = listOf(MonsterType.Fire)),
                        Monster(number = 5, name = "リザーノ", types = listOf(MonsterType.Fire)),
                        Monster(number = 6, name = "リザドーーン", types = listOf(MonsterType.Fire, MonsterType.Flying))
                ),
                MonsterType.Flying to listOf(
                        Monster(number = 6, name = "リザドーーン", types = listOf(MonsterType.Fire, MonsterType.Flying))
                ),
                MonsterType.Water to listOf(
                        Monster(number = 7, name = "ゼニカーメ", types = listOf(MonsterType.Water)),
                        Monster(number = 8, name = "カメールン", types = listOf(MonsterType.Water)),
                        Monster(number = 9, name = "カメクッスン", types = listOf(MonsterType.Water))
                )
        )

        actual.should be expected
    }
}