import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        carregarProdutos();

        int opcao;

        do {

            System.out.println("\n========== MINI MERCADO ==========");
            System.out.println("1 - Produtos");
            System.out.println("2 - Clientes");
            System.out.println("3 - Realizar Compra");
            System.out.println("4 - Controle de Estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch(opcao){

                case 1:
                    menuProdutos();
                    break;

                case 2:
                    menuClientes();
                    break;

                case 3:
                    realizarCompra();
                    break;

                case 4:
                    menuEstoque();
                    break;

                case 0:
                    ArquivoCSV.salvarProdutos();
                    ArquivoCSV.salvarClientes();
                    System.out.println("Dados salvos!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);
    }

    public static void menuProdutos(){

        int op;

        do{

            System.out.println("\n===== PRODUTOS =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por Código");
            System.out.println("0 - Voltar");

            op = sc.nextInt();
            sc.nextLine();

            switch(op){

                case 1:

                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    System.out.print("Estoque: ");
                    int estoque = sc.nextInt();

                    ProdutoCRUD.cadastrar(
                            new Produto(
                                    codigo,
                                    nome,
                                    preco,
                                    estoque
                            )
                    );

                    break;

                case 2:

                    ProdutoCRUD.listar();

                    break;

                case 3:

                    System.out.print("Código: ");
                    int codBusca = sc.nextInt();

                    Produto produto =
                            ProdutoCRUD.buscar(codBusca);

                    if(produto != null){

                        System.out.println(produto);

                    }else{

                        System.out.println(
                                "Produto não encontrado."
                        );
                    }

                    break;
            }

        } while(op != 0);
    }

    public static void menuClientes(){

        int op;

        do{

            System.out.println("\n===== CLIENTES =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por CPF");
            System.out.println("0 - Voltar");

            op = sc.nextInt();
            sc.nextLine();

            switch(op){

                case 1:

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    ClienteCRUD.cadastrar(
                            new Cliente(
                                    cpf,
                                    nome,
                                    telefone,
                                    email
                            )
                    );

                    break;

                case 2:

                    ClienteCRUD.listar();

                    break;

                case 3:

                    System.out.print("CPF: ");
                    String cpfBusca = sc.nextLine();

                    Cliente cliente =
                            ClienteCRUD.buscar(cpfBusca);

                    if(cliente != null){

                        System.out.println(cliente);

                    }else{

                        System.out.println(
                                "Cliente não encontrado."
                        );
                    }

                    break;
            }

        } while(op != 0);
    }

    public static void menuEstoque(){

        int op;

        do{

            System.out.println("\n===== ESTOQUE =====");
            System.out.println("1 - Listar Produtos");
            System.out.println("2 - Atualizar Estoque");
            System.out.println("0 - Voltar");

            op = sc.nextInt();

            switch(op){

                case 1:

                    ProdutoCRUD.listar();

                    break;

                case 2:

                    System.out.print(
                            "Código do Produto: "
                    );

                    int codigo =
                            sc.nextInt();

                    Produto produto =
                            ProdutoCRUD.buscar(
                                    codigo
                            );

                    if(produto == null){

                        System.out.println(
                                "Produto não encontrado."
                        );

                        break;
                    }

                    System.out.print(
                            "Novo estoque: "
                    );

                    int novoEstoque =
                            sc.nextInt();

                    produto.setEstoque(
                            novoEstoque
                    );

                    System.out.println(
                            "Estoque atualizado!"
                    );

                    break;
            }

        } while(op != 0);
    }

    public static void realizarCompra(){

        System.out.print(
                "CPF do cliente: "
        );

        String cpf =
                sc.next();

        Cliente cliente =
                ClienteCRUD.buscar(cpf);

        if(cliente == null){

            System.out.println(
                    "Cliente não encontrado!"
            );

            return;
        }

        ProdutoCRUD.listar();

        System.out.print(
                "\nCódigo do produto: "
        );

        int codigo =
                sc.nextInt();

        Produto produto =
                ProdutoCRUD.buscar(codigo);

        if(produto == null){

            System.out.println(
                    "Produto não encontrado!"
            );

            return;
        }

        System.out.print(
                "Quantidade: "
        );

        int quantidade =
                sc.nextInt();

        if(quantidade >
                produto.getEstoque()){

            System.out.println(
                    "Estoque insuficiente!"
            );

            return;
        }

        produto.setEstoque(
                produto.getEstoque()
                        - quantidade
        );

        Compra compra =
                new Compra(
                        cliente,
                        produto,
                        quantidade
                );

        compra.imprimirCupom();
    }

    public static void carregarProdutos(){

        ProdutoCRUD.cadastrar(new Produto(1,"Arroz Tio João 5kg",42.90,50));
        ProdutoCRUD.cadastrar(new Produto(2,"Feijão Carioca 1kg",9.99,80));
        ProdutoCRUD.cadastrar(new Produto(3,"Leite Integral 1L",6.49,100));
        ProdutoCRUD.cadastrar(new Produto(4,"Coca-Cola 2L",12.99,70));
        ProdutoCRUD.cadastrar(new Produto(5,"Café Pilão 500g",24.90,40));
        ProdutoCRUD.cadastrar(new Produto(6,"Açúcar Refinado 1kg",5.49,100));
        ProdutoCRUD.cadastrar(new Produto(7,"Óleo de Soja 900ml",8.99,80));
        ProdutoCRUD.cadastrar(new Produto(8,"Macarrão Espaguete 500g",4.99,120));
        ProdutoCRUD.cadastrar(new Produto(9,"Molho de Tomate 340g",2.99,100));
        ProdutoCRUD.cadastrar(new Produto(10,"Farinha de Trigo 1kg",6.99,70));
        ProdutoCRUD.cadastrar(new Produto(11,"Sal Refinado 1kg",2.49,90));
        ProdutoCRUD.cadastrar(new Produto(12,"Achocolatado Nescau 370g",8.99,60));
        ProdutoCRUD.cadastrar(new Produto(13,"Biscoito Oreo",4.49,80));
        ProdutoCRUD.cadastrar(new Produto(14,"Sabonete Dove",3.99,100));
        ProdutoCRUD.cadastrar(new Produto(15,"Detergente Ypê",2.99,120));
        ProdutoCRUD.cadastrar(new Produto(16,"Desinfetante Pinho Sol 1L",11.99,50));
        ProdutoCRUD.cadastrar(new Produto(17,"Papel Higiênico 12 Rolos",21.90,40));
        ProdutoCRUD.cadastrar(new Produto(18,"Shampoo Seda",12.90,60));
        ProdutoCRUD.cadastrar(new Produto(19,"Condicionador Seda",13.90,60));
        ProdutoCRUD.cadastrar(new Produto(20,"Creme Dental Colgate",4.99,120));
        ProdutoCRUD.cadastrar(new Produto(21,"Água Mineral 1,5L",3.49,200));
        ProdutoCRUD.cadastrar(new Produto(22,"Suco Del Valle 1L",8.99,70));
        ProdutoCRUD.cadastrar(new Produto(23,"Guaraná Antarctica 2L",11.99,80));
        ProdutoCRUD.cadastrar(new Produto(24,"Margarina Qualy 500g",9.49,50));
        ProdutoCRUD.cadastrar(new Produto(25,"Manteiga Aviação 200g",12.99,40));
        ProdutoCRUD.cadastrar(new Produto(26,"Queijo Mussarela 500g",24.90,30));
        ProdutoCRUD.cadastrar(new Produto(27,"Presunto Cozido 500g",18.90,30));
        ProdutoCRUD.cadastrar(new Produto(28,"Peito de Frango 1kg",19.99,40));
        ProdutoCRUD.cadastrar(new Produto(29,"Carne Moída 1kg",34.90,25));
        ProdutoCRUD.cadastrar(new Produto(30,"Banana Prata 1kg",6.99,60));
    }
}