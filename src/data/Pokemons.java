package data;

public enum Pokemons {
    // Jogador — Geração 1
    BULBASAUR("Bulbasaur", Especialidades.PLANTA, 90, Ataques.VINE_WHIP, Ataques.MEGA_DRAIN, Ataques.POISON_STING),
    IVYSAUR("Ivysaur", Especialidades.PLANTA, 120, Ataques.VINE_WHIP, Ataques.MEGA_DRAIN, Ataques.RAZOR_LEAF),
    VENUSAUR("Venusaur", Especialidades.PLANTA, 160, Ataques.VINE_WHIP, Ataques.RAZOR_LEAF, Ataques.SOLAR_BEAM),

    CHARMANDER("Charmander", Especialidades.FOGO, 80, Ataques.EMBER, Ataques.FIRE_SPIN, Ataques.FURY_ATTACK),
    CHARMELEON("Charmeleon", Especialidades.FOGO, 110, Ataques.EMBER, Ataques.FURY_ATTACK, Ataques.FIRE_PUNCH),
    CHARIZARD("Charizard", Especialidades.FOGO, 150, Ataques.EMBER, Ataques.FIRE_PUNCH, Ataques.FIRE_BLAST),

    SQUIRTLE("Squirtle", Especialidades.AGUA, 88, Ataques.BUBBLE, Ataques.WATER_GUN, Ataques.DOUBLE_SLAP),
    WARTORTLE("Wartortle", Especialidades.AGUA, 130, Ataques.BUBBLE, Ataques.DOUBLE_SLAP, Ataques.WATER_GUN),
    BLASTOISE("Blastoise", Especialidades.AGUA, 180, Ataques.BUBBLE, Ataques.WATER_GUN, Ataques.HYDRO_PUMP),

    // Jogador — Geração 2
    CYNDAQUIL("Cyndaquil", Especialidades.FOGO, 100, Ataques.EMBER, Ataques.VISE_GRIP, Ataques.WRAP),
    QUILAVA("Quilava", Especialidades.FOGO, 140, Ataques.EMBER, Ataques.FIRE_PUNCH, Ataques.VISE_GRIP),
    TYPHLOSION("Typhlosion", Especialidades.FOGO, 160, Ataques.EMBER, Ataques.FIRE_PUNCH, Ataques.FLAMETHROWER),

    TOTODILE("Totodile", Especialidades.AGUA, 80, Ataques.CLAMP, Ataques.WATER_GUN, Ataques.BUBBLE_BEAM),
    CROCRODILE("Crocrodile", Especialidades.AGUA, 120, Ataques.CLAMP, Ataques.BUBBLE_BEAM, Ataques.WATER_GUN),
    FERALIGATR("Feraligatr", Especialidades.AGUA, 150, Ataques.CLAMP, Ataques.SURF, Ataques.CRABHAMMER),

    CHIKORITA("Chikorita", Especialidades.PLANTA, 100, Ataques.ABSORB, Ataques.PAY_DAY, Ataques.SCRATCH),
    BAYLEEF("Bayleef", Especialidades.PLANTA, 110, Ataques.ABSORB, Ataques.MEGA_DRAIN, Ataques.PAY_DAY),
    MEGANIUM("Meganium", Especialidades.PLANTA, 130, Ataques.ABSORB, Ataques.MEGA_DRAIN, Ataques.PETAL_DANCE),

    // Inimigos
    RATTATA("Rattata", Especialidades.NORMAL, 60, Ataques.FURY_SWIPES, Ataques.DIZZY_PUNCH, Ataques.CUT),
    RATICATE("Raticate", Especialidades.NORMAL, 110, Ataques.FURY_SWIPES, Ataques.DIZZY_PUNCH, Ataques.EXPLOSION),

    PIDGEY("Pidgey", Especialidades.VOADOR, 80, Ataques.GUST, Ataques.WING_ATTACK, Ataques.PECK),
    PIDGEOTTO("Pidgeotto", Especialidades.VOADOR, 120, Ataques.GUST, Ataques.DRILL_PECK, Ataques.PECK),
    PIDGEOT("Pidgeot", Especialidades.VOADOR, 165, Ataques.GUST, Ataques.SKY_ATTACK, Ataques.FLY),

    CARTEPIE("Caterpie", Especialidades.INSETO, 90, Ataques.PIN_MISSILE, Ataques.TWINEEDLE, Ataques.SPIKE_CANNON),
    METAPOD("Metapod", Especialidades.INSETO, 100, Ataques.PIN_MISSILE, Ataques.TWINEEDLE, Ataques.SPIKE_CANNON),
    BUTTERFREE("Butterfree", Especialidades.INSETO, 120, Ataques.TWINEEDLE, Ataques.MEGA_KICK, Ataques.LEECH_LIFE),

    WEEDLE("Weedle", Especialidades.INSETO, 80, Ataques.PIN_MISSILE, Ataques.FURY_ATTACK, Ataques.FURY_SWIPES),
    KAKUNA("Kakuna", Especialidades.INSETO, 90, Ataques.SLASH, Ataques.PIN_MISSILE, Ataques.FURY_SWIPES),
    BEEDRILL("Beedrill", Especialidades.INSETO, 130, Ataques.SLASH, Ataques.PIN_MISSILE, Ataques.LEECH_LIFE),

