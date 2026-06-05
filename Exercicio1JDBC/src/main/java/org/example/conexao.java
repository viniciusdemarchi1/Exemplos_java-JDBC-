
package org.example;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexao {
    public conexao() {
    }

    public static Connection conectar() {
        try {

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbexercicio", "root", "Vadmf0910.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog((Component)null, "erro na conexão " + e.getMessage());

            return null;
        }
    }
}
