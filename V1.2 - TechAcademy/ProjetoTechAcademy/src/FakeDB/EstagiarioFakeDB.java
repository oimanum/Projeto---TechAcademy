package FakeDB;

import java.util.ArrayList;

import Dominio.Estagiario;

public class EstagiarioFakeDB extends AbsGenericFakeDB<Estagiario> {

    public EstagiarioFakeDB() {
        this.dados = new ArrayList<>();
        this.autoPreencher();
    }

    @Override
    protected void autoPreencher() {
        this.dados.add(new Estagiario(101, "Lucas Mendes", "33333333301", "lucas@email.com", "67988880001",
                "Rua Bahia, 15", 1200.00, 30, "Suporte de TI"));
        this.dados.add(new Estagiario(102, "Camila Torres", "33333333302", "camila@email.com", "67988880002",
                "Av. Afonso Pena, 900", 1350.00, 25, "Desenvolvimento"));
        this.dados.add(new Estagiario(103, "Bruno Ramos", "33333333303", "bruno@email.com", "67988880003",
                "Rua Minas Gerais, 42", 1100.00, 20, "Secretaria"));
    }
}
