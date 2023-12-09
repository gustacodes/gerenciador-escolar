package com.gerenciador.gerenciadorescolar.config;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    private static String url = "jdbc:mysql://127.0.0.1:3306/dbalunos";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String usuario = "root";
    private static String senha = "admin";

    public static Connection getConnection() {

        Connection conexao = null;

        if (conexao == null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro na conexão com o banco");
            }

            try {
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro no login ou senha");
            }
        }

        return conexao;
    }
}
