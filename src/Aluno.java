public class Aluno {
    public String nome;
    public String cpf;
    public int rg;
    public String telefone;
    public String curso;
    public String nomeSala;
    String disciplina;

    public Aluno() {}

public Aluno(String nome, String cpf, int rg, String telefone, String curso, String nomeSala) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.curso = curso;
        this.nomeSala = nomeSala;
    }
public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCurso() {
        return curso;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public Aluno(String nome) {
        this.nome = nome;
    }


}