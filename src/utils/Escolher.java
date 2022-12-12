package utils;

import models.Jogador;
import data.Adversarios;
import models.Adversario;
import models.Ataque;
import models.Pokemon;
import models.Treinador;

import java.util.*;

public class Escolher {

    public static void pokemonReviver(Scanner sc, Jogador jogador) {
        if (!jogador.temPokemonMorto()) {
            throw new RuntimeException("O treinador não tem pokemons mortos");
        }
        Pokemon[] pokemons = jogador.getPokemons();
        List<Integer> indicePokemonsMortos = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (pokemons[i].estaMorto()) {
                indicePokemonsMortos.add(i);
            }
        }
        String[] pokemonsNomes = indicePokemonsMortos.stream().map(i -> pokemons[i].getNome()).toArray(String[]::new);

        int escolhaPokemon = Criar.escolhaUmaOpcao(sc, "Escolha um pokemon para reviver", pokemonsNomes);
        int indicePokemon = indicePokemonsMortos.get(escolhaPokemon - 1);

        jogador.usarRevive(indicePokemon);

        Pokemon pokemon = pokemons[indicePokemon];
        String pokemonNome = pokemon.getNome();
        Integer pokemonVida = pokemon.getVida();
        String mensagem = String.format("Seu pokemon %s reviveu e está com %d de vida!", pokemonNome, pokemonVida);

        Criar.divisoriaEmbrulho(mensagem);
    }

    public static Adversario adversario(Scanner sc, int nivel) {
        Adversarios[] adversarios = Adversarios.values();

        List<Adversarios> adversariosList = new ArrayList<>();
        for (Adversarios adversario : adversarios) {
            if (adversario.getNivel() == nivel) {
                adversariosList.add(adversario);
            }
        }

        String[] adversariosNomes = adversariosList.stream().map(Adversarios::toString).toArray(String[]::new);

        int escolha = Criar.escolhaUmaOpcao(sc, "ADVERSÁRIO", "Escolha um adversário:", adversariosNomes);

        Adversarios adversario = adversariosList.get(escolha - 1);
        return Instanciar.adversario(adversario);
    }

    public static Ataque ataque(Scanner sc, Pokemon pokemon) {
        Ataque[] ataques = pokemon.getAtaques();
        String[] ataquesNomes = Arrays.stream(ataques).map(Ataque::toString).toArray(String[]::new);

        int escolha = Criar.escolhaUmaOpcao(sc, "ATACAR", "Escolha um ataque", ataquesNomes);
        Ataque ataque = ataques[escolha - 1];

        System.out.printf("%s usou %s\n", pokemon.getNome(), ataque.getNome());

        return ataque;
    }

    public static Ataque ataque(Pokemon pokemon) {
        Ataque[] ataques = pokemon.getAtaques();
        Ataque ataque = ataques[Escolher.aleatorio(0, ataques.length - 1)];

        System.out.printf("%s usou %s\n", pokemon.getNome(), ataque.getNome());
        return ataque;
    }

    public static Jogador jogador(Scanner sc) {
        System.out.print("Digite o seu nome: ");
        sc.nextLine();
        String nome = sc.nextLine();
        Console.limpar();
        return new Jogador(nome);
    }

    public static void pokemon(Scanner sc, Treinador treinador) {
        if (treinador.estaMorto()) {
            return;
        }

        Pokemon[] pokemons = treinador.getPokemons();

        List<Integer> indicePokemonsVivos = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (!pokemons[i].estaMorto()) {
                indicePokemonsVivos.add(i);
            }
        }

        String[] pokemonsNomes = indicePokemonsVivos.stream().map(i -> pokemons[i].toString()).toArray(String[]::new);

        int escolha = Criar.escolhaUmaOpcao(sc, "Escolher Pokemon","Escolha um pokemon",  pokemonsNomes);

        int indice = indicePokemonsVivos.get(escolha - 1);

        treinador.definirPokemonBatalha(indice);
    }

    public static void pokemon(Treinador treinador) {
        if (treinador.estaMorto()) {
            return;
        }

        Pokemon[] pokemons = treinador.getPokemons();
        List<Integer> indicePokemonsVivos = new ArrayList<>();

        for (int i = 0; i < pokemons.length; i++) {
            if (!pokemons[i].estaMorto()) {
                indicePokemonsVivos.add(i);
            }
        }

        int indice = aleatorio(0, indicePokemonsVivos.size() - 1);

        treinador.definirPokemonBatalha(indicePokemonsVivos.get(indice));
        Criar.divisoriaEmbrulho(String.format("%s escolheu %s", treinador.getNome(), treinador.getPokemonAtual().getNome()));
    }

    public static void evoluirPokemon(Scanner sc, Jogador jogador) {
        String subtitulo = "Você tem uma pedra de evolução!\nDeseja evoluir seu pokemon?";
        int escolha = Criar.escolhaUmaOpcao(sc, "Evoluir", subtitulo, new String[]{"Sim", "Não"});

        switch (escolha) {
            case 1 -> {
                Pokemon[] pokemons = jogador.getPokemons();
                List<Integer> indicePokemonsVivos = new ArrayList<>();

                for (int i = 0; i < pokemons.length; i++) {
                    if (pokemons[i].getEvolucao() != null) {
                        indicePokemonsVivos.add(i);
                    }
                }
                String[] pokemonsNomes = indicePokemonsVivos.stream().map(i -> pokemons[i].getNome()).toArray(String[]::new);

                int escolhaPokemon = Criar.escolhaUmaOpcao(sc, "Escolha um pokemon", pokemonsNomes);
                int indicePokemon = indicePokemonsVivos.get(escolhaPokemon - 1);

                Pokemon pokemon = pokemons[indicePokemon];

                String pokemonNome = pokemon.getNome();
                String evolucaoNome = pokemon.getEvolucao().getNome();
                String mensagem = String.format("Seu pokemon %s evoluiu para %s!", pokemonNome, evolucaoNome);

                jogador.evoluirPokemon(indicePokemon);
                Criar.divisoriaEmbrulho(mensagem);
            }
            case 2 -> {
            }
            default -> Criar.divisoriaEmbrulho("Opção inválida!");
        }
    }

    public static Integer aleatorio(int min, int max) {
        if (max == 0) {
            return 0;
        }

        return new Random().nextInt(max - min) + min;
    }
}