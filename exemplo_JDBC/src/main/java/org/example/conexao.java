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
                    "mysqlfatec"

            );


        }catch (SQLException e){
            JOptionPane.showInputDialog(null,"erro na conexão");
            return null;
        }
    }
}
