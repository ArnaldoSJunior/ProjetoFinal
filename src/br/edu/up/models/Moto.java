package br.edu.up.models;

public class Moto extends Veiculo {

    public Moto(String modelo, String placa, String cor) {
        super(modelo, placa, cor);
    }

    @Override
    public String toString() {
        return "Moto [Modelo: " + super.getModelo()
                + ", Placa: " + super.getPlaca()
                + ", Cor: " + super.getCor() + " ]";
    }

}
