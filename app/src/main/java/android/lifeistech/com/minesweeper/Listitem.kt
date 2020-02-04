package android.lifeistech.com.minesweeper

import android.lifeistech.com.minesweeper.databinding.ItemListBinding
import android.util.Log
import android.widget.ImageView
import com.xwray.groupie.databinding.BindableItem
import androidx.databinding.BindingAdapter


class ListItem(val box1: Box, val box2: Box, val box3: Box, val lister :TapListener) : BindableItem<ItemListBinding>() {

    override fun getLayout(): Int = R.layout.item_list

    override fun bind(viewBinding: ItemListBinding, position: Int) {
        if (box1.isTapped) {
            viewBinding.imageView.setImageResource(R.drawable.blacksquare)
        } else {
            viewBinding.imageView.setImageResource(R.drawable.bluesquare)
        }

        viewBinding.frameLayout.setOnClickListener {
            if (box1.hasBom){
               viewBinding.imageView.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            }else{
                viewBinding.textView.text = box1.number.toString()
            }
            lister.onTapped()
        }
        viewBinding.frameLayout2.setOnClickListener {
            if (box2.hasBom) {
                viewBinding.imageView2.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView2.text = box2.number.toString()
            }
            lister.onTapped()
        }
        viewBinding.frameLayout3.setOnClickListener {
            if (box3.hasBom) {
                viewBinding.imageView3.setImageResource(R.drawable.bom_image)
                lister.gameOver()
            } else {
                viewBinding.textView3.text = box3.number.toString()
            }
            lister.onTapped()
        }
    }


}
 interface TapListener{
     fun onTapped()
     fun gameOver()
 }