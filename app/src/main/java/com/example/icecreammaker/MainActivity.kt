package com.example.icecreammaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val precioUnitario = 3
    private var cantidad = 0
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
        cantidad++
        textViewCantidad.text = cantidad.toString()
    }

    fun decrese(Vista : View){
        if (cantidad>0){
            cantidad--
            textViewCantidad.text = cantidad.toString()
        }
    }
}