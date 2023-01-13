package com.example.icecreammaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val precioUnitario = 3
    private var cantidad = 1
    private lateinit var textViewPrecio: TextView
    private lateinit var textViewCantidad: TextView
    private lateinit var checkBoxCream: CheckBox
    private lateinit var checkBoxChocolate: CheckBox
    private lateinit var nameImput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewPrecio = findViewById(R.id.price)
        textViewCantidad = findViewById(R.id.amount)
        checkBoxCream = findViewById(R.id.checkBoxCream)
        checkBoxChocolate = findViewById(R.id.checkBoxChocolate)
        nameImput = findViewById(R.id.nameImput)
    }

    fun onClickButtonOrder(vista: View) {
        displayPriceInformation()
    }

    private fun  displayPriceInformation() {
        if (nameImput.text.isNullOrBlank())
            Toast.makeText(applicationContext, "Nombre invalido", Toast.LENGTH_SHORT).show()
        else{
            var info = ("Nombre: ${nameImput.text.toString().trim()}\n¿Incluir crema batida?: ${if (checkBoxCream.isChecked) "Sí" else "No"}\n¿Incluir chocolate?: ${if (checkBoxChocolate.isChecked) "Sí" else "No"}\nCantidad: ${cantidad}\nTotal: ${calculatePrice()} €\n¡Gracias por su visita!")
            textViewPrecio.text = info
        }
    }

    private fun calculatePrice() : Int {
        return (cantidad * precioUnitario)
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

class Icecream(var quantity : Int, var cream : Boolean)