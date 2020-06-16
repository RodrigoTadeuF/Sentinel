package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;

public class Hospital {

    private String nome;
    private String endereco;
    private Integer[] leitos = new Integer[20];

    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private List<Paciente> pacientes = new ArrayList<Paciente>();

    public Hospital() {  }

    public Hospital(String nome, String endereco, Integer[] leitos, List<Funcionario> funcionarios, List<Paciente> pacientes) {
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

    public Integer[] getLeitos() {
        return leitos;
    }

    public void setLeitos(Integer[] leitos) {
        this.leitos = leitos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
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


}
