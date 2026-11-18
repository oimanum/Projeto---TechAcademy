package Teste;

import Dominio.Estagiario;
import Servico.EstagiarioSrv;

public class EstagiarioTest {

    private EstagiarioSrv srv;

    public void executar() {
        System.out.println("===== TESTE ESTAGIÁRIO =====");

        System.out.println("\n--- 1) LISTAR (carga inicial) ---");
        this.listar();

        System.out.println("\n--- 2) BUSCAR código 102 ---");
        Estagiario achado = this.srv.Buscar(102);
        achado.exibir();

        System.out.println("\n--- 3) INCLUIR ---");
        Estagiario novo = new Estagiario(0, "Diego Farias", "33333333304", "diego@email.com", "67988880004",
                "Rua Mato Grosso, 8", 1250.00, 30, "Redes");
        Estagiario incluido = this.srv.Incluir(novo);
        System.out.println("Código gerado: " + incluido.getCodigo());
        this.listar();

        System.out.println("\n--- 4) ALTERAR ---");
        incluido.setValorBolsa(1500.00);
        incluido.setAreaEstagio("Infraestrutura");
        this.srv.Alterar(incluido);
        this.srv.Buscar(incluido.getCodigo()).exibir();

        System.out.println("\n--- 5) EXCLUIR ---");
        Estagiario apagado = this.srv.Excluir(incluido);
        System.out.println("Registro de código " + apagado.getCodigo() + " apagado com sucesso!");
        this.listar();

        System.out.println("\n--- 6) BUSCAR código inexistente (999) ---");
        System.out.println("Resultado: " + this.srv.Buscar(999));
    }

    private void listar() {
        for (Estagiario item : this.srv.Listar()) {
            item.exibir();
            System.out.println("-----");
        }
    }

    public EstagiarioTest() {
        this.srv = new EstagiarioSrv();
    }

    public static void main(String[] args) {
        EstagiarioTest teste = new EstagiarioTest();
        teste.executar();
    }
}
