package br.com.fiap.sentinel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlanoSaude {

	private static long id = GenerateId.generateId();
	private String nome;
	List<Paciente> pacientePlano = new ArrayList<Paciente>();
	List<RedeHospitalar> hospitaisPlano = new ArrayList<RedeHospitalar>();

	public PlanoSaude() {
	}

	public PlanoSaude(String nome, List<Paciente> pacientePlano, List<RedeHospitalar> hospitaisPlano) {
		this.nome = nome;
		this.pacientePlano = pacientePlano;
		this.hospitaisPlano = hospitaisPlano;
	}

	public PlanoSaude(String plano) {

		this.nome = plano;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Paciente> getPacientePlano() {
		return pacientePlano;
	}

	public void setPacientePlano(List<Paciente> pacientePlano) {
		this.pacientePlano = pacientePlano;
	}

	public List<RedeHospitalar> getHospitaisPlano() {
		return hospitaisPlano;
	}

	public void setHospitaisPlano(List<RedeHospitalar> hospitaisPlano) {
		this.hospitaisPlano = hospitaisPlano;
	}

	

}
