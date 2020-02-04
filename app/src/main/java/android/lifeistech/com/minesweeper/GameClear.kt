package android.lifeistech.com.minesweeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GameClear : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_clear)
    }

    override fun onBackPressed() {}
}
