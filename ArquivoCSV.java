import java.io.FileWriter;
import java.io.IOException;

public class ArquivoCSV {

    public static void salvarProdutos() {

        try {

            FileWriter fw =
                    new FileWriter("produtos.csv");

            for(Produto p :
                    ProdutoCRUD.produtos){

                fw.write(
                        p.getCodigo() + ";" +
                        p.getNome() + ";" +
                        p.getPreco() + ";" +
                        p.getEstoque() + "\n"
                );
            }

            fw.close();

            System.out.println(
                    "Produtos salvos com sucesso!"
            );

        } catch(IOException e){

            System.out.println(
                    "Erro ao salvar produtos."
            );
        }
    }

    public static void salvarClientes() {

        try {

            FileWriter fw =
                    new FileWriter("clientes.csv");

            for(Cliente c :
                    ClienteCRUD.clientes){

                fw.write(
                        c.getCpf() + ";" +
                        c.getNome() + ";" +
                        c.getTelefone() + ";" +
                        c.getEmail() + "\n"
                );
            }

            fw.close();

            System.out.println(
                    "Clientes salvos com sucesso!"
            );

        } catch(IOException e){

            System.out.println(
                    "Erro ao salvar clientes."
            );
        }
    }
}