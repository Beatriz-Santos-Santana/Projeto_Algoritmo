
public class Professor {

    String nome;
    String cpf;
    int rg;
    String materia;
    String usuario;
    String senha;

    // Construtor padrão
    public Professor() {
    }

    // Construtor com parâmetros
    public Professor(String nome, String cpf, int rg, String materia, String usuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.materia = materia;
        this.usuario = usuario;
        this.senha = senha;
    }

    // Métodos getters
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }
}
