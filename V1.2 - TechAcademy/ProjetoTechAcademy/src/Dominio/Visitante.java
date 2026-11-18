package Dominio;

public class Visitante extends AbsPrestador {
    private String motivoVisita;
    private int crachaNumero;
    private String setorVisita;

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public int getCrachaNumero() {
        return crachaNumero;
    }

    public void setCrachaNumero(int crachaNumero) {
        this.crachaNumero = crachaNumero;
    }

    public String getSetorVisita() {
        return setorVisita;
    }

    public void setSetorVisita(String setorVisita) {
        this.setorVisita = setorVisita;
    }

    @Override
    public void exibir() {
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("CPF: " + this.cpf);
        System.out.println("E-mail: " + this.email);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Motivo da visita: " + this.motivoVisita);
        System.out.println("Crachá número: " + this.crachaNumero);
        System.out.println("Setor da visita: " + this.setorVisita);
    }

    public Visitante() {}

    public Visitante(int codigo, String nome, String cpf, String email, String telefone, String endereco,
            String motivoVisita, int crachaNumero, String setorVisita) {
        super(codigo, nome, cpf, email, telefone, endereco);
        this.motivoVisita = motivoVisita;
        this.crachaNumero = crachaNumero;
        this.setorVisita = setorVisita;
    }
}
