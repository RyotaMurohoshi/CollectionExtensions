package com.muhron.kollection

import org.junit.Assert
import org.junit.Test

class GroupJoinTest {

    @Test
    fun testUnitsGroupJoinPersons() {
        val actual: List<UnitViewModel> = units.groupJoin(
                persons,
                { unit -> unit.id },
                { person -> person.unitsId },
                { unit: Units, persons: List<Person> -> UnitViewModel(unit.name, persons.toList()) }
        ).toList()

        val expected = listOf(
                UnitViewModel("Printemps", listOf(
                        Person(PersonId(0), "Honoka", UnitsId(0)),
                        Person(PersonId(2), "Kotori", UnitsId(0)),
                        Person(PersonId(7), "Hanayo", UnitsId(0))
                )),
                UnitViewModel("lily white", listOf(
                        Person(PersonId(3), "Umi", UnitsId(1)),
                        Person(PersonId(4), "Rin", UnitsId(1)),
                        Person(PersonId(6), "Nozomi", UnitsId(1))
                )),
                UnitViewModel("BiBi", listOf(
                        Person(PersonId(1), "Eli", UnitsId(2)),
                        Person(PersonId(5), "Maki", UnitsId(2)),
                        Person(PersonId(8), "Niko", UnitsId(2))
                )),
                UnitViewModel("Mutant Girls", listOf(
                ))
        )

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun testPersonsGroupJoinUnits() {
        val actual: List<PersonViewModel> = persons.groupJoin(
                units,
                { person -> person.unitsId },
                { unit -> unit.id },
                { person: Person, units: List<Units> -> PersonViewModel(person.name, units.map { it.name }.joinToString()) }
        ).toList()

        val expected = listOf(
                PersonViewModel("Honoka", "Printemps"),
                PersonViewModel("Eli", "BiBi"),
                PersonViewModel("Kotori", "Printemps"),
                PersonViewModel("Umi", "lily white"),
                PersonViewModel("Rin", "lily white"),
                PersonViewModel("Maki", "BiBi"),
                PersonViewModel("Nozomi", "lily white"),
                PersonViewModel("Hanayo", "Printemps"),
                PersonViewModel("Niko", "BiBi"),
                PersonViewModel("Alisa", ""),
                PersonViewModel("Yukiho", "")
        )

        Assert.assertEquals(expected, actual)
    }
}
