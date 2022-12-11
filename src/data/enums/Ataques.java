package data.enums;

public enum Ataques {
    FIRE_FANG(1, "Fire Fang", Especialidades.FOGO, 5, 40),
    WATER_GUN(1, "Water Gun", Especialidades.AGUA, 5, 40),
    RAZOR_LEAF(1, "Razor Leaf", Especialidades.GRAMA, 5, 40);

    private final Integer nivel;
    private final String nome;
    private final Especialidades especialidade;
    private final Integer ataqueMinimo;
    private final Integer ataqueMaximo;

    Ataques(Integer nivel, String nome, Especialidades especialidade, Integer ataqueMinimo, Integer ataqueMaximo) {
        this.nivel = nivel;
        this.nome = nome;
        this.especialidade = especialidade;
        this.ataqueMinimo = ataqueMinimo;
        this.ataqueMaximo = ataqueMaximo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public Integer getAtaqueMinimo() {
        return ataqueMinimo;
    }

    public Integer getAtaqueMaximo() {
        return ataqueMaximo;
    }
}
