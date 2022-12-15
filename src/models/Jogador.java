package models;

import errors.PedraEvolucaoException;
import errors.PokemonException;

public final class Jogador extends Treinador {
    private Integer pedraEvolucao;
    private Boolean revive;

    public Jogador(String nome, Integer nivel, Pokemon... pokemons) {
        super(nome, nivel, pokemons);
        this.pedraEvolucao = 0;
        this.revive = true;
    }

    public void restaurarRevive() {
        revive = true;
    }

    public Boolean temRevive() {
        return revive;
    }

    public void usarRevive(Integer indice) throws PokemonException, PedraEvolucaoException {
        if (!revive) {
            throw new PedraEvolucaoException("Você não possui pedras de evolução!");
        }
        if (pokemons[indice].estaVivo()) {
            throw new PokemonException("Este pokemon não está morto!");
        }

        pokemons[indice].curar(0.7);
        revive = false;
    }

    public void adicionarPedraEvolucao() {
        pedraEvolucao++;
    }

    public void evoluirPokemon(Integer indice) throws PedraEvolucaoException, PokemonException {
        if (pedraEvolucao <= 0) {
            throw new PedraEvolucaoException("Você não possui pedras de evolução!");
        }

        final Pokemon evolucao = pokemons[indice].getEvolucao();

        if (evolucao == null) {
            throw new PokemonException("Esse pokemon não pode evoluir!");
        }

        pokemons[indice] = evolucao;
        pedraEvolucao--;
    }

    public Boolean temPedraEvolucao() {
        return pedraEvolucao > 0;
    }

    public Integer getPedraEvolucao() {
        return pedraEvolucao;
    }

    public void evoluir() {
        nivel++;
    }
}
