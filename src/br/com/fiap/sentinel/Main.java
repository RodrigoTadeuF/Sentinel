package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcao = -1;

		JOptionPane.showMessageDialog(null, "BEM VINDO AO SENTINELS");

		Funcionario funcionario = null;
		Paciente paciente = null;
		Hospital hospital = null;
		RedeHospitalar redeHospitalar = null;

		List<Boolean> sintomasPaciente = new ArrayList<Boolean>();
		List<Funcionario> funcionariosHospital = new ArrayList<Funcionario>();
		List<Paciente> filaAtendimentoPaciente = new ArrayList<Paciente>();
		List<RedeHospitalar> redesHospitalares = new ArrayList<RedeHospitalar>();
		List<Hospital> hospitais = new ArrayList<Hospital>();
		List<PlanoSaude> planoSaudeL = new ArrayList<PlanoSaude>();

		int dialogButton = 0;

		while (opcao != 0) {
			opcao = Integer
					.parseInt(JOptionPane.showInputDialog("Selecione uma das opções abaixo para utilizar o sistema:"
							+ "\n" + " - Digite 1 para cadastrar um funcionário" + "\n"
							+ " - Digite 2 para cadastrar um hospital" + "\n" +
							" - Digite 3 para cadastrar uma rede"
							+ "\n" + " - Digite 4 para cadastrar um plano de saúde" + "\n"
							+ " - Digite 5 para cadastrar um paciente" + "\n"
							+ " - Digite 6 para atender um paciente" + "\n"
							+ " - Digite 7 para ver a quantidade de leitos disponíveis" + "\n"
							+ " - Digite 8 para liberar um paciente" + "\n" + " - Digite 0 para sair"));

			switch (opcao) {
			case 1:
				String primeiroNomeFuncionario = JOptionPane.showInputDialog("Digite o primeiro nome do funcionário: ");

				String sobrenomeFuncionario = JOptionPane.showInputDialog("Digite o sobrenome do funcionário");

				String emailFuncionario = JOptionPane.showInputDialog("Digite o email do funcionário");

				String cargoFuncionario = JOptionPane.showInputDialog("Digite o cargo do funcionário");

				funcionario = new Funcionario(primeiroNomeFuncionario, sobrenomeFuncionario, emailFuncionario,
						cargoFuncionario);

				funcionariosHospital.add(funcionario);

				break;

			case 2:
				String nomeHospital, endereco;

				nomeHospital = JOptionPane.showInputDialog("Digite o nome do hospital");

				endereco = JOptionPane.showInputDialog("Digite o endereço do hospital");

				hospital = new Hospital(nomeHospital, endereco);

				hospitais.add(hospital);

				break;

			case 3:

				int opt = -1;

				while (opt < 0) {
					String nomeRede, responsavel, cidades, estados;

					List<Hospital> hospitaisDaRede;

					redeHospitalar = new RedeHospitalar();

					nomeRede = JOptionPane.showInputDialog("Digite o nome da rede");

					responsavel = JOptionPane.showInputDialog("Digite o nome do responsável");

					redeHospitalar = new RedeHospitalar(nomeRede, responsavel);

					cidades = JOptionPane.showInputDialog("Digite o nome da cidade: ");

					dialogButton = JOptionPane.showConfirmDialog(null, "A rede atende mais de uma cidade?");

					while (dialogButton == JOptionPane.YES_OPTION) {

						cidades = JOptionPane.showInputDialog("Digite o nome da cidade: ");

						redeHospitalar.adicionaCidade(cidades);

						dialogButton = JOptionPane.showConfirmDialog(null, "A rede atende mais de uma cidade?");

					}

					estados = JOptionPane.showInputDialog("Digite o nome da estado: ");

					dialogButton = JOptionPane.showConfirmDialog(null, "A rede atende mais de um estado?");

					while (dialogButton == JOptionPane.YES_OPTION) {
						while (dialogButton == JOptionPane.YES_OPTION) {
							estados = JOptionPane.showInputDialog("Digite o nome da estado: ");

							redeHospitalar.adicionaEstado(estados);

							dialogButton = JOptionPane.showConfirmDialog(null, "A rede atende mais algum estado?");
						}
					}
					// estados = JOptionPane.showInputDialog("Digite o nome do estado: ");
					redeHospitalar.adicionaCidade(estados);

					do {
						for (Hospital hosp : hospitais)
							JOptionPane.showMessageDialog(null,
									"Hospitais cadastrados em nossa base: " + hosp.getId() + " - " + hosp.getNome() + "\n");

						String nomeDoHospital = JOptionPane
								.showInputDialog("Informe o nome do hospital que deseja vincular a essa rede: ");

						hospitaisDaRede = hospitais.stream().filter(x -> x.getNome().equals(nomeDoHospital))
								.collect(Collectors.toList());

//						Hospital hospRede = hospitaisDaRede.get(0);

						redeHospitalar.adicionarHospitais(hospitaisDaRede);
//						hospitais.remove(hospRede);

						dialogButton = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro Hospital na rede? ");

						redesHospitalares.add(redeHospitalar);
						opt = 0;

					} while (dialogButton == JOptionPane.YES_OPTION);
				}

				break;

			case 4:

			String nomePlanoSaude = JOptionPane.showInputDialog("Informe o nome do plano de saúde");

			PlanoSaude plano = new PlanoSaude(nomePlanoSaude);

			List<RedeHospitalar> redesFiltradas = null;

			if (redesHospitalares.size() > 0) {

				dialogButton = JOptionPane.showConfirmDialog(null, "Deseja vincular esse plano a alguma rede?");

				if (dialogButton == JOptionPane.YES_OPTION) {

					for (RedeHospitalar rede : redesHospitalares)
						JOptionPane.showMessageDialog(null,
								"Lista de redes hospitalares cadastradas em nossa base: " + rede.getId() + " - "
										+ rede.getNome() + "\n");

					String nomeRedePlano = JOptionPane
							.showInputDialog("Digite o nome da rede que deseja vincular a esse plano");

					redesFiltradas = redesHospitalares.stream().filter(x -> x.getNome().equals(nomeRedePlano))
							.collect(Collectors.toList());

					plano.setHospitaisPlano(redesFiltradas);

					JOptionPane.showMessageDialog(null,
							"Rede " + nomeRedePlano + " vinculada ao plano " + plano.getNome());
				}
				JOptionPane.showMessageDialog(null, "Obrigado! ");

			} 
			if (filaAtendimentoPaciente.size() > 0) {

				char opcaoPacientePlano = JOptionPane
						.showInputDialog("Deseja vincular pacientes a esse plano de saude? (S) ou (N)")
						.toUpperCase().charAt(0);

				if (opcaoPacientePlano == 'S') {
					for (Paciente p : filaAtendimentoPaciente)
						JOptionPane.showMessageDialog(null,
								"Pacientes vinculados a esse plano: " + p.getId() + " - " + p.getNome() + "\n");

					long pacienteId = Long.parseLong(JOptionPane.showInputDialog(
							"Informe o número correspondente ao paciente para vincular a esse plano"));

					Paciente p = filaAtendimentoPaciente.stream().filter(x -> x.getId() == pacienteId).findFirst()
							.orElse(null);

					if (!(p == null)) {
						JOptionPane.showMessageDialog(null,
								"Paciente " + p.getNome() + " agora faz parte do plano " + plano.getNome());
					} else {
						JOptionPane.showMessageDialog(null, "Paciente não encontrado!");
					}
				}

			} else {
				JOptionPane.showMessageDialog(null, "Nenhum paciente cadastrado em nossa base de dados.");
			}

			planoSaudeL.add(plano);

			break;

			case 5:

				String observacao = "";

				String nomePaciente = JOptionPane.showInputDialog("Informe o primeiro nome do paciente: ");

				String sobrenomePaciente = JOptionPane.showInputDialog("Informe o sobrenome do paciente: ");

				Double temperaturaPaciente = Double
						.parseDouble(JOptionPane.showInputDialog("Informe a temperatura do paciente: "));
				
				if(temperaturaPaciente>=37) {
					sintomasPaciente.add(true);
				}
				
				dialogButton = JOptionPane.showConfirmDialog(null, "O paciente está com tosse seca ? (S) ou (N): ");

				if (dialogButton == JOptionPane.YES_OPTION)
					sintomasPaciente.add(true);
				else
					sintomasPaciente.add(false);

				dialogButton = JOptionPane.showConfirmDialog(null, "O paciente está com dificuldade respiratória?");

				if (dialogButton == JOptionPane.YES_OPTION)
					sintomasPaciente.add(true);
				else
					sintomasPaciente.add(false);

				dialogButton = JOptionPane.showConfirmDialog(null,
						"Deseja anotar alguma observação a respeito do paciente?");

				if (dialogButton == JOptionPane.YES_OPTION) {
					observacao = JOptionPane.showInputDialog("Digite abaixo suas observações sobre o paciente: ");
				} else
					observacao = "Nenhuma observação";

				List<Boolean> sintomas = sintomasPaciente.stream().filter(x -> x == true).collect(Collectors.toList());

				paciente = new Paciente(nomePaciente, sobrenomePaciente, temperaturaPaciente, sintomas, observacao);
				
				if(sintomas.size()>=2) {
					filaAtendimentoPaciente.add(paciente);
					JOptionPane.showMessageDialog(null, "O paciente " + paciente.getNome() + " precisar� ser internado. Iremos adicion�-lo na fila de atendimento.");
				}else {
					JOptionPane.showMessageDialog(null, "O paciente " + paciente.getNome() + " poder� realizar o tratamento em casa e n�o precisar� ser internado.");
				}
				sintomas = new ArrayList<Boolean>();
				sintomasPaciente = new ArrayList<Boolean>();

				break;

			case 6:
				JOptionPane.showMessageDialog(null, "Bem vindo a central de atendimento");

				if (!filaAtendimentoPaciente.isEmpty()) {
					Paciente atendimento = null;
					atendimento = filaAtendimentoPaciente.get(0);
					
					String resultado = "";
					
					for(Boolean b : atendimento.getSintomasPaciente()) {
						if(b==true) 
							resultado = "Possui todos os sintomas " + "\n";
						
					}
					
					JOptionPane.showMessageDialog(null, atendimento.getId() + "\n" +

							atendimento.getNome() + "\n" + atendimento.getSobrenome() + "\n" + "\n" + atendimento.getTemperatura()
							+ resultado + "\n" + atendimento.getObservacoes());

					dialogButton = JOptionPane.showConfirmDialog(null, "Dado o cenário do paciente deseja interná-lo?");

					if (dialogButton == JOptionPane.YES_OPTION) {
						hospital.adicionaInternacao(atendimento);
					}

					JOptionPane.showMessageDialog(null, filaAtendimentoPaciente.get(0).getNome());

					filaAtendimentoPaciente.remove(0);

				} else {
					JOptionPane.showMessageDialog(null, "Não há pacientes para serem atendidos");
				}

				break;

			case 7:
				JOptionPane.showMessageDialog(null,
						String.format("O hospital possui %s leitos disponíveis", hospital.leitosDisponiveis()));
				break;

			case 8:
				String nomeDoPaciente = JOptionPane.showInputDialog(null, String.format("Digite o nome do paciente que deseja retirar do leito"));
				hospital.removeInternado(nomeDoPaciente);
				break;

			case 0:
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar nosso sistema!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Por favor, digite uma opção válida");
			}
		}

		sc.close();
	}
}
