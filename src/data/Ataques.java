package data;

public enum Ataques {
    ABSORB (" Absorb ", Especialidades. PLANTA , 16 , 24),
    ACID (" Acid ", Especialidades. VENENOSO , 32 , 48),
    AURORA_BEAM (" Aurora Beam ", Especialidades. GELO , 52 , 78),
    BARRAGE (" Barrage ", Especialidades. NORMAL , 12 , 18),
    BIND (" Bind ", Especialidades. NORMAL , 12 , 18),
    BITE (" Bite ", Especialidades. SOMBRIO , 48 , 72),
    BLIZZARD (" Blizzard ", Especialidades. GELO , 88 , 132),
    BODY_SLAM (" Body Slam ", Especialidades. NORMAL , 68 , 102),
    BONE_CLUB (" Bone Club ", Especialidades. TERRESTRE , 52 , 78),
    BONEMERANG (" Bonemerang ", Especialidades. TERRESTRE , 40 , 60),
    BUBBLE (" Bubble ", Especialidades. AGUA , 32 , 48),
    BUBBLE_BEAM (" Bubble Beam ", Especialidades. AGUA , 52 , 78),
    CLAMP (" Clamp ", Especialidades. AGUA , 28 , 42),
    COMET_PUNCH (" Comet Punch ", Especialidades. NORMAL , 14 , 22),
    CONFUSION (" Confusion ", Especialidades. PSIQUICO , 40 , 60),
    CONSTRICT (" Constrict ", Especialidades. NORMAL , 8 , 12),
    CRABHAMMER (" Crabhammer ", Especialidades. AGUA , 80 , 120),
    CUT (" Cut ", Especialidades. NORMAL , 40 , 60),
    DIG (" Dig ", Especialidades. TERRESTRE , 64 , 96),
    DIZZY_PUNCH (" Dizzy Punch ", Especialidades. NORMAL , 56 , 84),
    DOUBLE_EDGE (" Double-Edge ", Especialidades. NORMAL , 96 , 144),
    DOUBLE_KICK (" Double Kick ", Especialidades. LUTADOR , 24 , 36),
    DOUBLE_SLAP (" Double Slap ", Especialidades. NORMAL , 12 , 18),
    DREAM_EATER (" Dream Eater ", Especialidades. PSIQUICO , 80 , 120),
    DRILL_PECK (" Drill Peck ", Especialidades. VOADOR , 64 , 96),
    EARTHQUAKE (" Earthquake ", Especialidades. TERRESTRE , 80 , 120),
    EGG_BOMB (" Egg Bomb ", Especialidades. NORMAL , 80 , 120),
    EMBER (" Ember ", Especialidades. FOGO , 32 , 48),
    EXPLOSION (" Explosion ", Especialidades. NORMAL , 200 , 300),
    FIRE_BLAST (" Fire Blast ", Especialidades. FOGO , 88 , 132),
    FIRE_PUNCH (" Fire Punch ", Especialidades. FOGO , 60 , 90),
    FIRE_SPIN (" Fire Spin ", Especialidades. FOGO , 28 , 42),
    FLAMETHROWER (" Flamethrower ", Especialidades. FOGO , 72 , 108),
    FLY (" Fly ", Especialidades. VOADOR , 72 , 108),
    FURY_ATTACK (" Fury Attack ", Especialidades. NORMAL , 12 , 18),
    FURY_SWIPES (" Fury Swipes ", Especialidades. NORMAL , 14 , 22),
    GUST (" Gust ", Especialidades. VOADOR , 32 , 48),
    HEADBUTT (" Headbutt ", Especialidades. NORMAL , 56 , 84),
    HIGH_JUMP_KICK (" High Jump Kick ", Especialidades. LUTADOR , 104 , 156),
    HORN_ATTACK (" Horn Attack ", Especialidades. NORMAL , 52 , 78),
    HYDRO_PUMP (" Hydro Pump ", Especialidades. AGUA , 88 , 132),
    HYPER_BEAM (" Hyper Beam ", Especialidades. NORMAL , 120 , 180),
    HYPER_FANG (" Hyper Fang ", Especialidades. NORMAL , 64 , 96),
    ICE_BEAM (" Ice Beam ", Especialidades. GELO , 72 , 108),
    ICE_PUNCH (" Ice Punch ", Especialidades. GELO , 60 , 90),
    JUMP_KICK (" Jump Kick ", Especialidades. LUTADOR , 80 , 120),
    KARATE_CHOP (" Karate Chop ", Especialidades. LUTADOR , 40 , 60),
    LEECH_LIFE (" Leech Life ", Especialidades. INSETO , 64 , 96),
    LICK (" Lick ", Especialidades. FANTASMA , 24 , 36),
    MEGA_DRAIN (" Mega Drain ", Especialidades. PLANTA , 32 , 48),
    MEGA_KICK (" Mega Kick ", Especialidades. NORMAL , 96 , 144),
    MEGA_PUNCH (" Mega Punch ", Especialidades. NORMAL , 64 , 96),
    PAY_DAY (" Pay Day ", Especialidades. NORMAL , 32 , 48),
    PECK (" Peck ", Especialidades. VOADOR , 28 , 42),
    PETAL_DANCE (" Petal Dance ", Especialidades. PLANTA , 96 , 144),
    PIN_MISSILE (" Pin Missile ", Especialidades. INSETO , 20 , 30),
    POISON_STING (" Poison Sting ", Especialidades. VENENOSO , 12 , 18),
    POUND (" Pound ", Especialidades. NORMAL , 32 , 48),
    PSYBEAM (" Psybeam ", Especialidades. PSIQUICO , 52 , 78),
    PSYCHIC (" Psychic ", Especialidades. PSIQUICO , 72 , 108),
    QUICK_ATTACK (" Quick Attack ", Especialidades. NORMAL , 32 , 48),
    RAGE (" Rage ", Especialidades. NORMAL , 16 , 24),
    RAZOR_LEAF (" Razor Leaf ", Especialidades. PLANTA , 44 , 66),
    RAZOR_WIND (" Razor Wind ", Especialidades. NORMAL , 64 , 96),
    ROCK_SLIDE (" Rock Slide ", Especialidades. PEDRA , 60 , 90),
    ROCK_THROW (" Rock Throw ", Especialidades. PEDRA , 40 , 60),
    ROLLING_KICK (" Rolling Kick ", Especialidades. LUTADOR , 48 , 72),
    SCRATCH (" Scratch ", Especialidades. NORMAL , 32 , 48),
    SELF_DESTRUCT (" Self-Destruct ", Especialidades. NORMAL , 160 , 240),
    SKULL_BASH (" Skull Bash ", Especialidades. NORMAL , 104 , 156),
    SKY_ATTACK (" Sky Attack ", Especialidades. VOADOR , 112 , 168),
    SLAM (" Slam ", Especialidades. NORMAL , 64 , 96),
    SLASH (" Slash ", Especialidades. NORMAL , 56 , 84),
    SLUDGE (" Sludge ", Especialidades. VENENOSO , 52 , 78),
    SMOG (" Smog ", Especialidades. VENENOSO , 24 , 36),
    SOLAR_BEAM (" Solar Beam ", Especialidades. PLANTA , 96 , 144),
    SPIKE_CANNON (" Spike Cannon ", Especialidades. NORMAL , 16 , 24),
    STOMP (" Stomp ", Especialidades. NORMAL , 52 , 78),
    STRENGTH (" Strength ", Especialidades. NORMAL , 64 , 96),
    STRUGGLE (" Struggle ", Especialidades. NORMAL , 40 , 60),
    SUBMISSION (" Submission ", Especialidades. LUTADOR , 64 , 96),
    SURF (" Surf ", Especialidades. AGUA , 72 , 108),
    SWIFT (" Swift ", Especialidades. NORMAL , 48 , 72),
    TACKLE (" Tackle ", Especialidades. NORMAL , 32 , 48),
    TAKE_DOWN (" Take Down ", Especialidades. NORMAL , 72 , 108),
    THRASH (" Thrash ", Especialidades. NORMAL , 96 , 144),
    THUNDER (" Thunder ", Especialidades. ELETRICO , 88 , 132),
    THUNDER_PUNCH (" Thunder Punch ", Especialidades. ELETRICO , 60 , 90),
    THUNDER_SHOCK (" Thunder Shock ", Especialidades. ELETRICO , 32 , 48),
    THUNDERBOLT (" Thunderbolt ", Especialidades. ELETRICO , 72 , 108),
    TRI_ATTACK (" Tri Attack ", Especialidades. NORMAL , 64 , 96),
    TWINEEDLE (" Twineedle ", Especialidades. INSETO , 20 , 30),
    VINE_WHIP (" Vine Whip ", Especialidades. PLANTA , 36 , 54),
    VISE_GRIP (" Vise Grip ", Especialidades. NORMAL , 44 , 66),
    WATER_GUN (" Water Gun ", Especialidades. AGUA , 32 , 48),
    WATERFALL (" Waterfall ", Especialidades. AGUA , 64 , 96),
    WING_ATTACK (" Wing Attack ", Especialidades. VOADOR , 48 , 72),
    WRAP (" Wrap ", Especialidades. NORMAL , 12 , 18);

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
