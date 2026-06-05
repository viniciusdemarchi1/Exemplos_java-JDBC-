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
    String sql = "INSERT INTO empresa (nome,qtd_func,local )VALUES(?,?,?)";

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
                                "\nQTD_FUNC: "+rs.getInt("qtd_func") +
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

    public void alterar(Empresa empresa){
        try (Connection conn = conexao.conectar()) {
            if (conn == null) {
                return;
            }
    String sql = "update empresa set nome = ?, qtd_func = ? , local = ? where id = ?";


        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, empresa.getNome());
            stmt.setInt(2, empresa.getQtdeFunc());
            stmt.setString(3, empresa.getLocal());
            stmt.setInt(4, empresa.getId());

            int linhasModificadas = stmt.executeUpdate();

            if (linhasModificadas > 0) {
                JOptionPane.showMessageDialog(null, "Empresa alterada com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Empresa não encontrada");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    }
    }

public void excluir(int id){

    try (Connection conn = conexao.conectar()) {
        if (conn == null) {
            return;
        }
        String sqlVerifica = "select count(*) as total from funcionario where empresa = ?";
        String sqlDelete = "delete from empresa where id = ?";


        try (PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica)) {
            stmtVerifica.setInt(1, id);

            try (ResultSet rs = stmtVerifica.executeQuery()) {
                if (rs.next() && rs.getInt("total") > 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Não foi possível remover: existem funcionários vinculados a esta empresa."
                    );
                    return;
                }
            }
        }

        try (PreparedStatement stmtDelete = conn.prepareStatement(sqlDelete)) {
            stmtDelete.setInt(1, id);

            int linhasAfetadas = stmtDelete.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Empresa removida com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Empresa não encontrada");
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    }
}


}






