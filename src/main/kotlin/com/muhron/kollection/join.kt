package com.muhron.kollection

fun <TOuter, TInner, TKey, TResult> List<TOuter>.join(
        inner: List<TInner>,
        outerKeySelector: (TOuter) -> TKey,
        innerKeySelector: (TInner) -> TKey,
        resultSelector: (TOuter, TInner) -> TResult): List<TResult> =
        join(this, inner, outerKeySelector, innerKeySelector, resultSelector)

@JvmName("joins")
fun <TOuter, TInner, TKey, TResult> join(
        outer: List<TOuter>,
        inner: List<TInner>,
        outerKeySelector: (TOuter) -> TKey,
        innerKeySelector: (TInner) -> TKey,
        resultSelector: (TOuter, TInner) -> TResult): List<TResult> {

    val innerLookup = inner.groupBy(innerKeySelector)
    return outer.flatMap { outerElement ->
        val key = outerKeySelector(outerElement)
        val innerElements = innerLookup[key]

        innerElements?.map { innerElement -> resultSelector(outerElement, innerElement) } ?: emptyList<TResult>()
    }
}
