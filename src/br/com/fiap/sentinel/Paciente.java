package br.com.fiap.sentinel;

public class Paciente {

    private Long id;
    private String nome;
    private String sobrenome;
    private Integer temperatura;
    private Boolean tosse;
    private Boolean dificuldadeRespiratoria;
    private String observacoes;

    public Paciente() { }

    public Paciente(Long id, String nome, String sobrenome, Integer temperatura, Boolean tosse, Boolean dificuldadeRespiratoria, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.temperatura = temperatura;
        this.tosse = tosse;
        this.dificuldadeRespiratoria = dificuldadeRespiratoria;
        this.observacoes = observacoes;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Boolean getTosse() {
        return tosse;
    }

    public void setTosse(Boolean tosse) {
        this.tosse = tosse;
    }

    public Boolean getDificuldadeRespiratoria() {
        return dificuldadeRespiratoria;
    }

    public void setDificuldadeRespiratoria(Boolean dificuldadeRespiratoria) {
        this.dificuldadeRespiratoria = dificuldadeRespiratoria;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
