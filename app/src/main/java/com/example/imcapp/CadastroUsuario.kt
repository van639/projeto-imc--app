package com.example.imcapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.util.*

class CadastroUsuario : AppCompatActivity() {

    //Declaração de variavel global e pedindo para esperar a inicialização do oncreate
    lateinit var editEmail : EditText
    lateinit var editSenha : EditText
    lateinit var editNome : EditText
    lateinit var editAltura : EditText
    lateinit var editProfissao : EditText
    lateinit var editDataDeNascimento : EditText
    lateinit var radioFeminino : RadioButton
    lateinit var radioMasculino : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_imc)

        editEmail = findViewById(R.id.edit_novo_email)
        editSenha = findViewById(R.id.edit_nova_senha)
        editNome = findViewById(R.id.edit_novo_nome)
        editAltura = findViewById(R.id.edit_nova_altura)
        editProfissao = findViewById(R.id.edit_nova_profissao)
        editDataDeNascimento = findViewById(R.id.edit_nova_datadenascimento)
        radioFeminino = findViewById(R.id.radio_feminino)
        radioMasculino = findViewById(R.id.radio_masculino)

        // ** Abrir um calendarioao clicar no campo de datadeNascimento
        editDataDeNascimento.setOnClickListener {
            abrirCalendario()
        }

    }

    private fun abrirCalendario() {

        //Pegar um calendario
        val calendario = Calendar.getInstance()
        //Pegar o dia do mÊs
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        //Pegar o mes atual
        val mes = calendario.get(Calendar.MONTH)
        //Pegar o ano atual
        val ano = calendario.get(Calendar.YEAR)

        // Janeiro se inicia em 0 para o computador ou seja fev = 1 ...
        //Quando clicar no ok vai pegar as informações que o usúario adcionou no calendario e vai guardar
        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            //Colocar um zero a esquerda em mes que tem 1, 2, 3 = 01, 02, 03
            var mesFinal = ""

            if (month < 9){
                mesFinal = "0${month + 1}"
            }else {
                mesFinal = "${month +1}"
            }

            var diaFinal = ""

            if (dayOfMonth < 10) {
                diaFinal = "0$dayOfMonth"
            } else {
                diaFinal = "$dayOfMonth"
            }

            editDataDeNascimento.setText("$diaFinal/$mesFinal/$year")

        }, ano, mes, dia)

        dpd.show()
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
        editor.putString("senha", editSenha.text.toString())
        editor.putString("nome", editNome.text.toString())
        editor.putFloat("altura", editAltura.text.toString().toFloat())
        editor.putString("datadenascimento", editDataDeNascimento.text.toString())
        editor.putString("profissao", editProfissao.text.toString())
        editor.putString("sexo", if (radioFeminino.isChecked)"F" else "M")
        editor.apply()

        Toast.makeText(this, "Usúario cadastrado com sucesso", Toast.LENGTH_SHORT).show()
        finish()

        return true
    }

}