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
                print("Cadastrando...")
                convidado = cadastrar()
            }
            2 -> {
                print("Listando...")
                listar(convidado)
            }
            3 -> print("Editando...")
            4 -> print("Excluindo...")
            0 -> print("Saindo...")
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

    return convidado
}

private fun listar(convidado: Convidado){
    print("Nome: ${convidado.nome}; " +
        "Presente: ${convidado.presente}; " +
        "Restrição: ${convidado.alimentar}; " +
        "Vai ir pra festa? ${convidado.presenca}")
}

private fun editar(){
    println("O convidado vai? S/N")
    val resposta = readln()
    when(resposta){
        "S"-> convidado.presenca = true
        "N"-> convidado.presenca = false
    }
}

private fun excluir(){
    convidado.nome = ""
    convidado.alimentar = ""
    convidado.presente = ""
    convidado.presenca = false
    println("Convidado excluido")
}