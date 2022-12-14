package data;

public enum Historicos {
    VITORIAS("Vitorias", "vitorias.txt"),
    DERROTAS("Derrotas", "derrotas.txt"),
    DESISTENCIAS("Desistencias", "desistencias.txt");

    private final String titulo;
    private final String diretorio;

    Historicos(String titulo, String diretorio) {
        this.titulo = titulo;
        this.diretorio = diretorio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDiretorio() {
        return diretorio;
    }
}
