package models;

import data.enums.Especialidades;

public abstract class Pokemon {
    private final String nome;
    private final Especialidades especialidade;
    private final Pokemon evolucao;
    private final Ataque[] ataques;
    private final Integer vidaMaxima;
    private Integer vida;

    protected Pokemon(String nome, Especialidades especialidade, Pokemon evolucao, Integer vidaMaxima, Ataque[] ataques) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.evolucao = evolucao;
        this.ataques = ataques;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
    }

    public Integer receberDano(Ataque ataque) {
        int danoBase = ataque.getDano();
        Especialidades fraquese = especialidade.getFraqueza();
        Especialidades resistencia = especialidade.getResistencia();

        double multiplicador = 1;

        if (ataque.getEspecialidade() == fraquese) {
            multiplicador = 2;
        } else if (ataque.getEspecialidade() == resistencia) {
            multiplicador = 0.5;
        }

        int dano = (int) (danoBase * multiplicador);

        this.vida = Math.max(0, this.vida - dano);

        return dano;
    }

    public void restaurarVida() {
        this.vida = vidaMaxima;
    }

    public String getNome() {
        return nome;
    }

    public Ataque[] getAtaques() {
        return ataques;
    }

    public Integer getVida() {
        return vida;
    }

    public Boolean estaMorto() {
        return vida <= 0;
    }

    public Pokemon getEvolucao() {
        return evolucao;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }
    @Override
    public String toString() {
        return String.format("%s (%d) %s", nome, vida, especialidade.getNome());
    }
}
