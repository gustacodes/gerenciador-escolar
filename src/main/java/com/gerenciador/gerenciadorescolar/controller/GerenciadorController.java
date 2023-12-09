package com.gerenciador.gerenciadorescolar.controller;

import com.gerenciador.gerenciadorescolar.model.Aluno;
import com.gerenciador.gerenciadorescolar.notificacoes.Notificacoes;
import com.gerenciador.gerenciadorescolar.repositorie.AlunoRepository;
import com.gerenciador.gerenciadorescolar.service.AlunoService;
import com.gerenciador.gerenciadorescolar.view.Telas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GerenciadorController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Aluno> tb_alunos;

    @FXML
    private TableColumn<Aluno, String> nome;

    @FXML
    private TableColumn<Aluno, String> genero;

    @FXML
    private TableColumn<Aluno, Integer> idade;

    @FXML
    private TableColumn<Aluno, Long> matricula;

    @FXML
    private TableColumn<Aluno, String> turma;

    private AlunoService service;

    private Telas tela = new Telas();

    public GerenciadorController() {
        AlunoRepository alunoRepository = new AlunoRepository();
        this.service = new AlunoService(alunoRepository);
    }

    @FXML
    void alterar(ActionEvent event) throws IOException {
        SelectionModel<Aluno> selectionModel = tb_alunos.getSelectionModel();
        Aluno aluno = selectionModel.getSelectedItem();

        if (aluno == null) {
            Notificacoes.alunoNaoSelecionado("Nenhum aluno selecionado");
        } else {
            AlteraAlunoController.ID = aluno.getMatricula();
            AlteraAlunoController.aluno = aluno;
        }

        tela.telas("alterar", "Alterar cadastro");
        fecharStage();
    }

    @FXML
    void cadastar(ActionEvent event) throws IOException {
        tela.telas("aluno", "Cadastrar aluno");
        fecharStage();
    }

    @FXML
    void remover(ActionEvent event) throws SQLException, IOException {
        SelectionModel<Aluno> selectionModel = tb_alunos.getSelectionModel();
        Aluno aluno = selectionModel.getSelectedItem();

        if (aluno == null) {
            Notificacoes.alunoNaoSelecionado("Nenhum aluno selecionado");
        } else {
            fecharStage();
            service.removerAluno(aluno.getMatricula());
            tela.telas("principal", "Gerenciador de alunos");
        }
    }

    @FXML
    void fecharStage() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Aluno> aluno = null;
        try {
            aluno = service.listarAlunos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        matricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        turma.setCellValueFactory(new PropertyValueFactory<>("turma"));
        genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        idade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        tb_alunos.setItems(aluno);
    }
}
