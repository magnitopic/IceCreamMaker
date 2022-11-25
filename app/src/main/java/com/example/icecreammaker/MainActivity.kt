package com.example.icecreammaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val precioUnitario = 3
    private var cantidad = 1
    private lateinit var textViewPrecio: TextView
    private lateinit var textViewCantidad: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewPrecio = findViewById(R.id.price)
        textViewCantidad = findViewById(R.id.amount)
    }

    fun onClickButtonOrder(vista: View) {
        displayAndCalculatePriceInformation()
    }

    private fun displayAndCalculatePriceInformation() {
        var precioFinal = cantidad * precioUnitario
        textViewPrecio.text = "€ "+precioFinal
    }

    fun increase(Vista : View){
        if (cantidad < 10){
            cantidad++
            textViewCantidad.text = cantidad.toString()
        }else
            Toast.makeText(applicationContext, "Numero maximo de helados alcanzado", Toast.LENGTH_SHORT).show()
    }

    fun decrese(Vista : View){
        if (cantidad > 1){
            cantidad--
            textViewCantidad.text = cantidad.toString()

        }
        else
            Toast.makeText(applicationContext, "Numero minimo de helados alcanzado", Toast.LENGTH_SHORT).show()
    }
}