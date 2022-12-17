package utils;

import data.Geracoes;
import data.Historicos;
import errors.PPInsuficienteException;
import errors.PedraEvolucaoException;
import errors.PokemonException;
import errors.SemPokemonsException;
import models.Jogador;
import data.Adversarios;
import models.Adversario;
import models.Ataque;
import models.Pokemon;
import models.Treinador;

import java.util.*;

public final class Escolha {

    private static final Random random = new Random();

    private Escolha() {
        throw new IllegalStateException("Utility class");
    }

    public static Integer aleatorio(int min, int max) {
        if (max == 0) {
            return 0;
        }

        return random.nextInt(max - min) + min;
    }

    public static Integer historico(Scanner sc, Historicos[] historicos) {
        final String[] titulosHistoricos = Arrays
                .stream(historicos)
                .map(Historicos::getTitulo)
                .toArray(String[]::new);

        final Integer escolha = Imprima.escolhaUmaOpcaoOuVoltar(sc, "Histórico", titulosHistoricos);

        if (escolha == titulosHistoricos.length + 1) {
            return -1;
        }

        return escolha;
    }

    public static boolean ehParaRevicer(Scanner sc) {
        final String[] OPCOES = {"Reviver", "Não"};
        final String TITULO = "Deseja reviver um pokemon?";
        final int escolhaSair = Imprima.escolhaUmaOpcao(sc, TITULO, OPCOES);

        return escolhaSair != 2;
    }
    public static void reviverPokemon(Scanner sc, Jogador jogador) {
        final boolean ehParaReviver = Escolha.ehParaRevicer(sc);

        if (!ehParaReviver) {
            return;
        }

        if (!jogador.temPokemonMorto()) {
            Imprima.divisoriaEmbrulho("Você não tem pokemons mortos");
            return;
        }

        final Map<Integer, Pokemon> pokemons = jogador.getPokemonsMortos();

        final Integer[] pokemonsIndices = pokemons.keySet().toArray(Integer[]::new);
        final String[] pokemonsNomes = pokemons.values().stream()
                .map(Pokemon::getNome)
                .toArray(String[]::new);

        final String TITULO = "Escolha um pokemon para reviver";
        final int escolha = Imprima.escolhaUmaOpcaoOuVoltar(sc, TITULO, pokemonsNomes);

        if (escolha == -1) {
            return;
        }

        final int indicePokemon = pokemonsIndices[escolha - 1];

        try {
            PokemonUtils.reviver(jogador, indicePokemon);

            final Pokemon pokemon = pokemons.get(indicePokemon);
            final String pokemonNome = pokemon.getNome();
            final Integer pokemonVida = pokemon.getVida();
            final String mensagem = String.format("Seu pokemon %s reviveu e está com %d de vida!", pokemonNome, pokemonVida);

            Imprima.divisoriaEmbrulho(mensagem);
        } catch (SemPokemonsException | PokemonException | PedraEvolucaoException e) {
            Imprima.divisoriaEmbrulho(e.getMessage());
        }
    }


    public static Boolean abandonar(Scanner sc) {
        Imprima.divisoriaEmbrulho("Quer continuar sua jornada?");

        final String[] opcoes = {"Continuar", "Desistir"};
        final String TITULO = "Jornada";
        final Integer escolha = Imprima.escolhaUmaOpcao(sc, TITULO, opcoes);

        if (escolha == 2) {
            System.out.println("Você abandonou o Jogo!");
            return true;
        }

        return false;
    }

    public static Adversario adversario(Scanner sc, Jogador jogador) {
        final Adversarios[] adversarios = Arrays.stream(Adversarios.values())
                .filter(adversario -> adversario.getNivel() == jogador.getNivel())
                .toArray(Adversarios[]::new);

        final String[] adversariosNomes = Arrays.stream(adversarios)
                .map(Adversarios::toString)
                .toArray(String[]::new);

        final String TITULO = "ADVERSÁRIO";
        final String SUBTITULO = "Escolha um adversário";
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, adversariosNomes);

