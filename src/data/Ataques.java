package data;

public enum Ataques {
    BARRAGE("Barrage", Especialidades.NORMAL, 12, 18, 25),
    BIND("Bind", Especialidades.NORMAL, 12, 18, 30),
    BODY_SLAM("Body Slam", Especialidades.NORMAL, 68, 102, 4),
    COMET_PUNCH("Comet Punch", Especialidades.NORMAL, 14, 22, 30),
    CONSTRICT("Constrict", Especialidades.NORMAL, 8, 12, 40),
    CUT("Cut", Especialidades.NORMAL, 40, 60, 10),
    MEGA_KICK("Mega Kick", Especialidades.NORMAL, 96, 144, 3),
    MEGA_PUNCH("Mega Punch", Especialidades.NORMAL, 64, 96, 7),
    PAY_DAY("Pay Day", Especialidades.NORMAL, 32, 48, 15),
    HORN_ATTACK("Horn Attack", Especialidades.NORMAL, 52, 78, 6),
    FURY_ATTACK("Fury Attack", Especialidades.NORMAL, 12, 18, 30),
    FURY_SWIPES("Fury Swipes", Especialidades.NORMAL, 14, 22, 25),
    EGG_BOMB("Egg Bomb", Especialidades.NORMAL, 80, 120, 3),
    DIZZY_PUNCH("Dizzy Punch", Especialidades.NORMAL, 56, 84, 6),
    DOUBLE_EDGE("Double-Edge", Especialidades.NORMAL, 96, 144, 3),
    DOUBLE_SLAP("Double Slap", Especialidades.NORMAL, 12, 18, 30),
    EXPLOSION("Explosion", Especialidades.NORMAL, 200, 300, 1),
    HYPER_BEAM("Hyper Beam", Especialidades.NORMAL, 120, 180, 2),
    HYPER_FANG("Hyper Fang", Especialidades.NORMAL, 64, 96, 6),
    SCRATCH("Scratch", Especialidades.NORMAL, 32, 48, 20),
    SELF_DESTRUCT("Self-Destruct", Especialidades.NORMAL, 160, 240, 1),
    SKULL_BASH("Skull Bash", Especialidades.NORMAL, 104, 156, 3),
    SLAM("Slam", Especialidades.NORMAL, 64, 96, 5),
    SLASH("Slash", Especialidades.NORMAL, 56, 84, 10),
    SPIKE_CANNON("Spike Cannon", Especialidades.NORMAL, 16, 24, 20),
    STOMP("Stomp", Especialidades.NORMAL, 52, 78, 7),
    STRENGTH("Strength", Especialidades.NORMAL, 64, 96, 5),
    STRUGGLE("Struggle", Especialidades.NORMAL, 40, 60, 7),
    TRI_ATTACK("Tri Attack", Especialidades.NORMAL, 64, 96, 5),
    VISE_GRIP("Vise Grip", Especialidades.NORMAL, 44, 66, 15),
    WRAP("Wrap", Especialidades.NORMAL, 12, 18, 25),
    SWIFT("Swift", Especialidades.NORMAL, 48, 72, 10),
    TACKLE("Tackle", Especialidades.NORMAL, 32, 48, 20),
    TAKE_DOWN("Take Down", Especialidades.NORMAL, 72, 108, 4),
    THRASH("Thrash", Especialidades.NORMAL, 96, 144, 2),
    HEADBUTT("Headbutt", Especialidades.NORMAL, 56, 84, 6),
    POUND("Pound", Especialidades.NORMAL, 32, 48, 15),
    QUICK_ATTACK("Quick Attack", Especialidades.NORMAL, 32, 48, 25),
    RAGE("Rage", Especialidades.NORMAL, 16, 24, 30),
    RAZOR_WIND("Razor Wind", Especialidades.NORMAL, 64, 96, 7),


    THUNDER("Thunder", Especialidades.ELETRICO, 88, 132, 3),
    THUNDER_PUNCH("Thunder Punch", Especialidades.ELETRICO, 60, 90, 7),
    THUNDER_SHOCK("Thunder Shock", Especialidades.ELETRICO, 32, 48, 10),
    THUNDERBOLT("Thunderbolt", Especialidades.ELETRICO, 72, 108, 4),


    FLY("Fly", Especialidades.VOADOR, 72, 108, 5),
    DRILL_PECK("Drill Peck", Especialidades.VOADOR, 64, 96, 6),
    SKY_ATTACK("Sky Attack", Especialidades.VOADOR, 112, 168, 3),
    GUST("Gust", Especialidades.VOADOR, 32, 48, 20),
    PECK("Peck", Especialidades.VOADOR, 28, 42, 20),
    WING_ATTACK("Wing Attack", Especialidades.VOADOR, 48, 72, 10),


