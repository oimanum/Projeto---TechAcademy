package FakeDB;

import java.util.ArrayList;

import Dominio.Professor;

public class ProfessorFakeDB extends AbsGenericFakeDB<Professor> {
    public ProfessorFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override 
    protected void autoPreencher() {
        this.dados.add(new Professor(001, "Luizao", "012345678909", 6000.00 ));
        this.dados.add(new Professor(002, "Noiza", "01234567891",5500.00 ));
        this.dados.add(new Professor(003, "Murilo", "01234567892",4000.00 ));
        this.dados.add(new Professor(004, "", "01234567893", 3950.00 ));
        this.dados.add(new Professor(005, "Evandro", "01234567894", 3500.00));
    }
}
