package ru.stillercode

data class XY(val x: Int, val y: Int) {
    fun add(v: XY, size: XY): XY {
        return XY(
            add(x, v.x, size.x),
            add(y, v.y, size.y)
        )
    }
    private fun add(a: Int, b: Int, s: Int): Int {
        val sum = a + b
        return if (sum >= 0) {
            sum % s
        } else {
            s + sum
        }
    }
}
