package DAO;

import java.util.ArrayList;

import Dominio.Egresso;
import FakeDB.EgressoFakeDB;

public class EgressoDAO extends AbsGenericDAO<Egresso> {

    private ArrayList<Egresso> tabela;

    @Override
    public Egresso Read(int codigo) {
        for (Egresso item : this.tabela) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Egresso Edit(Egresso alterado) {
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
    public Egresso Add(Egresso novo) {
        int novoCodigo = 1;
        if (!this.tabela.isEmpty()) {
            novoCodigo = this.tabela.getLast().getCodigo() + 1;
        }
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Egresso Delete(Egresso apagado) {
        if (this.Read(apagado.getCodigo()) != null) {
            this.tabela.remove(apagado);
            return apagado; // devolve o objeto apagado para o usuário saber o que foi removido
        }
        return null;
    }

    public EgressoDAO() {
        this.repositorio = new EgressoFakeDB();
        this.tabela = this.repositorio.getDados();
    }
}
