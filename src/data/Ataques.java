package data;

public enum Ataques {
    // NORMAL
    BARRAGE("Barrage", Especialidades.NORMAL, 12, 18, 10),
    BIND("Bind", Especialidades.NORMAL, 12, 18, 10),
    BODY_SLAM("Body Slam", Especialidades.NORMAL, 68, 102, 4),
    COMET_PUNCH("Comet Punch", Especialidades.NORMAL, 14, 22, 7),
    CONSTRICT("Constrict", Especialidades.NORMAL, 8, 12, 40),
    CUT("Cut", Especialidades.NORMAL, 40, 60, 5),
    MEGA_KICK("Mega Kick", Especialidades.NORMAL, 96, 144, 1),
    MEGA_PUNCH("Mega Punch", Especialidades.NORMAL, 64, 96, 7),
    PAY_DAY("Pay Day", Especialidades.NORMAL, 32, 48, 5),
    HORN_ATTACK("Horn Attack", Especialidades.NORMAL, 52, 78, 3),
    FURY_ATTACK("Fury Attack", Especialidades.NORMAL, 12, 18, 10),
    FURY_SWIPES("Fury Swipes", Especialidades.NORMAL, 14, 22, 10),
    EGG_BOMB("Egg Bomb", Especialidades.NORMAL, 80, 120, 1),
    DIZZY_PUNCH("Dizzy Punch", Especialidades.NORMAL, 56, 84, 3),
    DOUBLE_EDGE("Double-Edge", Especialidades.NORMAL, 96, 144, 1),
    DOUBLE_SLAP("Double Slap", Especialidades.NORMAL, 12, 18, 10),
    EXPLOSION("Explosion", Especialidades.NORMAL, 200, 300, 1),
    HYPER_BEAM("Hyper Beam", Especialidades.NORMAL, 120, 180, 2),
    HYPER_FANG("Hyper Fang", Especialidades.NORMAL, 64, 96, 6),
    SCRATCH("Scratch", Especialidades.NORMAL, 32, 48, 5),
    SELF_DESTRUCT("Self-Destruct", Especialidades.NORMAL, 160, 240, 1),
    SKULL_BASH("Skull Bash", Especialidades.NORMAL, 104, 156, 3),
    SLAM("Slam", Especialidades.NORMAL, 64, 96, 5),
    SLASH("Slash", Especialidades.NORMAL, 56, 84, 3),
    SPIKE_CANNON("Spike Cannon", Especialidades.NORMAL, 16, 24, 10),
    STOMP("Stomp", Especialidades.NORMAL, 52, 78, 7),
    STRENGTH("Strength", Especialidades.NORMAL, 64, 96, 5),
    STRUGGLE("Struggle", Especialidades.NORMAL, 40, 60, 7),
    TRI_ATTACK("Tri Attack", Especialidades.NORMAL, 64, 96, 5),
    VISE_GRIP("Vise Grip", Especialidades.NORMAL, 44, 66, 5),
    WRAP("Wrap", Especialidades.NORMAL, 12, 18, 10),
    SWIFT("Swift", Especialidades.NORMAL, 48, 72, 10),
    TACKLE("Tackle", Especialidades.NORMAL, 32, 48, 5),
    TAKE_DOWN("Take Down", Especialidades.NORMAL, 72, 108, 2),
    THRASH("Thrash", Especialidades.NORMAL, 96, 144, 1),
    HEADBUTT("Headbutt", Especialidades.NORMAL, 56, 84, 6),
    POUND("Pound", Especialidades.NORMAL, 32, 48, 15),
    QUICK_ATTACK("Quick Attack", Especialidades.NORMAL, 32, 48, 25),
    RAGE("Rage", Especialidades.NORMAL, 16, 24, 30),
    RAZOR_WIND("Razor Wind", Especialidades.NORMAL, 64, 96, 7),

    // ELECTRICO
    THUNDER("Thunder", Especialidades.ELETRICO, 88, 132, 3),
    THUNDER_PUNCH("Thunder Punch", Especialidades.ELETRICO, 60, 90, 2),
    THUNDER_SHOCK("Thunder Shock", Especialidades.ELETRICO, 32, 48, 5),
    THUNDERBOLT("Thunderbolt", Especialidades.ELETRICO, 72, 108, 1),

    // VOADOR
    FLY("Fly", Especialidades.VOADOR, 72, 108, 1),
    DRILL_PECK("Drill Peck", Especialidades.VOADOR, 64, 96, 2),
    SKY_ATTACK("Sky Attack", Especialidades.VOADOR, 112, 168, 1),
    GUST("Gust", Especialidades.VOADOR, 32, 48, 5),
    PECK("Peck", Especialidades.VOADOR, 28, 42, 5),
    WING_ATTACK("Wing Attack", Especialidades.VOADOR, 48, 72, 4),

