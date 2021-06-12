package br.com.netflixcloneudemy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.netflixcloneudemy.databinding.ItemViewRecylerViewBinding
import br.com.netflixcloneudemy.model.Filmes

class FilmesAdapter(val filmes: MutableList<Filmes>): RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>() {

    //3) Localização dos itens da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val binding = ItemViewRecylerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmesViewHolder(binding)
    }
    //4) Posição dos itens da lista
    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        with(holder) {
            with(filmes[position]) {
                binding.ivItemImagemFilme.setImageResource(capaFilmes)
            }
        }
    }

    //2) Quantidade de itens na lista
    override fun getItemCount() = filmes.size

    //1)
    inner class FilmesViewHolder(val binding: ItemViewRecylerViewBinding): RecyclerView.ViewHolder(binding.root) {

    }
}