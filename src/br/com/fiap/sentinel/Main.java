package br.com.fiap.sentinel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        System.out.println("BEM VINDO AO SENTINELS:");


        while(opcao != 0) {
            System.out.println("Selecione uma das opções abaixo para utilizar o sistema:");
            System.out.println("Digite 1 para cadastrar um uma rede");
            System.out.println("Digite 2 para cadastrar um hospital");
            System.out.println("Digite 3 para cadastrar um funcionário");
            System.out.println("Digite 4 para cadastrar um paciente");
            System.out.println("Digite 5 para ver os hospitais que o plano atende");
            System.out.println("Digite 6 para atender um paciente");
            System.out.println("Digite 7 para ver a quantidade de leitos de um hospital");
            System.out.println("Digite 8 para liberar um paciente");
            System.out.println("Digite 0 para sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    break;

                case 2:
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
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Por favor, digite uma opção válida");
            }
        }


        sc.close();
    }
}
