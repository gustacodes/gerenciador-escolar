package com.gerenciador.gerenciadorescolar.service;

import com.gerenciador.gerenciadorescolar.exceptions.CadastroException;
import com.gerenciador.gerenciadorescolar.model.Aluno;
import com.gerenciador.gerenciadorescolar.repositorie.AlunoRepository;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void validarAluno(Aluno aluno) {
        if (aluno.getNome().isEmpty() || aluno.getGenero().isEmpty() || aluno.getIdade() == null || aluno.getTurma().isEmpty()) {
            throw new CadastroException("Falha ao cadastrar aluno");
        }
    }

    public void salvarAluno(Aluno aluno) throws SQLException {
        validarAluno(aluno);
        alunoRepository.salvarAluno(aluno);
    }

    public ObservableList<Aluno> listarAlunos() throws SQLException {
        return alunoRepository.listarAlunos();
    }

    public void alterarCadastroDoAluno(Aluno aluno) throws SQLException {
        alunoRepository.atualizarAluno(aluno);
    }

    public void removerAluno(Long matricula) throws SQLException {
        alunoRepository.removerAluno(matricula);
    }

}
