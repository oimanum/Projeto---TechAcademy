package FakeDB;

import java.util.ArrayList;

import Dominio.Egresso;

public class EgressoFakeDB extends AbsGenericFakeDB<Egresso> {

    public EgressoFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Egresso(101, "Ana Beatriz", "11111111101", 2020, "Ciência da Computação", "Desenvolvimento Web"));
        this.dados.add(new Egresso(102, "Carlos Eduardo", "11111111102", 2018, "Sistemas de Informação", "Banco de Dados"));
        this.dados.add(new Egresso(103, "Fernanda Lima", "11111111103", 2022, "Análise de Sistemas", "Suporte Técnico"));
        this.dados.add(new Egresso(104, "Rafael Souza", "11111111104", 2019, "Ciência da Computação", "Segurança da Informação"));
    }
}
