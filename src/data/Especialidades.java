package data;

public enum Especialidades {
    AGUA("Água"),
    FOGO("Fogo"),
    GRAMA("Grama");

    private final String nome;
    private Especialidades fraqueza;
    private Especialidades resistencia;

    Especialidades(String type) {
        this.nome = type;
    }

    static {
        AGUA.resistencia = FOGO;
        AGUA.fraqueza = GRAMA;

        FOGO.resistencia = GRAMA;
        FOGO.fraqueza = AGUA;

        GRAMA.resistencia = AGUA;
        GRAMA.fraqueza = FOGO;
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
