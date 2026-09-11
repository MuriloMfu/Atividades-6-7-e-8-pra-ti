package br.com.biblioteca.model;

public class Aluno extends Usuario {
    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int getLimiteEmprestimo() {
        return 3;
    }
}