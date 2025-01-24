package ru.stillercode

val SIZE = XY(20, 20)
val VECTORS = listOf(
    XY(0, 1),
    XY(0, -1),
    XY(1, 0),
    XY(-1, 0),
    XY(1, 1),
    XY(-1, -1),
    XY(1, -1),
    XY(-1, 1)
)
val UP = XY(0, -1)
val DOWN = XY(0, 1)
val LEFT = XY(-1, 0)
val RIGHT = XY(1, 0)
val LIFE = Rule(listOf(2, 3), listOf(3), "Life")
val LIFE_GAME = listOf(XY(x=1, y=4), XY(x=5, y=4), XY(x=7, y=4), XY(x=8, y=4), XY(x=9, y=4), XY(x=11, y=4), XY(x=12, y=4), XY(x=13, y=4), XY(x=1, y=5), XY(x=5, y=5), XY(x=7, y=5), XY(x=11, y=5), XY(x=1, y=6), XY(x=5, y=6), XY(x=7, y=6), XY(x=8, y=6), XY(x=9, y=6), XY(x=11, y=6), XY(x=12, y=6), XY(x=13, y=6), XY(x=1, y=7), XY(x=5, y=7), XY(x=7, y=7), XY(x=11, y=7), XY(x=1, y=8), XY(x=2, y=8), XY(x=3, y=8), XY(x=5, y=8), XY(x=7, y=8), XY(x=11, y=8), XY(x=12, y=8), XY(x=13, y=8), XY(x=1, y=11), XY(x=2, y=11), XY(x=3, y=11), XY(x=6, y=11), XY(x=9, y=11), XY(x=13, y=11), XY(x=15, y=11), XY(x=16, y=11), XY(x=17, y=11), XY(x=1, y=12), XY(x=5, y=12), XY(x=7, y=12), XY(x=9, y=12), XY(x=10, y=12), XY(x=12, y=12), XY(x=13, y=12), XY(x=15, y=12), XY(x=1, y=13), XY(x=5, y=13), XY(x=6, y=13), XY(x=7, y=13), XY(x=9, y=13), XY(x=11, y=13), XY(x=13, y=13), XY(x=15, y=13), XY(x=16, y=13), XY(x=17, y=13), XY(x=1, y=14), XY(x=3, y=14), XY(x=5, y=14), XY(x=7, y=14), XY(x=9, y=14), XY(x=13, y=14), XY(x=15, y=14), XY(x=1, y=15), XY(x=2, y=15), XY(x=3, y=15), XY(x=5, y=15), XY(x=7, y=15), XY(x=9, y=15), XY(x=13, y=15), XY(x=15, y=15), XY(x=16, y=15), XY(x=17, y=15))