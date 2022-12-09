package data.enums;

public enum Tipos {
    AGUA("Água"),
    FOGO("Fogo"),
    GRAMA("Grama");

    private final String nome;
    private Tipos fraqueza;
    private Tipos resistencia;

    Tipos(String type) {
        this.nome = type;
    }

    static {
        AGUA.fraqueza = FOGO;
        AGUA.resistencia = GRAMA;
        FOGO.fraqueza = GRAMA;
        FOGO.resistencia = AGUA;
        GRAMA.fraqueza = AGUA;
        GRAMA.resistencia = FOGO;
    }

    public String getNome() {
        return nome;
    }

    public Tipos getFraqueza() {
        return fraqueza;
    }

    public Tipos getResistencia() {
        return resistencia;
    }
}
