package com.gerenciador.gerenciadorescolar.exceptions;

import com.gerenciador.gerenciadorescolar.notificacoes.Notificacoes;
import javafx.scene.control.Alert;

public class CadastroException extends RuntimeException {

    public CadastroException(String message) {
        super(message);
        Notificacoes.validaCamposNulos(message);
    }
}
