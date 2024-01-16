enum class Nivel { INICIANTE, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val age: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel = Nivel.INICIANTE)

class Formacao(val nome: String, private val conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    private val inscritos = mutableSetOf<Usuario>()

    fun matricular(vararg usuarios: Usuario) {
        for (aluno in usuarios) {
            if (aluno in inscritos) {
                println("Aluno: ${aluno.nome} já matriculado.")
            } else {
                inscritos.add(aluno)
            }
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }

    fun imprimirInformacoes() {
        println("Formação: $nome")
        println("Conteúdos:")
        for (conteudo in conteudos) {
            println("- ${conteudo.nome}: ${conteudo.nivel} (Duração: ${conteudo.duracao} minutos)")
        }
        println("Inscritos:")
        for (aluno in inscritos) {
            println("- ${aluno.nome}")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Luis", 30)
    val usuario2 = Usuario("Maria", 25)
    val usuario3 = Usuario("Lucas", 22)

    val formacao1 = Formacao("Back-end com Kotlin")
    val formacao2 = Formacao("Lógica de programação com Portugol")
    val conteudo1 = ConteudoEducacional("Introdução à Kotlin", 90, Nivel.INICIANTE)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Conhecendo laços de repetição", 45, Nivel.INICIANTE)

    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)
    formacao2.adicionarConteudo(conteudo3)

    formacao1.matricular(usuario1)
    formacao2.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario1)  // Tentativa de matricular o primeiro usuário novamente
    formacao2.matricular(usuario3)

    formacao1.imprimirInformacoes()
    formacao2.imprimirInformacoes()

}