    // PLANTA
    ABSORB("Absorb", Especialidades.PLANTA, 16, 24, 10),
    VINE_WHIP("Vine Whip", Especialidades.PLANTA, 36, 54, 5),
    SOLAR_BEAM("Solar Beam", Especialidades.PLANTA, 96, 144, 1),
    MEGA_DRAIN("Mega Drain", Especialidades.PLANTA, 32, 48, 6),
    PETAL_DANCE("Petal Dance", Especialidades.PLANTA, 96, 144, 1),
    RAZOR_LEAF("Razor Leaf", Especialidades.PLANTA, 44, 66, 5),

    // VENENOSO
    ACID("Acid", Especialidades.VENENOSO, 32, 48, 15),
    POISON_STING("Poison Sting", Especialidades.VENENOSO, 12, 18, 10),
    SLUDGE("Sludge", Especialidades.VENENOSO, 52, 78, 3),
    SMOG("Smog", Especialidades.VENENOSO, 24, 36, 5),

    // GELO
    AURORA_BEAM("Aurora Beam", Especialidades.GELO, 52, 78, 4),
    BLIZZARD("Blizzard", Especialidades.GELO, 88, 132, 1),
    ICE_BEAM("Ice Beam", Especialidades.GELO, 72, 108, 1),
    ICE_PUNCH("Ice Punch", Especialidades.GELO, 60, 90, 2),

    // TERRESTRE
    BONE_CLUB("Bone Club", Especialidades.TERRESTRE, 52, 78, 12),
    BONEMERANG("Bonemerang", Especialidades.TERRESTRE, 40, 60, 13),
    DIG("Dig", Especialidades.TERRESTRE, 64, 96, 5),
    EARTHQUAKE("Earthquake", Especialidades.TERRESTRE, 80, 120, 3),

    // AGUA
    BUBBLE("Bubble", Especialidades.AGUA, 32, 48, 5),
    BUBBLE_BEAM("Bubble Beam", Especialidades.AGUA, 52, 78, 3),
    CLAMP("Clamp", Especialidades.AGUA, 28, 42, 5),
    CRABHAMMER("Crabhammer", Especialidades.AGUA, 80, 120, 1),
    HYDRO_PUMP("Hydro Pump", Especialidades.AGUA, 88, 132, 1),
    SURF("Surf", Especialidades.AGUA, 72, 108, 1),
    WATER_GUN("Water Gun", Especialidades.AGUA, 32, 48, 5),
    WATERFALL("Waterfall", Especialidades.AGUA, 64, 96, 2),

    // PISIQUICO
    PSYBEAM("Psybeam", Especialidades.PSIQUICO, 52, 78, 10),
    PSYCHIC("Psychic", Especialidades.PSIQUICO, 72, 108, 5),
    CONFUSION("Confusion", Especialidades.PSIQUICO, 40, 60, 20),
    DREAM_EATER("Dream Eater", Especialidades.PSIQUICO, 80, 120, 4),

    // LUTADOR
    DOUBLE_KICK("Double Kick", Especialidades.LUTADOR, 24, 36, 20),
    HIGH_JUMP_KICK("High Jump Kick", Especialidades.LUTADOR, 104, 156, 3),
    JUMP_KICK("Jump Kick", Especialidades.LUTADOR, 80, 120, 3),
    KARATE_CHOP("Karate Chop", Especialidades.LUTADOR, 40, 60, 10),
    ROLLING_KICK("Rolling Kick", Especialidades.LUTADOR, 48, 72, 10),
    SUBMISSION("Submission", Especialidades.LUTADOR, 64, 96, 5),

    // FOGO
    EMBER("Ember", Especialidades.FOGO, 32, 48, 5),
    FIRE_BLAST("Fire Blast", Especialidades.FOGO, 88, 132, 1),
    FIRE_PUNCH("Fire Punch", Especialidades.FOGO, 60, 90, 2),
    FIRE_SPIN("Fire Spin", Especialidades.FOGO, 28, 42, 6),
    FLAMETHROWER("Flamethrower", Especialidades.FOGO, 72, 108, 1),

    // INSETO
    TWINEEDLE("Twineedle", Especialidades.INSETO, 20, 30, 7),
    PIN_MISSILE("Pin Missile", Especialidades.INSETO, 20, 30, 7),
    LEECH_LIFE("Leech Life", Especialidades.INSETO, 64, 96, 2),

    // PEDRA
    ROCK_SLIDE("Rock Slide", Especialidades.PEDRA, 60, 90, 10),
    ROCK_THROW("Rock Throw", Especialidades.PEDRA, 40, 60, 13),

    // SOMBRIO
    BITE("Bite", Especialidades.SOMBRIO, 48, 72, 15),

    // FANTASMA
    LICK("Lick", Especialidades.FANTASMA, 24, 36, 20);

    private final String nome;
    private final Especialidades especialidade;
    private final Integer danoMinimo;
    private final Integer danoMaximo;
    private final Integer pp;

    Ataques(String nome, Especialidades especialidade, Integer ataqueMinimo, Integer ataqueMaximo, Integer pp) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.danoMinimo = ataqueMinimo;
        this.danoMaximo = ataqueMaximo;
        this.pp = pp;
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

    public Integer getPp() {
        return pp;
    }
}
