package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO {

    public void cadastrar(Aluno aluno) {
        Connection conn = conexao.conectar();
        String sql = "INSERT INTO aluno (nome, idade)" + "VALUES(?,?)";



        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Aluno cadastrado com sucesso");
            stmt.close();
            conn.close();

        } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"Erro:" + e.getMessage());
        }

        }
    public void consultar(String nomeBusca){
        Connection conn = conexao.conectar();
        String sql = "SELECT * FROM aluno WHERE nome = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nomeBusca);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
              String resultado = "NOME: " + rs.getString("nome")+
              "\nIdade: " + rs.getInt("idade");
              JOptionPane.showMessageDialog(null,resultado);
            }else{
                JOptionPane.showMessageDialog(null,"Aluno não encontrado");
            }
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());

        }
    }



}
