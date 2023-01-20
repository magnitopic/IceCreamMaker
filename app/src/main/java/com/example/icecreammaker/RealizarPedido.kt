package com.example.icecreammaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class RealizarPedido : AppCompatActivity() {
    private val precioUnitario = 3
    private lateinit var textViewPrecio: TextView
    private lateinit var name: String
    private lateinit var cream: String
    private lateinit var chocolate: String
    private lateinit var sprinkles: String
    private lateinit var amount: String
    private lateinit var info: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
        // Get textView
        textViewPrecio = findViewById(R.id.price)
        // Get variable values
        name = intent.getStringExtra("name").toString()
        cream = intent.getStringExtra("cream").toString()
        chocolate = intent.getStringExtra("chocolate").toString()
        sprinkles = intent.getStringExtra("sprinkles").toString()
        amount = intent.getStringExtra("amount").toString()
        // Show data in textView
        info =
            ("Nombre: ${name}\n¿Incluir crema batida?: ${cream}\n¿Incluir chocolate?: ${chocolate}\n¿Incluir sprinkles?: ${sprinkles}\nCantidad: ${amount}\nTotal: ${precioUnitario * amount.toInt()} €\n¡Gracias por su visita!")
        textViewPrecio.text = info
    }

    fun makeOrder(vista: View) {
        composeEmail(arrayOf("magnitrash@gmail.com"), "Nuevo pedido de helados", info)
        finish()
    }

    fun goBack(vista: View) {
        finish()
    }

    fun composeEmail(address: Array<String>, subject: String, message: String) {
        val newEmail = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (newEmail.resolveActivity(packageManager) != null) {
            startActivity(newEmail)
        }
    }
}