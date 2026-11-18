package FakeDB;

import java.util.ArrayList;

import Dominio.Visitante;

public class VisitanteFakeDB extends AbsGenericFakeDB<Visitante> {

    public VisitanteFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Visitante(101, "Marcos Vieira", "22222222201", "marcos@email.com", "67999990001",
                "Rua das Flores, 10", "Reunião com a coordenação", 1, "Coordenação"));
        this.dados.add(new Visitante(102, "Juliana Prado", "22222222202", "juliana@email.com", "67999990002",
                "Av. Brasil, 250", "Entrega de documentos", 2, "Secretaria"));
        this.dados.add(new Visitante(103, "Thiago Alves", "22222222203", "thiago@email.com", "67999990003",
                "Rua Goiás, 77", "Manutenção de equipamentos", 3, "Laboratório"));
    }
}
