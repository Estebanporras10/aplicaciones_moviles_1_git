package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var txtNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtNombre = findViewById(R.id.txtNombre)
    }

    fun ejecutar(view: View) {
        var aplicar = true
        val nombre = txtNombre.text.toString().trim() // Obtener el nombre sin espacios

        // Validar que el nombre no esté vacío
        if (nombre.isEmpty() && aplicar) {
            Toast.makeText(this, "Nombre requerido", Toast.LENGTH_SHORT).show()
            txtNombre.requestFocus()
            aplicar = false
        }

        // Validar que el nombre no exceda los 10 caracteres
        if (nombre.length > 10 && aplicar) {
            Toast.makeText(this, "El nombre no puede exceder los 10 caracteres", Toast.LENGTH_SHORT).show()
            txtNombre.requestFocus()
            aplicar = false
        }

        // Validar que el nombre no contenga números
        if (nombre.any { it.isDigit() } && aplicar) {
            Toast.makeText(this, "El nombre no puede contener números", Toast.LENGTH_SHORT).show()
            txtNombre.requestFocus()
            aplicar = false
        }

        // Si todas las validaciones pasan, invoca la otra ventana
        if (aplicar) {
            val laotra = Intent(this, gameActivity::class.java)
            laotra.putExtra("nombre", nombre)
            startActivity(laotra)
        }
    }
}
