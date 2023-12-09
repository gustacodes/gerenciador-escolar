package com.gerenciador.gerenciadorescolar.controller;

import com.gerenciador.gerenciadorescolar.model.Aluno;
import com.gerenciador.gerenciadorescolar.repositorie.AlunoRepository;
import com.gerenciador.gerenciadorescolar.service.AlunoService;
import com.gerenciador.gerenciadorescolar.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CadastraAlunoController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField genero;

    @FXML
    private TextField idade;

    @FXML
    private TextField nome;

    @FXML
    private TextField turma;
    Telas tela = new Telas();

    private AlunoService service;

    public CadastraAlunoController() {
        AlunoRepository alunoRepository = new AlunoRepository();
        this.service = new AlunoService(alunoRepository);
    }

    @FXML
    void cadastrarAluno(ActionEvent event) throws SQLException, IOException {
        var novoAluno = new Aluno(null, nome.getText(), turma.getText(), idade.getText(), genero.getText());
        service.salvarAluno(novoAluno);
        tela.telas("principal", "Gerenciador de alunos");
        fecharStage();
    }

    @FXML
    void fecharStage() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

}