package com.gerenciador.gerenciadorescolar.notificacoes;

import javafx.scene.control.Alert;

public class Notificacoes {

    public static void validaCamposNulos(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.setContentText("Preencha todos os campos.");
        alert.show();
    }

    public static void alunoNaoSelecionado(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(message);
        alert.setContentText("Selecione pelo menos um aluno para realizar a ação.");
        alert.show();
    }

}
