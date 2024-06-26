package br.edu.up.models;

public abstract class Veiculo {

    private String modelo;
    protected String placa;
    private String cor;

    public Veiculo(String modelo, String placa, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
