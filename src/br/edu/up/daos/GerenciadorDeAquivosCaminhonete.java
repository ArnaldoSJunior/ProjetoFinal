package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Caminhonete;
import br.edu.up.models.Carro;

public class GerenciadorDeAquivosCaminhonete {

    private String header = "";
    private String nomeDoArquivoCaminhonete = "C:\\Users\\autologon\\Documents\\ProjetoFinal\\src\\br\\edu\\up\\caminhonetes.csv";

    public List<Caminhonete> getCaminhonete() {

        List<Caminhonete> caminhonetes = new ArrayList<>();

        try {
            File arquivoLeituraCaminhonete = new File(nomeDoArquivoCaminhonete);
            Scanner leitorCaminhonete = new Scanner(arquivoLeituraCaminhonete);

            if (leitorCaminhonete.hasNextLine()) {
                header = leitorCaminhonete.nextLine();
            }

            while (leitorCaminhonete.hasNextLine()) {
                String linha = leitorCaminhonete.nextLine();
                String[] dados = linha.split(";");

                String modelo = dados[0];
                String placa = dados[1];
                String cor = dados[2];

                Caminhonete caminhonete = new Caminhonete(modelo, placa, cor);
                caminhonetes.add(caminhonete);
            }
            leitorCaminhonete.close();

        } catch (FileNotFoundException e) {

        }
        return caminhonetes;
    }

    public boolean gravarCaminhonete(List<Caminhonete> caminhonetes) {
        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivoCaminhonete);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);
            for (Caminhonete caminhonete : caminhonetes) {
                gravador.println(caminhonete.toCSV());
            }
            gravador.close();

            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível gravar o arquivo! " + e.getMessage());
        }
        return false;
    }

}
