package android.lifeistech.com.minesweeper

data class Box(var isTapped: Boolean = false,
               var number: Int = 0,
               var hasBom: Boolean = false,
               var hasFlag: Boolean = false) { 


    // flag
    // row
    // column


    /*override fun toString(): String {
        return "【bom;"  + hasBom.toString() + ",number;" + number.toString()+ "】"
    }*/
}
