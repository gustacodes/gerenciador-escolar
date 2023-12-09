package com.gerenciador.gerenciadorescolar.model;

import javafx.collections.ObservableList;

public class Aluno {

    private Long matricula;
    private String nome;
    private String turma;
    private String idade;
    private String genero;

    public Aluno() {

    }

    public Aluno(Long matricula, String nome, String turma, String idade, String genero) {
        this.matricula = matricula;
        this.nome = nome;
        this.turma = turma;
        this.idade = idade;
        this.genero = genero;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
