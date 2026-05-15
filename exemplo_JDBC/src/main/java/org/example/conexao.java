package org.example;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {
    public static Connection conectar(){

        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola",
                    "root",
                    ""

            );


        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"erro na conexão " + e.getMessage() );
            return null;
        }
    }
}
