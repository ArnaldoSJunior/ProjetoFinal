package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Carro;
import br.edu.up.models.Mensalista;
import br.edu.up.models.Moto;

public class GerenciadorDeArquivosMoto {
    private String header = "";
    private String nomeDoArquivoMoto = "C:\\Users\\autologon\\Documents\\ProjetoFinal\\src\\br\\edu\\up\\motos.csv";

    public List<Moto> getMoto() {
        List<Moto> motos = new ArrayList<>();

        try {

            File arquivoLeituraMoto = new File(nomeDoArquivoMoto);
            Scanner leitorMoto = new Scanner(arquivoLeituraMoto);

            if (leitorMoto.hasNextLine()) {
                header = leitorMoto.nextLine();
            }

            leitorMoto.nextLine();
            while (leitorMoto.hasNextLine()) {
                String linha = leitorMoto.nextLine();
                String[] dados = linha.split(";");

                String placa = dados[0];
                String modelo = dados[1];
                String cor = dados[2];

                Moto moto = new Moto(modelo, placa, cor);
                motos.add(moto);
            }

            leitorMoto.close();

        } catch (FileNotFoundException e) {

        }

        return motos;
    }

    public boolean gravarMoto(List<Moto> motos) {

        boolean arquivoExiste = new File(nomeDoArquivoMoto).exists();

        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivoMoto);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);
            for (Moto moto : motos) {
                gravador.println(moto.toCSV());
            }

            gravador.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
            return false;
        }
    }
}
