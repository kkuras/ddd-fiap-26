package exs.ex2;

public class Exercicio {

    String nomeExer;
    String maquina;
    String descricao;
    int series;
    int repeticao;
    int carga;
    String dificuldade;

    // metodo => açoes
    //escrevo um trecho de codigo esse metodo pode ser usado varias vezes
    //public => metodo publico
    //void => um tipo vazio | metodo sem retorno
    //nome do metodo: começa com letra minuscula usa padrao camelcase, nao pode conter carac especiais

    public void exibir() {
        System.out.println("Descrição");
        System.out.println(nomeExer + "\n" +
                maquina);
        System.out.println(descricao);
        System.out.println("Series: " + series);
        System.out.println("repetição: " + repeticao);
        System.out.println("carga: " + carga);
    }

    //metodo com retorno
    //public TIPO_RETORNO nomeMetodo(){}
    //sempre devemos retornar o tipo solicitado e usamos a palavra return valor/variavel
    public String exibirComRetorno() {
        String mensagem = "\nDescrição do exercicio\n" + nomeExer + "\n" +
                maquina + "\n" + descricao + "\n" + "Series: " + series + "\n" + "repetição: " + repeticao;

        return mensagem;
    }
}
