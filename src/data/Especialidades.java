package data;

public enum Especialidades {
    INSETO("Inseto"),
    SOMBRIO("Sombrio"),
    DRAGAO("Dragão"),
    ELETRICO("Elétrico"),
    FADA("Fada"),
    LUTADOR("Lutador"),
    FOGO("Fogo"),
    VOADOR("Voador"),
    FANTASMA("Fantasma"),
    PLANTA("Planta"),
    TERRESTRE("Terrestre"),
    GELO("Gelo"),
    NORMAL("Normal"),
    VENENOSO("Venenoso"),
    PSIQUICO("Psíquico"),
    PEDRA("Pedra"),
    ACO("Aço"),
    AGUA("Água");

    private final String nome;
    private Especialidades fraqueza;
    private Especialidades resistencia;

    Especialidades(String type) {
        this.nome = type;
    }

    static {
        AGUA.resistencia = ELETRICO;
        AGUA.fraqueza = GELO;

        FOGO.resistencia = AGUA;
        FOGO.fraqueza = INSETO;

        PLANTA.resistencia = FOGO;
        PLANTA.fraqueza = AGUA;

        ACO.resistencia = LUTADOR;
        ACO.fraqueza = VOADOR;

        DRAGAO.resistencia = DRAGAO;
        DRAGAO.fraqueza = ELETRICO;

        FADA.resistencia = VENENOSO;
        FADA.fraqueza = SOMBRIO;

        FANTASMA.resistencia = SOMBRIO;
        FANTASMA.fraqueza = PSIQUICO;

        GELO.resistencia = LUTADOR;
        GELO.fraqueza = GELO;

        INSETO.resistencia = FOGO;
        INSETO.fraqueza = TERRESTRE;

        NORMAL.resistencia = LUTADOR;
        NORMAL.fraqueza = FANTASMA;

        PEDRA.resistencia = ACO;
        PEDRA.fraqueza = NORMAL;

        PSIQUICO.resistencia = FANTASMA;
        PSIQUICO.fraqueza = LUTADOR;

        SOMBRIO.resistencia = FADA;
        SOMBRIO.fraqueza = FANTASMA;

        TERRESTRE.resistencia = PLANTA;
        TERRESTRE.fraqueza = PEDRA;

        VENENOSO.resistencia = PSIQUICO;
        VENENOSO.fraqueza = PLANTA;

        VOADOR.resistencia = PEDRA;
        VOADOR.fraqueza = INSETO;

        ELETRICO.resistencia = PEDRA;
        ELETRICO.fraqueza = AGUA;
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
