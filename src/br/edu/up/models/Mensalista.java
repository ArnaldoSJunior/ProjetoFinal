package br.edu.up.models;

public class Mensalista {
    private String nome;
    private String cpf;
    private String telefone;
    private Carro carro;
    private Moto moto;
    private Caminhonete caminhonete;
    // private Veiculo veiculo;
    private String placaVeiculo;

    public Mensalista(String nome, String cpf, String telefone, String placaVeiculo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.placaVeiculo = placaVeiculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    @Override
    public String toString() {
        return "Mensalista [nome= " + nome + ", cpf= " + cpf + ", telefone= " + telefone + ", Veiculos= " + "Carro= "
                + carro + ", Moto= " + moto + ", Caminhonete= " + caminhonete
                + "]\n";
    }

    public String toCSV() {
        return nome + ";" + cpf + ";" + telefone + ";" + placaVeiculo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Caminhonete getCaminhonete() {
        return caminhonete;
    }

    public void setCaminhonete(Caminhonete caminhonete) {
        this.caminhonete = caminhonete;
    }

}
