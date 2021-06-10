package br.com.netflixcloneudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.netflixcloneudemy.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbarCadastro = binding.toolbarCadastro
        toolbarCadastro.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
        toolbarCadastro.setBackgroundColor(getColor(R.color.white))
    }
}