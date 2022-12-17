package models;

import data.Especialidades;
import errors.PPInsuficienteException;
import utils.Escolha;

public final class Ataque {
    private final String nome;
    private final Especialidades especialidade;
    private final Integer danoMinimo;
    private final Integer danoMaximo;
    private final Integer ppMaximo;
    private Integer ppAtual;

    public Ataque(String nome, Especialidades especialidade, Integer danoMinimo, Integer danoMaximo, Integer pp) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.danoMinimo = danoMinimo;
        this.danoMaximo = danoMaximo;
        this.ppMaximo = pp;
        this.ppAtual = pp;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() throws PPInsuficienteException {
        if (ppAtual <= 0) {
            throw new PPInsuficienteException();
        }
        ppAtual--;
        return Escolha.aleatorio(danoMinimo, danoMaximo);
    }

    public int getPpAtual() {
        return ppAtual;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return String.format("%s (%d-%d) %s [%d/%d]", nome, danoMinimo, danoMaximo, especialidade.getNome(), ppAtual, ppMaximo);
    }
}
