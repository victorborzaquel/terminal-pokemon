package data;

public enum Adversarios {
    JESSIE(1, "Jessie", Especialidades.PLANTA, "Equipe Rocket decolando na velocidade da luz!", Pokemons.POLIWAG, Pokemons.ODISH, Pokemons.SANDSHREW),
    JAMES(1, "James", Especialidades.NORMAL, "Renda-se agora ou prepare-se para lutar!", Pokemons.RATTATA, Pokemons.POLIWAG, Pokemons.RATTATA),
    MEOWTH(1, "Meowth", Especialidades.INSETO, "Meowth! É isso aí!", Pokemons.WEEDLE, Pokemons.SANDSHREW, Pokemons.CARTEPIE),

    ASH(2, "Ash", Especialidades.FOGO, "Temos de pegar todos", Pokemons.PIDGEOTTO, Pokemons.GROWLITHE, Pokemons.PONITA),
    MISTY(2, "Misty", Especialidades.INSETO, "Oi, você é uma cara nova!", Pokemons.METAPOD, Pokemons.KAKUNA, Pokemons.BEEDRILL),
    BROCK(2, "Brock", Especialidades.ELETRICO, "Quando se trata de força de vontade, ninguém pode me vencer!", Pokemons.PIKACHU, Pokemons.PIKACHU, Pokemons.RAICHU),

    TRACEY(3, "Tracey", Especialidades.PLANTA, "...", Pokemons.VILEPLUME, Pokemons.SANDSLASH, Pokemons.RATICATE),
    MAY(3, "May", Especialidades.AGUA, "Pokémon totalmente restaurado! Itens prontos, e… Hã? Huh? Quem... quem é você?", Pokemons.POLIWRATH, Pokemons.TENTACRUEL, Pokemons.TENTACOOL),
    GARY(3, "Gary", Especialidades.FOGO, "Estou aqui para lutar, não para falar. E você?", Pokemons.ARCANINE, Pokemons.PIDGEOT, Pokemons.RAPIDASH);

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
