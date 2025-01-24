package ru.stillercode

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import androidx.gridlayout.widget.GridLayout

import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var buttonGrid: MutableList<MutableList<Button>>
    val life = Life(SIZE, LIFE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        buttonGrid = createGrid()
        findViewById<Button>(R.id.clearButton).setOnClickListener {
            clear()
        }
        findViewById<Button>(R.id.stepButton).setOnClickListener {
            step()
        }
        findViewById<Button>(R.id.upButton).setOnClickListener {
            move(UP)
        }
        findViewById<Button>(R.id.downButton).setOnClickListener {
            move(DOWN)
        }
        findViewById<Button>(R.id.leftButton).setOnClickListener {
            move(LEFT)
        }
        findViewById<Button>(R.id.rightButton).setOnClickListener {
            move(RIGHT)
        }
        findViewById<Button>(R.id.randomButton).setOnClickListener {
            random()
        }
        findViewById<Button>(R.id.invertButton).setOnClickListener {
            invert()
        }
        updateGrid()
    }

    private fun invert() {
        life.invert()
        updateGrid()
    }

    private fun clear() {
        life.clear()
        updateGrid()
    }
    private fun step() {
        life.step()
        updateGrid()
    }

    private fun createGrid(): MutableList<MutableList<Button>> {
        val gridLayout = findViewById<GridLayout>(R.id.grid)
        gridLayout.rowCount = SIZE.y
        gridLayout.columnCount = SIZE.x
        val out = mutableListOf<MutableList<Button>>()
        for (y in 0 until SIZE.y) {
            val line = mutableListOf<Button>()
            for (x in 0 until  SIZE.x) {
                val button = Button(this).apply {
                    setBackgroundResource(R.drawable.cell)
                    layoutParams = GridLayout.LayoutParams().apply {
                        width = 0
                        height = 0
                        columnSpec = GridLayout.spec(x, 1, 1f)
                        rowSpec = GridLayout.spec(y, 1, 1f)
                    }
                    setOnClickListener {
                        cellClicked(XY(x, y))
                    }
                }
                gridLayout.addView(button)
                line.add(button)
            }
            out.add(line)
        }
        return out
    }
    private fun cellClicked(cell: XY) {
        //buttonGrid[cell.y][cell.x].setBackgroundResource(R.drawable.livecell)
        life.click(cell)
        updateGrid()
    }

    private fun updateGrid() {
        for (y in 0 until SIZE.y) {
            for (x in 0 until SIZE.x) {
                if (life.get(x, y)) {
                    buttonGrid[y][x].setBackgroundResource(R.drawable.livecell)
                } else {
                    buttonGrid[y][x].setBackgroundResource(R.drawable.cell)
                }
            }
        }
    }
    private fun move(vector: XY) {
        life.move(vector)
        updateGrid()
    }
    private fun random() {
        life.randFill(50)
        updateGrid()
    }

}


