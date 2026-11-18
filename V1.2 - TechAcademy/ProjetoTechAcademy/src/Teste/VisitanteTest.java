package Teste;

import Dominio.Visitante;
import Servico.VisitanteSrv;

public class VisitanteTest {

    private VisitanteSrv srv;

    public void executar() {
        System.out.println("===== TESTE VISITANTE =====");

        System.out.println("\n--- 1) LISTAR (carga inicial) ---");
        this.listar();

        System.out.println("\n--- 2) BUSCAR código 102 ---");
        Visitante achado = this.srv.Buscar(102);
        achado.exibir();

        System.out.println("\n--- 3) INCLUIR ---");
        Visitante novo = new Visitante(0, "Renata Dias", "22222222204", "renata@email.com", "67999990004",
                "Rua Paraná, 5", "Entrevista", 4, "Recursos Humanos");
        Visitante incluido = this.srv.Incluir(novo);
        System.out.println("Código gerado: " + incluido.getCodigo());
        this.listar();

        System.out.println("\n--- 4) ALTERAR ---");
        incluido.setSetorVisita("Financeiro");
        incluido.setCrachaNumero(10);
        this.srv.Alterar(incluido);
        this.srv.Buscar(incluido.getCodigo()).exibir();

        System.out.println("\n--- 5) EXCLUIR ---");
        Visitante apagado = this.srv.Excluir(incluido);
        System.out.println("Registro de código " + apagado.getCodigo() + " apagado com sucesso!");
        this.listar();

        System.out.println("\n--- 6) BUSCAR código inexistente (999) ---");
        System.out.println("Resultado: " + this.srv.Buscar(999));
    }

    private void listar() {
        for (Visitante item : this.srv.Listar()) {
            item.exibir();
            System.out.println("-----");
        }
    }

    public VisitanteTest() {
        this.srv = new VisitanteSrv();
    }

    public static void main(String[] args) {
        VisitanteTest teste = new VisitanteTest();
        teste.executar();
    }
}
