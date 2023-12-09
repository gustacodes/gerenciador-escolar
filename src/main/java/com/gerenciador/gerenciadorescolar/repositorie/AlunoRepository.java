package com.gerenciador.gerenciadorescolar.repositorie;

import com.gerenciador.gerenciadorescolar.config.ConexaoDB;
import com.gerenciador.gerenciadorescolar.controller.AlteraAlunoController;
import com.gerenciador.gerenciadorescolar.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoRepository {

    public Aluno buscarAlunoPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM alunos WHERE matricula = (?)";
        var aluno = new Aluno();

            PreparedStatement stm = ConexaoDB.getConnection().prepareStatement(sql);
            stm.setLong(1, id);
            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()) {
                aluno = new Aluno(resultSet.getLong("matricula"), resultSet.getString("nome"), resultSet.getString("turma"), resultSet.getString("genero"), resultSet.getString("idade"));
            }


        return aluno;
    }

    public void salvarAluno(Aluno aluno) throws SQLException {

        String sql = "INSERT INTO alunos VALUES (?, ?, ?, ?, ?);";

        PreparedStatement stm = ConexaoDB.getConnection().prepareStatement(sql);

        stm.setLong(1, 0);
        stm.setString(2, aluno.getNome());
        stm.setString(3, aluno.getTurma());
        stm.setString(4, aluno.getGenero());
        stm.setString(5, aluno.getIdade());

        stm.execute();
        stm.close();
    }

    public ObservableList<Aluno> listarAlunos() throws SQLException {
        ObservableList<Aluno> aluno = FXCollections.observableArrayList();

        String sql = "SELECT * FROM alunos";

        PreparedStatement stm = ConexaoDB.getConnection().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            aluno.add(new Aluno(rs.getLong("matricula"), rs.getString("nome"), rs.getString("turma"), rs.getString("genero"), rs.getString("idade")));
        }

        return aluno;
    }

    public void atualizarAluno(Aluno aluno) throws SQLException {
        String sqlUpdate = "UPDATE alunos SET nome = (?), turma = (?), genero = (?), idade = (?) WHERE matricula = (?)";

        PreparedStatement stm = ConexaoDB.getConnection().prepareStatement(sqlUpdate);

        stm.setString(1, aluno.getNome());
        stm.setString(2, aluno.getTurma());
        stm.setString(3, aluno.getGenero());
        stm.setString(4, aluno.getIdade());
        stm.setLong(5, AlteraAlunoController.ID);

        stm.execute();
        stm.close();
    }

    public void removerAluno(Long matricula) throws SQLException {
        String sql = "DELETE FROM alunos WHERE matricula = (?)";

        PreparedStatement stm = ConexaoDB.getConnection().prepareStatement(sql);
        stm.setLong(1, matricula);
        stm.execute();
        stm.close();
    }

}
