package android.lifeistech.com.minesweeper

data class Box(var isTapped :Boolean,var number:Int,var hasBom :Boolean){


    override fun toString(): String {
        return "【bom;"  + hasBom.toString() + ",number;" + number.toString()+ "】"
    }
}
