
fun main() {
    menu()
}

var convidado: Convidado = Convidado()

private fun menu(){
    do {
        println("---MENU---")
        println("1- CADASTRAR")
        println("2- LISTAR")
        println("3- EDITAR")
        println("4- EXCLUIR")
        println("0- SAIR")

        val opcao = readln().toInt()//Validar

        when (opcao){
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
    }while (true)
}

private fun cadastrar(): Convidado {

    var convidado = Convidado()

    print("Qual o seu nome?")
    convidado.nome = readln()

    print("Qual vai ser o presente?")
    convidado.presente = readln()

    print("Qual a sua restrição alimentar?")
    convidado.alimentar = readln()

    listConvidados
}

private fun listar() : String{
    var i = 0
    if (listaConvidados.isEmpy()){
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

private fun editar(){
    listar()

    println("Digite a posição a ser editada: ")
    val posicao = readln().toInt()
    println("O convidado vai? S/N")
    val resposta = readln()
    when(resposta){
        "S"-> listaConvidados[posicao].presenca = true
        "N"-> listaConvidados[posicao].presenca = false
    }
}

private fun excluir(){
    listaConvidados.removeAt(0)

   /* convidado.nome = ""
    convidado.alimentar = ""
    convidado.presente = ""
    convidado.presenca = false*/

    println("Convidado excluido")
}