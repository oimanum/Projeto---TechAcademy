import java.util.Locale;
import java.util.Scanner;

import Dominio.Aluno;

public class MenuAluno {
    public void executar() {
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);

        System.out.println("--- CADASTRO DO ALUNO ---");

        System.out.println("Digite o código: ");
        int codigo = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite um nome:");
        String nome = scan.nextLine();

        System.out.println("Digite o CPF:");
        String cpf = scan.nextLine();

        System.out.println("Digite a Matrícula: ");
        String matricula = scan.nextLine();
        
        System.out.println("Digite a nota: ");
        Double nota = scan.nextDouble();

        Aluno a1 = new Aluno(codigo, nome, cpf, matricula);
        a1.setNota(nota);

        scan.close();

        a1.exibir();
    }
    
}
