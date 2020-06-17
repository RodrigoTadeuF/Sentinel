package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private String nome;
    private String endereco;
    private List<Paciente> leitos = new ArrayList<Paciente>(2);

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private List<Paciente> pacientes = new ArrayList<Paciente>();

    public Hospital() {  }
    
    public Hospital(String nome, String endereco) {
    	this.nome = nome;
    	this.endereco = endereco;
    }

    public Hospital(String nome, String endereco, List<Paciente> leitos, List<Funcionario> funcionarios, List<Paciente> pacientes) {
        this.nome = nome;
        this.endereco = endereco;
        this.leitos = leitos;
        this.funcionarios = funcionarios;
        this.pacientes = pacientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Paciente> getLeitos() {
        return leitos;
    }

    public void setLeitos(List<Paciente> leitos) {
        this.leitos = leitos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public List<Hospital>getHospitalByPlanoSaude(String nomePlanoSaude){
    	return null;
    }
    
    public void adicionaInternacao (Paciente p) {
    	if(leitos.size() < 40) {
    		leitos.add(p);
    	}
    	else {
    		System.out.println("Todos os leitos estão ocupados");
    	}	
    }
    
    public int leitosDisponiveis() {
    	int leitosDisponiveis = 40 - leitos.size();
    	return leitosDisponiveis;
    }


}
