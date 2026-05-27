
package Model;
import javax.swing.*;
import java.time.LocalDate;

import org.example.conexao;
import javax.swing.JOptionPane;
import java.sql.Connection;

import DAO.EmpresaDAO;
import DAO.FuncionarioDAO;
import Model.Funcionario;
import Model.Empresa;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Connection conn = conexao.conectar();


        EmpresaDAO empresaDAO = new EmpresaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        int opcao;

        do {

            String menu = """
                    1 - Cadastrar empresa
                    2 - Cadastrar funcionário
                    3 - Consultar empresa
                    4 - Consultar funcionário
                    5 - Sair
                    
                    Escolha uma opção:
                    """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {

                case 1:

                    Empresa empresa = new Empresa();

                    empresa.setNome(
                            JOptionPane.showInputDialog("Digite o nome da empresa:")
                    );

                    empresa.setQtdeFunc(
                            Integer.parseInt(
                                    JOptionPane.showInputDialog("Digite a quantidade de funcionários:")
                            )
                    );

                    empresa.setLocal(
                            JOptionPane.showInputDialog("Digite o endereço da empresa:")
                    );

                    empresaDAO.cadastrarEmpresa(empresa);

                    break;
                case 2:
                    Funcionario funcionario = new Funcionario();

                    funcionario.setNome(
                            JOptionPane.showInputDialog("Digite o nome do funcionário:")
                    );

                    String dataTexto = JOptionPane.showInputDialog(
                            "Digite a data (AAAA-MM-DD):"
                    );
                    funcionario.setData_nasc(java.sql.Date.valueOf(LocalDate.parse(dataTexto)));

                    funcionario.setId(
                            Integer.parseInt(
                                    JOptionPane.showInputDialog("Digite o código da empresa:")
                            )
                    );

                    funcionarioDAO.cadastrarFuncionario(funcionario);

                    break;

                case 3:
                    String nomeEmpresa = JOptionPane.showInputDialog(
                            "Digite o nome da empresa:"
                    );

                    empresaDAO.consultar(nomeEmpresa);

                    break;

                case 4:
                    String nomeFuncionario = JOptionPane.showInputDialog(
                            "Digite o nome do funcionário:"
                    );

                    funcionarioDAO.consultar(nomeFuncionario);

                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 5);
    }
}



