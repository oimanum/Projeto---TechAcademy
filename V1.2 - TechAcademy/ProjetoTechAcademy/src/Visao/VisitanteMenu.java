package Visao;

import java.util.Scanner;

import Dominio.Visitante;
import Servico.VisitanteSrv;

public class VisitanteMenu extends AbsMenu {

    private VisitanteSrv servico;

    public void executar() {
        int opcao = 0;
        while (opcao != 6) {
            opcao = this.exibirOpcoes();
            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    this.listarTodos();
                    break;
                case 3:
                    this.buscarPorCodigo();
                    break;
                case 4:
                    this.editar();
                    break;
                case 5:
                    this.excluir();
                    break;
                case 6:
                    System.out.println("Encerrando o menu de visitantes...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    // O menu do enunciado tem opções diferentes do AbsMenu, por isso tem o seu próprio método
    private int exibirOpcoes() {
        System.out.println("\n---- Menu [VISITANTE] ----");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar Todos");
        System.out.println("3 - Buscar por Código");
        System.out.println("4 - Editar");
        System.out.println("5 - Excluir");
        System.out.println("6 - Sair");
        System.out.print("Selecione uma opção: ");
        return this.lerInteiro();
    }

    private void cadastrar() {
        System.out.println("\n***** CADASTRAR VISITANTE *****");
        Visitante novo = new Visitante();
        this.lerDados(novo);
        Visitante incluido = this.servico.Incluir(novo);
        System.out.println("Visitante cadastrado com o código " + incluido.getCodigo() + "!");
    }

    private void listarTodos() {
        System.out.println("\n***** LISTAR VISITANTES *****");
        for (Visitante item : this.servico.Listar()) {
            item.exibir();
            System.out.println("-----");
        }
    }

    private void buscarPorCodigo() {
        System.out.println("\n***** BUSCAR VISITANTE POR CÓDIGO *****");
        System.out.print("Informe o código: ");
        int codigo = this.lerInteiro();
        Visitante achado = this.servico.Buscar(codigo);
        if (achado == null) {
            System.out.println("Visitante não encontrado!");
        } else {
            achado.exibir();
        }
    }

    private void editar() {
        System.out.println("\n***** EDITAR VISITANTE *****");
        System.out.print("Informe o código: ");
        int codigo = this.lerInteiro();
        Visitante achado = this.servico.Buscar(codigo);
        if (achado == null) {
            System.out.println("Visitante não encontrado!");
            return;
        }
        System.out.println("Dados atuais:");
        achado.exibir();
        System.out.println("\nInforme os novos dados:");
        this.lerDados(achado);
        this.servico.Alterar(achado);
        System.out.println("Visitante alterado com sucesso!");
    }

    private void excluir() {
        System.out.println("\n***** EXCLUIR VISITANTE *****");
        System.out.print("Informe o código: ");
        int codigo = this.lerInteiro();
        Visitante achado = this.servico.Buscar(codigo);
        if (achado == null) {
            System.out.println("Visitante não encontrado!");
            return;
        }
        achado.exibir();
        System.out.print("Deseja realmente excluir? (S/N): ");
        String resposta = this.scan.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            this.servico.Excluir(achado);
            System.out.println("Registro de código " + codigo + " apagado com sucesso!");
        } else {
            System.out.println("Exclusão cancelada.");
        }
    }

    // Pede pelo teclado os dados do visitante e guarda no objeto recebido
    private void lerDados(Visitante v) {
        System.out.print("Nome: ");
        v.setNome(this.scan.nextLine());
        System.out.print("CPF: ");
        v.setCpf(this.scan.nextLine());
        System.out.print("E-mail: ");
        v.setEmail(this.scan.nextLine());
        System.out.print("Telefone: ");
        v.setTelefone(this.scan.nextLine());
        System.out.print("Endereço: ");
        v.setEndereco(this.scan.nextLine());
        System.out.print("Motivo da visita: ");
        v.setMotivoVisita(this.scan.nextLine());
        System.out.print("Número do crachá: ");
        v.setCrachaNumero(this.lerInteiro());
        System.out.print("Setor da visita: ");
        v.setSetorVisita(this.scan.nextLine());
    }

    public VisitanteMenu() {
        this.scan = new Scanner(System.in);
        this.servico = new VisitanteSrv();
    }
}
