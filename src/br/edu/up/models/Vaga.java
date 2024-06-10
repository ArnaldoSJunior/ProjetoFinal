package br.edu.up.models;

public class Vaga {

    private int numero;
    private Boolean ocupada = false;
    private Carro carro;
    private Moto moto;
    private Caminhonete caminhonete;
    private String veiculoPlaca;

    public Vaga(int numero) {
        this.numero = numero;
    }

    public void ocuparVaga(String placa, String modelo, String cor, int tipo) {

        if (tipo == 1) {
            this.ocupada = true;
            this.moto = new Moto(modelo, placa, cor);
            this.veiculoPlaca = moto.getPlaca();

        } else if (tipo == 2) {
            this.ocupada = true;
            this.carro = new Carro(modelo, placa, cor);
            this.veiculoPlaca = carro.getPlaca();
        } else if (tipo == 3) {
            this.ocupada = true;
            this.caminhonete = new Caminhonete(modelo, placa, cor);
            this.veiculoPlaca = caminhonete.getPlaca();

        }

        // carro.toString();

    }

    public void liberarVaga() {
        this.ocupada = false;
        this.veiculoPlaca = null;
        this.carro = null;
        this.moto = null;
        this.caminhonete = null;
    }

    public boolean ocupada() {
        return ocupada;
    }

    public Boolean getOcupada() {
        return ocupada;
    }

    public String estaOcupado() {
        if (ocupada == true) {
            return "sim";
        }
        return "não";
    }

    public Carro getCarro() {
        return carro;
    }

    public String getCarroPlaca() {
        return veiculoPlaca;
    }

    public int getNumero() {
        return numero;
    }

    public Moto getMoto() {
        return moto;
    }

    public Caminhonete getCaminhonete() {
        return caminhonete;
    }

}
