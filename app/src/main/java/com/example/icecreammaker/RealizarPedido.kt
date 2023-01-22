package com.example.icecreammaker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class RealizarPedido : AppCompatActivity() {
    private val precioUnitario = 3
    private val precioTopings = .5
    private lateinit var textViewDetails: TextView
    private lateinit var info: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
        // Get textView
        textViewDetails = findViewById(R.id.details)
        // Get variable values
        val name = intent.getStringExtra("name")
        val cream = intent.getBooleanExtra("cream", false)
        val chocolate = intent.getBooleanExtra("chocolate", false)
        val sprinkles = intent.getBooleanExtra("sprinkles", false)
        val amount = intent.getIntExtra("amount", 1)
        // Show data in textView
        info =
            ("Nombre: ${name}\n" +
                    "¿Incluir crema batida?: ${if (cream) "Sí" else "No"}\n" +
                    "¿Incluir chocolate?: ${if (chocolate) "Sí" else "No"}\n" +
                    "¿Incluir sprinkles?: ${if (sprinkles) "Sí" else "No"}\n" +
                    "Cantidad: ${amount}\n" +
                    "Total: ${
                        calcularPrecio(
                            amount,
                            arrayOf(
                                boolToInt(cream),
                                boolToInt(chocolate),
                                boolToInt(sprinkles)
                            )
                        )
                    } €\n" +
                    "¡Gracias por su visita!")
        // Display order details
        textViewDetails.text = info
    }

    fun makeOrder(vista: View) {
        composeEmail(arrayOf("magnitrash@gmail.com"), info)
        finish()
    }

    fun goBack(vista: View) {
        finish()
    }

    private fun calcularPrecio(amount: Int, topings: Array<Int>): Double {
        return (amount * precioUnitario) + (topings.sum() * precioTopings)
    }

    private fun boolToInt(variable: Boolean): Int {
        if (variable) return 1 else return 0
    }

    private fun composeEmail(address: Array<String>, message: String) {
        val newEmail = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT, "Nuevo pedido de helados")
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (newEmail.resolveActivity(packageManager) != null) {
            startActivity(newEmail)
        }
    }
}
