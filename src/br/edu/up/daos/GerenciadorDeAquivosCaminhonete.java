package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Caminhonete;

public class GerenciadorDeAquivosCaminhonete {
    
    private String header = "";
    private String nomeDoArquivoCaminhonete = "G:\\java\\ProjetoFinal\\src\\br\\edu\\up\\caminhonetes.csv";


    public List<Caminhonete> getCaminhonete(){

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

                String placa = dados[0];
                String modelo = dados[1];
                String cor = dados[2];

              Caminhonete caminhonete = new Caminhonete(placa, modelo, cor);
                caminhonetes.add(caminhonete);
            }
            leitorCaminhonete.close();




        } catch (FileNotFoundException e) {
            
        }
      return caminhonetes;
 }










}