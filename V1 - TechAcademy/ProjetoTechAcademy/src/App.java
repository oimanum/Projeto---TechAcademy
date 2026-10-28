import Dominio.*;
import DAO.*;

public class App {
    public static void main(String[] args) throws Exception {
        ColaboradorDAO dao = new ColaboradorDAO();

        System.out.println("--- ANTES: ---");
        for(Colaborador item : dao.browse()) {
            item.exibir();
        }

        Colaborador colab = new Colaborador(106, "Lula", "133333333300", "Presidente da República");
        Colaborador novo = dao.Add(colab);

        System.out.println();
        System.out.println();
        System.out.println("--- ADD ---");
        for(Colaborador item : dao.browse()) {
            item.exibir();
        } 
        System.out.println();
        System.out.println(novo.getNome() + " passou cargo de " + novo.getCargo() + " para Flavio");
        System.out.println();
        novo.setNome("Flavio");
        novo.setCpf("22222222200");
        dao.Edit(novo);
        System.out.println();
        System.out.println();
        System.out.println("--- EDIT ---");
        for(Colaborador item : dao.browse()) {
            item.exibir();
        } 

        dao.Delete(novo);
        System.out.println();
        System.out.println("Registro de código " + novo.getCodigo() + " apagado com sucesso!");
        System.out.println();
        System.out.println("--- DELETE ---");
        for(Colaborador item : dao.browse()) {
            item.exibir();
        } 
    }

}
