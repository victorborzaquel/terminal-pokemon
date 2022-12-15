package data;

public enum Especialidades {
    INSETO ("Inseto"),
    SOMBRIO ("Sombrio"),
    DRAGAO ("Dragão"),
    ELETRICO ("Elétrico"),
    FADA ("Fada"),
    LUTADOR ("Lutador"),
    FOGO ("Fogo"),
    VOADOR ("Voador"),
    FANTASMA ("Fantasma"),
    PLANTA ("Planta"),
    TERRESTRE ("Terrestre"),
    GELO ("Gelo"),
    NORMAL ("Normal"),
    VENENOSO ("Venenoso"),
    PSIQUICO ("Psíquico"),
    PEDRA ("Pedra"),
    ACO ("Aço"),
    AGUA ("Água");

    private final String nome;
    private Especialidades fraqueza;
    private Especialidades resistencia;

    Especialidades(String type) {
        this.nome = type;
    }

    static {
        AGUA.resistencia = FOGO;
        AGUA.fraqueza = PLANTA;

        FOGO.resistencia = PLANTA;
        FOGO.fraqueza = AGUA;

        PLANTA.resistencia = AGUA;
        PLANTA.fraqueza = FOGO;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades getFraqueza() {
        return fraqueza;
    }

    public Especialidades getResistencia() {
        return resistencia;
    }
}
