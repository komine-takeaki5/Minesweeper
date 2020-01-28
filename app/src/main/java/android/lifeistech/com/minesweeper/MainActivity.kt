package android.lifeistech.com.minesweeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Section
import kotlin.random.Random

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groupAdapter = GroupAdapter<GroupieViewHolder>()

        findViewById<RecyclerView>(R.id.recycler_view).adapter = groupAdapter


        val boxArray = mutableListOf<Box>()
        for (i in 1..9){
            val ran : Int =Random.nextInt(2)
            val box = Box(false, 0,(ran==1))
            boxArray.add(box)
        }

        var sec1 = Section()
        sec1.add(ListItem(boxArray[0],boxArray[1],boxArray[2]))
        sec1.add(ListItem(boxArray[3],boxArray[4],boxArray[5]))
        sec1.add(ListItem(boxArray[6],boxArray[7],boxArray[8]))
        groupAdapter.add(sec1)






        // TODO java
        //for (int i = 0; i < items.size; i++) {
        //val ran : Int =Random.nextInt(2)

        }


    }
