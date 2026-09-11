package br.com.biblioteca.model;

public abstract class ItemBiblioteca {private String codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true; // Todo item nasce disponível
    }

    // Métodos abstratos: cada subclasse define sua própria regra de negócio
    public abstract int getPrazoDias();
    public abstract double getMultaPorDia();

    // Controle de estado interno (encapsulamento sem setDisponivel público)
    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public boolean isDisponivel() { return disponivel; }

    @Override
    public String toString() {
        return String.format("[%s] %s | Disponível: %s | Prazo: %d dias | Multa/dia: R$ %.2f",
                codigo, titulo, (disponivel ? "Sim" : "Não"), getPrazoDias(), getMultaPorDia());
    }
}