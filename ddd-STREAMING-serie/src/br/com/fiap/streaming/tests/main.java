package br.com.fiap.streaming.tests;

import br.com.fiap.streaming.enums.ClassificacaoEnum;
import br.com.fiap.streaming.models.Episodio;
import br.com.fiap.streaming.models.Filme;
import br.com.fiap.streaming.models.Serie;
import br.com.fiap.streaming.models.Temporada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    static List<Serie> series = new ArrayList<>();
    static List<Filme>  filmes = new ArrayList<>();
    static Scanner sc     = new Scanner(System.in);

    public static void main(String[] args) {

        popularDados();

        int opcao;
        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║       SISTEMA DE STREAMING           ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1. Episódios por temporada           ║");
            System.out.println("║ 2. Séries ativas                     ║");
            System.out.println("║ 3. Qtd. de temporadas por série      ║");
            System.out.println("║ 4. Séries finalizadas                ║");
            System.out.println("║ 5. Ver temporadas de série finalizada║");
            System.out.println("║ 6. Melhores episódios de temporada   ║");
            System.out.println("║ 7. Filmes por ano de lançamento      ║");
            System.out.println("║ 8. Filmes filtrados por duração      ║");
            System.out.println("║ 0. Sair                              ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> exibirEpisodiosPorTemporada();
                case 2 -> exibirSeriesAtivas();
                case 3 -> exibirQtdTemporadasPorSerie();
                case 4 -> exibirSeriesFinalizadas();
                case 5 -> exibirTemporadasSerieFinalizadaSelecionada();
                case 6 -> exibirMelhoresEpisodiosDaTemporada();
                case 7 -> listarFilmesPorAno();
                case 8 -> listarFilmesPorDuracao();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    // ─── EX 1 ─────────────────────────────────────────────────────────────────
    static void exibirEpisodiosPorTemporada() {
        System.out.print("\nNome da série: ");
        sc.nextLine(); // limpar buffer
        String busca = sc.nextLine().toLowerCase();

        boolean encontrou = false;
        for (Serie s : series) {
            if (s.getNome().toLowerCase().contains(busca)) {
                s.exibirEpisodiosPorTemporada();
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Série não encontrada.");
    }

    // ─── EX 2 ─────────────────────────────────────────────────────────────────
    static void exibirSeriesAtivas() {
        System.out.println("\n=== SÉRIES ATIVAS ===");
        boolean achou = false;
        for (Serie s : series) {
            if (s.isAtiva()) {
                System.out.println("  • " + s);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhuma série ativa.");
    }

    // ─── EX 3 ─────────────────────────────────────────────────────────────────
    static void exibirQtdTemporadasPorSerie() {
        System.out.println("\n=== QUANTIDADE DE TEMPORADAS POR SÉRIE ===");
        for (Serie s : series) {
            s.exibirQuantidadeTemporadas();
        }
    }

    // ─── EX 4 ─────────────────────────────────────────────────────────────────
    static void exibirSeriesFinalizadas() {
        System.out.println("\n=== SÉRIES FINALIZADAS ===");
        boolean achou = false;
        for (Serie s : series) {
            if (!s.isAtiva()) {
                System.out.println("  • " + s);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhuma série finalizada.");
    }

    // ─── EX 5 ─────────────────────────────────────────────────────────────────
    static void exibirTemporadasSerieFinalizadaSelecionada() {
        // Lista as finalizadas numeradas
        List<Serie> finalizadas = new ArrayList<>();
        System.out.println("\n=== SÉRIES FINALIZADAS ===");
        int idx = 1;
        for (Serie s : series) {
            if (!s.isAtiva()) {
                System.out.println("  " + idx + ". " + s.getNome());
                finalizadas.add(s);
                idx++;
            }
        }
        if (finalizadas.isEmpty()) {
            System.out.println("Nenhuma série finalizada.");
            return;
        }
        System.out.print("Escolha o número da série: ");
        int escolha = sc.nextInt();
        if (escolha < 1 || escolha > finalizadas.size()) {
            System.out.println("Opção inválida.");
            return;
        }
        finalizadas.get(escolha - 1).exibirTodasTemporadasEEpisodios();
    }

    // ─── EX 6 ─────────────────────────────────────────────────────────────────
    static void exibirMelhoresEpisodiosDaTemporada() {
        System.out.print("\nNome da série: ");
        sc.nextLine();
        String busca = sc.nextLine().toLowerCase();

        Serie serieEscolhida = null;
        for (Serie s : series) {
            if (s.getNome().toLowerCase().contains(busca)) {
                serieEscolhida = s;
                break;
            }
        }
        if (serieEscolhida == null) {
            System.out.println("Série não encontrada.");
            return;
        }
        System.out.print("Número da temporada: ");
        int numTemp = sc.nextInt();
        serieEscolhida.exibirMelhoresEpisodios(numTemp);
    }

    // ─── EX 7 ─────────────────────────────────────────────────────────────────
    static void listarFilmesPorAno() {
        // Cópia do array para não alterar o original (selection sort decrescente)
        Filme[] arr = filmes.toArray(new Filme[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getAnoDeLancamento() > arr[maxIdx].getAnoDeLancamento()) {
                    maxIdx = j;
                }
            }
            Filme tmp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = tmp;
        }
        System.out.println("\n=== FILMES POR ANO (mais recente → mais antigo) ===");
        for (Filme f : arr) {
            System.out.println("  • " + f);
        }
    }

    // ─── EX 8 ─────────────────────────────────────────────────────────────────
    static void listarFilmesPorDuracao() {
        System.out.print("\nDuração máxima (minutos): ");
        int maxMin = sc.nextInt();
        System.out.print("Duração mínima (minutos): ");
        int minMin = sc.nextInt();

        System.out.println("\n=== FILMES ENTRE " + minMin + " e " + maxMin + " MINUTOS ===");
        boolean achou = false;
        for (Filme f : filmes) {
            if (f.getDuracaoEmMinutos() >= minMin && f.getDuracaoEmMinutos() <= maxMin) {
                System.out.println("  • " + f);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum filme encontrado com esse filtro.");
    }

    // ─── POPULAR DADOS DE TESTE ───────────────────────────────────────────────
    static void popularDados() {

        // --- Filmes ---
        Filme f1 = new Filme("O Poderoso Chefão", 1972, 175, ClassificacaoEnum.DEZESSEIS, "Francis Ford Coppola");
        Filme f2 = new Filme("Inception",          2010, 148, ClassificacaoEnum.QUATORZE,  "Christopher Nolan");
        Filme f3 = new Filme("Oppenheimer",        2023, 180, ClassificacaoEnum.QUATORZE,  "Christopher Nolan");
        Filme f4 = new Filme("Parasita",           2019, 132, ClassificacaoEnum.DEZESSEIS, "Bong Joon-ho");
        Filme f5 = new Filme("Clube da Luta",      1999,  139, ClassificacaoEnum.DEZOITO,  "David Fincher");
        f1.somarNotas(9.2); f2.somarNotas(8.8); f3.somarNotas(8.9);
        f4.somarNotas(8.6); f5.somarNotas(8.8);
        filmes.add(f1); filmes.add(f2); filmes.add(f3);
        filmes.add(f4); filmes.add(f5);

        // --- Série 1: Breaking Bad (finalizada) ---
        List<Episodio> epT1BB = List.of(
                new Episodio(1, "Piloto",               9.0, 5000000),
                new Episodio(2, "Gato no Saco",         8.7, 4800000),
                new Episodio(3, "E Daí?",               8.6, 4600000)
        );
        List<Episodio> epT2BB = List.of(
                new Episodio(1, "Falta de Oxigênio",    9.2, 6000000),
                new Episodio(2, "Quatro Dias Fora",     8.9, 5800000),
                new Episodio(3, "Abaixo do Mercado",    8.8, 5700000)
        );
        List<Temporada> tempBB = new ArrayList<>();
        tempBB.add(new Temporada(1, epT1BB));
        tempBB.add(new Temporada(2, epT2BB));
        Serie breakingBad = new Serie("Breaking Bad", 2008, 47,
                ClassificacaoEnum.DEZOITO, false, 13, 47, tempBB);
        series.add(breakingBad);

        // --- Série 2: Stranger Things (ativa) ---
        List<Episodio> epT1ST = List.of(
                new Episodio(1, "A Desaparição de Will", 8.9, 8000000),
                new Episodio(2, "A Baraka",               8.7, 7900000),
                new Episodio(3, "O Monstro",              8.8, 7800000)
        );
        List<Episodio> epT2ST = List.of(
                new Episodio(1, "Capítulo Um",    9.1, 9000000),
                new Episodio(2, "Capítulo Dois",  8.6, 8800000)
        );
        List<Temporada> tempST = new ArrayList<>();
        tempST.add(new Temporada(1, epT1ST));
        tempST.add(new Temporada(2, epT2ST));
        Serie strangerThings = new Serie("Stranger Things", 2016, 50,
                ClassificacaoEnum.QUATORZE, true, 9, 50, tempST);
        series.add(strangerThings);

        // --- Série 3: Game of Thrones (finalizada) ---
        List<Episodio> epT1GOT = List.of(
                new Episodio(1, "Winter Is Coming", 9.1, 10000000),
                new Episodio(2, "O Caminho Real",   8.6,  9500000)
        );
        List<Temporada> tempGOT = new ArrayList<>();
        tempGOT.add(new Temporada(1, epT1GOT));
        Serie got = new Serie("Game of Thrones", 2011, 57,
                ClassificacaoEnum.DEZOITO, false, 10, 57, tempGOT);
        series.add(got);



        System.out.println("==================================");
        for (Serie serie : series){
            System.out.println("serie: " + serie.getNome());
            for (Temporada temporada : serie.getTemporadas()) {
                System.out.println("temporada: " + temporada.getNumeroTemporada());
                for (Episodio episodio : temporada.getEpisodios()){
                    System.out.println("ep: " + episodio.getNumero() + " - " + episodio.getNome());
                }
            }
        }
        series.forEach(serie -> {
            System.out.println("serie: " + serie.getNome());
            serie.getTemporadas().forEach(temporada -> {
                System.out.println("temporada: " + temporada.getNumeroTemporada());
                temporada.getEpisodios().forEach(episodio -> {
                    System.out.println("ep: " + episodio.getNumero() + " - " + episodio.getNome());
                });
            });
        });


        System.out.println("==================================");
        for (Serie serie : series) {
            if (serie.isAtiva()) {
                System.out.println("serie ativa: " + serie.getNome());
            }
        }

        series.forEach(serie -> {
            if (serie.isAtiva()) {
                System.out.println("serie ativa: " + serie.getNome());
            }
        });

        System.out.println("==================================");
        for (Serie s : series) {
            System.out.println(s.getNome() + " tem " + s.getTemporadas().size() + "temporadas");
        }

        System.out.println("==================================");
        String serieescolhida = "coco 2";
        for (Serie s : series) {
            if (!s.isAtiva() && s.getNome().equalsIgnoreCase(serieescolhida)) {
                System.out.println("finalizada: " + s.getNome());
                for (Temporada temporada : s.getTemporadas()) {
                    System.out.println("temporada: " + s.getNumeroTemporada());
                    for (Episodio episodio : temporada.getEpisodios()) {
                        System.out.println("ep " + episodio.getNumero() + " - " + episodio.getNome());
                    }
                }} else {
                System.out.println("serie " + serieescolhida + "nao finaziou");
            }
        }
    }

}
