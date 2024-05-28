
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Secretaria {

    private Login login;
    private HashMap<String, SalaDeAula> salas;
    private List<Aluno> alunosMatriculados;
    private List<Professor> professores;

    public Secretaria(Login login, HashMap<String, SalaDeAula> salas) {
        this.login = login;
        this.salas = salas;
        this.alunosMatriculados = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    public boolean matricularAluno(Aluno aluno) {
        // Lógica para matricular aluno
        alunosMatriculados.add(aluno);
        return true; // ou false dependendo da lógica de matrícula
    }

    public void desmatricularAluno(String cpf) {
        // Remover o aluno da lista de matriculados em todas as salas
        for (SalaDeAula sala : salas.values()) {
            sala.removerAluno(cpf);
        }
        // Remover o aluno da lista de alunos matriculados no sistema
        alunosMatriculados.removeIf(a -> a.getCpf().equals(cpf));
    }

    public void excluirProfessor(Professor professor) {
        // Lógica para excluir professor
        professores.removeIf(p -> p.getCpf().equals(professor.getCpf()));
    }

    public void adicionarProfessor(Professor professor) {
        // Adicione o professor à lista de professores da secretaria
        professores.add(professor);
    }

    public boolean verificarLoginProfessor(String usuario, String senha) {
        // Lógica para verificar o login do professor
        // Retorna true se o login for bem-sucedido, false caso contrário
        // Aqui você pode verificar se o usuário e a senha correspondem a algum professor registrado
        // Por exemplo, você pode percorrer a lista de professores e verificar se algum deles tem o mesmo usuário e senha
        for (Professor professor : professores) {
            if (professor.getUsuario().equals(usuario) && professor.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
