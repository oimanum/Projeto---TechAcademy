package FakeDB;

import java.util.ArrayList;

import Dominio.AbsPessoa;

public abstract class AbsFakeDB {
    protected ArrayList<AbsPessoa> dados;

    public ArrayList<AbsPessoa> getDados() {
        return this.dados;
    }

    protected abstract void autoPreencher();
}

//Não estamos usando AbsFakeDB pois estamos sendo GENERIC e não usando GENERIC como nesse caso aqui, vou deixar a classe só pra sabermos como exemplo, porém, não iremos utilizar.