package models;

import data.enums.Especialidades;
import utils.Escolher;

public abstract class Ataque {
    private final String nome;
    private final Especialidades especialidade;
    private final Integer danoMinimo;
    private final Integer danoMaximo;
    protected Ataque(String nome, Especialidades especialidade, Integer danoMinimo, Integer danoMaximo) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.danoMinimo = danoMinimo;
        this.danoMaximo = danoMaximo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDano() {
        return Escolher.aleatorio(danoMinimo, danoMaximo);
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return String.format("%s (%d-%d) %s", nome, danoMinimo, danoMaximo, especialidade.getNome());
    }
}
