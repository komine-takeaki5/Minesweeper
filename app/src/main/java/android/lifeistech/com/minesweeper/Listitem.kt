package android.lifeistech.com.minesweeper

import android.lifeistech.com.minesweeper.databinding.ItemListBinding
import android.util.Log
import android.widget.ImageView
import com.xwray.groupie.databinding.BindableItem
import androidx.databinding.BindingAdapter


class ListItem(val boxArray: MutableList<Box>, val lister :TapListener) : BindableItem<ItemListBinding>() {

    override fun getLayout(): Int = R.layout.item_list

    override fun bind(viewBinding: ItemListBinding, position: Int) {

        viewBinding.frameLayout.setOnClickListener {
            if (boxArray.get(0).hasBom) {
                viewBinding.imageView.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView.text = boxArray.get(0).number.toString()
            }
            lister.onTapped()
        }
        viewBinding.frameLayout2.setOnClickListener {
            if (boxArray.get(1).hasBom) {
                viewBinding.imageView2.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView2.text = boxArray.get(1).number.toString()
            }
            lister.onTapped()
        }
        viewBinding.frameLayout3.setOnClickListener {
            if (boxArray.get(2).hasBom) {
                viewBinding.imageView3.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView3.text = boxArray.get(2).number.toString()
            }
            lister.onTapped()
        }
        viewBinding.frameLayout4.setOnClickListener {
            if (boxArray.get(3).hasBom) {
                viewBinding.imageView4.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView4.text = boxArray.get(3).number.toString()
            }
            lister.onTapped()
        }
        viewBinding.frameLayout5.setOnClickListener {
            if (boxArray.get(4).hasBom) {
                viewBinding.imageView5.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView5.text = boxArray.get(4).number.toString()
            }
            lister.onTapped()
        }
        viewBinding.frameLayout6.setOnClickListener {
            if (boxArray.get(5).hasBom) {
                viewBinding.imageView6.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView6.text = boxArray.get(5).number.toString()
            }
            lister.onTapped()
        }

        if (boxArray.get(0).isTapped) {
            viewBinding.textView.text = boxArray.get(0).number.toString()
        } else if (boxArray.get(1).isTapped) {
            viewBinding.textView.text = boxArray.get(1).number.toString()
        } else if (boxArray.get(2).isTapped) {
            viewBinding.textView.text = boxArray.get(2).number.toString()
        }else if (boxArray.get(3).isTapped) {
            viewBinding.textView.text = boxArray.get(3).number.toString()
        }else if (boxArray.get(4).isTapped) {
            viewBinding.textView.text = boxArray.get(4).number.toString()
        }else if (boxArray.get(5).isTapped) {
            viewBinding.textView.text = boxArray.get(5).number.toString()
        }


    }

    interface TapListener {
        fun onTapped()
        fun gameOver()
    }
}