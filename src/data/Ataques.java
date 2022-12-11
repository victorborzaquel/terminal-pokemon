package data;

public enum Ataques {
    // Nivel 1
    FIRE_FANG("Fire Fang", Especialidades.FOGO, 5, 40),
    WATER_GUN("Water Gun", Especialidades.AGUA, 5, 40),
    RAZOR_LEAF("Razor Leaf", Especialidades.GRAMA, 5, 40);

    // Nivel 2

    // Nivel 3
    private final String nome;
    private final Especialidades especialidade;
    private final Integer danoMinimo;
    private final Integer danoMaximo;

    Ataques(String nome, Especialidades especialidade, Integer ataqueMinimo, Integer ataqueMaximo) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.danoMinimo = ataqueMinimo;
        this.danoMaximo = ataqueMaximo;
    }

    public String getNome() {
        return nome;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public Integer getDanoMinimo() {
        return danoMinimo;
    }

    public Integer getDanoMaximo() {
        return danoMaximo;
    }
}
