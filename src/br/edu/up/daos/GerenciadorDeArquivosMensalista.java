package br.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.models.Mensalista;

public class GerenciadorDeArquivosMensalista {

    private String header = "";
    private String nomeDoArquivoMensalista = "C:\\Users\\autologon\\Documents\\ProjetoFinal\\src\\br\\edu\\up\\mensalistas.csv";

    public List<Mensalista> getMensalista() {

        List<Mensalista> ListaMensalistas = new ArrayList<>();

        try {
            File arquivoLeituraMensalista = new File(nomeDoArquivoMensalista);
            Scanner leitorMensalsita = new Scanner(arquivoLeituraMensalista);

            header = leitorMensalsita.nextLine();

            while (leitorMensalsita.hasNextLine()) {
                String linha = leitorMensalsita.nextLine();
                String[] dados = linha.split(";");

                String nome = dados[0];
                String cpf = dados[1];
                String telefone = dados[2];
                String placaVeiculo = dados[3];

                Mensalista mensalista = new Mensalista(nome, cpf, telefone, placaVeiculo);
                ListaMensalistas.add(mensalista);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado! " + e.getMessage());
        }

        return ListaMensalistas;
    }

    public boolean gravarMensalista(List<Mensalista> mensalistas) {
        try {
            FileWriter arquivoGRavar = new FileWriter(nomeDoArquivoMensalista);
            PrintWriter gravador = new PrintWriter(arquivoGRavar);

            gravador.println(header);
            for (Mensalista mensalista : mensalistas) {
                gravador.println(mensalista.toCSV());
            }
            gravador.close();

            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível gravar o arquivo!");
        }
        return false;
    }

}
