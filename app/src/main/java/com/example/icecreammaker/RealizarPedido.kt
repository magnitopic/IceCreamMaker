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
    private lateinit var textViewPrecio: TextView
    private lateinit var info: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realizar_pedido)
        // Get textView
        textViewPrecio = findViewById(R.id.price)
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
                            arrayOf<Int>(
                                boolToInt(cream),
                                boolToInt(chocolate),
                                boolToInt(sprinkles)
                            )
                        )
                    } €\n" +
                    "¡Gracias por su visita!")
        textViewPrecio.text = info
    }

    fun makeOrder(vista: View) {
        composeEmail(arrayOf("magnitrash@gmail.com"), "Nuevo pedido de helados", info)
        finish()
    }

    fun goBack(vista: View) {
        finish()
    }

    fun calcularPrecio(amount: Int, topings: Array<Int>): Double {
        val price = (amount * precioUnitario) + (topings.sum() * precioTopings)
        return price
    }

    fun boolToInt(variable: Boolean): Int {
        if (variable) return 1 else return 0
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
