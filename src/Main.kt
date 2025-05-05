val expressaoRegular = Regex("[0-4]")
var listaConvidados = mutableListOf<Convidado>()
var convidado: Convidado = Convidado()
fun main() {
    menu()
}

private fun menu(){
    do {
        println("---MENU---")
        println("1- CADASTRAR")
        println("2- LISTAR")
        println("3- EDITAR")
        println("4- EXCLUIR")
        println("5 - BUSCAR")
        println("0- SAIR")

        val opcao = readln()//Validar
        if (expressaoRegular.matches(opcao)){
        when (opcao.toInt()) {
            1 -> {
                println("Cadastrando...")
                cadastrar()
            }

            2 -> {
                println("Listando...")
                listar()
            }

            3 -> {
                println("Editando...")
                editar()
            }

            4 -> {
                println("Excluindo...")
                excluir()
            }

            5 -> {
                println("Buscando...")
                buscar()
            }

            0 -> println("Saindo...")
            }

        }else{
            println("\n\n\nOpção Inválida")
        }
    }while (opcao != "0")
}

private fun cadastrar() {
    val regexNome = Regex("^[A-Za-zÀ-ÿ\\s]+$")
    var convidado = Convidado()
    do {
        print("Qual o seu nome? ")
        val nomeDigitado = readln()
        if (regexNome.matches(nomeDigitado)) {
            convidado.nome = nomeDigitado
            break
        } else {
            println("Nome inválido! Digite apenas letras e espaços.")
        }
    } while (true)

    print("Qual vai ser o presente? ")
    convidado.presente = readln()

    print("Qual a sua restrição alimentar? ")
    convidado.alimentar = readln()

    listaConvidados.add(convidado)
}

private fun listar() {
    var i = 0
    if (listaConvidados.isEmpty()){
        println("Não há convidados")
    }else {
        listaConvidados.forEach {convidado ->
        print(
            "Posição: ${i++}" +
                    "Nome: ${convidado.nome}; " +
                    "Presente: ${convidado.presente}; " +
                    "Restrição: ${convidado.alimentar}; " +
                    "Vai ir pra festa? ${convidado.presenca}"
        )
        }
    }
}

private fun editar(): Boolean {
    if (listaConvidados.isEmpty()) {
        println("A lista está vazia!")
        return false
    }

    listar()

    val posicao: Int
    while (true) {
        print("Digite a posição a ser editada: ")
        val entrada = readln()
        val numero = entrada.toIntOrNull()

        if (numero != null && numero in listaConvidados.indices) {
            posicao = numero
            break
        } else {
            println("Posição inválida! Digite um número válido existente na lista.")
        }
    }

    var resposta: String
    while (true) {
        print("O convidado vai? (S/N): ")
        resposta = readln().uppercase()

        if (resposta == "S" || resposta == "N") {
            break
        } else {
            println("Resposta inválida! Digite apenas 'S' ou 'N'.")
        }
    }

    listaConvidados[posicao].presenca = resposta == "S"
    println("Presença atualizada com sucesso.")
    return true
}

private fun excluir(): Boolean {
    if (listaConvidados.isEmpty()) {
        println("A lista está vazia!")
        return false
    }

    listar()

    val posicao: Int
    while (true) {
        print("Qual posição você deseja remover: ")
        val entrada = readln()
        val numero = entrada.toIntOrNull()

        if (numero != null && numero in listaConvidados.indices) {
            posicao = numero
            break
        } else {
            println("Posição inválida! Digite um número correspondente a um convidado existente.")
        }
    }

    listaConvidados.removeAt(posicao)
    println("Convidado excluído com sucesso.")
    return true
}

private fun buscar() {
    if (listaConvidados.isEmpty()) {
        println("A lista está vazia!")
        return
    }

    val regexAlfabetico = Regex("^[A-Za-zÀ-ÿ\\s]+\$")

    var termo: String
    while (true) {
        print("Digite o nome para buscar: ")
        val entrada = readln()
        if (regexAlfabetico.matches(entrada)) {
            termo = entrada.trim().lowercase()
            break
        } else {
            println("Entrada inválida! Digite apenas letras e espaços.")
        }
    }

    val resultados = listaConvidados.filter { it.nome.lowercase().contains(termo) }

    if (resultados.isEmpty()) {
        println("Nenhum convidado encontrado com esse nome.")
    } else {
        println("Resultados encontrados:")
        resultados.forEach { convidado ->
            println(
                "Nome: ${convidado.nome}, " +
                        "Presente: ${convidado.presente}, " +
                        "Restrição: ${convidado.alimentar}, " +
                        "Vai à festa? ${if (convidado.presenca) "Sim" else "Não"}"
            )
        }
    }
}