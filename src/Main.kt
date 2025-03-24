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

            0 -> println("Saindo...")
        }
        }else{
            println("\n\n\nOpção Inválida")
        }
    }while (opcao != "0")
}

private fun cadastrar() {

    var convidado = Convidado()

    print("Qual o seu nome?")
    convidado.nome = readln()

    print("Qual vai ser o presente?")
    convidado.presente = readln()

    print("Qual a sua restrição alimentar?")
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

private fun editar(): Boolean{
    if (listaConvidados.isEmpty()) {
        println("A lista está vazia!")
        return false
    }
    listar()

    println("Digite a posição a ser editada: ")
    val posicao = readln().toInt()
    println("O convidado vai? S/N")
    val resposta = readln()
    when(resposta){
        "S"-> listaConvidados[posicao].presenca = true
        "N"-> listaConvidados[posicao].presenca = false
      return true
    }
}

private fun excluir(): Boolean{
    if (listaConvidados.isEmpty()){
        println("A lista está vazia!")
        return false
    }
    listar()

    println("Qual posção você deseja remover: ")
    val posicao = readln().toInt()
    listaConvidados.removeAt(posicao)
    println("Convidado excluido")
    return true
}