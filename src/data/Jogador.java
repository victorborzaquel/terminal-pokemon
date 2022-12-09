package data;

import models.Pokemon;
import models.Treinador;
import data.pokemons.Bulbassauro;
import data.pokemons.Charmander;
import data.pokemons.Squirtle;

public class Jogador extends Treinador {
    private Integer nivel;
    private Integer pedraEvolucao;
    public Jogador(String nome) {
        super(nome, new Pokemon[]{
            new Bulbassauro(),
            new Squirtle(),
            new Charmander()
        });
        this.nivel = 1;
        this.pedraEvolucao = 1;
    }
    public Integer getNivel() {
        return nivel;
    }
    public void evoluir() {
        nivel++;
    }

    public void adicionarPedraEvolucao() {
        pedraEvolucao++;
    }

    public void evoluirPokemon() {
        if (pedraEvolucao <= 0) {
            return;
        }
        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].equals(pokemonAtual)) {
                pokemons[i] = pokemonAtual.getEvolucao();;
                break;
            }
        }
        pokemonAtual = pokemonAtual.getEvolucao();
        pedraEvolucao--;
    }
    public Boolean temPedraEvolucao() {
        return pedraEvolucao > 0;
    }
}
