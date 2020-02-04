package android.lifeistech.com.minesweeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GameOver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
    }

    override fun onBackPressed() {}
}
