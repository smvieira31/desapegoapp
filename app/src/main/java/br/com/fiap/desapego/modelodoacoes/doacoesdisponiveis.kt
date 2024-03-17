package br.com.fiap.desapego.modelodoacoes

import br.com.fiap.desapego.modelodoacoes.modelodoacao

fun getAllDoacoes(): List<modelodoacao> {
    return listOf(
        modelodoacao(id = 1, title = "Mesa e cadeiras",  data = 1987),
        modelodoacao(id = 2, title = "box queen",  data = 1991),
        modelodoacao(id = 3, title = "geladeira",  data = 1983),
        modelodoacao(id = 4, title = "microondas",  data = 1986)
    )
}

fun getDoacoesByTitle(title: String): List<modelodoacao>{
    return getAllDoacoes().filter {
        it.title.startsWith(prefix = title, ignoreCase = true)
    }
}