package android.lifeistech.com.minesweeper

 public class Box(var isTapped :Boolean,var number:Int,var hasBom :Boolean,var row:Int ,
                var column:Int,var hasFlag:Boolean){

    // flag
    // row
    // column


    override fun toString(): String {
        return "【bom;"  + hasBom.toString() + ",number;" + number.toString()+ "】"
    }
}
