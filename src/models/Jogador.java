package models;

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

    public void usarRevive(Integer indice) throws PokemonException {
        if (!revive) {
            throw new RuntimeException("Você não possui pedras de evolução!");
        }
        if (pokemons[indice].estaVivo()) {
            throw new RuntimeException("Este pokemon não está morto!");
        }

        pokemons[indice].reviver();
        revive = false;
    }

    public void adicionarPedraEvolucao() {
        pedraEvolucao++;
    }

    public void evoluirPokemon(Integer indice) {
        if (pedraEvolucao <= 0) {
            throw new RuntimeException("Você não possui pedras de evolução!");
        }

        final Pokemon evolucao = pokemons[indice].getEvolucao();

        if (evolucao == null) {
            throw new RuntimeException("Esse pokemon não pode evoluir!");
        }

        pokemons[indice] = evolucao;
        pedraEvolucao--;
    }

    public Boolean temPedraEvolucao() {
        return pedraEvolucao > 0;
    }

    public void evoluir() {
        nivel++;
    }
}
