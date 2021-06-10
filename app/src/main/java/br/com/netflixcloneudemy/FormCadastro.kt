package br.com.netflixcloneudemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.netflixcloneudemy.databinding.ActivityFormCadastroBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        toolbarCadastro()


        //Evento no button cadastrar
        val buttonCadastro = binding.btCadastrar
        buttonCadastro.setOnClickListener {
            val edEmail = binding.etEmailCadastro.text.toString()
            val edSenha = binding.etSenhaCadastro.text.toString()
            val tvErro = binding.tvMensagemErro

            if(edEmail.isEmpty() || edSenha.isEmpty()) {

                tvErro.setText("Preencha os campos!")

            } else {

                cadastrarUsuario()

            }

        }
    }

    private fun toolbarCadastro() {
        val toolbarCadastro = binding.toolbarCadastro
        toolbarCadastro.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
        toolbarCadastro.setBackgroundColor(getColor(R.color.white))
    }

    private fun cadastrarUsuario() {
        val edEmail = binding.etEmailCadastro.text.toString()
        val edSenha = binding.etSenhaCadastro.text.toString()
        val tvErro = binding.tvMensagemErro

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(edEmail, edSenha).addOnCompleteListener {

            if(it.isSuccessful) {
                Toast.makeText(this, "Cadastro efetivado com sucesso!", Toast.LENGTH_SHORT).show()
                binding.etEmailCadastro.setText("")
                binding.etSenhaCadastro.setText("")
                tvErro.setText("")
            }

        }.addOnFailureListener {
            val error = it

            when {
                error is FirebaseAuthUserCollisionException -> tvErro.setText("Este email ja foi cadastrado")
                error is FirebaseAuthWeakPasswordException -> tvErro.setText("A sua senha precisa ter, no minimo, 6 caracteres")
                error is FirebaseNetworkException -> tvErro.setText("Sem conexao com Internet")
                else -> tvErro.setText("Cadastro recusado, tente novamente!")
            }

        }

    }
}
