package com.example.icecreammaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlin.system.exitProcess

class RealizarPedido : AppCompatActivity() {
    private val precioUnitario = 3
    private lateinit var textViewPrecio: TextView
    private lateinit var name: String
    private lateinit var cream: String
    private lateinit var chocolate: String
    private lateinit var amount: String
    private lateinit var email: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
        // Get textView
        textViewPrecio = findViewById(R.id.price)
        // Get variable values
        name = intent.getStringExtra("name").toString()
        cream = intent.getStringExtra("cream").toString()
        chocolate = intent.getStringExtra("chocolate").toString()
        amount = intent.getStringExtra("amount").toString()
        email = intent.getStringExtra("email").toString()
        val info =
            ("Nombre: ${name}\n¿Incluir crema batida?: ${cream}\n¿Incluir chocolate?: ${chocolate}\nCantidad: ${amount}\nTotal: ${precioUnitario * amount.toInt()} €\n¡Gracias por su visita!")
        textViewPrecio.text = info
    }

    fun displayInfo(vista: View) {
    }

    /*private fun calculatePrice(): Int {
        return (cantidad * precioUnitario)
    }*/

    fun goBack(vista: View) {
        finish()
    }

    fun composeEmail(address: Array<String>, message: String, subject: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}