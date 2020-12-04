package android.lifeistech.com.minesweeper

import android.lifeistech.com.minesweeper.databinding.ItemListBinding
import com.xwray.groupie.databinding.BindableItem


class ListItem(val boxArray: MutableList<Box>, val listner: MainActivity) : BindableItem<ItemListBinding>() {

    override fun getLayout(): Int = R.layout.item_list

    override fun bind(viewBinding: ItemListBinding, position: Int) {
        val boxImages = arrayOf(viewBinding.boxImage1, viewBinding.boxImage2, viewBinding.boxImage3,
        viewBinding.boxImage4, viewBinding.boxImage5, viewBinding.boxImage6)
        val boxTexts = arrayOf(viewBinding.boxText1, viewBinding.boxText2, viewBinding.boxText3,
            viewBinding.boxText4, viewBinding.boxText5, viewBinding.boxText6)

        for(i in 0..boxArray.size-1){
            val box =boxArray.get(i)
            val imageView = boxImages[i]
            val flag = box.hasFlag
            if(flag){
                imageView.setImageResource(R.drawable.flag)
            }else{
                imageView.setImageDrawable(null)
            }
        }
        for(i in 0..boxArray.size -1){
            val box =boxArray.get(i)
            val textView = boxTexts[i]
            val num = box.number
              boxArray.get(i).number.toString()
        }


        /*viewBinding.boxFrame1.setOnClickListener {
            if (boxArray.get(0).hasBom) {
                viewBinding.boxImage1.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.boxText1.text = boxArray.get(0).number
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
        }*/









        if (boxArray.get(0).isTapped) {
            viewBinding.boxText1.text = boxArray.get(0).number.toString()
        }else if (boxArray.get(1).isTapped) {
            viewBinding.boxText2.text = boxArray.get(1).number.toString()
        }else if (boxArray.get(2).isTapped) {
            viewBinding.boxText3.text = boxArray.get(2).number.toString()
        }else if (boxArray.get(3).isTapped) {
            viewBinding.boxText4.text = boxArray.get(3).number.toString()
        }else if (boxArray.get(4).isTapped) {
            viewBinding.boxText5.text = boxArray.get(4).number.toString()
        }else if (boxArray.get(5).isTapped) {
            viewBinding.boxText6.text = boxArray.get(5).number.toString()
        }


    }

    interface TapListener {
        fun onTapped(box: Box)
        //fun bom(box: Box)
        //fun boxOpen(box: Box)
        fun gameOver()

        fun setOnLongClickListener(box: Box)
        fun createBoxArray()
    }

}