package models;

import data.Pokemons;
import utils.Instanciar;

public class Jogador extends Treinador {
    private Integer pedraEvolucao;
    private Boolean revive;

    public Jogador(String nome) {
        super(nome, new Pokemon[]{
                Instanciar.pokemon(Pokemons.BULBASSAURO),
                Instanciar.pokemon(Pokemons.BULBASSAURO),
                Instanciar.pokemon(Pokemons.BULBASSAURO)
        });
        this.pedraEvolucao = 0;
        this.revive = true;
    }

    public void restaurarRevive() {
        revive = true;
    }

    public Boolean temRevive() {
        return revive;
    }

    public void usarRevive(Integer indice) {
        if (!revive) {
            throw new RuntimeException("Você não possui pedras de evolução!");
        }
        if (!pokemons[indice].estaMorto()) {
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
