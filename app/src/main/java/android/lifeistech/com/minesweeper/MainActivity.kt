package android.lifeistech.com.minesweeper

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ListItem.TapListener {


    val ROW_NUMBER = 6
    var bomNumber = 0
    var tappedNumber = 0
    var boxArray = mutableListOf<MutableList<Box>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groupAdapter = GroupAdapter<GroupieViewHolder>()

        findViewById<RecyclerView>(R.id.recycler_view).adapter = groupAdapter

        //boxArray作成
        for (i in 0.. ROW_NUMBER - 1) {
            boxArray.add(mutableListOf<Box>())
            //boxArrayの中にboxを作成
            for (j in 0..ROW_NUMBER - 1) {
                val box = Box(false, 0, false,false, i, j)
                boxArray.get(i).add(box)
            }
        }
        /*var tappledBoxPosition = Random.nextInt(ROW_NUMBER * ROW_NUMBER)
        while (!getBox(tappledBoxPosition).hasBom) {
            tappledBoxPosition = Random.nextInt(ROW_NUMBER * ROW_NUMBER)

        }*/
        //getBox(tappledBoxPosition).isTapped = true
        //Log.e("Box", getBox(tappledBoxPosition).number.toString())

        var sec1 = Section()
        for (i in 0 until boxArray.size) {
            sec1.add(ListItem(boxArray.get(i), this))
        }
        groupAdapter.add(sec1)

        //Log.e("Box", "Box")

        //for (i in 0..ROW_NUMBER - 1) {
            //Log.e("Box", boxArray.get(i).toString())
        //}
    }
    // boxを開ける判定
    override fun onTapped(box: Box) {
        if (!box.isTapped) {
            box.isTapped = true
            tappedNumber++
            Log.e("tappedNumber", tappedNumber.toString())
            Log.e("bomNumber", bomNumber.toString())
            if(tappedNumber==1){
                bom(box)
                boxOpen(box)

            }else{
                boxOpen(box)
                return
            }
            if (tappedNumber == ROW_NUMBER * ROW_NUMBER - bomNumber) {
                val intent = Intent(this, GameClear::class.java)
                startActivity(intent)
            }
        }
    }

    override fun setOnLongClickListener(box: Box) {
        TODO("Not yet implemented")

    }


    // bomのセット
     fun bom (box:Box) {
        bomNumber = Random.nextInt((ROW_NUMBER * ROW_NUMBER) / 3 - 1) + 1
        var i = box.row
        var j = box.column

        for (i in 0..bomNumber) {
                val position = Random.nextInt(ROW_NUMBER * ROW_NUMBER)
                //Log.e("Bom", position.toString())
                getBox(position).hasBom = true
            }
        for (i  in 0..ROW_NUMBER - 1) {
            for (j in 0..ROW_NUMBER - 1) {

                var boxNum = 0
                if (boxArray.get(i).get(j).hasBom) {
                    continue
                }
                if (j - 1 >= 0) {
                    val checkBox = boxArray.get(i).get(j - 1)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                if (j + 1 <= ROW_NUMBER - 1) {
                    val checkBox = boxArray.get(i).get(j + 1)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                if (i - 1 >= 0) {
                    val checkBox = boxArray.get(i - 1).get(j)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                if (i + 1 <= ROW_NUMBER - 1) {
                    val checkBox = boxArray.get(i + 1).get(j)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                if (j - 1 >= 0 && i - 1 >= 0) {
                    val checkBox = boxArray.get(i - 1).get(j - 1)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                if (j - 1 >= 0 && i + 1 <= ROW_NUMBER - 1) {
                    val checkBox = boxArray.get(i + 1).get(j - 1)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                if (j + 1 <= ROW_NUMBER - 1 && i - 1 >= 0) {
                    val checkBox = boxArray.get(i - 1).get(j + 1)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                if (j + 1 <= ROW_NUMBER - 1 && i + 1 <= ROW_NUMBER - 1) {
                    val checkBox = boxArray.get(i + 1).get(j + 1)
                    if (checkBox.hasBom) {
                        boxNum++
                    }
                }
                boxArray.get(i).get(j).number = boxNum
            }
        }
    }

     fun boxOpen (box: Box) {
        var i = box.row
        var j = box.column
        //マスがあるか確認
        if (i < 0 && i > ROW_NUMBER - 1 && j < 0 && j > ROW_NUMBER - 1) {
            return
        }
        //すでにタップされてるか確認
        if (box.isTapped == true) {
            return
        }
        //ボムがあるか確認
        if (box.hasBom == true) {
            gameOver()
            return
        }
        //周りのボム数で仕分け
        if (bomNumber > 0) {
            bomNumber.toString()

        } else {

            boxOpen(boxArray.get(i - 1).get(j - 1))
            boxOpen(boxArray.get(i).get(j - 1))
            boxOpen(boxArray.get(i + 1).get(j - 1))
            boxOpen(boxArray.get(i - 1).get(j))
            boxOpen(boxArray.get(i + 1).get(j))
            boxOpen(boxArray.get(i - 1).get(j + 1))
            boxOpen(boxArray.get(i).get(j + 1))
            boxOpen(boxArray.get(i + 1).get(j + 1))

        }

    }

    override fun onBackPressed() {
    }

    override fun gameOver() {
        val intent = Intent(this, GameOver::class.java)
        startActivity(intent)
    }
    fun getBox(position: Int): Box {
        return boxArray.get(position / ROW_NUMBER).get(position % ROW_NUMBER)
    }
    interface TapListener {
        fun onTapped(box: Box)
        //fun bom(box: Box)
        //fun boxOpen(box: Box)
        fun gameOver()
    }
}