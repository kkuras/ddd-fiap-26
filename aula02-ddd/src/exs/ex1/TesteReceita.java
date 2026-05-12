package exs.ex1;

public class TesteReceita {
    public static void main(String[] args) {
        Receita boloMilho = new Receita();
        boloMilho.nomeReceita = "Bolo de Milho";
        boloMilho.autor = "Vanessa";
        boloMilho.custo = "Custo Baixo";
        boloMilho.tempoPreparo = 50;
        boloMilho.dificuldade = "Muito Facil";
        boloMilho.quantidade = 10;
        boloMilho.nota = 5;
        boloMilho.descricao = "Recita 10/10 amo ela <3";

        System.out.println(boloMilho.nomeReceita);
        System.out.println(boloMilho.autor);
        System.out.println(boloMilho.descricao);
        System.out.println(boloMilho.tempoPreparo + "min" + "\t\t" +
                boloMilho.custo + "\t\t" +
                boloMilho.quantidade + "\t\t" +
                boloMilho.dificuldade);

    }
}
