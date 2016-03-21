package com.muhron.kollection

enum class Attribute {
    Smile,
    Pure,
    Cool
}

val names = listOf("Honoka", "Eli", "Kotori", "Umi", "Rin", "Maki", "Nozomi", "Hanayo", "Nico")

enum class Rank {
    R,
    SR,
    UR
}

data class UnitsId(val id: Int)
data class PersonId(val id: Int)
data class Units(val id: UnitsId, val name: String)
data class Person(val id: PersonId, val name: String, val unitsId: UnitsId)
data class PersonViewModel(val name: String, val teamName: String)
data class UnitViewModel(val name: String, val persons: List<Person>)

val units: List<Units> = listOf(
        Units(UnitsId(0), "Printemps"),
        Units(UnitsId(1), "lily white"),
        Units(UnitsId(2), "BiBi"),
        Units(UnitsId(3), "Mutant Girls")
)

val persons: List<Person> = listOf(
        Person(PersonId(0), "Honoka", UnitsId(0)),
        Person(PersonId(1), "Eli", UnitsId(2)),
        Person(PersonId(2), "Kotori", UnitsId(0)),
        Person(PersonId(3), "Umi", UnitsId(1)),
        Person(PersonId(4), "Rin", UnitsId(1)),
        Person(PersonId(5), "Maki", UnitsId(2)),
        Person(PersonId(6), "Nozomi", UnitsId(1)),
        Person(PersonId(7), "Hanayo", UnitsId(0)),
        Person(PersonId(8), "Niko", UnitsId(2)),
        Person(PersonId(9), "Alisa", UnitsId(-1)),
        Person(PersonId(10), "Yukiho", UnitsId(-1))
)

data class Complex(val real: Double, val imaginary: Double) {
    operator fun plus(that: Complex): Complex = Complex(this.real + that.real, this.imaginary + that.imaginary)
    operator fun times(that: Complex): Complex {
        val (a, b) = this
        val (c, d) = that
        return Complex(a * c - b * d, a * d + b * c)
    }
}

enum class Direction {
    Up,
    Right,
    Down,
    Left
}

data class Point(val x: Int, val y: Int) {
    fun move(direction: Direction): Point = when (direction) {
        Direction.Up -> Point(x, y + 1)
        Direction.Right -> Point(x + 1, y)
        Direction.Down -> Point(x, y - 1)
        Direction.Left -> Point(x - 1, y)
    }
}
