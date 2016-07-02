package com.muhron.collections_extensions

fun <T> repeat(value: T): Sequence<T> = Sequence {
    object : Iterator<T> {
        override fun next(): T = value
        override fun hasNext(): Boolean = true
    }
}
