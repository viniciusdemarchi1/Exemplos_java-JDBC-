//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package Model;

import org.example.conexao;

import javax.swing.JOptionPane;
import java.sql.Connection;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Connection conn = conexao.conectar();
    }
}
