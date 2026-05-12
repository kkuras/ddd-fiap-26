package exs.ex2;

public class TesteExercicio {
    public static void main(String[] args) {
        Exercicio exercicio = new Exercicio();
        //classe (tipo) objeto = cria efetivamente objeto
        //instanciar um objeto = criar um objeto
        
        exercicio.nomeExer = "supino";
        exercicio.maquina = "anilha";
        exercicio.descricao = "te deixa forte";
        exercicio.series = 3;
        exercicio.repeticao = 15;
        exercicio.carga = 75;
        exercicio.dificuldade = "3 estrelas";

        exercicio.exibir();
        exercicio.exibirComRetorno();

        //System.out.println("Descrição");
        //System.out.println(exercicio.nomeExer + "\n" +
        //                  exercicio.maquina);
        //System.out.println(exercicio.descricao);
        //System.out.println(exercicio.carga);
        //System.out.println("Series: " + exercicio.series);
        //System.out.println("repetição: " + exercicio.repeticao);
        //System.out.println("carga: " + exercicio.carga);

    }
}
