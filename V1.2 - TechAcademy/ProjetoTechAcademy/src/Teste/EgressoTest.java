package Teste;

import Dominio.Egresso;
import Servico.EgressoSrv;

public class EgressoTest {

    private EgressoSrv srv;

    public void executar() {
        System.out.println("===== TESTE EGRESSO =====");

        System.out.println("\n--- 1) LISTAR (carga inicial) ---");
        this.listar();

        System.out.println("\n--- 2) BUSCAR código 102 ---");
        Egresso achado = this.srv.Buscar(102);
        achado.exibir();

        System.out.println("\n--- 3) INCLUIR ---");
        Egresso novo = new Egresso(0, "Patrícia Gomes", "11111111105", 2023, "Engenharia de Software", "Testes");
        Egresso incluido = this.srv.Incluir(novo);
        System.out.println("Código gerado: " + incluido.getCodigo());
        this.listar();

        System.out.println("\n--- 4) ALTERAR ---");
        incluido.setAreaAtuacao("Gestão de Projetos");
        this.srv.Alterar(incluido);
        this.srv.Buscar(incluido.getCodigo()).exibir();

        System.out.println("\n--- 5) EXCLUIR ---");
        Egresso apagado = this.srv.Excluir(incluido);
        System.out.println("Registro de código " + apagado.getCodigo() + " apagado com sucesso!");
        this.listar();

        System.out.println("\n--- 6) BUSCAR código inexistente (999) ---");
        System.out.println("Resultado: " + this.srv.Buscar(999));
    }

    private void listar() {
        for (Egresso item : this.srv.Listar()) {
            item.exibir();
            System.out.println("-----");
        }
    }

    public EgressoTest() {
        this.srv = new EgressoSrv();
    }

    public static void main(String[] args) {
        EgressoTest teste = new EgressoTest();
        teste.executar();
    }
}
