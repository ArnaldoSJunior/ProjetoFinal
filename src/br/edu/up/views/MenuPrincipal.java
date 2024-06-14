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
                    int opcao = Prompt.lerInteiro("Digite o tipo de veículp: (1-Carro/ 2-Moto/ 3-Caminhonete)");
                    if (opcao != 1 && opcao != 2 && opcao != 3) {
                        System.out.println("Opção de veículo inválido!!");
                        break;

                    }
                    String nome = Prompt.lerLinha("Digite o nome: ");
                    String cpf = Prompt.lerLinha("Digite o seu CPF");
                    String telefone = Prompt.lerLinha("Digite o seu telefone: ");
                    System.out.println("--- Incluir Carro de Mensalista ---");
                    String modeloVeiculo = Prompt.lerLinha("Digite o modelo do veículo: ");
                    String placa = Prompt.lerLinha("Digite o placa do veículo: ");
                    String cor = Prompt.lerLinha("Digite a cor da veículo: ");
                    if (ctrlEstacionamento.criarMensalista(opcao, nome, cpf, telefone, modeloVeiculo, placa, cor)
                            .equals("ok")) {
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
                    System.out.println(ctrlEstacionamento.listarMensalistas());
                    break;
                default:
                    break;

            }
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

            op = Prompt.lerInteiro();

        } while (op != 8);

        if (ctrlEstacionamento.gravarMensalista()) {
            System.out.println("Dados gravador com sucesso!");
        } else {
            System.out.println("Falha ao gravar dados!");
        }
        System.out.println("Programa encerrado");

    }
}
