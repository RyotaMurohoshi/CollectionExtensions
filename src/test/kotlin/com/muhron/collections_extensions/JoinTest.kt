package com.muhron.collections_extensions

import com.taroid.knit.should
import org.junit.Assert
import org.junit.Test

class JoinTest {

    @Test
    fun testUnitsJoinPersons() {
        val actual: List<PersonViewModel> = units.join(
                persons,
                { unit -> unit.id },
                { person -> person.unitsId },
                { unit: Units, person: Person -> PersonViewModel(person.name, unit.name) }
        ).toList()

        val expected = listOf(
                PersonViewModel("Honoka", "Printemps"),
                PersonViewModel("Kotori", "Printemps"),
                PersonViewModel("Hanayo", "Printemps"),
                PersonViewModel("Umi", "lily white"),
                PersonViewModel("Rin", "lily white"),
                PersonViewModel("Nozomi", "lily white"),
                PersonViewModel("Eli", "BiBi"),
                PersonViewModel("Maki", "BiBi"),
                PersonViewModel("Niko", "BiBi")
        )

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun testPersonsJoinUnits() {
        val actual: List<PersonViewModel> = persons.join(
                units,
                { person -> person.unitsId },
                { unit -> unit.id },
                { person: Person, unit: Units -> PersonViewModel(person.name, unit.name) }
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
                PersonViewModel("Niko", "BiBi")
        )

        Assert.assertEquals(expected, actual)
    }
}
