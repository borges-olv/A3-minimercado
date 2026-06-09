import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Compra {

    private Cliente cliente;
    private Produto produto;
    private int quantidade;
    private LocalDateTime dataCompra;

    public Compra(
            Cliente cliente,
            Produto produto,
            int quantidade) {

        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataCompra = LocalDateTime.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotal() {
        return produto.getPreco() * quantidade;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void imprimirCupom() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern(
                        "dd/MM/yyyy HH:mm:ss"
                );

        System.out.println(
                "\n=============================="
        );

        System.out.println(
                "      MINI MERCADO"
        );

        System.out.println(
                "=============================="
        );

        System.out.println(
                "Data: " +
                dataCompra.format(formato)
        );

        System.out.println(
                "Cliente: " +
                cliente.getNome()
        );

        System.out.println(
                "CPF: " +
                cliente.getCpf()
        );

        System.out.println(
                "Produto: " +
                produto.getNome()
        );

        System.out.println(
                "Preço Unitário: R$ " +
                String.format("%.2f",
                        produto.getPreco())
        );

        System.out.println(
                "Quantidade: " +
                quantidade
        );

        System.out.println(
                "TOTAL: R$ " +
                String.format("%.2f",
                        getTotal())
        );

        System.out.println(
                "=============================="
        );
    }
}