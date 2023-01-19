package com.example.icecreammaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    private var cantidad = 1
    private lateinit var textViewCantidad: TextView
    private lateinit var checkBoxCream: CheckBox
    private lateinit var checkBoxChocolate: CheckBox
    private lateinit var nameInput: EditText
    private lateinit var emailInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewCantidad = findViewById(R.id.amount)
        checkBoxCream = findViewById(R.id.checkBoxCream)
        checkBoxChocolate = findViewById(R.id.checkBoxChocolate)
        nameInput = findViewById(R.id.nameImput)
        emailInput = findViewById(R.id.emailInput)
    }

    fun onClickOrderInfo(vista: View) {
        if (nameInput.text.isNullOrBlank() || emailInput.text.isNullOrBlank())
            Toast.makeText(applicationContext, "No puede haber campos vacios", Toast.LENGTH_SHORT)
                .show()
        else
            startActivity(Intent(this, RealizarPedido::class.java))
    }

    fun increase(Vista: View) {
        if (cantidad < 10) {
            cantidad++
            textViewCantidad.text = cantidad.toString()
        } else
            Toast.makeText(
                applicationContext,
                "Numero maximo de helados alcanzado",
                Toast.LENGTH_SHORT
            ).show()
    }

    fun CharSequence?.isValidEmail() =
        !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    fun decrese(Vista: View) {
        if (cantidad > 1) {
            cantidad--
            textViewCantidad.text = cantidad.toString()
        } else
            Toast.makeText(
                applicationContext,
                "Numero minimo de helados alcanzado",
                Toast.LENGTH_SHORT
            ).show()
    }
}


