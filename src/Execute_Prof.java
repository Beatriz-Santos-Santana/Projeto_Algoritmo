
import java.util.Scanner;

public class Execute_Prof {

    static Scanner ler = new Scanner(System.in);

    public Resultado_Prof verificarMed(NotaAluno nota) {
        Resultado_Prof resultado = new Resultado_Prof();

        resultado.med = (nota.not1 + nota.not2 + nota.not3) / 3;
        resultado.sitMed = resultado.med >= 6 ? "Aprovado" : "Reprovado";
        return resultado;
    }

    public void verificarSit() {

        System.out.println("Informe o nome do aluno: ");
        String nome = ler.next();
        System.out.println("Informe a quantidade de aulas que você ministrou: ");
        double qntaulas = ler.nextDouble();

        System.out.println("Agora, informe a quantidade de aulas que o aluno compareceu: ");
        double qntcom = ler.nextDouble();
        double cal = qntaulas * 0.7;
        if (cal <= qntcom) {
            System.out.println(nome + " consta como ativo!\n");
        } else if (qntcom == 0) {
            System.out.println(nome + " consta como inativo, faltando em todas as aulas. Por favor, entrar em contato com o aluno!\n");
        } else {
            System.out.println(nome + " consta como ativo, mas de DP por faltas. Por favor, entrar em contato com o aluno!\n");
        }
    }

}
