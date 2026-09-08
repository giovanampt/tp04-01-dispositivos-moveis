package com.example.tp04_01

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmeAdapter(private val filmes: MutableList<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitulo: TextView = view.findViewById(R.id.tvTitulo)
        val tvDiretor: TextView = view.findViewById(R.id.tvDiretor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return FilmeViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        holder.tvTitulo.text = filme.titulo
        holder.tvDiretor.text = filme.diretor
    }

    override fun getItemCount() = filmes.size

    fun adicionarFilme(filme: Filme) {
        filmes.add(filme)
        notifyItemInserted(filmes.size - 1)
    }
}