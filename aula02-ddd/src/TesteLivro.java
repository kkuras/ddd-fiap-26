public class TesteLivro {
    public static void main(String[] args) {
        // instanciar seria tudo apos o = do objeto
        Livro meuLivro = new Livro(); // linha para criar um objeto se tiver o new
        meuLivro.editora = "editora";
        meuLivro.nome = "harrypotter";
        meuLivro.pag = 15;
        Livro favorito = meuLivro;
        System.out.println(favorito);
        System.out.println(favorito.editora);

    }
}
