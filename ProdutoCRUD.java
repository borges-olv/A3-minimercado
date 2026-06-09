import java.util.ArrayList;

public class ProdutoCRUD {

    public static ArrayList<Produto> produtos =
            new ArrayList<>();

    public static boolean cadastrar(Produto produto) {

        if(buscar(produto.getCodigo()) != null){

            System.out.println(
                "Já existe um produto com esse código!"
            );

            return false;
        }

        produtos.add(produto);

        System.out.println(
            "Produto cadastrado com sucesso!"
        );

        return true;
    }

    public static void listar() {

        if(produtos.isEmpty()) {

            System.out.println(
                "Nenhum produto cadastrado."
            );

            return;
        }

        for(Produto p : produtos) {

            System.out.println(p);
        }
    }

    public static Produto buscar(int codigo) {

        for(Produto p : produtos) {

            if(p.getCodigo() == codigo) {

                return p;
            }
        }

        return null;
    }

    public static Produto buscarPorNome(String nome){

        for(Produto p : produtos){

            if(p.getNome().equalsIgnoreCase(nome)){

                return p;
            }
        }

        return null;
    }

    public static boolean remover(int codigo){

        Produto produto = buscar(codigo);

        if(produto == null){

            return false;
        }

        produtos.remove(produto);

        return true;
    }

    public static void atualizarEstoque(
            int codigo,
            int novoEstoque){

        Produto produto = buscar(codigo);

        if(produto != null){

            produto.setEstoque(novoEstoque);
        }
    }

    public static void alterarPreco(
            int codigo,
            double novoPreco){

        Produto produto = buscar(codigo);

        if(produto != null){

            produto.setPreco(novoPreco);
        }
    }
}