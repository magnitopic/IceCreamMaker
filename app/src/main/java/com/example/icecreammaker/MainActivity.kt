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
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private var amount = 1
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
        else {
            var i = Intent(this, RealizarPedido::class.java)
            i.putExtra("name", nameInput.text.toString().trim())
            i.putExtra("cream", if (checkBoxCream.isChecked) "Sí" else "No")
            i.putExtra("chocolate", if (checkBoxChocolate.isChecked) "Sí" else "No")
            i.putExtra("amount", amount.toString())
            i.putExtra("email", emailInput.text.toString())
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

    fun CharSequence?.isValidEmail() =
        !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

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


