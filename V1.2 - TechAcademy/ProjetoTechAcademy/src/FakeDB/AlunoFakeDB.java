package FakeDB;

import java.util.ArrayList;

import Dominio.Aluno;

public class AlunoFakeDB extends AbsGenericFakeDB<Aluno> {
    public AlunoFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override 
    protected void autoPreencher() {
        this.dados.add(new Aluno(101, "Cristina Costa", "01234567890", "ABC1"));
        this.dados.add(new Aluno(102, "Pedro Paulo", "01234567891", "ABC2"));
        this.dados.add(new Aluno(103, "Matheus Pereira", "01234567892", "ABC3"));
        this.dados.add(new Aluno(104, "Maria Helena", "01234567893", "ABC4"));
        this.dados.add(new Aluno(105, "Clara Madalena", "01234567894", "ABC5"));
    }
}
