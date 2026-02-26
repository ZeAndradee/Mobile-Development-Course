package com.example.exercise01

import android.content.ContentValues.TAG
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "→ onCreate: App iniciado")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Referenciando meus itens do XML
        val tvMensagem: TextView = findViewById(R.id.tvMensagem)
        val btnMudar: Button = findViewById(R.id.btnMudar)

        val cores = arrayOf(
            Color.parseColor("#3488FF"),
            Color.parseColor("red"),
            Color.parseColor("white"),
            Color.parseColor("blue"),
            Color.parseColor("green"),
        )

        //Posicao array de cores
        var indice = 0
        //Contador de cliques
        var cliques = 0

        btnMudar.setOnClickListener {
            Log.i(TAG, "Botão Clicado!")
            //Atualizar contador
            cliques++
            tvMensagem.text = "Você clicou nesse botão: $cliques ${if(cliques > 1) "vezes" else "vez"}!"


            //Atualizar cor do fundo
            indice = (indice + 1) % cores.size
            findViewById<ConstraintLayout>(R.id.main)
                .setBackgroundColor(cores[indice])
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "→ onStart: Tela visível")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "→ onResume: App em foco")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "→ onPause: Perdeu foco")
    }
}