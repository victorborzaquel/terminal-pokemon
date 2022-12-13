package utils;

import data.Geracoes;
import errors.SemPokemonsException;
import models.Jogador;
import data.Adversarios;
import models.Adversario;
import models.Ataque;
import models.Pokemon;
import models.Treinador;

import java.util.*;

public final class Escolher {

    public static void reviverPokemon(Scanner sc, Jogador jogador) {
        final String[] OPCOES = {"Reviver", "Não"};
        final String TITULO = "Deseja reviver um pokemon?";
        final int escolha = Imprimir.escolhaUmaOpcao(sc, TITULO, OPCOES);

        if (escolha == 2) {
            return;
        }

        try {
            PokemonUtils.reviver(sc, jogador);
        } catch (SemPokemonsException e) {
            Imprimir.divisoriaEmbrulho(e.getMessage());
        }
    }

    public static Boolean abandonar(Scanner sc) {
        Imprimir.divisoriaEmbrulho("Quer continuar sua jornada?");

        final String[] OPCOES = {"Continuar", "Desistir"};
        final String TITULO = "Jornada";
        final Integer escolha = Imprimir.escolhaUmaOpcao(sc, TITULO, OPCOES);

        if (escolha == 2) {
            System.out.println("Você abandonou o Jogo!");
            return true;
        }

        return false;
    }

    public static Adversario adversario(Scanner sc, Jogador jogador) {
        final Adversarios[] adversarios = Arrays
                .stream(Adversarios.values())
                .filter(adversario -> adversario.getNivel() == jogador.getNivel())
                .toArray(Adversarios[]::new);

        final String[] adversariosNomes = Arrays
                .stream(adversarios)
                .map(Adversarios::toString)
                .toArray(String[]::new);

        final String TITULO = "ADVERSÁRIO";
        final String SUBTITULO = "Escolha um adversário";
        final int escolha = Imprimir.escolhaUmaOpcao(sc, TITULO, SUBTITULO, adversariosNomes);

        return Instanciar.adversario(adversarios[escolha - 1]);
    }

    public static Ataque ataque(Scanner sc, Pokemon pokemon) {
        final Ataque[] ataques = pokemon.getAtaques();
        final String[] ataquesNomes = Arrays
                .stream(ataques)
                .map(Ataque::toString)
                .toArray(String[]::new);


        final String TITULO = "ATACAR";
        final String SUBTITULO = "Escolha um ataque";
        final int escolha = Imprimir.escolhaUmaOpcao(sc, TITULO, SUBTITULO, ataquesNomes);
        final Ataque ataque = ataques[escolha - 1];

        System.out.printf("%s usou %s\n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    public static Ataque ataque(Pokemon pokemon) {
        final Ataque[] ataques = pokemon.getAtaques();
        final Ataque ataque = ataques[Escolher.aleatorio(0, ataques.length - 1)];

        System.out.printf("%s usou %s\n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    public static Jogador jogador(Scanner sc, Geracoes geracao) {
        System.out.print("Digite o seu nome: ");
        sc.nextLine();
        final String nome = sc.nextLine();
        Imprimir.limparConsole();

        return Instanciar.jogador(nome, geracao);
    }

    public static Geracoes geracao(Scanner sc) {
        final Geracoes[] geracoes = Geracoes.values();
        final String[] geracoesNomes = Arrays
                .stream(geracoes)
                .map(Geracoes::getNome)
                .toArray(String[]::new);

        final String TITULO = "GERAÇÃO";
        final String SUBTITULO = "Escolha uma geração";
        final int escolha = Imprimir.escolhaUmaOpcao(sc, TITULO, SUBTITULO, geracoesNomes);

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

        final String[] pokemonsNomes = indicePokemonsVivos
                .stream()
                .map(i -> pokemons[i].toString())
                .toArray(String[]::new);

        final String TITULO = "Escolher Pokemon";
        final String SUBTITULO = "Escolha um pokemon";
        final int escolha = Imprimir.escolhaUmaOpcao(sc, TITULO, SUBTITULO, pokemonsNomes);

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
        Imprimir.divisoriaEmbrulho(String.format("%s escolheu %s", treinador.getNome(), treinador.getPokemonAtual().getNome()));
    }

    public static void evoluirPokemon(Scanner sc, Jogador jogador) {
        final String TITULO = "Evoluir";
        final String SUBTITULO = "Você tem uma pedra de evolução!\nDeseja evoluir seu pokemon?";
        final String[] OPCOES = {"Sim", "Não"};
        final int escolha = Imprimir.escolhaUmaOpcao(sc, TITULO, SUBTITULO, OPCOES);

        switch (escolha) {
            case 1 -> evoluir(sc, jogador);
            case 2 -> {
            }
            default -> Imprimir.divisoriaEmbrulho("Opção inválida!");
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

        final String[] pokemonsNomes = indicePokemonsVivos
                .stream()
                .map(i -> pokemons[i].getNome())
                .toArray(String[]::new);


        final int escolhaPokemon = Imprimir.escolhaUmaOpcao(sc, "Escolha um pokemon", pokemonsNomes);
        final int indicePokemon = indicePokemonsVivos.get(escolhaPokemon - 1);

        final  Pokemon pokemon = pokemons[indicePokemon];

        final String pokemonNome = pokemon.getNome();
        final String evolucaoNome = pokemon.getEvolucao().getNome();
        final String mensagem = String.format("Seu pokemon %s evoluiu para %s!", pokemonNome, evolucaoNome);

        jogador.evoluirPokemon(indicePokemon);
        Imprimir.divisoriaEmbrulho(mensagem);
    }

    public static Integer aleatorio(int min, int max) {
        if (max == 0) {
            return 0;
        }

        return new Random().nextInt(max - min) + min;
    }
}
