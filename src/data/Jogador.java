package data;

import data.pokemons.evolucao1.Bulbassauro;
import data.pokemons.evolucao2.Charmander;
import data.pokemons.evolucao3.Blastoise;
import models.Pokemon;
import models.Treinador;

public class Jogador extends Treinador {
    private Integer pedraEvolucao;
    public Jogador(String nome) {
        super(nome, new Pokemon[]{
            new Bulbassauro(),
            new Blastoise(),
            new Charmander()
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
