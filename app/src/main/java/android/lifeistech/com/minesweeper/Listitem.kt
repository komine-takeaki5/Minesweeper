package android.lifeistech.com.minesweeper

import android.lifeistech.com.minesweeper.databinding.ItemListBinding
import android.util.Log
import android.widget.ImageView
import com.xwray.groupie.databinding.BindableItem
import androidx.databinding.BindingAdapter


class ListItem(val box1: Box, val box2: Box, val box3: Box) : BindableItem<ItemListBinding>() {
    override fun getLayout(): Int = R.layout.item_list

    override fun bind(viewBinding: ItemListBinding, position: Int) {
        if (box1.isTapped) {
            viewBinding.imageView.setImageResource(R.drawable.blacksquare)
        } else {
            viewBinding.imageView.setImageResource(R.drawable.bluesquare)
        }

        viewBinding.frameLayout.setOnClickListener {
            if (box1.hasBom){
                Log.e("TAG","GAME OVER")
            }else{
                viewBinding.textView.text = box1.number.toString()
            }
        }
        viewBinding.frameLayout2.setOnClickListener {
            if (box2.hasBom) {
                Log.e("TAG","GAME OVER")
            } else {
                viewBinding.textView2.text = box2.number.toString()
            }
        }
        viewBinding.frameLayout3.setOnClickListener {
            if (box3.hasBom) {
                Log.e("TAG","GAME OVER")
            } else {
                viewBinding.textView3.text = box3.number.toString()
            }
        }




        //TODO; box2,box3実装


    }


}

//@BindingAdapter("app:srcCompat")
//fun bindSrcCompat(view: ImageView, resourceId: Int) {
//    view.setImageResource(resourceId)
//}