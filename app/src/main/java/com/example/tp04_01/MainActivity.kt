package com.example.tp04_01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: FilmeAdapter
    private val listaFilmes = mutableListOf<Filme>()
    private var isGridView = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvFilmes = findViewById<RecyclerView>(R.id.rvFilmes)
        val etTitulo = findViewById<EditText>(R.id.etTitulo)
        val etDiretor = findViewById<EditText>(R.id.etDiretor)
        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        val btnAlternarLayout = findViewById<Button>(R.id.btnAlternarLayout)

        // Inicializa o Adapter
        adapter = FilmeAdapter(listaFilmes)
        rvFilmes.adapter = adapter

        // Começa com Layout de Lista (Linear)
        rvFilmes.layoutManager = LinearLayoutManager(this)

        // Botão Adicionar
        btnAdicionar.setOnClickListener {
            val titulo = etTitulo.text.toString()
            val diretor = etDiretor.text.toString()

            if (titulo.isNotEmpty() && diretor.isNotEmpty()) {
                adapter.adicionarFilme(Filme(titulo, diretor))
                etTitulo.text.clear()
                etDiretor.text.clear()
            }
        }

        // Botão Alternar LayoutManager (Exigência do trabalho)
        btnAlternarLayout.setOnClickListener {
            if (isGridView) {
                rvFilmes.layoutManager = LinearLayoutManager(this)
            } else {
                rvFilmes.layoutManager = GridLayoutManager(this, 2) // Grid com 2 colunas
            }
            isGridView = !isGridView
        }
    }
}