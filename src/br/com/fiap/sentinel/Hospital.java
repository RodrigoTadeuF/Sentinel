package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hospital {

    private Long id = GenerateId.generateId();
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
    
    public long getId() {
    	return id;
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
    
    public List<Hospital>getAll(List<Hospital>hospitalL){
    	 return hospitalL;
    }
    
    public Hospital getById(List<Hospital>hospitais,long id ) {
    	return hospitais.parallelStream().filter(x-> x.getId() == id).findFirst().orElse(null);
    }

    public void removeInternado(String nome) {
        List<Paciente> remocao = leitos.stream().filter(p -> p.getNome().equals(nome)).collect(Collectors.toList());
        Paciente removido = remocao.get(0);
        leitos.remove(removido);
        System.out.println("Paciente removido com sucesso!");
    }


}
