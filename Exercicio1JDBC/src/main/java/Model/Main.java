
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
                    5 - Alterar empresa
                    6 - Alterar funcionario
                    7 - Excluir empresa
                    8 - Excluir funcionario
                    9 - Sair
                    
                    Escolha uma opção:
                    """;

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {

                case 1:
                    Empresa empresa = new Empresa();
                    empresa.setNome(JOptionPane.showInputDialog("Digite o nome da empresa:"));
                    empresa.setQtdeFunc(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de funcionários:")));
                    empresa.setLocal(JOptionPane.showInputDialog("Digite o endereço da empresa:"));

                    empresaDAO.cadastrarEmpresa(empresa);
                    break;

                case 2:
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(JOptionPane.showInputDialog("Digite o nome do funcionário:"));
                    String dataTexto = JOptionPane.showInputDialog("Digite a data de nascimento (AAAA-MM-DD):");
                    funcionario.setData_nasc(java.sql.Date.valueOf(LocalDate.parse(dataTexto)));
                    funcionario.setEmpresa(Integer.parseInt(JOptionPane.showInputDialog("Digite o código da empresa:")));

                    funcionarioDAO.cadastrarFuncionario(funcionario);
                    break;

                case 3:
                    String nomeEmpresa = JOptionPane.showInputDialog("Digite o nome da empresa:");
                    empresaDAO.consultar(nomeEmpresa);
                    break;

                case 4:
                    String nomeFuncionario = JOptionPane.showInputDialog("Digite o nome do funcionário:");
                    funcionarioDAO.consultar(nomeFuncionario);
                    break;

                case 5:
                    Empresa empAlterar = new Empresa();
                    empAlterar.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da empresa que deseja alterar:")));
                    empAlterar.setNome(JOptionPane.showInputDialog("Digite o novo nome da empresa:"));
                    empAlterar.setQtdeFunc(Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de funcionários:")));
                    empAlterar.setLocal(JOptionPane.showInputDialog("Digite o novo endereço da empresa:"));

                    empresaDAO.alterar(empAlterar);
                    break;

                case 6:
                    Funcionario funcAlterar = new Funcionario();
                    funcAlterar.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do funcionário que deseja alterar:")));
                    funcAlterar.setNome(JOptionPane.showInputDialog("Digite o novo nome do funcionário:"));
                    String dataTextoAlt = JOptionPane.showInputDialog("Digite a nova data de nascimento (AAAA-MM-DD):");
                    funcAlterar.setData_nasc(java.sql.Date.valueOf(LocalDate.parse(dataTextoAlt)));
                    funcAlterar.setEmpresa(Integer.parseInt(JOptionPane.showInputDialog("Digite o novo código da empresa:")));

                    funcionarioDAO.alterar(funcAlterar);
                    break;

                case 7:
                    int idEmpresaExcluir = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da empresa para remover:"));

                    empresaDAO.excluir(idEmpresaExcluir);
                    break;

                case 8:
                    int idFuncExcluir = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do funcionário para remover:"));

                    funcionarioDAO.remover(idFuncExcluir);
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 9);
    }
}