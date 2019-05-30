package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    protected fun btnClick (view:View) {
        val btnSelected = view as Button
        var cellId = 0

        when (btnSelected.id) {
            R.id.btn1 -> cellId=1
            R.id.btn2 -> cellId=2
            R.id.btn3 -> cellId=3
            R.id.btn4 -> cellId=4
            R.id.btn5 -> cellId=5
            R.id.btn6 -> cellId=6
            R.id.btn7 -> cellId=7
            R.id.btn8 -> cellId=8
            R.id.btn9 -> cellId=9
        }

        PlayGame(cellId, btnSelected)

        CheckWinner()
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun PlayGame (cellId:Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.orange)
            player1.add(cellId)
            activePlayer = 2
            AutoGame()

        }else {
            btnSelected.text = "Y"
            btnSelected.setBackgroundResource(R.color.customeblue)
            player2.add(cellId)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
    }

    fun CheckWinner() {
        var winner = -1

        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (winner!=-1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 is the winner", Toast.LENGTH_SHORT).show()

            }else {
                Toast.makeText(this, "Player 2 is the winner", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun AutoGame() {
        val emptyCell = ArrayList <Int> ()
        for (cellId in 1 .. 9) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCell.add(cellId)
            }
        }
        // Assigning default Random class
        val r = Random()
        // Creating index with next random id
        val randIndex = r.nextInt(emptyCell.size-0)+0
        // Updating cellid by randomly empty cell
        val cellId = emptyCell [randIndex]

        // Creating selected button statement
        val btnSelected: Button?
        when (cellId){
            1-> btnSelected = btn1
            2-> btnSelected = btn2
            3-> btnSelected = btn3
            4-> btnSelected = btn4
            5-> btnSelected = btn5
            6-> btnSelected = btn6
            7-> btnSelected = btn7
            8-> btnSelected = btn8
            9-> btnSelected = btn9
            else -> btnSelected = btn1
        }
       PlayGame(cellId, btnSelected)
    }

}
