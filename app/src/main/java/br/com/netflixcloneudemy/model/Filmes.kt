package br.com.netflixcloneudemy.model

import br.com.netflixcloneudemy.R


data class Filmes(
    val capaFilmes: Int
)

class buildFilmes {
        var capaFilmes: Int = 0
        fun build() = Filmes(capaFilmes)
    }

fun filmes(block: buildFilmes.() -> Unit): Filmes = buildFilmes().apply(block).build()

fun addFilmes(): MutableList<Filmes> = mutableListOf(

        filmes {
            capaFilmes = R.drawable.filme1
        },

        filmes {
            capaFilmes = R.drawable.filme2
        },

        filmes {
            capaFilmes = R.drawable.filme3
        },

        filmes {
            capaFilmes = R.drawable.filme4
        },

        filmes {
            capaFilmes = R.drawable.filme5
        },

        filmes {
            capaFilmes = R.drawable.filme6
        },

        filmes {
            capaFilmes = R.drawable.filme7
        },

        filmes {
            capaFilmes = R.drawable.filme8
        },

        filmes {
            capaFilmes = R.drawable.filme9
        },

        filmes {
            capaFilmes = R.drawable.filme10
        },

        filmes {
            capaFilmes = R.drawable.filme11
        },

        filmes {
            capaFilmes = R.drawable.filme12
        }
    )