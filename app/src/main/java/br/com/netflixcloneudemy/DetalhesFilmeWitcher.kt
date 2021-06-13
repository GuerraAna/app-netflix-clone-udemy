package br.com.netflixcloneudemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.netflixcloneudemy.adapter.FilmesAdapter
import br.com.netflixcloneudemy.databinding.ActivityDetalhesFilmeBinding
import br.com.netflixcloneudemy.model.addFilmes
import com.squareup.picasso.Picasso

class DetalhesFilmeWitcher : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        toolbarVoltarListaFilmes()

        recyclerViewListaFilmesDetalhes()

        imagensFirebasePicasso()

        playParaVideoWitcher()
    }

    private fun toolbarVoltarListaFilmes() {
        val toolbarDetalhesFilmes = binding.toolbarDetalhesFilme
        toolbarDetalhesFilmes.setNavigationIcon(getDrawable(R.drawable.ic_voltar_lista_filmes))
        toolbarDetalhesFilmes.setNavigationOnClickListener {
            val intent = Intent(this, ListaFilmes::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun recyclerViewListaFilmesDetalhes() {
        val recyclerViewMaisFilmes = binding.recyclerOutrosFilmes
        recyclerViewMaisFilmes.adapter = FilmesAdapter(addFilmes())
        recyclerViewMaisFilmes.layoutManager = GridLayoutManager(applicationContext, 3)
    }

    private fun imagensFirebasePicasso() {
        val capaFilmeWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-clone-udemy.appspot.com/o/video.jpg?alt=media&token=360cc268-5630-4ab0-80b9-d3b4265cc666"
        Picasso.get().load(capaFilmeWitcher).fit().into(binding.ivVideoWitcher)
    }

    private fun playParaVideoWitcher() {
        val buttonPlayVideo = binding.ivStartVideoWitcher
        buttonPlayVideo.setOnClickListener {
            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }
    }
}