package com.muhron.collections_extensions

fun <TSource, TAccumulate> List<TSource>.scan(
        seed: TAccumulate, accumulator: (TAccumulate, TSource) -> TAccumulate): List<TAccumulate>
        = asSequence().scan(seed, accumulator).toList()

fun <TSource> List<TSource>.scan(accumulator: (TSource, TSource) -> TSource): List<TSource>
        = asSequence().scan(accumulator).toList()

fun <TSource, TAccumulate> Sequence<TSource>.scan(
        seed: TAccumulate, accumulator: (TAccumulate, TSource) -> TAccumulate): Sequence<TAccumulate>
        = ScanningSequence(this, seed, accumulator)

fun <TSource> Sequence<TSource>.scan(accumulator: (TSource, TSource) -> TSource): Sequence<TSource> {
    if (!any()) {
        return emptySequence()
    }

    return ScanningSequence(this.drop(1), this.first(), accumulator);
}

internal class ScanningSequence<TSource, TAccumulate> constructor(
        private val sequence: Sequence<TSource>,
        private val seed: TAccumulate,
        private val accumulator: (TAccumulate, TSource) -> TAccumulate) : Sequence<TAccumulate> {

    override fun iterator(): Iterator<TAccumulate> = object : Iterator<TAccumulate> {
        val iterator = sequence.iterator()
        var previousAccumulate: TAccumulate = seed

        override fun next(): TAccumulate {
            previousAccumulate = accumulator(previousAccumulate, iterator.next())
            return previousAccumulate
        }

        override fun hasNext(): Boolean {
            return iterator.hasNext()
        }
    }
}
