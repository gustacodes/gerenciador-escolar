package com.gerenciador.gerenciadorescolar.controller;

import com.gerenciador.gerenciadorescolar.model.Aluno;
import com.gerenciador.gerenciadorescolar.repositorie.AlunoRepository;
import com.gerenciador.gerenciadorescolar.service.AlunoService;
import com.gerenciador.gerenciadorescolar.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AlteraAlunoController implements Initializable {

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

    public static Long ID;
    public static Aluno aluno;

    private AlunoService service;

    public AlteraAlunoController() {
        AlunoRepository alunoRepository = new AlunoRepository();
        this.service = new AlunoService(alunoRepository);
    }

    @FXML
    void alterarAluno(ActionEvent event) throws SQLException, IOException {
        var atualizaAluno = new Aluno(ID, nome.getText(), turma.getText(), idade.getText(), genero.getText());
        service.alterarCadastroDoAluno(atualizaAluno);
        tela.telas("principal", "Gerenciador de alunos");
        fecharStage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nome.setText(aluno.getNome());
        idade.setText(aluno.getIdade());
        genero.setText(aluno.getGenero());
        turma.setText(aluno.getTurma());
    }

    @FXML
    void fecharStage() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}
