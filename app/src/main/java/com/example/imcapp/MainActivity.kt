package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Remover a tool bar
        supportActionBar!!.hide()

        //instanciar o botão entrar
        val buttonCriarConta = findViewById<Button>(R.id.button_criar_conta)

        // criar  um listener - ouvinte vai ficar esperando o objeto ser clicado
        buttonCriarConta.setOnClickListener {
            // cirar uma intent "inteção"
            val abrirCadastro = Intent(this, cadastro_imc::class.java)
            startActivity(abrirCadastro)
        }
    }
}