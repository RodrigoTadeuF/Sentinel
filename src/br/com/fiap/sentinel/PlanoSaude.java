package br.com.fiap.sentinel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanoSaude {

	private static long id;
    private String nome;
    List<Paciente> pacientePlano = new ArrayList<Paciente>();
    List<RedeHospitalar> hospitaisPlano = new ArrayList<RedeHospitalar>();

    public PlanoSaude() {  }

    public PlanoSaude(String nome, List<Paciente> pacientePlano, List<RedeHospitalar> hospitaisPlano) {
    	generateId();
    	this.nome = nome;
        this.pacientePlano = pacientePlano;
        this.hospitaisPlano = hospitaisPlano;
    }
    
    
    public PlanoSaude(String plano) {
    	generateId(); 
    	this.nome = plano; 
    }

    public static long generateId() {
    	PlanoSaude.id = PlanoSaude.id + 1 ;
    	return PlanoSaude.id;
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
