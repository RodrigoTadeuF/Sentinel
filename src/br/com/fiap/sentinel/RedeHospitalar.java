package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;

public class RedeHospitalar {

    private String nome;
    private String responsavel;
    private List<String> cidadesCobertura = new ArrayList<String>();
    private List<String> estadosCobertura = new ArrayList<String>();

    private List<Hospital> hospitais = new ArrayList<Hospital>();

    public RedeHospitalar() {  }
    
    public RedeHospitalar(String nome, String responsavel) { 
    	this.nome = nome;
    	this.responsavel = responsavel;
    }

    public RedeHospitalar(String nome, String responsavel, List<String> cidadesCobertura, List<String> estadosCobertura, List<Hospital> hospitais) {
        this.nome = nome;
        this.responsavel = responsavel;
        this.cidadesCobertura = cidadesCobertura;
        this.estadosCobertura = estadosCobertura;
        this.hospitais = hospitais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public List<String> getCidadesCobertura() {
        return cidadesCobertura;
    }

    public List<String> getEstadosCobertura() {
        return estadosCobertura;
    }


    public List<Hospital> getHospitais() {
        return hospitais;
    }

    public void setHospitais(List<Hospital> hospitais) {
        this.hospitais = hospitais;
    }

    public void adicionaCidade(String cidade) {
        cidadesCobertura.add(cidade);
    }

    public void adicionaEstado(String estado) {
        estadosCobertura.add(estado);
    }
}
