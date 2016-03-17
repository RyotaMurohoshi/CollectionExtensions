package com.muhron.kollection

@JvmName("combinationsExtension")
fun <A, B> List<A>.combinations(listB: List<B>): List<Pair<A, B>> =
        combinations<A, B>(this, listB)

@JvmName("combinations")
fun <A, B> combinations(listA: List<A>, listB: List<B>): List<Pair<A, B>> =
        listA.flatMap { first -> listB.map { second -> first to second } }

@JvmName("combinationsExtension")
fun <A, B, C> List<A>.combinations(listB: List<B>, listC: List<C>): List<Triple<A, B, C>> =
        combinations<A, B, C>(this, listB, listC)

@JvmName("combinations")
fun <A, B, C> combinations(listA: List<A>, listB: List<B>, listC: List<C>): List<Triple<A, B, C>> =
        listA.flatMap { first ->
            listB.flatMap { second ->
                listC.map { third ->
                    Triple(first, second, third)
                }
            }
        }

fun <T> combinations(vararg listOfList: List<T>): List<List<T>> {
    return listOfList.fold(
            initial = listOf(emptyList<T>()),
            operation = { accumulateListOfList: List<List<T>>, elementList: List<T> ->
                accumulateListOfList.flatMap { list: List<T> ->
                    elementList.map { element: T -> list + element }
                }
            }
    )
}
