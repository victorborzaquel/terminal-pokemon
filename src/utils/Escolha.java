package utils;

import data.Geracoes;
import data.Historicos;
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

        final Integer escolha = Imprima.escolhaUmaOpcao(sc, "Histórico", titulosHistoricos, "Voltar");

        if (escolha == titulosHistoricos.length + 1) {
            return -1;
        }

        return escolha;
    }

    public static void reviverPokemon(Scanner sc, Jogador jogador) {
        final String[] OPCOES = {"Reviver", "Não"};
        final String TITULO = "Deseja reviver um pokemon?";
        final int escolhaSair = Imprima.escolhaUmaOpcao(sc, TITULO, OPCOES);

        final Pokemon[] pokemons = jogador.getPokemons();

        if (escolhaSair == 2) {
            return;
        }

        int indicePokemon = Escolha.pokemonMorto(sc, jogador) - 1;

        try {
            PokemonUtils.reviver(jogador, indicePokemon);

            final Pokemon pokemon = pokemons[indicePokemon];
            final String pokemonNome = pokemon.getNome();
            final Integer pokemonVida = pokemon.getVida();
            final String mensagem = String.format("Seu pokemon %s reviveu e está com %d de vida!", pokemonNome, pokemonVida);

            Imprima.divisoriaEmbrulho(mensagem);
        } catch (SemPokemonsException | PokemonException | PedraEvolucaoException e) {
            Imprima.divisoriaEmbrulho(e.getMessage());
        }
    }

    public static Integer pokemonMorto(Scanner sc, Jogador jogador) {
        if (Boolean.FALSE.equals(jogador.temPokemonMorto())) {
            throw new SemPokemonsException("O treinador não tem pokemons mortos");
        }

        final Map<Integer, Pokemon> pokemons = jogador.getPokemonsMortos();

        final String[] pokemonsNomes = pokemons
                .values()
                .stream()
                .map(Pokemon::getNome)
                .toArray(String[]::new);

        final String TITULO = "Escolha um pokemon para reviver";

        return Imprima.escolhaUmaOpcao(sc, TITULO, pokemonsNomes);
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

    public static Ataque ataque(Scanner sc, Pokemon pokemon) {
        final Ataque[] ataques = pokemon.getAtaques();
        final String[] ataquesNomes = Arrays.stream(ataques)
                .map(Ataque::toString)
                .toArray(String[]::new);


        final String TITULO = "ATACAR";
        final String SUBTITULO = "Escolha um ataque";
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, ataquesNomes);
        final Ataque ataque = ataques[escolha - 1];

        System.out.printf("%s usou %s%n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    public static Ataque ataque(Pokemon pokemon) {
        final Ataque[] ataques = pokemon.getAtaques();
        final Ataque ataque = ataques[Escolha.aleatorio(0, ataques.length - 1)];

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
        final String SUBTITULO = "Escolha uma geração";
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
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, pokemonsNomes);

        final int indice = indicePokemonsVivos.get(escolha - 1);

        treinador.definirPokemonBatalha(indice);

        Imprima.divisoriaEmbrulho("%s foi trocado por %s%n", pokemonAntigo.getNome(), treinador.getPokemonAtual().getNome());
    }

    public static void evoluirPokemon(Scanner sc, Jogador jogador) {
        final String TITULO = "Evoluir";
        final String SUBTITULO = "Você tem uma pedra de evolução!\nDeseja evoluir seu pokemon?";
        final String[] opcoes = {"Sim", "Não"};
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, opcoes);

        switch (escolha) {
            case 1 -> evoluir(sc, jogador);
            case 2 -> {/* Não faz nada*/}
            default -> Dialogo.opcaoInvalida();
        }
    }

    private static void evoluir(Scanner sc, Jogador jogador) {
        final Pokemon[] pokemons = jogador.getPokemons();
        final List<Integer> indicePokemonsVivos = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].getEvolucao() != null) {
                indicePokemonsVivos.add(i);
            }
        }

        final String[] pokemonsNomes = indicePokemonsVivos.stream()
                .map(i -> pokemons[i].getNome())
                .toArray(String[]::new);


        final int escolhaPokemon = Imprima.escolhaUmaOpcao(sc, "Escolha um pokemon", pokemonsNomes);
        final int indicePokemon = indicePokemonsVivos.get(escolhaPokemon - 1);

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

    public static void acaoBatalha(Scanner sc, Jogador jogador) {
        final String TITULO = "Ação";
        final String SUBTITULO = "O que deseja fazer?";
        final String[] opcoes = {"Atacar", "Trocar Pokemon", "Ver Inventario"};
        final int escolha = Imprima.escolhaUmaOpcao(sc, TITULO, SUBTITULO, opcoes);

        switch (escolha) {
            case 1 -> {/* Não faz nada */}
            case 2 -> trocaPokemon(sc, jogador);
            case 3 -> verInventario(jogador);
            default -> Dialogo.opcaoInvalida();
        }
    }

    private static void verInventario(Jogador jogador) {
        final Pokemon[] pokemons = jogador.getPokemons();

        System.out.println(jogador.temRevive() ? "Você tem um revive!" : "Você não tem revive!");

        if (jogador.getPedraEvolucao() == 0) {
            System.out.println("Você não tem pedra de evolução!");
        } else if (jogador.getPedraEvolucao() == 1) {
            System.out.println("Você tem 1 pedra de evolução!");
        } else {
            System.out.printf("Você tem %d pedras de evolução!%n", jogador.getPedraEvolucao());
        }

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
}
