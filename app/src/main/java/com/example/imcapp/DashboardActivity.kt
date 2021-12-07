package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

class DashboardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var cardPesarAgora: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        supportActionBar!!.hide()

        tvNome = findViewById(R.id.tv_dash_nome)
        tvProfissao = findViewById(R.id.tv_dash_profissao)
        tvAltura = findViewById(R.id.tv_dash_altura)
        cardPesarAgora = findViewById(R.id.card_pesar_agora)

        cardPesarAgora.setOnClickListener {
            val abrirPesagem = Intent(this, activity_pesagem2::class.java)
            startActivity(abrirPesagem)
        }

        //***Carregar os dados da sharedPreferences nos campos da dashboard


        //***Abrir o arquivo cadastro
        val arquivo = getSharedPreferences("cadastro", MODE_PRIVATE)

        //***Pegar os dados do arquivo e jogar nos TextView
        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
    }
}