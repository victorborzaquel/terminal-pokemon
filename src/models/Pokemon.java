package models;

import data.Especialidades;
import errors.PPInsuficienteException;
import errors.PokemonException;

import java.util.HashMap;
import java.util.Map;

public final class Pokemon {
    private final String nome;
    private final Especialidades especialidade;
    private final Pokemon evolucao;
    private final Ataque[] ataques;
    private final Integer vidaMaxima;
    private Integer vida;

    public Pokemon(String nome, Especialidades especialidade, Pokemon evolucao, Integer vidaMaxima, Ataque[] ataques) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.evolucao = evolucao;
        this.ataques = ataques;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
    }

    public void curar(double vidaPorCento) throws PokemonException {
        if (vida != 0) {
            throw new PokemonException("Não é possível reviver um Pokémon vivo");
        }

        int vidaRecuperada = (int) (vidaMaxima * vidaPorCento);
        int novaVida = vida + vidaRecuperada;

        vida = Math.max(vidaMaxima, novaVida);
    }

    public int receberDano(Ataque ataque) throws PPInsuficienteException {
        final int danoBase = ataque.getDano();
        final Especialidades fraquese = especialidade.getFraqueza();
        final Especialidades resistencia = especialidade.getResistencia();

        double multiplicador = 1;
        if (ataque.getEspecialidade() == fraquese) {
            multiplicador = 2;
        } else if (ataque.getEspecialidade() == resistencia) {
            multiplicador = 0.5;
        }

        final int dano = (int) (danoBase * multiplicador);

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

    public Boolean estaVivo() {
        return vida > 0;
    }

    public Pokemon getEvolucao() {
        return evolucao;
    }

    public Map<Integer, Ataque> getAtaquesComPp() {
        Map<Integer, Ataque> ataquesComPp = new HashMap<>();

        for (int i = 0; i < ataques.length; i++) {
            if (ataques[i].getPpAtual() > 0) {
                ataquesComPp.put(i, ataques[i]);
            }
        }

        return ataquesComPp;
    }

    @Override
    public String toString() {
        return String.format("%s (%d) %s", nome, vida, especialidade.getNome());
    }
}
