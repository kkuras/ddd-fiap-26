package prod;

public class Produto {
    String nome;
    double preco;
    int quantidade;

    public void adicionarEstoque(int quant) {
        quantidade = quantidade + quant;
    }
    public void removerEstoque(int qtd) {
        if (qtd <= quantidade) {
            quantidade -= qtd;
        } else {
            System.out.println("Nao foi possivel remover do estoque");
        }
    }
    public String mostrarDados() {
        return "Produto: " + nome + " | Preço: " + preco + " | Quantidade: " + quantidade;
    }
}
