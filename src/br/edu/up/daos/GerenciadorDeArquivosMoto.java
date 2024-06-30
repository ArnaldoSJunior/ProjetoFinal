package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Moto;

public class GerenciadorDeArquivosMoto {
    private String header = "";
    private String nomeDoArquivoCaminhonete = "G:\\java\\ProjetoFinal\\src\\br\\edu\\up\\motos.csv";

    public List<Moto> getMoto(){
        List<Moto> motos = new ArrayList<>();

        try {

            File arquivoLeituraMoto = new File(nomeDoArquivoCaminhonete);
            Scanner leitorMoto = new Scanner(arquivoLeituraMoto);

            if (leitorMoto.hasNextLine()) {
                header = leitorMoto.nextLine();
            }

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
}
    
    
    