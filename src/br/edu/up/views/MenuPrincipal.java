package br.edu.up.views;

import br.edu.up.controllers.ControleEstacionamento;
import br.edu.up.models.Estacionamento;
import br.edu.up.util.Prompt;

public class MenuPrincipal {

    ControleEstacionamento ctrlEstacionamento = new ControleEstacionamento();

    public void mostrar() {

        Estacionamento est = new Estacionamento();

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
                    Prompt.imprimir("Tipo de veículo:");
                    int tipo = Prompt.lerInteiro("1.Moto 2.Carro 3.Caminhonete 4.Voltar");

                    if (tipo == 1) {
                        Prompt.imprimir("Informe a placa da moto:");

                    } else if (tipo == 2) {
                        Prompt.imprimir("Informe a placa do carro:");

                    } else if (tipo == 3) {
                        Prompt.imprimir("Informe a placa da caminhonete:");

                    } else if (tipo == 4) {
                        mostrar();
                    }
                    break;
                case 2:
                    Prompt.imprimir("Informe a placa do veículo!");

                    break;
                case 3:
                    System.out.println("Vagas disponíveis: ");
                    int vagaDisponivel = 0;
                    break;
                case 4:
                    System.out.println("--- Incluir Mensalistas ---");
                    String nome = Prompt.lerLinha("Digite o nome: ");
                    String cpf = Prompt.lerLinha("Digite o seu CPF");
                    String telefone = Prompt.lerLinha("Digite o seu telefone: ");
                    String placa = Prompt.lerLinha("Digite a placa do seu veículo: ");
                    if (ctrlEstacionamento.criarMensalista(nome, cpf, telefone, placa).equals("ok")) {
                        System.out.println("Mensalista adicionado com sucesso!!");
                    } else {
                        System.out.println("Falha ao adicionar mensalista!!");
                    }
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

            mostrar();

        } while (op != 8);

    }
}
