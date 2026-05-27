package DAO;
import Model.Empresa;
import Model.Funcionario;
import org.example.conexao;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class FuncionarioDAO {
    public FuncionarioDAO() {
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        Connection conn = conexao.conectar();
        String sql = "INSERT INTO funcionario (nome,id,data,empresa )VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setInt(2, funcionario.getId());
            stmt.setInt(3, funcionario.getData_nasc());
            stmt.setString(4, funcionario.getEmpresa());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog((Component)null, "Empresa cadastrada com sucesso");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((Component)null, "Erro:" + e.getMessage());
        }
    }
}
