package br.com.biblioteca;

import br.com.biblioteca.model.Aluno;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Revista;
import br.com.biblioteca.service.Biblioteca;

public class Main {
    public static void main(String[] args) {
      Biblioteca biblio = new Biblioteca(10, 10);

        // Instanciando itens
        Livro l1 = new Livro("L01", "Java para Iniciantes");
        Livro l2 = new Livro("L02", "Estruturas de Dados");
        Livro l3 = new Livro("L03", "Arquitetura Clean");
        Livro l4 = new Livro("L04", "Design Patterns");
        Revista r1 = new Revista("R01", "Tech Monthly");

        // Cadastrando no acervo
        biblio.cadastrarItem(l1);
        biblio.cadastrarItem(l2);
        biblio.cadastrarItem(l3);
        biblio.cadastrarItem(l4);
        biblio.cadastrarItem(r1);

        // Criando usuário
        Aluno aluno = new Aluno("Carlos Santos"); // Limite = 3

        System.out.println("=== CENÁRIO DE TESTES ===");

        // Exibe acervo inicial
        biblio.listarAcervo();

        // 3 Empréstimos bem-sucedidos
        biblio.emprestar(aluno, l1);
        biblio.emprestar(aluno, l2);
        biblio.emprestar(aluno, r1);

        // Tentativa do 4º empréstimo (deve ser RECUSADO por limite atingido)
        biblio.emprestar(aluno, l3);

        // Exibe acervo pós-empréstimos
        biblio.listarAcervo();
    }
}