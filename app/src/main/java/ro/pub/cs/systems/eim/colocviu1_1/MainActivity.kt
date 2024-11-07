package ro.pub.cs.systems.eim.colocviu1_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var cardinalButtonCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_colocviu1_1_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textView = findViewById<TextView>(R.id.text_view)
        val buttonNorth = findViewById<Button>(R.id.button_north)
        val buttonLeft = findViewById<Button>(R.id.button_left)
        val buttonRight = findViewById<Button>(R.id.button_right)
        val buttonCenter = findViewById<Button>(R.id.button_center)
        val buttonBelowTextView = findViewById<Button>(R.id.button_below_textview)
        val buttonResetAndNavigate = findViewById<Button>(R.id.button_reset_and_navigate)

        val buttons = listOf(buttonNorth, buttonLeft, buttonRight, buttonCenter, buttonBelowTextView)

        for (button in buttons) {
            button.setOnClickListener {
                if (button == buttonNorth || button == buttonLeft || button == buttonRight || button == buttonCenter) {
                    cardinalButtonCount++
                    Log.d("MainActivity", "Cardinal button pressed. Count: $cardinalButtonCount")
                }
                textView.text = "Buttons pressed: $cardinalButtonCount"
            }
        }

        if (savedInstanceState != null) {
            cardinalButtonCount = savedInstanceState.getInt("cardinalButtonCount", 0)
            Log.d("MainActivity", "Restored cardinalButtonCount: $cardinalButtonCount")
            textView.text = "Buttons pressed: $cardinalButtonCount"
        }

        buttonBelowTextView.setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("instructions", textView.text.toString())
            startActivity(intent)
        }

        buttonResetAndNavigate.setOnClickListener {
            textView.text = ""
            cardinalButtonCount = 0
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra("instructions", "")
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("cardinalButtonCount", cardinalButtonCount)
        Log.d("MainActivity", "Saved cardinalButtonCount: $cardinalButtonCount")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        cardinalButtonCount = savedInstanceState.getInt("cardinalButtonCount", 0)
        Log.d("MainActivity", "Restored cardinalButtonCount: $cardinalButtonCount")
    }
}