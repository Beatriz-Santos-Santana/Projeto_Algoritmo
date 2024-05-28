
import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Login login = new Login();
        HashMap<String, SalaDeAula> salas = new HashMap<>();

        Secretaria sec = new Secretaria(login, salas);
        String senha;
        int escolha;
        boolean isProfessorLoggedIn = false;
        String professorUsuario = "";
        int op1;
        int op2;

        do {
            System.out.println("Olá, seja bem-vindo(a) ao nosso CADASTRO DE ALUNOS!\n"
                    + "Para começar, selecione o seu usuário: ");
            System.out.println("1- Admin \n2- Professor \n0- Sair");
            escolha = scan.nextInt();
            scan.nextLine(); // Consumir a nova linha pendente após o nextInt()

            if (escolha < 1 || escolha > 2) {
                System.out.println("Opção Inválida! Tente novamente:");
                System.out.println("");
                continue;
            }

            if (escolha == 1) {
                System.out.println("Digite sua senha: ");
                senha = scan.nextLine();
                if (senha.equals("admin12345")) {

                    do {
                        System.out.println("""
                                           1- Matricular Aluno
                                           2- Desmatricular Aluno
                                           3- Cadastrar Professor
                                           4- Excluir Professor
                                           5- Cadastrar Sala
                                           6- Listar Salas
                                           0- Sair""");
                        op1 = scan.nextInt();
                        scan.nextLine(); // Consumir a nova linha pendente após o nextInt()

                        if (op1 < 0 || op1 > 6) {
                            System.out.println("Opção Inválida! Tente novamente: ");
                            System.out.println("");
                            continue;
                        }

                        switch (op1) {
                            case 1 -> {
                                System.out.println("Informe o nome do aluno: ");
                                String nome = scan.nextLine();
                                System.out.println("CPF: ");
                                String cpf = scan.nextLine();
                                System.out.println("RG: ");
                                int rg = scan.nextInt();
                                scan.nextLine(); // Consumir a nova linha pendente após o nextInt()
                                System.out.println("Telefone:");
                                String telefone = scan.nextLine();

                                System.out.println("Escolha o curso:");
                                System.out.println("1. ADS");
                                System.out.println("2. Redes");
                                System.out.println("3. Engenharia");
                                System.out.println("4. Sistemas");
                                System.out.print("Escolha uma opção: ");
                                int cursoOpcao = scan.nextInt();
                                scan.nextLine(); // Consumir a nova linha pendente após o nextInt()
                                String curso = "";

                                switch (cursoOpcao) {
                                    case 1 ->
                                        curso = "ADS";
                                    case 2 ->
                                        curso = "Redes";
                                    case 3 ->
                                        curso = "Engenharia";
                                    case 4 ->
                                        curso = "Sistemas";
                                    default -> {
                                        System.out.println("Opção de curso inválida!");
                                        continue;
                                    }
                                }

                                SalaDeAula sala = salas.get(curso);
                                if (sala != null) {
                                    Aluno alu = new Aluno(nome, cpf, rg, telefone, curso, sala.nomeSala);
                                    if (sec.matricularAluno(alu)) {
                                        sala.adicionarAluno(alu);
                                        System.out.println("Aluno adicionado com sucesso à sala " + sala.nomeSala);
                                    }
                                } else {
                                    System.out.println("Não foi encontrada nenhuma sala para o curso selecionado.");
                                }
                                break;
                            }

                            case 2 -> {
                                // Desmatricular Aluno
                                System.out.println("Digite o CPF do aluno para desmatricular:");
                                String cpf = scan.nextLine();
                                sec.desmatricularAluno(cpf);
                                break;
                            }

                            case 3 -> {
                                System.out.println("Nome: ");
                                String nomeProf = scan.nextLine();
                                System.out.println("CPF: ");
                                String cpfProf = scan.nextLine();
                                System.out.println("RG: ");
                                int rgProf = scan.nextInt();
                                scan.nextLine(); // Consumir a nova linha pendente após o nextInt()
                                System.out.println("Matéria:");
                                String materiaProf = scan.nextLine();
                                System.out.println("Usuário:");
                                String usuario = scan.nextLine();
                                System.out.println("Senha: ");
                                String senhaProfessor = scan.nextLine();

                                Professor prof = new Professor(nomeProf, cpfProf, rgProf, materiaProf, usuario, senhaProfessor);
                                Administrador admin = new Administrador(usuario, senhaProfessor, cpfProf);

                                sec.adicionarProfessor(prof);
                                break;
                            }

                            case 4 -> {
                                System.out.println("Digite o CPF do professor: ");
                                String excProfessor = scan.nextLine();

                                Professor excProf = new Professor();
                                excProf.cpf = excProfessor;

                                sec.excluirProfessor(excProf);
                                System.out.println("Professor excluído");
                                break;
                            }

                            case 5 -> {
                                // Cadastrar sala
                                System.out.print("Digite o nome da sala para o curso ADS: ");
                                String salaADS = scan.nextLine();
                                salas.put("ADS", new SalaDeAula(salaADS));

                                System.out.print("Digite o nome da sala para o curso Redes: ");
                                String salaRedes = scan.nextLine();
                                salas.put("Redes", new SalaDeAula(salaRedes));

                                System.out.print("Digite o nome da sala para o curso Engenharia: ");
                                String salaEngenharia = scan.nextLine();
                                salas.put("Engenharia", new SalaDeAula(salaEngenharia));

                                System.out.print("Digite o nome da sala para o curso Sistemas: ");
                                String salaSistemas = scan.nextLine();
                                salas.put("Sistemas", new SalaDeAula(salaSistemas));
                                break;
                            }

                            case 6 -> {
                                // Listar alunos de uma sala
                                System.out.println("Escolha o curso para listar os alunos:");
                                System.out.println("1. ADS");
                                System.out.println("2. Redes");
                                System.out.println("3. Engenharia");
                                System.out.println("4. Sistemas");

                                int cursoOpcao = scan.nextInt();
                                scan.nextLine(); // Consumir a nova linha pendente após o nextInt()
                                String curso = "";

                                switch (cursoOpcao) {
                                    case 1 ->
                                        curso = "ADS";
                                    case 2 ->
                                        curso = "Redes";
                                    case 3 ->
                                        curso = "Engenharia";
                                    case 4 ->
                                        curso = "Sistemas";
                                    default -> {
                                        System.out.println("Opção de curso inválida!");
                                        continue;
                                    }
                                }

                                SalaDeAula sala = salas.get(curso);
                                if (sala != null) {
                                    System.out.println("Alunos da sala " + sala.getNomeSala() + ":");
                                    sala.listarAlunos();
                                } else {
                                    System.out.println("Não foi encontrada nenhuma sala para o curso selecionado.");
                                }
                                break;
                            }
                        }
                    } while (op1 != 0);

                } else {
                    System.out.println("Senha incorreta!");
                }

            } else if (escolha == 2) {
                System.out.println("Usuário: ");
                String usuario = scan.nextLine();
                System.out.println("Senha: ");
                String senhaUsuario = scan.nextLine();

                if (sec.verificarLoginProfessor(usuario, senhaUsuario)) {
                    isProfessorLoggedIn = true;
                    professorUsuario = usuario;
                    do {
                        System.out.println("""
                                           1- Verificar Aprovação
                                           2- Verificar Presença
                                           0- Sair""");
                        op2 = scan.nextInt();
                        scan.nextLine(); // Consumir a nova linha pendente após o nextInt()

                        if (op2 < 1 || op2 > 2) {
                            System.out.println("Opção Inválida! Tente novamente: ");
                            System.out.println("");
                            continue;
                        }

                        switch (op2) {
                            case 1 -> {
                                System.out.println("\nPreencha as seguintes informações:");

                                System.out.println("Nome do Aluno: ");
                                String nomeAluno = scan.nextLine();
                                System.out.println("Curso: ");
                                String curso = scan.nextLine();
                                System.out.println("Disciplina: ");
                                String disciplina = scan.nextLine();

                                System.out.println("Informe as três notas do aluno: ");
                                int not1 = scan.nextInt();
                                int not2 = scan.nextInt();
                                int not3 = scan.nextInt();

                                NotaAluno not = new NotaAluno(not1, not2, not3);
                                Execute_Prof exe = new Execute_Prof();
                                Resultado_Prof re = exe.verificarMed(not);

                                System.out.println("A média do aluno é= " + re.med);
                                System.out.println(re.sitMed);
                                System.out.println("");

                                break;
                            }

                            case 2 -> {
                                Execute_Prof exe = new Execute_Prof();
                                exe.verificarSit();
                                break;
                            }
                        }

                    } while (op2 != 0);
                } else {
                    System.out.println("Usuário ou senha inválidos");
                }
            }
        } while (escolha != 0);

        scan.close(); // Fechar o Scanner quando não for mais necessário
    }
}
