package br.com.netflixcloneudemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import br.com.netflixcloneudemy.adapter.FilmesAdapter
import br.com.netflixcloneudemy.databinding.ActivityListaFilmesBinding
import br.com.netflixcloneudemy.model.addFilmes
import com.google.firebase.auth.FirebaseAuth

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler_filmes = binding.firstRecyclerView
        recycler_filmes.adapter = FilmesAdapter(addFilmes())
        recycler_filmes.layoutManager = GridLayoutManager(applicationContext, 3)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflateMenu = menuInflater
        inflateMenu.inflate(R.menu.lista_filmes_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_netflix_deslogar -> {
                FirebaseAuth.getInstance().signOut()
                voltaParaFormLogin()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun voltaParaFormLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}