package br.com.netflixcloneudemy.model


data class Filmes(
    val capaFilmes: Int
) {
    class buildFilmes() {
        var capaFilmes: Int = 0
        fun build() = Filmes(capaFilmes)
    }

    fun filmes(block: buildFilmes.() -> Unit): Filmes = buildFilmes().apply(block).build()

    fun addFilmes(): MutableList<Filmes> = mutableListOf(
        filmes {

        }
    )
}