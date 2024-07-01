package br.edu.up.controllers;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.daos.*;
import br.edu.up.models.*;
import br.edu.up.util.Prompt;

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

    public String incluirCaminhonete(String modelo, String placa, String cor) {

        int vaga = est.encontrarVagaDisponivel();

        if (vaga != -1) {

            Caminhonete caminhonete = new Caminhonete(modelo, placa, cor);
            List<Caminhonete> caminhonetes = new ArrayList<>();
            caminhonetes.add(caminhonete);
            return "ok";
        }
        return "null";

    }

}
