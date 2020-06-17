package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private static Long id = 0l;
    private String nome;
    private String sobrenome;
    private Double temperatura;
    
    private List<Boolean>sintomasPaciente = new ArrayList<Boolean>(); 
    
    private String observacoes;

    public Paciente() { }

    public Paciente(String nome, String sobrenome, Double temperatura,List<Boolean>sintomasPaciente , String observacoes) {
    	generateId();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.temperatura = temperatura;
        this.sintomasPaciente = sintomasPaciente;
        this.observacoes = observacoes;
    }

    public static long generateId() {
    	Paciente.id = Paciente.id +1 ;
    	 return Paciente.id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
  
    public List<Boolean> getSintomasPaciente() {
		return sintomasPaciente;
	}
    
	public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
