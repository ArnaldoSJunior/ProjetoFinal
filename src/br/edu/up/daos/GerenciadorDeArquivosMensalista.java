package br.edu.up.daos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.*;

public class GerenciadorDeArquivosMensalista {

    private String header = "";
    private String nomeDoArquivoMensalista = "C:\\Users\\Casa\\Documents\\Estudos-Programação\\ProjetoFinal\\src\\br\\edu\\up\\mensalistas.csv";

    public List<Mensalista> getMensalista() {

        List<Mensalista> listaMensalistas = new ArrayList<>();

        try {
            File arquivoLeituraMensalista = new File(nomeDoArquivoMensalista);
            Scanner leitorMensalista = new Scanner(arquivoLeituraMensalista);

            header = leitorMensalista.nextLine(); // Ler cabeçalho (opcional)

            while (leitorMensalista.hasNextLine()) {
                String linha = leitorMensalista.nextLine();
                String[] dados = linha.split(";"); // Dividir por espaços

                String nome = dados[0];
                String cpf = dados[1];
                String telefone = dados[2];
                String placaVeiculo = dados[3];

                String modelo = dados[4];
                String cor = dados[5];
                int tipoVeiculo = Integer.parseInt(dados[6]);

                Mensalista mensalista = new Mensalista(nome, cpf, telefone, placaVeiculo);

                switch (tipoVeiculo) {
                    case 1:
                        Carro carro = new Carro(modelo, placaVeiculo, cor);
                        mensalista.setVeiculoCarro(carro);
                        break;
                    case 2:
                        Moto moto = new Moto(modelo, placaVeiculo, cor);
                        mensalista.setVeiculoMoto(moto);
                        break;
                    case 3:
                        Caminhonete caminhonete = new Caminhonete(modelo, placaVeiculo, cor);
                        mensalista.setVeiculoCaminhonete(caminhonete);
                        break;
                    default:
                        System.out.println("Tipo de veículo inválido: " + tipoVeiculo);
                }

                listaMensalistas.add(mensalista);
            }

            leitorMensalista.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Formato de tipo de veículo inválido: " + e.getMessage());
        }

        return listaMensalistas;
    }

    public boolean gravarMensalista(List<Mensalista> mensalistas) {
        boolean arquivoExiste = new File(nomeDoArquivoMensalista).exists();
        
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivoMensalista, true); // Modo apêndice
            PrintWriter gravador = new PrintWriter(arquivoGravar);
    
            // Escrever cabeçalho apenas se o arquivo não existir ou estiver vazio
            if (!arquivoExiste || new File(nomeDoArquivoMensalista).length() == 0) {
                gravador.println(header);
            }
    
            for (Mensalista mensalista : mensalistas) {
                String linhaTXTcarro = mensalista.toCSVcarro();
                String linhaTXTmoto = mensalista.toCSVmoto();
                String linhaTXTcaminhonete = mensalista.toCSVcaminhonete();
    
                if (mensalista.getTipoVeiculo() == 1) {
                    gravador.println(linhaTXTcarro);
                } else if (mensalista.getTipoVeiculo() == 2) {
                    gravador.println(linhaTXTmoto);
                } else if (mensalista.getTipoVeiculo() == 3) {
                    gravador.println(linhaTXTcaminhonete);
                }
            }
    
            gravador.close();
    
            return true;
    
        } catch (Exception e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
            return false;
        }
    }
    
    
}
