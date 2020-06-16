package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;

public class PlanoSaude {

    private String nome;
    List<Paciente> pacientePlano = new ArrayList<Paciente>();
    List<RedeHospitalar> hospitaisPlano = new ArrayList<RedeHospitalar>();

    public PlanoSaude() {  }

    public PlanoSaude(String nome, List<Paciente> pacientePlano, List<RedeHospitalar> hospitaisPlano) {
        this.nome = nome;
        this.pacientePlano = pacientePlano;
        this.hospitaisPlano = hospitaisPlano;
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
