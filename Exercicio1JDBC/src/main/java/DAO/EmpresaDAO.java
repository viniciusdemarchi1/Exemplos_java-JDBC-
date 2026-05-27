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
    String sql = "INSERT INTO empresa (nome,qtdeFunc,local )VALUES(?,?,?)";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, empresa.getNome());;
        stmt.setInt(2, empresa.getQtdeFunc());
        stmt.setString(3, empresa.getLocal());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog((Component)null, "Empresa cadastrada com sucesso");
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog((Component)null, "Erro:" + e.getMessage());
    }
}

    public void consultar(String nomeBusca) {
        Connection conn = conexao.conectar();
        String sql = "select * from empresa where nome = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nomeBusca);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String resultado =
                        "NOME: "+rs.getString("nome") +
                                "\nQTD_FUNC: "+rs.getInt("qtde_func") +
                                "\nENDERECO: "+rs.getString("local");

                JOptionPane.showMessageDialog(null,resultado);
            } else {
                JOptionPane.showMessageDialog(null,"Empresa não encontrada");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro: "+e.getMessage());
        }
    }

    }