    PIKACHU("Pikachu", Especialidades.ELETRICO, 90, Ataques.BARRAGE, Ataques.THUNDER_SHOCK, Ataques.THUNDER_PUNCH),
    RAICHU("Raichu", Especialidades.ELETRICO, 130, Ataques.THUNDER_SHOCK, Ataques.THUNDER_PUNCH, Ataques.THUNDERBOLT),

    SANDSHREW("Sandshrew", Especialidades.PLANTA, 100, Ataques.VINE_WHIP, Ataques.MEGA_DRAIN, Ataques.BIND),
    SANDSLASH("Sandslash", Especialidades.PLANTA, 150, Ataques.VINE_WHIP, Ataques.MEGA_DRAIN, Ataques.PETAL_DANCE),

    ODISH("Oddish", Especialidades.PLANTA, 90, Ataques.VINE_WHIP, Ataques.MEGA_DRAIN, Ataques.BIND),
    GLOOM("Gloom", Especialidades.PLANTA, 120, Ataques.VINE_WHIP, Ataques.COMET_PUNCH, Ataques.PETAL_DANCE),
    VILEPLUME("Vileplume", Especialidades.PLANTA, 150, Ataques.COMET_PUNCH, Ataques.PETAL_DANCE, Ataques.SOLAR_BEAM),

    GROWLITHE("Growlithe", Especialidades.FOGO, 110, Ataques.FIRE_SPIN, Ataques.EMBER, Ataques.HORN_ATTACK),
    ARCANINE("Arcanine", Especialidades.FOGO, 180, Ataques.FIRE_SPIN, Ataques.FLAMETHROWER, Ataques.FIRE_BLAST),

    POLIWAG("Poliwag", Especialidades.AGUA, 80, Ataques.TACKLE, Ataques.WATER_GUN, Ataques.CLAMP),
    POLIWHIRL("Poliwhirl", Especialidades.AGUA, 130, Ataques.TACKLE, Ataques.WATER_GUN, Ataques.CLAMP),
    POLIWRATH("Poliwrath", Especialidades.AGUA, 180, Ataques.WATER_GUN, Ataques.WATERFALL, Ataques.CRABHAMMER),

    TENTACOOL("Tentacool", Especialidades.AGUA, 80, Ataques.WATER_GUN, Ataques.CLAMP, Ataques.BUBBLE_BEAM),
    TENTACRUEL("Tentacruel", Especialidades.AGUA, 160, Ataques.WATER_GUN, Ataques.SURF, Ataques.HYDRO_PUMP),

    PONITA("Ponita", Especialidades.FOGO, 100, Ataques.FIRE_SPIN, Ataques.FIRE_PUNCH, Ataques.TACKLE),
    RAPIDASH("Rapidash", Especialidades.FOGO, 145, Ataques.FIRE_SPIN, Ataques.FIRE_PUNCH, Ataques.FIRE_BLAST);


    private final String nome;
    private final Especialidades especialidade;
    private final Integer vida;
    private final Ataques[] ataques;
    private Pokemons evolucao;

    Pokemons(String nome, Especialidades especialidade, Integer vida, Ataques... ataques) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.vida = vida;
        this.ataques = ataques;
    }

    static {
        CHARMANDER.evolucao = CHARMELEON;
        CHARMELEON.evolucao = CHARIZARD;
        CHARIZARD.evolucao = null;

        SQUIRTLE.evolucao = WARTORTLE;
        WARTORTLE.evolucao = BLASTOISE;
        BLASTOISE.evolucao = null;

        BULBASAUR.evolucao = IVYSAUR;
        IVYSAUR.evolucao = VENUSAUR;
        VENUSAUR.evolucao = null;

        CYNDAQUIL.evolucao = QUILAVA;
        QUILAVA.evolucao = TYPHLOSION;
        TYPHLOSION.evolucao = null;

        TOTODILE.evolucao = CROCRODILE;
        CROCRODILE.evolucao = FERALIGATR;
        FERALIGATR.evolucao = null;

        CHIKORITA.evolucao = BAYLEEF;
        BAYLEEF.evolucao = MEGANIUM;
        MEGANIUM.evolucao = null;

        RATTATA.evolucao = RATICATE;
        RATICATE.evolucao = null;

        PIDGEY.evolucao = PIDGEOTTO;
        PIDGEOTTO.evolucao = PIDGEOT;
        PIDGEOT.evolucao = null;

        CARTEPIE.evolucao = METAPOD;
        METAPOD.evolucao = BUTTERFREE;
        BUTTERFREE.evolucao = null;

        WEEDLE.evolucao = KAKUNA;
        KAKUNA.evolucao = BEEDRILL;
        BEEDRILL.evolucao = null;

        PIKACHU.evolucao = RAICHU;
        RAICHU.evolucao = null;

        SANDSHREW.evolucao = SANDSLASH;
        SANDSLASH.evolucao = null;

        ODISH.evolucao = GLOOM;
        GLOOM.evolucao = VILEPLUME;
        VILEPLUME.evolucao = null;

        GROWLITHE.evolucao = ARCANINE;
        ARCANINE.evolucao = null;

        POLIWAG.evolucao = POLIWHIRL;
        POLIWHIRL.evolucao = POLIWRATH;
        POLIWRATH.evolucao = null;


    }

    public String getNome() {
        return nome;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public Ataques[] getAtaques() {
        return ataques;
    }

    public Integer getVida() {
        return vida;
    }

    public Pokemons getEvolucao() {
        return evolucao;
    }
}