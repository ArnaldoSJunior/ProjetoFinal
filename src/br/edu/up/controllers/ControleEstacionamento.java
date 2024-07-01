package br.edu.up.controllers;

import java.util.List;

import br.edu.up.daos.*;
import br.edu.up.models.*;

public class ControleEstacionamento {

    private int contEntrada = 0;
    private int carrosSegundoPeriodo;
    Estacionamento est = new Estacionamento();
    private GerenciadorDeArquivosMensalista gArquivosMensalista = new GerenciadorDeArquivosMensalista();
    private GerenciadorDeArquivosCarro gArquivosCarro = new GerenciadorDeArquivosCarro();
    private GerenciadorDeAquivosCaminhonete gArquivosCaminhonete = new GerenciadorDeAquivosCaminhonete();
    private GerenciadorDeArquivosMoto gArquivosMoto = new GerenciadorDeArquivosMoto();
    private List<Mensalista> mensalistas;
    private List<Carro> carros;
    private List<Moto> motos;
    private List<Caminhonete> caminhonetes;

    public ControleEstacionamento() {
        this.mensalistas = gArquivosMensalista.getMensalista();
        this.carros = gArquivosCarro.getCarros();
        this.motos = gArquivosMoto.getMoto();
        this.caminhonetes = gArquivosCaminhonete.getCaminhonete();
    }

    public String criarMensalista(int op, String nome, String cpf, String telefone, String modelo, String placa,
            String cor) {
        Mensalista acharMensalista = mensalistas.stream().filter(x -> x.getPlacaVeiculo() == placa).findFirst()
                .orElse(null);
        if (acharMensalista == null) {
            Mensalista mensalista = new Mensalista(nome, cpf, telefone, placa);
            if (op == 1) {
                // Carro
                Carro carro = registrarCarroMensalista(modelo, placa, cor);
                if (carro != null) {
                    mensalista.setVeiculoCarro(carro);
                    mensalista.setTipoVeiculo(1);
                    incluirMensalistaLista(mensalista);
                    return "ok";
                }
                return "null";
            } else if (op == 2) {
                // Moto
                Moto moto = registrarMotoMensalista(modelo, placa, cor);
                if (moto != null) {
                    mensalista.setVeiculoMoto(moto);
                    mensalista.setTipoVeiculo(2);
                    incluirMensalistaLista(mensalista);
                    return "ok";
                }
                return "null";
            } else if (op == 3) {
                // Caminhonete
                Caminhonete caminhonete = registrarCaminhoneteMensalista(modelo, placa, cor);
                if (caminhonete != null) {
                    mensalista.setVeiculoCaminhonete(caminhonete);
                    mensalista.setTipoVeiculo(3);
                    incluirMensalistaLista(mensalista);
                    return "ok";
                }
                return "null";
            }

        }
        return "null";

    }

    public String excluirMensalista(String cpf) {
        Mensalista acharMensalista = mensalistas.stream().filter(x -> x.getCpf() == cpf).findFirst().orElse(null);
        if (acharMensalista != null) {
            mensalistas.remove(acharMensalista);
            return "ok";

        }
        return "null;";
    }

    public void incluirMensalistaLista(Mensalista mensalista) {
        this.mensalistas.add(mensalista);
    }

    public boolean gravarMensalista() {
        return gArquivosMensalista.gravarMensalista(mensalistas);
    }

    public Carro registrarCarroMensalista(String modelo, String placa, String cor) {
        Carro acharCarro = carros.stream().filter(x -> x.getPlaca() == placa).findFirst().orElse(null);
        if (acharCarro == null) {
            Carro carro = new Carro(modelo, placa, cor);
            return carro;
        }
        return null;
    }

    public Moto registrarMotoMensalista(String modelo, String placa, String cor) {
        Moto acharMoto = motos.stream().filter(x -> x.getPlaca() == placa).findFirst().orElse(null);
        if (acharMoto == null) {
            Moto moto = new Moto(modelo, placa, cor);
            return moto;
        }
        return null;
    }

    public Caminhonete registrarCaminhoneteMensalista(String modelo, String placa, String cor) {
        Caminhonete acharCaminhonete = caminhonetes.stream().filter(x -> x.getPlaca() == placa).findFirst()
                .orElse(null);
        if (acharCaminhonete == null) {
            Caminhonete caminhonete = new Caminhonete(modelo, placa, cor);
            caminhonetes.add(caminhonete);
            return caminhonete;
        }
        return null;
    }

    public String listarMensalistas() {
        if (mensalistas.size() == 0) {
            return "Não há mensalistas cadastrados!";
        } else {
            return mensalistas.toString();
        }
    }

    public List<Mensalista> getListaMensalistas() {
        return mensalistas;
    }

    public String registrarEntrada(String placa, String modelo, String cor, int tipo) {
        int vagaDisponivel = est.encontrarVagaDisponivel();
        if (vagaDisponivel != -1) {
            if (validarPlaca(placa) == true) {
                contEntrada++;
                est.getVagas(vagaDisponivel).ocuparVaga(placa, modelo, cor, tipo);
                return "OK";
            } else {
                return "null";
            }
        } else {
            return "null";
        }
    }

    public String registarSaida(String placa) {
        for (int i = 0; i < 10; i++) {
            if (est.verificarPlaca(placa) != null && est.verificarPlaca(placa).equals("1")) {
                if (est.getVagas(i).getCarroPlaca() != null && est.getVagas(i).getCarroPlaca().equals(placa)) {
                    est.getVagas(i).liberarVaga();
                    return "OK"; // Retorna "OK" se a placa for encontrada e a vaga for liberada
                }
            }
        }
        return "OFF"; // Retorna "OFF" se a placa não for encontrada ou se a vaga não estiver ocupada
                      // por esse veículo
    }

    public int contarVagasDisponiveis() {
        int contador = 0;
        for (Vaga vaga : est.getVagas()) {
            if (!vaga.ocupada()) {
                contador++;
            }
        }
        return contador;
    }

    public int consultarVaga(String placa) {
        for (int i = 0; i < 10; i++) {
            if (est.getVagas(i).getCarroPlaca().equals(placa)) {
                return est.getVagas(i).getNumero();
            }

        }
        return 0;
    }

    public Double finalizarPeriodo() {
        Double valorFinal = contEntrada * 5.00;
        return valorFinal;
    }

    public Double finalizarPeriodoTarde() {
        double valorFinal = (contEntrada + carrosSegundoPeriodo) * 5.00;
        return valorFinal;
    }

    public int carrosSegundoPeriodo() {
        this.carrosSegundoPeriodo = 10 - contarVagasDisponiveis();
        return carrosSegundoPeriodo;
    }

    public double finalizarPeriodoNoite() {
        double valorFinal = (contEntrada + carrosSegundoPeriodo) * 5.00;
        return valorFinal;
    }

    public int getContEntrada() {
        return contEntrada;
    }

    public int getCarrosSegundoPeriodo() {
        return carrosSegundoPeriodo;
    }

    public void setContEntrada(int contEntrada) {
        this.contEntrada = contEntrada;
    }

    public boolean validarPlaca(String placa) {
        String[] partes = placa.split("-");
        if (partes.length != 2 || partes[0].length() != 3) {
            return false;
        }
        // Verifica se a segunda parte consiste apenas em dígitos ou letras
        if (!partes[1].matches("[0-9a-zA-Z]+")) {
            return false;
        }
        return true;
    }

}
