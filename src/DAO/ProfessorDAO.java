package DAO;

import java.util.ArrayList;

import Dominio.Professor;
import FakeDB.ProfessorFakeDB;

public class ProfessorDAO extends AbsGenericDAO<Professor> {

    private ArrayList<Professor> tabela;

    @Override
    public ArrayList<Professor> browse() {
        return this.repositorio.getDados();
    }

    @Override
    public Professor Read(int codigo) {        
        for ( Professor item :this.tabela ) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Professor Edit(Professor alterado) {
        int codigoProcurado = alterado.getCodigo();
        if (this.Read(codigoProcurado) != null) {
            int index = this.tabela.indexOf(alterado);
            this.tabela.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public Professor Add(Professor novo) {
        int ultimoCodigo = this.tabela.getLast().getCodigo();
        int novoCodigo = ultimoCodigo + 1;
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public Professor Delete(Professor apagado) {
        int codigoProcurado = apagado.getCodigo();
        if (this.Read(codigoProcurado) != null) {
            this.tabela.remove(apagado);
            return apagado; 
            /* remove da tabela mas ainda devolve o objeto apagado para que o usuário saiba o que foi apagado,
             só seria completamente apagado se o retorno fosse null, mas nesse caso o usuário não saberia o que foi apagado, 
             então é melhor devolver o objeto apagado mesmo. */
        }
        return null;
        
    }


    public ProfessorDAO() {
        this.repositorio = new ProfessorFakeDB();
        this.tabela = this.repositorio.getDados();
    }
    
}
