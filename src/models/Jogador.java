package models;

import data.Pokemons;
import utils.Instanciar;

public class Jogador extends Treinador {
    private Integer pedraEvolucao;

    public Jogador(String nome) {
        super(nome, new Pokemon[]{
                Instanciar.pokemon(Pokemons.BULBASSAURO),
                Instanciar.pokemon(Pokemons.BULBASSAURO),
                Instanciar.pokemon(Pokemons.BULBASSAURO)
        });
        this.pedraEvolucao = 1;
    }

    public void adicionarPedraEvolucao() {
        pedraEvolucao++;
    }

    public void evoluirPokemon(Integer indice) {
        if (pedraEvolucao <= 0) {
            throw new RuntimeException("Você não possui pedras de evolução!");
        }

        Pokemon evolucao = pokemons[indice].getEvolucao();

        if (evolucao == null) {
            throw new RuntimeException("Esse pokemon não pode evoluir!");
        }

        pokemons[indice] = evolucao;
        pedraEvolucao--;
    }

    public Boolean temPedraEvolucao() {
        return pedraEvolucao > 0;
    }
}
