package ru.stillercode

import kotlin.random.Random

class Life(private val size: XY, var rule: Rule) {
    private var current = Array(size.y) {BooleanArray(size.x)}
    private val neighborMap = mutableMapOf<XY, List<XY>>()
    init {
        for (y in 0 until size.y) {
            for (x in 0 until size.x) {
                val cell = XY(x, y)
                val list = mutableListOf<XY>()
                for (v in VECTORS) {
                    val n = cell.add(v, size)
                    list.add(n)
                }
                neighborMap[cell] = list.toList()
            }
        }
        putInitial()
    }
    private fun putInitial() {
        for (cell in LIFE_GAME) {
            click(cell)
        }
    }
    fun get(cell: XY): Boolean {
        return current[cell.y][cell.x]
    }
    fun get(x: Int, y: Int): Boolean {
        return current[y][x]
    }
    fun clear() {
        current = Array(size.y) {BooleanArray(size.x)}
    }
    fun click(cell: XY) {
        current[cell.y][cell.x] = !current[cell.y][cell.x]
    }
    private fun getCellNeighborCount(cell: XY): Int {
        var count = 0
        for (n in neighborMap[cell]!!) {
            if (get(n)) {
                count++
            }
        }
        return count
    }
    fun step() {
        val next = Array(size.y) {BooleanArray(size.x)}
        for (y in 0 until size.y) {
            for (x in 0 until size.x) {
                val cell = XY(x, y)
                val count = getCellNeighborCount(cell)
                if (get(cell)) {
                    if (count in rule.survival) {
                        next[y][x] = true
                    }
                } else {
                    if (count in rule.birth) {
                        next[y][x] = true
                    }
                }
            }
        }
        current = next
    }
    fun move(vector: XY) {
        val next = Array(size.y) {BooleanArray(size.x)}
        for (y in 0 until size.y) {
            for (x in 0 until size.x) {
                if (get(x, y)) {
                    val nextCell = XY(x, y).add(vector, size)
                    next[nextCell.y][nextCell.x] = true
                }
            }
        }
        current = next
    }
    fun count(): Int {
        var n = 0
        for (y in 0 until size.y) {
            for (x in 0 until size.x) {
                if (get(x, y)) {
                    n++
                }
            }
        }
        return n
    }
    fun getEmpty(): MutableList<XY> {
        val out = mutableListOf<XY>()
        for (y in 0 until size.y) {
            for (x in 0 until size.x) {
                if (!get(x, y)) {
                    out.add(XY(x, y))
                }
            }
        }
        return out
    }
    fun invert() {
        for (y in 0 until size.y) {
            for (x in 0 until size.x) {
                current[y][x] = !current[y][x]
            }
        }
    }
    fun randFill(percents: Int) {
        val n = ((size.x * size.y) * percents / 100.0).toInt()
        println(n)
        val emptyCells = getEmpty()
        while (count() < n) {
            val cell = emptyCells[Random.nextInt(emptyCells.size)]
            emptyCells.remove(cell)
            click(cell)
        }
    }
    fun print() {
        var log = ""
        for (y in 0 until size.y) {
            for (x in 0 until size.x) {
                if (get(x, y)) {
                    val cell = XY(x, y)
                    log += "$cell, "
                }
            }
        }
        println(log)
    }
}