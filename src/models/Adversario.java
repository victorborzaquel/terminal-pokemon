package models;

public abstract class Adversario extends Treinador{
    private final String frase;
    protected Adversario(String nome, String frase, Pokemon[] pokemons) {
        super(nome, pokemons);
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }
}
