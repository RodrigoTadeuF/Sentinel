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
		Hospital hospital = null;
		RedeHospitalar redeHospitalar = null;
		
		List<Boolean> sintomasPaciente = new ArrayList<Boolean>();
		List<Funcionario> funcionariosHospital = new ArrayList<Funcionario>();
		List<Paciente>filaAtendimentoPaciente = new ArrayList<Paciente>();
		List<Paciente>pacientesParaInternar = new ArrayList<Paciente>();
		List<RedeHospitalar>redesHospitalares = new ArrayList<RedeHospitalar>();
		List<Hospital>hospitais = new ArrayList<Hospital>();
		List<PlanoSaude>planoSaudeL = null;
		

		while (opcao != 0) {
			System.out.println("Selecione uma das opções abaixo para utilizar o sistema:");
			System.out.println("Digite 1 para cadastrar um funcionário");
			System.out.println("Digite 2 para cadastrar um hospital");
			System.out.println("Digite 3 para cadastrar uma rede");
			System.out.println("Digite 4 para cadastrar um paciente");
			System.out.println("Digite 5 para ver os hospitais que o plano atende");
			System.out.println("Digite 6 para atender um paciente");
			System.out.println("Digite 7 para ver a quantidade de leitos disponíveis");
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

				System.out.print("Digite o email do funcionário: ");
				String emailFuncionario = sc.nextLine();

				System.out.print("Digite o cargo do funcionário: ");
				String cargoFuncionario = sc.nextLine();

				funcionario = new Funcionario(primeiroNomeFuncionario, sobrenomeFuncionario, emailFuncionario,
						cargoFuncionario);

				funcionariosHospital.add(funcionario);

				break;

			case 2:
				String nomeHospital, endereco;

				System.out.println("Digite o nome do hospital: ");
				nomeHospital = sc.nextLine();

				System.out.println("Digite o endereço do hospital: ");
				endereco = sc.nextLine();
				
				hospital = new Hospital(nomeHospital, endereco);
				
				hospitais.add(hospital);
				
//				Teste para validar os dados do hospital
//				System.out.println(hospital.getNome());
//				System.out.println(hospital.getEndereco());
				
				break;

			case 3:
				String nomeRede, responsavel, cidade, estado, cidades, estados;

				redeHospitalar = new RedeHospitalar();

				System.out.print("Digite o nome da rede: ");
				nomeRede = sc.nextLine();

				System.out.print("Digite o nome do responsável: ");
				responsavel = sc.nextLine();
				
				redeHospitalar = new RedeHospitalar(nomeRede, responsavel);

				System.out.print("A rede atende mais de uma cidade?");
				cidade = sc.nextLine();
				cidade = cidade.toUpperCase();

				if (cidade.equals("SIM")) {
					while (cidade.equals("SIM")) {
						System.out.print("Digite o nome da cidade: ");
						cidades = sc.nextLine();
						redeHospitalar.adicionaCidade(cidades);
						System.out.print("A rede atende mais alguma cidade?");
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
						System.out.print("Digite o nome da estado: ");
						estados = sc.nextLine();
						redeHospitalar.adicionaEstado(estados);
						System.out.print("A rede atende mais algum estado?");
						estado = sc.nextLine();
						estado = estado.toUpperCase();
					}
				} else {
					System.out.print("Digite o nome do estado: ");
					estados = sc.nextLine();
					redeHospitalar.adicionaCidade(estados);
				}
				
				System.out.print("Informe o número dos hospitais que deseja vincular a essa rede: ");
				
				long opcaoHospital = 0;
				
				if(hospitais.size()==0) {
					System.out.println("Não há hospitais cadastrados no banco para vincular a essa rede");
				}
				else {
					for (Hospital hosp : hospitais) {
						System.out.println(hosp.getId() + " - " + hosp.getNome());
					}
					opcaoHospital = sc.nextLong();
					
				    Hospital hospitalFiltrado = hospital.getById(hospitais, opcaoHospital);
				    
				    List<Hospital>hospitalL = new ArrayList<Hospital>();
				    
				    if(!(hospitalFiltrado==null)) {
				    	hospitalL.add(hospitalFiltrado);
				    	redeHospitalar.setHospitais(hospitalL);
				    	
				    	System.out.println("Hospital " + hospitalFiltrado.getNome() + " adicionado a rede hospitalar: " + redeHospitalar.getNome());
				    	
				    }else {
				    	System.out.println("Não foram encontrados hospitais cadastrados em nossa base de dados. ");
				    }	
				}
				
//				Testes para checar o cadastro da rede
//				System.out.println(redeHospitalar.getNome());
//				System.out.println(redeHospitalar.getResponsavel());
//				System.out.println(redeHospitalar.getCidadesCobertura());
//				System.out.println(redeHospitalar.getEstadosCobertura());

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

				paciente = new Paciente(nomePaciente, sobrenomePaciente, temperaturaPaciente,
							sintomas, observacao);
				
				filaAtendimentoPaciente.add(paciente);
				
//				Teste do preenchimento da lista
//				for (Paciente p : filaAtendimentoPaciente) {
//					System.out.println(p.getId());
//					System.out.println(p.getNome());
//					System.out.println(p.getSobrenome());
//					System.out.println(p.getSintomasPaciente());
//					System.out.println(p.getObservacoes());
//				}
				
//				if (sintomas.size() >= 2) {
//					
//					paciente = new Paciente(nomePaciente, sobrenomePaciente, temperaturaPaciente,
//							sintomas, observacao);
//					
//					System.out.println("Será necessário internar o paciente: " + paciente.getNome());
//					
//					pacientesParaInternar.add(paciente);
					
					
					// Teste para ver se os dados estavam sendo preenchidos corretamente no objeto paciente
//					for(Paciente i : pacientesParaInternar) {
//						System.out.println(i.getId());
//						System.out.println(i.getNome());
//						System.out.println(i.getObservacoes());
//						System.out.println(i.getSobrenome());
//						System.out.println(i.getTemperatura());
//					}
					
					
//				} else {
//					paciente = new Paciente(nomePaciente, sobrenomePaciente, temperaturaPaciente,
//							sintomasPaciente, observacao);
//					
//					System.out.println("O tratamento do paciente: " + paciente.getNome() + " poderá ser feito em casa.");
//				}

				break;

			case 5:
				break;

			case 6:
				System.out.println();
				System.out.println("Bem vindo a central de atendimento");
				System.out.println();
				
				String respostaInternacao;
				
				if(!filaAtendimentoPaciente.isEmpty()) {
					Paciente atendimento = null;
					atendimento = filaAtendimentoPaciente.get(0);
					System.out.println(atendimento.getNome());
					System.out.println(atendimento.getSobrenome());
					System.out.println(atendimento.getSintomasPaciente());
					System.out.println(atendimento.getObservacoes());
					
					System.out.println("Dado o cenário do paciente deseja interná-lo?");
					respostaInternacao = sc.nextLine();
					respostaInternacao = respostaInternacao.toUpperCase();
					
					if(respostaInternacao.equals("SIM")) {
						hospital.adicionaInternacao(atendimento);
					}
					
//					Paciente internado = null;
//					internado = hospital.getLeitos().get(0);
//					System.out.println(internado.getNome());
					filaAtendimentoPaciente.remove(0);
					
				} else {
					System.out.println("Não há pacientes para serem atendidos");
				}
				
				
				break;

			case 7:
				System.out.printf("O hospital possui %s leitos disponíveis", hospital.leitosDisponiveis());
				System.out.println();
				break;

			case 8:
				break;

			case 0:
				System.out.println("Obrigado por utilizar nosso sistema!");
				System.exit(0);
				break;

			default:
				System.out.println("Por favor, digite uma opção válida");
			}
		}

		sc.close();
	}
}
