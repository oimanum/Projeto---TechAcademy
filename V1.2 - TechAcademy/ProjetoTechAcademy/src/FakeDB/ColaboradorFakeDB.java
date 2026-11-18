package FakeDB;

import java.util.ArrayList;

import Dominio.Colaborador;

public class ColaboradorFakeDB extends AbsGenericFakeDB<Colaborador> {
    
    public ColaboradorFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override 
    protected void autoPreencher() {
        this.dados.add(new Colaborador(101, "Matheus Souza", "1234567890", "Estagiario"));
        this.dados.add(new Colaborador(102, "João Silva", "1234567891", "Bibliotecário"));
        this.dados.add(new Colaborador(103, "Paulo Santos", "1234567892", "Jovem Aprendiz"));
        this.dados.add(new Colaborador(104, "André Santos", "1234567893", "Técnico de TI"));
        this.dados.add(new Colaborador(105, "Pedro Lima", "1234567894", "Estagiario"));
    }
}
