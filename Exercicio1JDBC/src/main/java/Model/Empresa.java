package Model;

public class Empresa {
    private String nome;
    private int id;
    private int qtdeFunc;
    private String local;


    public Empresa(String nome, int qtdeFunc, String local) {
        this.nome = nome;
        this.qtdeFunc = qtdeFunc;
        this.local = local;
    }

public Empresa(){

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

    public int getQtdeFunc() {
        return qtdeFunc;
    }

    public void setQtdeFunc(int qtdeFunc) {
        this.qtdeFunc = qtdeFunc;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
