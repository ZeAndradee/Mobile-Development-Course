package com.example.myprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Declarando variaveis dos botoes do xml
        val btnGithub = findViewById<Button>(R.id.btnGithub)
        val btnLinkedin = findViewById<Button>(R.id.btnLinkedin)
        val darkModeSwitch = findViewById<Switch>(R.id.darkModeSwitch)


        //Listeners dos botões
        btnLinkedin.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://www.linkedin.com/in/zeandrade/".toUri())
            startActivity(intent)
        }

        btnGithub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://github.com/ZeAndradee".toUri())
            startActivity(intent)
        }

        //Logica Dark Mode
        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }

        }

        }
}