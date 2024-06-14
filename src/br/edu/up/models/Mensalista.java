package br.edu.up.models;

public class Mensalista {
    private String nome;
    private String cpf;
    private String telefone;
    // private Carro carro;
    // private Moto moto;
    // private Caminhonete caminhonete;
    private Veiculo veiculo;
    private String placaVeiculo;
    private int tipoVeiculo;

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

    // @Override
    // public String toString() {
    //     return "Mensalista [nome= " + nome + ", cpf= " + cpf + ", telefone= " + telefone + ", Veiculos= " + "Carro= "
    //             + carro + ", Moto= " + moto + ", Caminhonete= " + caminhonete
    //             + "]\n";
    // }
    @Override
    public String toString() {
        return "Mensalista [nome= " + nome + ", cpf= " + cpf + ", telefone= " + telefone + ", Veiculos= " +veiculo
                + "]\n";
    }

    public String toCSVcarro() {
        return nome + ";" + cpf + ";" + telefone + ";" + placaVeiculo+ ";" +veiculo.getModelo()+ ";" +veiculo.getCor()+ ";" + tipoVeiculo;
    }

    public String toCSVmoto(){
        return nome + ";" + cpf + ";" + telefone + ";" + placaVeiculo+";"+veiculo.getModelo()+";"+veiculo.getCor()+";"+tipoVeiculo;
    }

    public String toCSVcaminhonete(){
        return nome + ";" + cpf + ";" + telefone + ";" + placaVeiculo+";"+veiculo.getModelo()+";"+veiculo.getCor()+";"+tipoVeiculo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setVeiculoCarro(Carro carro){
        this.veiculo = carro;
    }

    public void setVeiculoMoto(Moto moto){
        this.veiculo = moto;
    }

    public void setVeiculoCaminhonete(Caminhonete caminhonete){
        this.veiculo = caminhonete;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    

}
