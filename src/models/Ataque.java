package models;

import utils.Escolher;

public abstract class Ataque {
    private final String nome;
    private final Integer danoMinimo;
    private final Integer danoMaximo;
    protected Ataque(String nome, Integer danoMinimo, Integer danoMaximo) {
        this.nome = nome;
        this.danoMinimo = danoMinimo;
        this.danoMaximo = danoMaximo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDano() {
        return Escolher.aleatorio(danoMinimo, danoMaximo);
    }

    @Override
    public String toString() {
        return String.format("%s (%d-%d)", nome, danoMinimo, danoMaximo);
    }
}
