package FakeDB;

import java.util.ArrayList;

import Dominio.ProfessorEfetivo;

public class ProfessorEfetivoFakeDB extends AbsGenericFakeDB<ProfessorEfetivo> {
    public ProfessorEfetivoFakeDB(){
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override 
    protected void autoPreencher() {
        this.dados.add(new ProfessorEfetivo(001, "Luizao", "012345678909", 6000.00, 700.00 ));
        this.dados.add(new ProfessorEfetivo(002, "Noiza", "01234567891",5500.00, 500.00 ));
        this.dados.add(new ProfessorEfetivo(003, "Murilo", "01234567892",4000.00, 450.00 ));
        this.dados.add(new ProfessorEfetivo(004, "Jeandro", "01234567893", 3950.00, 400.00 ));
        this.dados.add(new ProfessorEfetivo(005, "Evandro", "01234567894", 3500.00, 350.00));
    }
}
