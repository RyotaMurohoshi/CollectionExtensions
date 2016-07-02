package com.muhron.collections_extensions

fun <TOuter, TInner, TKey, TResult> List<TOuter>.groupJoin(
        inner: List<TInner>,
        outerKeySelector: (TOuter) -> TKey,
        innerKeySelector: (TInner) -> TKey,
        resultSelector: (TOuter, List<TInner>) -> TResult): List<TResult> =
        groupJoin(this, inner, outerKeySelector, innerKeySelector, resultSelector)

@JvmName("groupJoins")
fun <TOuter, TInner, TKey, TResult> groupJoin(
        outer: List<TOuter>,
        inner: List<TInner>,
        outerKeySelector: (TOuter) -> TKey,
        innerKeySelector: (TInner) -> TKey,
        resultSelector: (TOuter, List<TInner>) -> TResult): List<TResult> {

    val innerLookup = inner.groupBy(innerKeySelector)
    return outer.map { outerElement ->
        val key = outerKeySelector(outerElement)
        val innerElements = innerLookup[key]

        resultSelector(outerElement, innerElements ?: emptyList<TInner>())
    }
}
