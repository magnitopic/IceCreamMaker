package com.example.icecreammaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RealizarPedido : AppCompatActivity() {
    private val precioUnitario = 3
    private lateinit var textViewPrecio: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
        textViewPrecio = findViewById(R.id.price)
    }

    private fun displayInfo() {
        //var info = ("Nombre: ${nameImput.text.toString().trim()}\n¿Incluir crema batida?: ${if (checkBoxCream.isChecked) "Sí" else "No"}\n¿Incluir chocolate?: ${if (checkBoxChocolate.isChecked) "Sí" else "No"}\nCantidad: ${cantidad}\nTotal: ${calculatePrice()} €\n¡Gracias por su visita!")
        textViewPrecio.text = "Cozas"
    }

    /*private fun calculatePrice(): Int {
        return (cantidad * precioUnitario)
    }*/



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