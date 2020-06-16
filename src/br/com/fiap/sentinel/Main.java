package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao = -1;

		System.out.println("BEM VINDO AO SENTINELS:");

		Funcionario funcionario = null;
		Paciente paciente = null;

		List<Boolean> sintomasPaciente = new ArrayList<Boolean>();
		List<Funcionario> funcionariosHospital = new ArrayList<Funcionario>();
		List<Paciente>pacientesParaInternar = new ArrayList<Paciente>();

		while (opcao != 0) {
			System.out.println("Selecione uma das opções abaixo para utilizar o sistema:");
			System.out.println("Digite 1 para cadastrar um funcionário");
			System.out.println("Digite 2 para cadastrar um hospital");
			System.out.println("Digite 3 para cadastrar uma rede");
			System.out.println("Digite 4 para cadastrar um paciente");
			System.out.println("Digite 5 para ver os hospitais que o plano atende");
			System.out.println("Digite 6 para atender um paciente");
			System.out.println("Digite 7 para ver a quantidade de leitos de um hospital");
			System.out.println("Digite 8 para liberar um paciente");
			System.out.println("Digite 0 para sair");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Digite o primeiro nome do funcionário: ");
				String primeiroNomeFuncionario = sc.nextLine();

				System.out.print("Digite o sobrenome do funcionário: ");
				String sobrenomeFuncionario = sc.nextLine();

				System.out.println("Digite o email do funcionário: ");
				String emailFuncionario = sc.nextLine();

				System.out.print("Digite o cargo do funcionário: ");
				String cargoFuncionario = sc.nextLine();

				funcionario = new Funcionario(primeiroNomeFuncionario, sobrenomeFuncionario, emailFuncionario,
						cargoFuncionario);

				funcionariosHospital.add(funcionario);

				break;

			case 2:
				String nomeHospital, endereco;

				Hospital hospital = new Hospital();

				System.out.println("Digite o nome do Hospital");
				nomeHospital = sc.nextLine();

				hospital.setNome(nomeHospital);

				System.out.println("Digite o endereço do hospital");
				endereco = sc.nextLine();

				hospital.setEndereco(endereco);
				break;

			case 3:
				String nomeRede, responsavel, cidade, estado, cidades, estados;

				RedeHospitalar redeHospitalar = new RedeHospitalar();

				System.out.println("Digite o nome da rede: ");
				nomeRede = sc.nextLine();
				redeHospitalar.setNome(nomeRede);

				System.out.println("Digite o nome do responsável: ");
				responsavel = sc.nextLine();
				redeHospitalar.setResponsavel(responsavel);

				System.out.println("A rede atende mais de uma cidade?");
				cidade = sc.nextLine();
				cidade = cidade.toUpperCase();

				if (cidade.equals("SIM")) {
					while (cidade.equals("SIM")) {
						System.out.println("Digite o nome da cidade: ");
						cidades = sc.nextLine();
						redeHospitalar.adicionaCidade(cidades);
						System.out.println("A rede atende mais alguma cidade?");
						cidade = sc.nextLine();
						cidade = cidade.toUpperCase();
					}
				} else {
					System.out.println("Digite o nome da cidade: ");
					cidades = sc.nextLine();
					redeHospitalar.adicionaCidade(cidades);
				}

				System.out.println("A rede atende mais de um estado?");
				estado = sc.nextLine();
				estado = estado.toUpperCase();

				if (estado.equals("SIM")) {
					while (estado.equals("SIM")) {
						System.out.println("Digite o nome da estado: ");
						estados = sc.nextLine();
						redeHospitalar.adicionaEstado(estados);
						System.out.println("A rede atende mais alguma estado?");
						estado = sc.nextLine();
						estado = estado.toUpperCase();
					}
				} else {
					System.out.println("Digite o nome da estado: ");
					estados = sc.nextLine();
					redeHospitalar.adicionaCidade(estados);
				}

				break;

			case 4:

				char respostaSintomaCoronaVirus = ' ';
				char opcaoResposta = ' ';
				String observacao = "";

				System.out.print("Informe o primeiro nome do paciente: ");
				String nomePaciente = sc.nextLine();

				System.out.print("Informe o sobrenome do paciente: ");
				String sobrenomePaciente = sc.nextLine();

				System.out.print("Informe a temperatura do paciente: ");
				Double temperaturaPaciente = sc.nextDouble();

				System.out.print("O paciente está com tosse seca ? (S) ou (N): ");
				respostaSintomaCoronaVirus = sc.next().toUpperCase().charAt(0);

				if (respostaSintomaCoronaVirus == 'S') 
					sintomasPaciente.add(true);
				else
					sintomasPaciente.add(false);

				sc.nextLine();
				
				System.out.print("O paciente está com dificuldade respiratória? (S) ou (N): ");
				respostaSintomaCoronaVirus = sc.next().toUpperCase().charAt(0);

				if (respostaSintomaCoronaVirus == 'S') 
					sintomasPaciente.add(true);
				 else 
					sintomasPaciente.add(false);
				

				System.out.print("Deseja anotar alguma observação a respeito do paciente? (S) ou (N): ");
				opcaoResposta = sc.next().toUpperCase().charAt(0);

				sc.nextLine();
				
				if (opcaoResposta == 'S') {
					System.out.println("Digite abaixo suas observações sobre o paciente: ");
					observacao = sc.nextLine();
				} else 
					observacao = "Nenhuma observação";
				

				List<Boolean> sintomas =
						sintomasPaciente
						.stream()
						.filter(x -> x == true)
						.collect(Collectors.toList());

				if (sintomas.size() >= 2) {
					
					paciente = new Paciente(nomePaciente, sobrenomePaciente, temperaturaPaciente,
							sintomas, observacao);
					
					System.out.println("Será necessário internar o paciente: " + paciente.getNome());
					
					pacientesParaInternar.add(paciente);
					
					
					// Teste para ver se os dados estavam sendo preenchidos corretamente no objeto paciente
//					for(Paciente i : pacientesParaInternar) {
//						System.out.println(i.getId());
//						System.out.println(i.getNome());
//						System.out.println(i.getObservacoes());
//						System.out.println(i.getSobrenome());
//						System.out.println(i.getTemperatura());
//					}
					
					
				} else {
					paciente = new Paciente(nomePaciente, sobrenomePaciente, temperaturaPaciente,
							sintomasPaciente, observacao);
					
					System.out.println("O tratamento do paciente: " + paciente.getNome() + " poderá ser feito em casa.");
				}

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
