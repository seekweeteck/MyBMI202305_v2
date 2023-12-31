package my.edu.tarc.mybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Declaration of variables
        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus : TextView = findViewById(R.id.textViewStatus)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val buttonReset: Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {
            if(editTextWeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.error_input))
                return@setOnClickListener //terminate program execution here
            }
            if(editTextHeight.text.isEmpty()){
                editTextHeight.setError(getString(R.string.error_input))
                return@setOnClickListener //terminate program execution here
            }
            val weight: Float = editTextWeight.text.toString().toFloat()
            val height = editTextHeight.text.toString().toFloat()
            val bmi = weight/ (height/100).pow(2)
            if(bmi < 18.5){ //underweight
                textViewBMI.text = String.format("%s : %.2f",
                        getString(R.string.bmi),bmi)//BMI : 18.45
                imageViewBMI.setImageResource(R.drawable.under)
            }

        }
        buttonReset.setOnClickListener {

        }

    }
}