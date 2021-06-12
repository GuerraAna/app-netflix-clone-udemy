package br.com.netflixcloneudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.netflixcloneudemy.databinding.ActivityDetalhesFilmeBinding

class DetalhesFilmeWitcher : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}