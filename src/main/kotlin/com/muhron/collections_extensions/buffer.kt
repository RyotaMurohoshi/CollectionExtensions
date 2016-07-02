package com.muhron.collections_extensions

import java.util.LinkedList
import java.util.ArrayList

fun <TSource> List<TSource>.buffer(count: Int): List<List<TSource>> = buffer(count, count)

fun <TSource> List<TSource>.buffer(count: Int, skip: Int): List<List<TSource>> {

    val buffers = LinkedList<ArrayList<TSource>>()
    val result = ArrayList<List<TSource>>()

    var index = 0;
    for (item in this) {
        if (index % skip == 0) {
            buffers.add(ArrayList(count))
        }

        for (buffer in buffers) {
            buffer.add(item)
        }

        if (buffers.size > 0 && buffers.peek().size == count) {
            result.add(buffers.remove())
        }

        index++
    }

    while (buffers.size > 0) {
        result.add(buffers.remove())
    }

    return result
}
