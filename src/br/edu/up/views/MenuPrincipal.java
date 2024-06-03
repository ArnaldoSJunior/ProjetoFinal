package br.edu.up.views;

import br.edu.up.util.Prompt;

public class MenuPrincipal {

    public void mostrar() {
        Prompt.imprimir("------------------MENU PRINCIPAL------------------");
        Prompt.separador();
        Prompt.imprimir("1.Registrar entrada:");
        Prompt.imprimir("2.Registrar saída:");
        Prompt.imprimir("3.Verificar vagas:");
        Prompt.imprimir("4.Incluir mensalista:");
        Prompt.imprimir("5.Excluir mensalista:");
        Prompt.imprimir("6.Emitir relatório diário:");
        Prompt.imprimir("7.Emitir relatório mensalistas:");
        Prompt.imprimir("8.Sair");

        int op = Prompt.lerInteiro();
        do {
            switch (op) {
                case 1:
                    Prompt.imprimir("Tipo de veículo?");
                    int tipo = Prompt.lerInteiro("1.Moto 2.Carro 3.Caminhonete 4.Voltar");
                    if (tipo == 1) {

                    } else if (tipo == 2) {

                    } else if (tipo == 3) {

                    } else if (tipo == 4) {
                        mostrar();
                    }
                    break;
                case 2:
                    Prompt.imprimir("Informe a placa do veículo!");
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.exit(0);
                    break;

                default:
                    break;
            }

        } while (op != 8);

    }
}
