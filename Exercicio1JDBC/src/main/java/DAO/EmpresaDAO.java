package DAO;
import Model.Empresa;
import org.example.conexao;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class EmpresaDAO {
public EmpresaDAO() {
}

public void cadastrarEmpresa(Empresa empresa) {
    Connection conn = conexao.conectar();
    String sql = "INSERT INTO empresa (nome,id,qtdeFunc,local )VALUES(?,?,?,?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, empresa.getNome());
        stmt.setInt(2, empresa.getId());
        stmt.setInt(3, empresa.getQtdeFunc());
        stmt.setString(4, empresa.getLocal());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog((Component)null, "Empresa cadastrada com sucesso");
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog((Component)null, "Erro:" + e.getMessage());
    }
}

    public void consultarEmpresa() {
        Connection conn = conexao.conectar();
        String sql = "SELECT * FROM empresa = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String var10000 = rs.getString("nome");
                String resultado = "NOME: ";
                JOptionPane.showMessageDialog((Component)null, resultado);
            } else {
                JOptionPane.showMessageDialog((Component)null, "Empresa não encontrada");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((Component)null, "Erro: " + e.getMessage());
        }

    }



}
