package android.lifeistech.com.minesweeper

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlin.random.Random

class MainActivity : AppCompatActivity(),TapListener {


    val ROW_NUMBER = 3
    var bomNumber = 0
    var tappedNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groupAdapter = GroupAdapter<GroupieViewHolder>()

        findViewById<RecyclerView>(R.id.recycler_view).adapter = groupAdapter


        val boxArray = mutableListOf<MutableList<Box>>()
        for (i in 0..ROW_NUMBER-1) {
            boxArray.add(mutableListOf<Box>())
            for (j in 0..ROW_NUMBER-1) {
                val ran: Int = Random.nextInt(2)
                if (ran == 1){
                    bomNumber++
                }
                val box = Box(false, 0, (ran == 1))
                boxArray.get(i).add(box)
            }
        }

        for (i in 0..ROW_NUMBER-1) {
            for (j in 0..ROW_NUMBER-1) {

                var boxNum = 0

                if(j - 1 >= 0  ){
                    val checkBox = boxArray.get(i).get(j-1)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                if(j + 1 <= ROW_NUMBER - 1){
                    val checkBox = boxArray.get(i).get(j+1)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                if(i - 1 >= 0){
                    val checkBox = boxArray.get(i-1).get(j)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                if(i + 1 <= ROW_NUMBER - 1){
                    val checkBox = boxArray.get(i+1).get(j)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                if(j - 1 >= 0 && i - 1 >= 0) {
                    val checkBox = boxArray.get(i-1).get(j-1)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                if(j - 1 >= 0 && i + 1 <= ROW_NUMBER - 1){
                    val checkBox = boxArray.get(i+1).get(j-1)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                if( j + 1 <= ROW_NUMBER - 1 && i - 1 >= 0){
                    val checkBox = boxArray.get(i-1).get(j+1)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                if(j + 1 <= ROW_NUMBER - 1 && i + 1 <= ROW_NUMBER - 1 ){
                    val checkBox = boxArray.get(i+1).get(j+1)
                    if (checkBox.hasBom){
                        boxNum++
                    }
                }
                boxArray.get(i).get(j).number = boxNum
            }
        }

        var sec1 = Section()
        for (i in 0 until boxArray.size){
            sec1.add(ListItem(boxArray.get(i).get(0), boxArray.get(i).get(1), boxArray.get(i).get(2),this))
        }
        groupAdapter.add(sec1)

    }

    override fun onTapped() {
        tappedNumber++
        if (tappedNumber == ROW_NUMBER * ROW_NUMBER - bomNumber){
            val intent = Intent(this, GameClear::class.java)
            startActivity(intent)

        }


    }

    override fun gameOver() {
        val intent = Intent(this, GameOver::class.java)
        startActivity(intent)

    }


}