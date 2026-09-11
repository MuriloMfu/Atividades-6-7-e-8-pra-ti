package br.com.biblioteca.service;

// Precisa importar as entidades da pasta model
import br.com.biblioteca.model.ItemBiblioteca;
import br.com.biblioteca.model.Usuario;

public class Biblioteca {private ItemBiblioteca[] acervo;
    private Usuario[] usuarios;
    private int totalItens;
    private int totalUsuarios;

    public Biblioteca(int capacidadeAcervo, int capacidadeUsuarios) {
        this.acervo = new ItemBiblioteca[capacidadeAcervo];
        this.usuarios = new Usuario[capacidadeUsuarios];
        this.totalItens = 0;
        this.totalUsuarios = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        if (totalItens < acervo.length) {
            acervo[totalItens++] = item;
        } else {
            System.out.println("Erro: Acervo lotado!");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (totalUsuarios < usuarios.length) {
            usuarios[totalUsuarios++] = usuario;
        } else {
            System.out.println("Erro: Limite de usuários atingido!");
        }
    }

    public boolean emprestar(Usuario usuario, ItemBiblioteca item) {
        if (!item.isDisponivel()) {
            System.out.println("❌ Falha no Empréstimo: '" + item.getTitulo() + "' já está emprestado.");
            return false;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println("❌ Falha no Empréstimo: " + usuario.getNome() + 
                               " atingiu o limite de " + usuario.getLimiteEmprestimo() + " itens.");
            return false;
        }

        item.emprestar();
        usuario.incrementarEmprestimo();
        System.out.println("✅ Empréstimo realizado: '" + item.getTitulo() + 
                           "' para " + usuario.getNome() + 
                           " (Prazo: " + item.getPrazoDias() + " dias).");
        return true;
    }

    public boolean devolver(Usuario usuario, ItemBiblioteca item) {
        if (item.isDisponivel()) {
            System.out.println("❌ Falha na Devolução: '" + item.getTitulo() + "' já estava na biblioteca.");
            return false;
        }

        item.devolver();
        usuario.decrementarEmprestimo();
        System.out.println("✅ Devolução realizada: '" + item.getTitulo() + "' por " + usuario.getNome());
        return true;
    }

    // Cumpre a dica 9: Percorre o array em um único laço polimórfico sem 'instanceof' ou 'if'
    public void listarAcervo() {
        System.out.println("\n--- ACERVO DA BIBLIOTECA ---");
        for (int i = 0; i < totalItens; i++) {
            System.out.println(acervo[i].toString());
        }
        System.out.println("----------------------------\n");
    }
}