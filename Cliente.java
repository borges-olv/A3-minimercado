public class Cliente {

    private String cpf;
    private String nome;
    private String telefone;
    private String email;

    public Cliente(String cpf, String nome,
                   String telefone, String email) {

        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf +
               " | Nome: " + nome +
               " | Telefone: " + telefone +
               " | Email: " + email;
    }
}