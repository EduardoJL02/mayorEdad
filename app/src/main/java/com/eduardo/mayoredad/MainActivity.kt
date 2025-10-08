package com.eduardo.mayoredad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val miNumero: EditText = findViewById(R.id.etNumero)
        val miBoton: Button = findViewById(R.id.btnEnviar)
        val textoResultado: TextView = findViewById(R.id.tvResultado)

        val botonSumar: Button = findViewById(R.id.sumarEdad)
        val botonRestar: Button = findViewById(R.id.restarEdad)

        // función para evaluar y mostrar resultado
        fun comprobarEdad() {
            val numeroResultado = miNumero.text.toString().toIntOrNull()
            textoResultado.text = when {
                numeroResultado == null -> "Introduce un valor"
                numeroResultado < 18 -> "Eres menor de edad"
                numeroResultado > 18 -> "Eres mayor de edad"
                else -> "Tienes justo 18 años"
            }
        }

        // Botón comprobar
        miBoton.setOnClickListener {
            comprobarEdad()
        }

        // Botón restar
        botonRestar.setOnClickListener {
            val numeroResultado = miNumero.text.toString().toIntOrNull()
            if (numeroResultado == null) {
                textoResultado.text = "Introduce un valor"
            } else {
                miNumero.setText((numeroResultado - 1).toString())
                comprobarEdad()
            }
        }

        // Botón sumar
        botonSumar.setOnClickListener {
            val numeroResultado = miNumero.text.toString().toIntOrNull()
            if (numeroResultado == null) {
                textoResultado.text = "Introduce un valor"
            } else {
                miNumero.setText((numeroResultado + 1).toString())
                comprobarEdad()
            }
        }
    }
}
