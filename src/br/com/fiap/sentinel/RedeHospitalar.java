package br.com.fiap.sentinel;

import java.util.ArrayList;
import java.util.List;

public class RedeHospitalar {

    private String nome;
    private String responsavel;
    private List<String> cidadesCobertura = new ArrayList<String>();
    private List<String> estadosCobertura = new ArrayList<String>();
    private String cidadeOrigem;

    private List<Hospital> hospitais = new ArrayList<Hospital>();

}
