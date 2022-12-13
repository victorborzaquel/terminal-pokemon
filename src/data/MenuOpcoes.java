package data;

public enum MenuOpcoes {
    INICIAR_PARTIDA("Iniciar partida"),
    HISTORICO("Histórico"),
    SAIR("Sair");

    private final String titulo;

    MenuOpcoes(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