        return Instancia.adversario(adversarios[escolha - 1]);
    }

    public static Ataque ataque(Scanner sc, Pokemon pokemon) throws PPInsuficienteException {
        if (pokemon.getAtaquesComPp().isEmpty()) {
            throw new PPInsuficienteException("O pokemon não tem ataques com PP");
        }

        final Ataque[] ataques = pokemon.getAtaques();
        final String[] ataquesNomes = Arrays.stream(ataques)
                .map(Ataque::toString)
                .toArray(String[]::new);


        final String TITULO = "ATACAR";
        final String SUBTITULO = "Escolha um ataque";
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, ataquesNomes);
        final Ataque ataque = ataques[escolha - 1];

        if (ataque.getPpAtual() <= 0) {
            Imprima.divisoriaEmbrulho("Você não tem mais PP para usar esse ataque!");
            return ataque(sc, pokemon);
        }

        System.out.printf("%s usou %s%n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    public static Ataque ataque(Pokemon pokemon) throws PPInsuficienteException {
        final Map<Integer, Ataque> ataques = pokemon.getAtaquesComPp();
        final Integer[] ataquesIndices = ataques.keySet().toArray(Integer[]::new);

        if (ataquesIndices.length == 0) {
            String mensagem = String.format("O pokemon %s não tem ataques com PP", pokemon.getNome());
            throw new PPInsuficienteException(mensagem);
        }

        final Integer escolha = ataquesIndices[Escolha.aleatorio(0, ataquesIndices.length - 1)];
        final Ataque ataque = ataques.get(escolha);

        System.out.printf("%s usou %s%n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    public static Jogador jogador(Scanner sc, Geracoes geracao) {
        System.out.print("Digite o seu nome: ");
        sc.nextLine();
        final String nome = sc.nextLine();
        Imprima.limparConsole();

        return Instancia.jogador(nome, geracao);
    }

    public static Geracoes geracao(Scanner sc) {
        final Geracoes[] geracoes = Geracoes.values();
        final String[] geracoesNomes = Arrays.stream(geracoes)
                .map(Geracoes::getNome)
                .toArray(String[]::new);

        final String TITULO = "GERAÇÃO";
        final String SUBTITULO = "Escolha os seus pokemons de uma geração";
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, geracoesNomes);

        return geracoes[escolha - 1];
    }

    public static void pokemon(Scanner sc, Treinador treinador) throws SemPokemonsException {
        if (treinador.estaMorto()) {
            throw new SemPokemonsException("Você não tem mais pokemons!");
        }

        final Pokemon[] pokemons = treinador.getPokemons();

        final List<Integer> indicePokemonsVivos = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].estaVivo()) {
                indicePokemonsVivos.add(i);
            }
        }

        final String[] pokemonsNomes = indicePokemonsVivos.stream()
                .map(i -> pokemons[i].toString())
                .toArray(String[]::new);

        final String TITULO = "Escolher Pokemon";
        final String SUBTITULO = "Escolha um pokemon";
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, pokemonsNomes);

        final int indice = indicePokemonsVivos.get(escolha - 1);

        treinador.definirPokemonBatalha(indice);
    }

    public static void pokemon(Treinador treinador) {
        if (treinador.estaMorto()) {
            return;
        }

        final Pokemon[] pokemons = treinador.getPokemons();
        final List<Integer> indicePokemonsVivos = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (!pokemons[i].estaMorto()) {
                indicePokemonsVivos.add(i);
            }
        }

        final int indice = aleatorio(0, indicePokemonsVivos.size() - 1);

        treinador.definirPokemonBatalha(indicePokemonsVivos.get(indice));
        Imprima.divisoriaEmbrulho(String.format("%s escolheu %s", treinador.getNome(), treinador.getPokemonAtual().getNome()));
    }

    public static void trocaPokemon(Scanner sc, Treinador treinador) {
        if (treinador.estaMorto()) {
            throw new SemPokemonsException("Você não tem mais pokemons!");
        }

        final Pokemon pokemonAntigo = treinador.getPokemonAtual();
        final Pokemon[] pokemons = treinador.getPokemons();

        final List<Integer> indicePokemonsVivos = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].estaVivo()) {
                indicePokemonsVivos.add(i);
            }
        }
        indicePokemonsVivos.remove(treinador.getIndicePokemonAtual());

        final String[] pokemonsNomes = indicePokemonsVivos.stream()
                .map(i -> pokemons[i].toString())
                .toArray(String[]::new);

        final String TITULO = "Escolher Pokemon";
        final String SUBTITULO = "Escolha um pokemon";
        final int escolha = Imprima.escolhaUmaOpcaoOuVoltar(sc, TITULO, SUBTITULO, pokemonsNomes);

        if (escolha == pokemonsNomes.length + 1) {
            return;
        }

        final int indice = indicePokemonsVivos.get(escolha - 1);

        treinador.definirPokemonBatalha(indice);

        String mensagem = String.format("%s trocou %s por %s", treinador.getNome(), pokemonAntigo.getNome(), treinador.getPokemonAtual().getNome());
        Imprima.divisoriaEmbrulho(mensagem);
    }

    public static void evoluirPokemon(Scanner sc, Jogador jogador) {
        while (true) {
            if (!jogador.temPedraEvolucao()) {
                return;
            }

            final String TITULO = "Evoluir";
            final String SUBTITULO = "Você tem uma pedra de evolução!\nDeseja evoluir seu pokemon?";
            final String[] opcoes = {"Sim", "Não"};
            final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, opcoes);

            switch (escolha) {
                case 1 -> evoluir(sc, jogador);
                case 2 -> {
                    return;
                }
                default -> Dialogo.opcaoInvalida();
            }
        }
    }

    private static void evoluir(Scanner sc, Jogador jogador) {
        final Pokemon[] pokemons = jogador.getPokemons();
        final List<Integer> indicePokemonsTemEvolucao = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].getEvolucao() != null) {
                indicePokemonsTemEvolucao.add(i);
            }
        }

        if (indicePokemonsTemEvolucao.isEmpty()) {
            Imprima.divisoriaEmbrulho("Você não tem nenhum pokemon que possa evoluir!");
            return;
        }

        final String[] pokemonsNomes = indicePokemonsTemEvolucao.stream()
                .map(i -> pokemons[i].getNome())
                .toArray(String[]::new);


        final int escolhaPokemon = Imprima.escolhaUmaOpcao(sc, "Escolha um pokemon", pokemonsNomes);
        final int indicePokemon = indicePokemonsTemEvolucao.get(escolhaPokemon - 1);

        final Pokemon pokemon = pokemons[indicePokemon];

        final String pokemonNome = pokemon.getNome();
        final String evolucaoNome = pokemon.getEvolucao().getNome();
        final String mensagem = String.format("Seu pokemon %s evoluiu para %s!", pokemonNome, evolucaoNome);

        try {
            jogador.evoluirPokemon(indicePokemon);
            Imprima.divisoriaEmbrulho(mensagem);
        } catch (PedraEvolucaoException | PokemonException e) {
            Imprima.divisoriaEmbrulho(e.getMessage());
        }
    }

    public static void verInventario(Jogador jogador) {
        final Pokemon[] pokemons = jogador.getPokemons();

        Imprima.divisoria("Inventario");
        System.out.println(jogador.temRevive() ? "Você tem um revive!" : "Você não tem revive!");

        if (jogador.getPedraEvolucao() == 0) {
            System.out.println("Você não tem pedra de evolução!");
        } else if (jogador.getPedraEvolucao() == 1) {
            System.out.println("Você tem 1 pedra de evolução!");
        } else {
            System.out.printf("Você tem %d pedras de evolução!%n", jogador.getPedraEvolucao());
        }

        Imprima.divisoria("Pokemons");
        for (int i = 0; i < pokemons.length; i++) {
            final Pokemon pokemon = pokemons[i];

            System.out.print(pokemon);

            if (pokemon.estaMorto()) {
                System.out.print(" [Morto]");
            } else if (jogador.getIndicePokemonAtual() == i) {
                System.out.print(" [Batalhando]");
            }

            System.out.println();
        }

    }

    public static void reiniciar(Scanner sc) {
        final String TITULO = "Reiniciar";
        final String SUBTITULO = "Deseja reiniciar o jogo?";
        final String[] opcoes = {"Sim", "Não"};
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, opcoes);

        switch (escolha) {
            case 1 -> {/* Não faz nada */}
            case 2 -> System.exit(0);
            default -> Dialogo.opcaoInvalida();
        }
    }
}
