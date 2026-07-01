package model;

public abstract class Carta {

    protected String nome, descricao;

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return this.nome;
    }
}
