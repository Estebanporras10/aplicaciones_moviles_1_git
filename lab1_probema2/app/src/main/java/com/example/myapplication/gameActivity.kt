package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class gameActivity : AppCompatActivity() {

    private lateinit var lblNombre: EditText
    private lateinit var imageToFind: ImageView
    private val imageResources = arrayOf(
        R.mipmap.twitter,
        R.mipmap.youtube,
        R.mipmap.facebook,
        R.mipmap.instagram,
        R.mipmap.telegram,
        R.mipmap.whatsapp
    )

    private lateinit var gridImages: List<ImageView>
    private val hiddenImages = mutableListOf<Int>()
    private var score = 0  // Puntuación del jugador
    private lateinit var scoreTextView: EditText  // Referencia al campo de puntuación

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        // Obtiene el nombre del jugador
        val nombre = intent.extras!!.get("nombre")!!.toString()
        lblNombre = findViewById(R.id.lblNombre)
        lblNombre.setEnabled(false)
        lblNombre.setText(nombre)

        // Vincula el ImageView de la imagen superior
        imageToFind = findViewById(R.id.imageToFind)

        // Selecciona una imagen aleatoria para la parte superior
        val randomIndex = Random.nextInt(imageResources.size)
        val selectedImage = imageResources[randomIndex]
        imageToFind.setImageResource(selectedImage)
        imageToFind.tag = selectedImage // Asigna el tag a imageToFind

        // Prepara la lógica para el grid (imágenes ocultas)
        prepareGrid()

        // Vincula el EditText de puntuación
        scoreTextView = findViewById(R.id.scoreTextView)
        scoreTextView.setText(score.toString())
    }

    private fun prepareGrid() {
        hiddenImages.addAll(imageResources)
        hiddenImages.addAll(imageResources) // Para tener pares de imágenes (memoria)
        hiddenImages.shuffle()

        gridImages = listOf(
            findViewById(R.id.imageView1),
            findViewById(R.id.imageView2),
            findViewById(R.id.imageView3),
            findViewById(R.id.imageView4),
            findViewById(R.id.imageView5),
            findViewById(R.id.imageView6),
            findViewById(R.id.imageView7),
            findViewById(R.id.imageView8),
            findViewById(R.id.imageView9),
            findViewById(R.id.imageView10),
            findViewById(R.id.imageView11),
            findViewById(R.id.imageView12),
            findViewById(R.id.imageView13),
            findViewById(R.id.imageView14),
            findViewById(R.id.imageView15),
            findViewById(R.id.imageView16),
            findViewById(R.id.imageView17),
            findViewById(R.id.imageView18),
            findViewById(R.id.imageView19),
            findViewById(R.id.imageView20)
        )

        val gridSize = hiddenImages.size
        for (i in 0 until gridSize) {
            val imageView = gridImages[i]
            imageView.tag = hiddenImages[i]  // Asigna la imagen oculta en el tag
            Log.d("gameActivity", "Tamaño de la lista: ${hiddenImages.size}")
            Log.d("gameActivity", "Índice accedido: $i")

            // Configura el evento de clic para voltear la imagen
            imageView.setOnClickListener {
                revealImage(imageView)
            }
        }
    }

    private fun revealImage(imageView: ImageView) {
        val hiddenImageResId = imageView.tag as? Int  // Casting seguro para obtener el tag
        val upperImageResId = imageToFind.tag as? Int // Obtener el tag de la imagen superior

        // Comprobar si hiddenImageResId es null
        if (hiddenImageResId == null || upperImageResId == null) {
            Log.e("gameActivity", "Error: tag es null para el ImageView o la imagen superior")
            return  // Salir de la función si el tag es null
        }

        imageView.setImageResource(hiddenImageResId)  // Cambia la imagen mostrada

        // Verifica si la imagen coincide con la de arriba
        if (hiddenImageResId != upperImageResId) {
            // Si no coincide, se le resta 10 puntos y oculta la imagen nuevamente
            Toast.makeText(this, "No coincide!", Toast.LENGTH_SHORT).show()
            score -= 10
            scoreTextView.setText(score.toString())

            // Oculta la imagen después de 1 segundo
            Handler().postDelayed({
                imageView.setImageResource(R.mipmap.ic_launcher) // Cambia a la imagen por defecto
            }, 1000) // 1000 ms = 1 segundo
        } else {
            // Si coincide, se suman 10 puntos
            Toast.makeText(this, "¡Coincide!", Toast.LENGTH_SHORT).show()
            score += 100
            scoreTextView.setText(score.toString())
        }
    }


}
