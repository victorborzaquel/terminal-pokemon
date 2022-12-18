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
    private Especialidades[] fraquezas;
    private Especialidades[] resistencias;

    Especialidades(String type) {
        this.nome = type;
    }

    static {
        NORMAL.resistencias = e();
        NORMAL.fraquezas = e(LUTADOR);

        PLANTA.resistencias = e(TERRESTRE, PEDRA, AGUA);
        PLANTA.fraquezas = e(FOGO, VENENOSO, VOADOR, INSETO, GELO);

        FOGO.resistencias = e(PLANTA, GELO, ACO, INSETO);
        FOGO.fraquezas = e(AGUA, TERRESTRE, PEDRA);

        AGUA.resistencias = e(TERRESTRE, PEDRA, FOGO);
        AGUA.fraquezas = e(PLANTA, ELETRICO);

        ELETRICO.resistencias = e(AGUA, VOADOR);
        ELETRICO.fraquezas = e(TERRESTRE);

        VOADOR.resistencias = e(PLANTA, LUTADOR, INSETO);
        VOADOR.fraquezas = e(ELETRICO, GELO, PEDRA);

        GELO.resistencias = e(PLANTA, TERRESTRE, VOADOR, DRAGAO);
        GELO.fraquezas = e(FOGO, LUTADOR, PEDRA, ACO);

        PEDRA.resistencias = e(INSETO, VOADOR, FOGO, GELO);
        PEDRA.fraquezas = e(AGUA, PLANTA, LUTADOR, TERRESTRE, ACO);

        TERRESTRE.resistencias = e(FOGO, ELETRICO, PEDRA, VENENOSO, ACO);
        TERRESTRE.fraquezas = e(GELO, AGUA, PLANTA);

        ACO.resistencias = e(FADA, GELO, PEDRA);
        ACO.fraquezas = e(LUTADOR, FOGO, TERRESTRE);

        LUTADOR.resistencias = e(NORMAL, PEDRA, ACO, GELO, SOMBRIO);
        LUTADOR.fraquezas = e(VOADOR, FADA, PSIQUICO);

        SOMBRIO.resistencias = e(FANTASMA, PSIQUICO);
        SOMBRIO.fraquezas = e(LUTADOR, FADA, INSETO);

        PSIQUICO.resistencias = e(LUTADOR, VENENOSO);
        PSIQUICO.fraquezas = e(FANTASMA, SOMBRIO, INSETO);

        VENENOSO.resistencias = e(PLANTA, FADA);
        VENENOSO.fraquezas = e(TERRESTRE, PSIQUICO);

        INSETO.resistencias = e(PLANTA, SOMBRIO, PSIQUICO);
        INSETO.fraquezas = e(FOGO, VOADOR, PEDRA);

        FADA.resistencias = e(LUTADOR, DRAGAO, SOMBRIO);
        FADA.fraquezas = e(VENENOSO, ACO);

        FANTASMA.resistencias = e(FANTASMA, PSIQUICO);
        FANTASMA.fraquezas = e(FANTASMA, SOMBRIO);

        DRAGAO.resistencias = e(DRAGAO);
        DRAGAO.fraquezas = e(DRAGAO, GELO, FADA);
    }

    private static Especialidades[] e(Especialidades... especialidades) {
        return especialidades;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades[] getFraquezas() {
        return fraquezas;
    }

    public Especialidades[] getResistencias() {
        return resistencias;
    }
}
