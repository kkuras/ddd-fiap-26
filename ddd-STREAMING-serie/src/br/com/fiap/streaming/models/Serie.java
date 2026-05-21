package br.com.fiap.streaming.models;

import br.com.fiap.streaming.enums.ClassificacaoEnum;

import java.util.List;

public class Serie extends Titulo{

    private int numeroTemporada;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
    private List<Temporada> temporadas;

    public Serie(String nome, int anoDeLancamento, int duracaoEmMinutos,
                 ClassificacaoEnum classificacaoIndicativa,
                 boolean ativa, int episodiosPorTemporada,
                 int minutosPorEpisodio, List<Temporada> temporadas) {
        super(nome, anoDeLancamento, duracaoEmMinutos, classificacaoIndicativa);
        this.ativa = ativa;
        this.episodiosPorTemporada = episodiosPorTemporada;
        this.minutosPorEpisodio = minutosPorEpisodio;
        this.temporadas = temporadas;
        this.numeroTemporada = temporadas.size();
    }

    public void exibirEpisodiosPorTemporada() {
        System.out.println("\n=== EPISÓDIOS POR TEMPORADA: " + getNome()     + " ===");
        for (Temporada t : temporadas) {
            System.out.println("\n" + t);
            for (Episodio e : t.getEpisodios()) {
                System.out.println(e);
            }
        }
    }

    public void exibirQuantidadeTemporadas() {
        System.out.println(getNome() + " → " + temporadas.size() + " temporada(s)");
    }

    public void exibirTodasTemporadasEEpisodios() {
        System.out.println("\n=== SÉRIE FINALIZADA: " + getNome() + " ===");
        for (Temporada t : temporadas) {
            System.out.println("\n  " + t);
            for (Episodio e : t.getEpisodios()) {
                System.out.println("  " + e);
            }
        }
    }

    public void exibirMelhoresEpisodios(int numTemporada) {
        Temporada temporadaEscolhida = null;
        for (Temporada t : temporadas) {
            if (t.getNumeroTemporada() == numTemporada) {
                temporadaEscolhida = t;
                break;
            }
        }
        if (temporadaEscolhida == null) {
            System.out.println("Temporada " + numTemporada + " não encontrada em " + getNome());
            return;
        }

        // Ordenação manual por avaliação (selection sort — sem Collections)
        List<Episodio> lista = temporadaEscolhida.getEpisodios();
        Episodio[] arr = lista.toArray(new Episodio[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getAvaliacao() > arr[maxIdx].getAvaliacao()) {
                    maxIdx = j;
                }
            }
            Episodio tmp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = tmp;
        }

        System.out.println("\n=== MELHORES EPISÓDIOS — " + getNome()
                + " | Temporada " + numTemporada + " ===");
        for (Episodio e : arr) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return getNome() + " | Temporadas: " + temporadas.size()
                + " | Status: " + (ativa ? "Ativa" : "Finalizada");
    }

    @Override
    public void exibirFichaTecnica() {
        System.out.println("=== SÉRIE ===");
        super.exibirFichaTecnica();
        System.out.println("Temporadas: " + temporadas.size());
        System.out.println("Status: " + (ativa ? "Em andamento" : "Finalizada"));
    }

    public boolean isAtiva() {
        return ativa;
    }
    public int getNumeroTemporada() {
        return numeroTemporada;
    }
    public List<Temporada> getTemporadas() {
        return temporadas;
    }
    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }
    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    @Override
    public ClassificacaoEnum getClassificacaoIndicativa() {
        return super.getClassificacaoIndicativa();
    }

    public void somarNotas(double nota) {

    }
}
