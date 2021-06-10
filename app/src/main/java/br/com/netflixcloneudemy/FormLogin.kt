package br.com.netflixcloneudemy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.netflixcloneudemy.databinding.ActivityFormLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        verificaCadastroUsuarioAtivo()

        abrirCadastro()

        val entrarNetflix = binding.btEntrar
        entrarNetflix.setOnClickListener {
            val etEmail = binding.etLoginEmail.text.toString()
            val etSenha = binding.etLoginSenha.text.toString()
            val tvMensagemErro = binding.tvMensagemErro

            if(etEmail.isEmpty() || etSenha.isEmpty()) {

                tvMensagemErro.setText("Preencha todos os campos")

            } else {

                loginNetlfix()

            }
        }

    }

    private fun abrirCadastro() {
        val textCadastro = binding.tvNovoPorAqui
        textCadastro.setOnClickListener {

            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)

        }
    }

    private fun loginNetlfix() {
        val etEmail = binding.etLoginEmail.text.toString()
        val etSenha = binding.etLoginSenha.text.toString()
        val tvMensagemErro = binding.tvMensagemErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(etEmail, etSenha).addOnCompleteListener {
            if(it.isSuccessful) {

                Toast.makeText(this, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                abrirListaFilmes()

            } else {
                val erro = it
                when {
                    erro is FirebaseAuthInvalidCredentialsException -> tvMensagemErro.setText("Email ou senha errados, tente novamente.")
                    erro is FirebaseNetworkException -> tvMensagemErro.setText("Sem conexao com Internet")
                    else -> tvMensagemErro.setText("Erro ao logar o usuario, tente novamente.")
                }

            }
        }

    }

    private fun abrirListaFilmes() {

        val intent = Intent(this, ListaFilmesActivity::class.java)
        startActivity(intent)
        finish()

    }

    private fun verificaCadastroUsuarioAtivo() {
        val usuarioCadastrado = FirebaseAuth.getInstance().currentUser

        if(usuarioCadastrado != null) {

            abrirListaFilmes()

        }
    }

}
