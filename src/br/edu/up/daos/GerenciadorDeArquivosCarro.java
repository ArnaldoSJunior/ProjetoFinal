package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Carro;

public class GerenciadorDeArquivosCarro {
    
    private String header = "Placa;Modelo;Cor";
    private String nomeDoArquivoCarro = "C:\\Users\\autologon\\Documents\\ProjetoFinal\\src\\br\\edu\\up\\carros.csv";

    public List<Carro> getCarros() {

        List<Carro> listaCarros = new ArrayList<>();

        try {
            File arquivoLeituraCarro = new File(nomeDoArquivoCarro);
            Scanner leitorCarro = new Scanner(arquivoLeituraCarro);

            if (leitorCarro.hasNextLine()) {
                header = leitorCarro.nextLine();
            }

            while (leitorCarro.hasNextLine()) {
                String linha = leitorCarro.nextLine();
                String[] dados = linha.split(";");

                String placa = dados[1];
                String modelo = dados[0];
                String cor = dados[2];

                Carro carro = new Carro(placa, modelo, cor);
                listaCarros.add(carro);
            }
            leitorCarro.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        return listaCarros;
    }

    public boolean gravarCarros(List<Carro> carros) {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivoCarro);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);
            for (Carro carro : carros) {
                gravador.println(carro.toCSV());
            }
            gravador.close();

            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível gravar o arquivo! " + e.getMessage());
        }
        return false;
    }

}
