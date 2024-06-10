package br.edu.up.models;

public class Caminhonete extends Veiculo {

    public Caminhonete(String modelo, String placa, String cor) {
        super(modelo, placa, cor);
    }

    @Override
    public String toString() {
        return "Caminhonete [Modelo: " + super.getModelo()
                + ", Placa: " + super.getPlaca()
                + ", Cor: " + super.getCor() + " ]";
    }

}
