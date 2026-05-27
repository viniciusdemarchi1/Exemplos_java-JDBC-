package Model;

import java.sql.Date;

public class Funcionario {
    private String nome;
    private int id;
    private Date data_nasc;
    private int empresa;

    public Funcionario(String nome, int id, Date data_nasc, int empresa) {
        this.nome = nome;
        this.id = id;
        this.data_nasc = data_nasc;
        this.empresa = empresa;
    }

    public Funcionario(){

    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public Date getData_nasc() {

        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {

        this.data_nasc = data_nasc;
    }

    public int getEmpresa() {

        return empresa;
    }

    public void setEmpresa(int empresa) {

        this.empresa = empresa;
    }
}
