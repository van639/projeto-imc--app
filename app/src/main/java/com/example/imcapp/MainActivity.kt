package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var btnEntrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Remover a tool bar
        supportActionBar!!.hide()

        //instanciar o botão criar conta
        val buttonCriarConta = findViewById<Button>(R.id.button_criar_conta)

        editEmail = findViewById(R.id.edit_login_email)
        editSenha = findViewById(R.id.edit_login_senha)
        btnEntrar = findViewById(R.id.btn_entrar)

        btnEntrar.setOnClickListener {
            login()
        }


        // criar  um listener - ouvinte vai ficar esperando o objeto ser clicado
        buttonCriarConta.setOnClickListener {
            // cirar uma intent "inteção"
            val abrirCadastro = Intent(this, CadastroUsuario::class.java)
            startActivity(abrirCadastro)
        }
    }

    private fun login() {
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        val email = arquivo.getString("email", "")
        val senha = arquivo.getString("senha", "")

        val emailDigitado = editEmail.text.toString()
        val senhaDigitado = editSenha.text.toString()

        if (emailDigitado == email && senhaDigitado == senha){
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Usúario ou senha incorretos!!", Toast.LENGTH_SHORT).show()
        }
    }
}