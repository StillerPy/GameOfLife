package ru.stillercode

class Switcher<T>(val list: List<T>) {
    var i = 0
    fun get(): T {
        return list[i]
    }
    fun switch() {
        i = (i + 1) % list.size
    }
}