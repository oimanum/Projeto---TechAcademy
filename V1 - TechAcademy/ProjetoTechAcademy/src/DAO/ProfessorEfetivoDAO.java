package DAO;

import java.util.ArrayList;

import Dominio.ProfessorEfetivo;
import FakeDB.ProfessorEfetivoFakeDB;

public class ProfessorEfetivoDAO extends AbsGenericDAO<ProfessorEfetivo> {

    private ArrayList<ProfessorEfetivo> tabela;

    @Override
    public ArrayList<ProfessorEfetivo> browse() {
        return this.repositorio.getDados();
    }

    @Override
    public ProfessorEfetivo Read(int codigo) {        
        for ( ProfessorEfetivo item :this.tabela ) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    @Override
    public ProfessorEfetivo Edit(ProfessorEfetivo alterado) {
        int codigoProcurado = alterado.getCodigo();
        if (this.Read(codigoProcurado) != null) {
            int index = this.tabela.indexOf(alterado);
            this.tabela.set(index, alterado);
            return alterado;
        }
        return null;
    }

    @Override
    public ProfessorEfetivo Add(ProfessorEfetivo novo) {
        int ultimoCodigo = this.tabela.getLast().getCodigo();
        int novoCodigo = ultimoCodigo + 1;
        novo.setCodigo(novoCodigo);
        this.tabela.add(novo);
        return novo;
    }

    @Override
    public ProfessorEfetivo Delete(ProfessorEfetivo apagado) {
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


    public ProfessorEfetivoDAO() {
        this.repositorio = new ProfessorEfetivoFakeDB();
        this.tabela = this.repositorio.getDados();
    }
    
}
