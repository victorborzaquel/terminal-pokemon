package data;

public enum Adversarios {
    JESSIE(1, "Jessie", Especialidades.VENENOSO, "Equipe Rocket decolando na velocidade da luz!", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),
    JAMES(1, "James", Especialidades.VENENOSO, "Renda-se agora ou prepare-se para lutar!", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),
    MEOWTH(1, "Meowth", Especialidades.NORMAL, "Meowth! É isso aí!", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),

    ASH(2, "Ash", Especialidades.ELETRICO, "Temos de pegar todos", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),
    MISTY(2, "Misty", Especialidades.AGUA, "Oi, você é uma cara nova!", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),
    BROCK(2, "Brock", Especialidades.PEDRA, "Quando se trata de força de vontade, ninguém pode me vencer!", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),

    TRACEY(3, "Tracey", Especialidades.PLANTA, "...", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),
    MAY(3, "May", Especialidades.AGUA, "Pokémon totalmente restaurado! Itens prontos, e… Hã? Huh? Quem... quem é você?", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),
    GARY(3, "Gary", Especialidades.FOGO, "Estou aqui para lutar, não para falar. E você?", Pokemons.BULBASSAURO, Pokemons.BULBASSAURO, Pokemons.BULBASSAURO),
    ;

    private final Integer nivel;
    private final String nome;
    private final Especialidades especialidade;
    private final String frase;
    private final Pokemons[] pokemons;

    Adversarios(Integer nivel, String name, Especialidades especialidade, String frase, Pokemons... pokemons) {
        this.nivel = nivel;
        this.nome = name;
        this.especialidade = especialidade;
        this.frase = frase;
        this.pokemons = pokemons;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public String getFrase() {
        return frase;
    }

    public Pokemons[] getPokemons() {
        return pokemons;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", nome, especialidade);
    }
}
