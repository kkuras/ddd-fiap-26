package prod;

import java.util.Scanner;

public class TesteProduto {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Produto produto = new Produto();

        System.out.println("Digite o nome do produto: ");
        produto.nome = leitor.nextLine();
        System.out.println("Digite o preço do produto: ");
        produto.preco = leitor.nextDouble();
        System.out.println("Digite a quantidade inicial de produto: ");
        produto.quantidade = leitor.nextInt();

        produto.adicionarEstoque(10);
        produto.adicionarEstoque(20);
        produto.removerEstoque(30);
        produto.removerEstoque(20);

        System.out.println(produto.mostrarDados());
    }
}
