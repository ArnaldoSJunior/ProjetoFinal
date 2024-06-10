package br.edu.up.controllers;

import java.util.List;

import br.edu.up.daos.GerenciadorDeArquivosMensalista;
import br.edu.up.models.*;

public class ControleEstacionamento {

    private int contEntrada = 0;
    private int carrosSegundoPeriodo;
    Estacionamento est = new Estacionamento();
    private GerenciadorDeArquivosMensalista gArquivosMensalista = new GerenciadorDeArquivosMensalista();
    private List<Mensalista> mensalistas;

    public ControleEstacionamento() {
        this.mensalistas = gArquivosMensalista.getMensalista();
    }

    public String criarMensalista(String nome, String cpf, String telefone, String placaVeiculo) {
        Mensalista acharMensalista = mensalistas.stream().filter(x -> x.getPlacaVeiculo() == placaVeiculo).findFirst()
                .orElse(null);
        if (acharMensalista == null) {
            Mensalista mensalista = new Mensalista(nome, cpf, telefone, placaVeiculo);
            incluirMensalistaLista(mensalista);
            return "ok";
        }
        return "null";

    }

    public void incluirMensalistaLista(Mensalista mensalista) {
        this.mensalistas.add(mensalista);
    }

}
