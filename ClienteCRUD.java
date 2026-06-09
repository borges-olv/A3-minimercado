import java.util.ArrayList;

public class ClienteCRUD {

    public static ArrayList<Cliente> clientes =
            new ArrayList<>();

    public static boolean cadastrar(Cliente cliente) {

        if(buscar(cliente.getCpf()) != null){

            System.out.println(
                "Já existe um cliente com esse CPF!"
            );

            return false;
        }

        clientes.add(cliente);

        System.out.println(
            "Cliente cadastrado com sucesso!"
        );

        return true;
    }

    public static void listar() {

        if(clientes.isEmpty()) {

            System.out.println(
                "Nenhum cliente cadastrado."
            );

            return;
        }

        for(Cliente c : clientes) {

            System.out.println(c);
        }
    }

    public static Cliente buscar(String cpf) {

        for(Cliente c : clientes) {

            if(c.getCpf().equals(cpf)) {

                return c;
            }
        }

        return null;
    }

    public static boolean remover(String cpf){

        Cliente cliente = buscar(cpf);

        if(cliente == null){

            return false;
        }

        clientes.remove(cliente);

        return true;
    }

    public static Cliente buscarPorNome(String nome){

        for(Cliente c : clientes){

            if(c.getNome().equalsIgnoreCase(nome)){

                return c;
            }
        }

        return null;
    }
}