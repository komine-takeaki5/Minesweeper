package android.lifeistech.com.minesweeper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GameOver : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
    }
    fun back(v: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

    }
    override fun onBackPressed() {
    }
}
