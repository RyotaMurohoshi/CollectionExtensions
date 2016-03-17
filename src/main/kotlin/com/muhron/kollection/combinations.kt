package com.muhron.kollection

fun <A, B> combinations(listA: List<A>, listB: List<B>): List<Pair<A, B>> =
        listA.flatMap { first -> listB.map { second -> first to second } }

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
                elementList.flatMap { element: T ->
                    accumulateListOfList.map { list -> list + element }
                }
            }
    )
}
