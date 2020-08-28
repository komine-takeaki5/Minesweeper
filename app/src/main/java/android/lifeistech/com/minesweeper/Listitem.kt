package android.lifeistech.com.minesweeper

import android.lifeistech.com.minesweeper.databinding.ItemListBinding
import android.util.Log
import android.widget.ImageView
import com.xwray.groupie.databinding.BindableItem
import androidx.databinding.BindingAdapter
import kotlinx.android.synthetic.main.item_list.view.*


class ListItem(val boxArray: MutableList<Box>, val listner :TapListener) : BindableItem<ItemListBinding>() {

    override fun getLayout(): Int = R.layout.item_list

    override fun bind(viewBinding: ItemListBinding, position: Int) {

        viewBinding.frameLayout.setOnClickListener {
            if (boxArray.get(0).hasBom) {
                viewBinding.imageView.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.textView.text = boxArray.get(0).number.toString()
            }
            listner.onTapped(boxArray.get(0))
        }
        viewBinding.frameLayout2.setOnClickListener {
            if (boxArray.get(1).hasBom) {
                viewBinding.imageView2.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.textView2.text = boxArray.get(1).number.toString()
            }
            listner.onTapped(boxArray.get(1))
        }
        viewBinding.frameLayout3.setOnClickListener {
            if (boxArray.get(2).hasBom) {
                viewBinding.imageView3.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.textView3.text = boxArray.get(2).number.toString()
            }
            listner.onTapped(boxArray.get(2))
        }
        viewBinding.frameLayout4.setOnClickListener {
            if (boxArray.get(3).hasBom) {
                viewBinding.imageView4.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.textView4.text = boxArray.get(3).number.toString()
            }
            listner.onTapped(boxArray.get(3))
        }
        viewBinding.frameLayout5.setOnClickListener {
            if (boxArray.get(4).hasBom) {
                viewBinding.imageView5.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.textView5.text = boxArray.get(4).number.toString()
            }
            listner.onTapped(boxArray.get(4))
        }
        viewBinding.frameLayout6.setOnClickListener {
            if (boxArray.get(5).hasBom) {
                viewBinding.imageView6.setImageResource(R.drawable.bom_image)
                listner.gameOver()
            } else {
                viewBinding.textView6.text = boxArray.get(5).number.toString()
            }
            listner.onTapped(boxArray.get(5))
        }

        // OnLongClickListerner
        viewBinding.frameLayout.setOnLongClickListener {

           it.imageView.setImageResource(R.drawable.flag)
        }
        viewBinding.frameLayout2.setOnLongClickListener {
            it.imageView2.setImageResource(R.drawable.flag)
        }
        viewBinding.frameLayout3.setOnLongClickListener {
            it.imageView3.setImageResource(R.drawable.flag)
        }
        viewBinding.frameLayout4.setOnLongClickListener {

            it.imageView4.setImageResource(R.drawable.flag)
        }
        viewBinding.frameLayout5.setOnLongClickListener {

            it.imageView5.setImageResource(R.drawable.flag)
        }
        viewBinding.frameLayout6.setOnLongClickListener {

            it.imageView6.setImageResource(R.drawable.flag)
        }









        if (boxArray.get(0).isTapped) {
            viewBinding.textView.text = boxArray.get(0).number.toString()
        } else if (boxArray.get(1).isTapped) {
            viewBinding.textView.text = boxArray.get(1).number.toString()
        } else if (boxArray.get(2).isTapped) {
            viewBinding.textView.text = boxArray.get(2).number.toString()
        } else if (boxArray.get(3).isTapped) {
            viewBinding.textView.text = boxArray.get(3).number.toString()
        }else if (boxArray.get(4).isTapped) {
            viewBinding.textView.text = boxArray.get(4).number.toString()
        }else if (boxArray.get(5).isTapped) {
            viewBinding.textView.text = boxArray.get(5).number.toString()
        }


    }

    interface TapListener {
        fun onTapped(box: Box)
        //fun bom(box: Box)
        //fun boxOpen(box: Box)
        fun gameOver()

        fun setOnLongClickListener(box: Box)
    }

}