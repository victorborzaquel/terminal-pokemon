package models;

public abstract class Pokemon {
    private final String nome;
    private final Pokemon evolucao;
    private final Ataque[] ataques;
    private Integer vida;

    protected Pokemon(String nome, Pokemon evolucao, Integer vida, Ataque[] ataques) {
        this.nome = nome;
        this.evolucao = evolucao;
        this.ataques = ataques;
        this.vida = vida;
    }

    public Integer receberDano(Integer dano) {
        int vidaAtual = this.vida - dano;

        if (vidaAtual < 0) {
            this.vida = 0;
            return vidaAtual * -1;
        }

        this.vida = vidaAtual;
        return 0;
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

    public Pokemon getEvolucao() {
        return evolucao;
    }
    @Override
    public String toString() {
        return String.format("%s (%d)", nome, vida);
    }
}
