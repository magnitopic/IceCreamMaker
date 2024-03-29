package com.example.icecreammaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var amount = 1
    private lateinit var textViewCantidad: TextView
    private lateinit var checkBoxCream: CheckBox
    private lateinit var checkBoxChocolate: CheckBox
    private lateinit var checkBoxSprinkles: CheckBox
    private lateinit var nameInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewCantidad = findViewById(R.id.amount)
        checkBoxCream = findViewById(R.id.checkBoxCream)
        checkBoxChocolate = findViewById(R.id.checkBoxChocolate)
        checkBoxSprinkles = findViewById(R.id.checkBoxSprinkles)
        nameInput = findViewById(R.id.nameImput)
    }

    fun onClickOrderInfo(vista: View) {
        if (nameInput.text.isNullOrBlank())
            Toast.makeText(applicationContext, "Se debe dar un nombre", Toast.LENGTH_SHORT).show()
        else {
            val i = Intent(this, RealizarPedido::class.java).apply {
                putExtra("name", nameInput.text.toString().trim())
                putExtra("cream", checkBoxCream.isChecked)
                putExtra("chocolate", checkBoxChocolate.isChecked)
                putExtra("sprinkles", checkBoxSprinkles.isChecked)
                putExtra("amount", amount)
            }
            startActivity(i)
        }
    }

    fun increase(Vista: View) {
        if (amount < 10) {
            amount++
            textViewCantidad.text = amount.toString()
        } else
            Toast.makeText(
                applicationContext,
                "Numero maximo de helados alcanzado",
                Toast.LENGTH_SHORT
            ).show()
    }

    fun decrese(Vista: View) {
        if (amount > 1) {
            amount--
            textViewCantidad.text = amount.toString()
        } else
            Toast.makeText(
                applicationContext,
                "Numero minimo de helados alcanzado",
                Toast.LENGTH_SHORT
            ).show()
    }
}


