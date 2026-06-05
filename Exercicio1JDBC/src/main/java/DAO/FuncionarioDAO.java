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
        String sql = "INSERT INTO funcionario (nome,data_nasc,id,empresa)VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,funcionario.getNome());
            stmt.setDate(2, new java.sql.Date(funcionario.getData_nasc().getTime()));
            stmt.setInt(3,funcionario.getId());
            stmt.setInt(4, funcionario.getEmpresa());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog((Component)null, "Funcionario cadastrado com sucesso ");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog((Component)null, "Erro:" + e.getMessage());
        }
    }



    public void consultar(String nomeBusca) {
        Connection conn = conexao.conectar();
        String sql = "select * from funcionario where nome = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nomeBusca);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String resultado =
                        "NOME: "+rs.getString("nome") +
                                "\nDATA: "+rs.getDate("data_nasc")+
                                "\nCOD_EMP: "+rs.getInt("id");

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
public void alterar(Funcionario funcionario) {
    try (Connection conn = conexao.conectar()) {
        if (conn == null) {
            return;
        }

        String sql = "update funcionario set nome = ?, data_nasc = ?, empresa = ? where id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setDate(2, new java.sql.Date(funcionario.getData_nasc().getTime()));
            stmt.setInt(3, funcionario.getEmpresa());
            stmt.setInt(4, funcionario.getId());

            int linhasModificadas = stmt.executeUpdate();

            if (linhasModificadas > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario alterado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Funcionario não encontrada");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    }
}

    public void remover(int id) {


        try (Connection conn = conexao.conectar()) {
            if (conn == null) {
                return;
            }

            String sql = "delete from funcionario where id = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);

                int linhasModifacadas = stmt.executeUpdate();

                if (linhasModifacadas > 0) {
                    JOptionPane.showMessageDialog(null, "Funcionario removido com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Funcionario não encontrada");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }



}
