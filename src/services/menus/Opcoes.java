package services.menus;

public enum Opcoes {
    INICIAR_PARTIDA("Iniciar partida"),
    HISTORICO("Histórico"),
    SAIR("Sair");

    private final String titulo;

    Opcoes(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
