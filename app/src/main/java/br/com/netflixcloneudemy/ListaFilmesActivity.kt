package br.com.netflixcloneudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.netflixcloneudemy.databinding.ActivityListaFilmesBinding

class ListaFilmesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}