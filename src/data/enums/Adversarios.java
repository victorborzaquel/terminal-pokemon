package data.enums;

public enum Adversarios {
    MISTY( "Misty", Tipos.AGUA),
    BROCK("Brock", Tipos.GRAMA),
    ASH("Ash", Tipos.FOGO);

    private final String nome;
    private final Tipos tipo;

    Adversarios(String name, Tipos type) {
        this.nome = name;
        this.tipo = type;
    }

    public String getNome() {
        return nome;
    }

    public Tipos getTipo() {
        return tipo;
    }
}
