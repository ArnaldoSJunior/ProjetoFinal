package br.edu.up.models;

public class Carro extends Veiculo {

    public Carro(String modelo, String placa, String cor) {
        super(modelo, placa, cor);
    }

    
    public String toString() {
        return "Carro [Modelo: " + super.getModelo()
                + ", Placa: " + super.getPlaca()
                + ", Cor: " + super.getCor() + " ]";
    }


    public String toCSV() {
        return getPlaca() + ";" + getModelo() + ";" + getCor();
    }

}