    ABSORB("Absorb", Especialidades.PLANTA, 16, 24, 20),
    VINE_WHIP("Vine Whip", Especialidades.PLANTA, 36, 54, 10),
    SOLAR_BEAM("Solar Beam", Especialidades.PLANTA, 96, 144, 3),
    MEGA_DRAIN("Mega Drain", Especialidades.PLANTA, 32, 48, 20),
    PETAL_DANCE("Petal Dance", Especialidades.PLANTA, 96, 144, 3),
    RAZOR_LEAF("Razor Leaf", Especialidades.PLANTA, 44, 66, 10),


    ACID("Acid", Especialidades.VENENOSO, 32, 48, 15),
    POISON_STING("Poison Sting", Especialidades.VENENOSO, 12, 18, 30),
    SLUDGE("Sludge", Especialidades.VENENOSO, 52, 78, 10),
    SMOG("Smog", Especialidades.VENENOSO, 24, 36, 30),


    AURORA_BEAM("Aurora Beam", Especialidades.GELO, 52, 78, 13),
    BLIZZARD("Blizzard", Especialidades.GELO, 88, 132, 3),
    ICE_BEAM("Ice Beam", Especialidades.GELO, 72, 108, 4),
    ICE_PUNCH("Ice Punch", Especialidades.GELO, 60, 90, 6),


    BONE_CLUB("Bone Club", Especialidades.TERRESTRE, 52, 78, 12),
    BONEMERANG("Bonemerang", Especialidades.TERRESTRE, 40, 60, 13),
    DIG("Dig", Especialidades.TERRESTRE, 64, 96, 5),
    EARTHQUAKE("Earthquake", Especialidades.TERRESTRE, 80, 120, 3),


    BUBBLE("Bubble", Especialidades.AGUA, 32, 48, 20),
    BUBBLE_BEAM("Bubble Beam", Especialidades.AGUA, 52, 78, 15),
    CLAMP("Clamp", Especialidades.AGUA, 28, 42, 25),
    CRABHAMMER("Crabhammer", Especialidades.AGUA, 80, 120, 2),
    HYDRO_PUMP("Hydro Pump", Especialidades.AGUA, 88, 132, 3),
    SURF("Surf", Especialidades.AGUA, 72, 108, 5),
    WATER_GUN("Water Gun", Especialidades.AGUA, 32, 48, 20),
    WATERFALL("Waterfall", Especialidades.AGUA, 64, 96, 5),


    PSYBEAM("Psybeam", Especialidades.PSIQUICO, 52, 78, 10),
    PSYCHIC("Psychic", Especialidades.PSIQUICO, 72, 108, 5),
    CONFUSION("Confusion", Especialidades.PSIQUICO, 40, 60, 20),
    DREAM_EATER("Dream Eater", Especialidades.PSIQUICO, 80, 120, 4),


    DOUBLE_KICK("Double Kick", Especialidades.LUTADOR, 24, 36, 20),
    HIGH_JUMP_KICK("High Jump Kick", Especialidades.LUTADOR, 104, 156, 3),
    JUMP_KICK("Jump Kick", Especialidades.LUTADOR, 80, 120, 3),
    KARATE_CHOP("Karate Chop", Especialidades.LUTADOR, 40, 60, 10),
    ROLLING_KICK("Rolling Kick", Especialidades.LUTADOR, 48, 72, 10),
    SUBMISSION("Submission", Especialidades.LUTADOR, 64, 96, 5),


    EMBER("Ember", Especialidades.FOGO, 32, 48, 15),
    FIRE_BLAST("Fire Blast", Especialidades.FOGO, 88, 132, 4),
    FIRE_PUNCH("Fire Punch", Especialidades.FOGO, 60, 90, 7),
    FIRE_SPIN("Fire Spin", Especialidades.FOGO, 28, 42, 20),
    FLAMETHROWER("Flamethrower", Especialidades.FOGO, 72, 108, 5),


    TWINEEDLE("Twineedle", Especialidades.INSETO, 20, 30, 20),
    PIN_MISSILE("Pin Missile", Especialidades.INSETO, 20, 30, 20),
    LEECH_LIFE("Leech Life", Especialidades.INSETO, 64, 96, 6),


    ROCK_SLIDE("Rock Slide", Especialidades.PEDRA, 60, 90, 10),
    ROCK_THROW("Rock Throw", Especialidades.PEDRA, 40, 60, 13),


    BITE("Bite", Especialidades.SOMBRIO, 48, 72, 15),


    LICK("Lick", Especialidades.FANTASMA, 24, 36, 20),;

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
