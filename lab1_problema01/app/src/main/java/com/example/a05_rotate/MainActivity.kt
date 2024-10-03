package com.example.a05_rotate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageMain: ImageView = findViewById(R.id.content_image_main)

        val images = arrayOf(
            R.mipmap.cubo,
            R.mipmap.android,
            R.mipmap.angular,
            R.mipmap.dropbox,
            R.mipmap.jabali,
            R.mipmap.bluetooh,
            R.mipmap.kraken,
            R.mipmap.a500px,
            R.mipmap.docker
        )

        for (i in images.indices) {
            val imageViewId = resources.getIdentifier("image_${i + 1}", "id", packageName)
            val imageView: ImageView = findViewById(imageViewId)

            imageView.setOnClickListener {
                imageMain.setImageResource(images[i])
            }
        }
    }
}