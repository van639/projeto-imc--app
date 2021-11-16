package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

class CadastroUsuario : AppCompatActivity() {

    //Declaração de variavel global e pedindo para esperar a inicialização do oncreate
    lateinit var editEmail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_imc)

        editEmail = findViewById(R.id.edit_novo_email)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_novo_usuario, menu)

        return true
    }

    // Fazer uma ação quando algum item do menu foi clicado
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        //Salvar os dados do usuario em sharedPreferences
        //Criar um arquivo sharedPreferences
        //Se o arquivo já existir o arquivo será aberto
        val dados = getSharedPreferences("cadastro", MODE_PRIVATE)

        // Criar um editor para o arquivo "para salvar dados do cadastro, gravar coisas nesse arquivo"
        val editor = dados.edit()
        editor.putString("email", editEmail.text.toString())
        editor.apply()

        return true
    }

}