package ro.pub.cs.systems.eim.colocviu1_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondary_activity)

        val instructions = intent.getStringExtra("instructions")
        val textView = findViewById<TextView>(R.id.text_view_instructions)
        textView.text = instructions

        val buttonRegister = findViewById<Button>(R.id.button_register)
        val buttonCancel = findViewById<Button>(R.id.button_cancel)

        buttonRegister.setOnClickListener {
            Toast.makeText(this, buttonRegister.text, Toast.LENGTH_SHORT).show()
            val returnIntent = Intent()
            setResult(RESULT_OK, returnIntent)
            finish()
        }

        buttonCancel.setOnClickListener {
            Toast.makeText(this, buttonCancel.text, Toast.LENGTH_SHORT).show()
            val returnIntent = Intent()
            setResult(RESULT_CANCELED, returnIntent)
            finish()
        }
    }
}