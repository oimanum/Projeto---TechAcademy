package DAO;

import java.util.ArrayList;

import Dominio.Visitante;
import FakeDB.VisitanteFakeDB;

public class VisitanteDAO extends AbsGenericDAO<Visitante> {

    private ArrayList<Visitante> tabela;

    @Override
    public Visitante Read(int codigo) {
        for (Visitante item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Visitante Edit(Visitante alterado) {
        // percorre a tabela procurando a posição do registro com o mesmo código
        for (int i = 0; i < this.tabela.size(); i++) {
            if (this.tabela.get(i).getCodigo() == alterado.getCodigo()) {
                this.tabela.set(i, alterado);
                return alterado;
            }
        }
        return null;
    }

    @Override
    public Visitante Add(Visitante novo) {
        int novoCodigo = 1;
        if (!this.tabela.isEmpty()) {
            novoCodigo = this.tabela.getLast().getCodigo() + 1;
        }
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Visitante Delete(Visitante apagado) {
        if (this.Read(apagado.getCodigo()) != null) {
            this.tabela.remove(apagado);
            return apagado; // devolve o objeto apagado para o usuário saber o que foi removido
        }
        return null;
    }

    public VisitanteDAO() {
        this.repositorio = new VisitanteFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
