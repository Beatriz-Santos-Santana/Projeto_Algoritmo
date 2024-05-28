
import java.util.ArrayList;

public class SalaDeAula {

    public String nomeSala;
    public ArrayList<Aluno> alunos;

    public SalaDeAula(String nomeSala) {
        this.nomeSala = nomeSala;
        this.alunos = new ArrayList<>();

    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(String cpf) {
        alunos.removeIf(a -> a.getCpf().equals(cpf));
    }

    public void listarAlunos() {
        System.out.println("Alunos da sala " + nomeSala + ":");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + " CPF: " + aluno.getCpf() + " RG: " + aluno.getRg() + " Telefone: " + aluno.getTelefone() + " Curso: " + aluno.getCurso() + " Sala: " + nomeSala);
            System.out.println(); // Adiciona uma linha em branco para separar os alunos
        }
    }

    public void removerProfessor(Professor professor) {
        // Lógica para remover o professor da lista de professores associados à sala
    }

    public String getNomeSala() {
        return nomeSala;
    }
}
