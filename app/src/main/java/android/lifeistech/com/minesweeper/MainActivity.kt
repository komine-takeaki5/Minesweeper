package android.lifeistech.com.minesweeper

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    val ROW_NUMBER = 6
    var bomNumber = 0
    var tappedNumber = 2
    var boxArray = mutableListOf<MutableList<Box>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      createBoxArray()

        val groupAdapter = GroupAdapter<GroupieViewHolder>()

        findViewById<RecyclerView>(R.id.recycler_view).adapter = groupAdapter

        //boxArray作成
        /*for (i in 0.. ROW_NUMBER - 1) {
            boxArray.add(mutableListOf<Box>())
            //boxArrayの中にboxを作成
            for (j in 0..ROW_NUMBER - 1) {
                val box = Box(false, 0, false, i, j,false)
                boxArray.get(i).add(box)
            }
        }*/
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
    /*override fun onTapped(box: Box) {
        if (!box.isTapped) {
            box.isTapped = true
            tappedNumber++
            Log.e("tappedNumber", tappedNumber.toString())
            Log.e("bomNumber", bomNumber.toString())
            if(tappedNumber==1){
                bom(box)
                onOpenBox(row: Int, column: Int, recursive: Boolean)

            }else{
                onOpenBox(row: Int, column: Int, recursive: Boolean)
                return
            }
            if (tappedNumber == ROW_NUMBER * ROW_NUMBER - bomNumber) {
                val intent = Intent(this, GameClear::class.java)
                startActivity(intent)
            }
        }
    }*/
    fun  createBoxArray() {
        var boxArrayList = boxArray

        // 1行ごとに乱数を発生させて爆弾を生成
        for (i in 0..(ROW_NUMBER - 1)) {
            var array = mutableListOf<Box>()
            val bomNum1 = Random.nextInt(ROW_NUMBER - 1)
            val bomNum2 =Random.nextInt(ROW_NUMBER - 1)

                for (j in 0..(ROW_NUMBER - 1)){

                    var box = Box()


                    if(bomNum1 ==j){
                        box.hasBom = true
                    }
                    if (bomNum2 == j && j !== bomNum1 ){
                        box.hasBom = true
                    }


                }
            boxArrayList.add(array)
        }
        // 次に回りの爆弾の数を数える
        for (n in 0..ROW_NUMBER - 1) {
            for (m in 0..(ROW_NUMBER - 1)) {
                var box =

                // ①
                checkBom(n - 1,m - 1 )
                checkBom(n,m - 1)
                checkBom(n + 1,m - 1)
                checkBom(n - 1,m)
                checkBom(n + 1,m)
                checkBom(n - 1,m + 1)
                checkBom(n,m + 1)
                checkBom(n + 1,m + 1)


            }
        }
    }
    fun checkBom(row: Int, column: Int): Int {
        // マスが存在するか確認
        if (row < 0 || row > ROW_NUMBER - 1 || column < 0 || column > ROW_NUMBER - 1) {
            return 0

        } else if (boxArray[row][column].hasBom) {
            return 1

        } else {
            return 0

        }

    }







    // bomのセット
    /* fun bom (box:Box) {
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
    }*/

     fun onOpenBox (row: Int, column: Int, recursive: Boolean) {
         var i =row
         var j = column

        //マスがあるか確認
        if (i < 0 && i > ROW_NUMBER - 1 && j < 0 && j > ROW_NUMBER - 1) {
            return
        }
         //boxを取得
         var box = boxArray.get(i).get(j)

        //すでにタップされてる/flag
        if (box.isTapped) {
            return
        }
        //ボムがあるか確認
        if (box.hasBom) {
            gameOver()
            return
        }
        //周りのボム数で仕分け
        if (bomNumber > 0) {
            bomNumber.toString()

        } else {

            onOpenBox(i - 1,j - 1 , true)
            onOpenBox(i,j - 1,true)
            onOpenBox(i + 1,j - 1,true)
            onOpenBox(i - 1,j,true)
            onOpenBox(i + 1,j,true)
            onOpenBox(i - 1,j + 1,true)
            onOpenBox(i,j + 1,true)
            onOpenBox(i + 1,j + 1,true)

        }

    }
    /*override fun setOnLongClickListener(box: Box){
        viewBinding.boxFrame1.setOnClickListener {
            if (boxArray.get(0).hasBom) {
                viewBinding.boxImage1.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.boxText1.text = boxArray.get(0).number.toString()
            }
            listner.onTapped(boxArray.get(0))
        }
        viewBinding.boxFrame2.setOnClickListener {
            if (boxArray.get(1).hasBom) {
                viewBinding.boxImage2.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.boxText2.text = boxArray.get(1).number.toString()
            }
            listner.onTapped(boxArray.get(1))
        }
        viewBinding.boxFrame3.setOnClickListener {
            if (boxArray.get(2).hasBom) {
                viewBinding.boxImage3.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.boxText3.text = boxArray.get(2).number.toString()
            }
            listner.onTapped(boxArray.get(2))
        }
        viewBinding.boxFrame4.setOnClickListener {
            if (boxArray.get(3).hasBom) {
                viewBinding.boxImage4.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.boxText4.text = boxArray.get(3).number.toString()
            }
            listner.onTapped(boxArray.get(3))
        }
        viewBinding.boxFrame5.setOnClickListener {
            if (boxArray.get(4).hasBom) {
                viewBinding.boxImage5.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.boxText5.text = boxArray.get(4).number.toString()
            }
            listner.onTapped(boxArray.get(4))
        }
        viewBinding.boxFrame6.setOnClickListener {
            if (boxArray.get(5).hasBom) {
                viewBinding.boxImage6.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.boxText6.text = boxArray.get(5).number.toString()
            }
            listner.onTapped(boxArray.get(5))
        }


    }*/

    /*override fun setOnLongClickListener(box: Box) {
        viewBinding.boxFrame1.setOnLongClickListener {

            it.boxImage1.setImageResource(R.drawable.flag)
        }
        viewBinding.boxFrame2.setOnLongClickListener {
            it.boxImage2.setImageResource(R.drawable.flag)
        }
        viewBinding.boxFrame3.setOnLongClickListener {
            it.boxImage3.setImageResource(R.drawable.flag)
        }
        viewBinding.boxFrame4.setOnLongClickListener {

            it.boxImage4.setImageResource(R.drawable.flag)
        }
        viewBinding.boxFrame5.setOnLongClickListener {

            it.boxImage5.setImageResource(R.drawable.flag)
        }
        viewBinding.boxFrame6.setOnLongClickListener {

            it.boxImage6.setImageResource(R.drawable.flag)
        }


    }*/



    override fun onBackPressed() {
    }

    fun gameOver() {
        val intent = Intent(this, GameOver::class.java)
        startActivity(intent)
    }

    fun setOnLongClickListener(box: Box) {
        TODO("Not yet implemented")
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