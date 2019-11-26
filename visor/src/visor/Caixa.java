
package visor;

import java.util.ArrayList;

public class Caixa {
    private ArrayList<Cliente> clientela= new ArrayList<Cliente>();
    private ArrayList<Funcionario> func= new ArrayList<Funcionario>();
    private String nomedocaixa;

    public String getNomedocaixa() {
        return nomedocaixa;
    }

    public void setNomedocaixa(String nomedocaixa) {
        this.nomedocaixa = nomedocaixa;
    }
    public Cliente getClientela(int i) {
        return this.clientela.get(i);
    }
    public int tamcliente() {
        return this.clientela.size();
    }
    public void setClientela(Cliente c1) {
        this.clientela.add(c1);
    }

    public Funcionario getfunc(int i) {
        return this.func.get(i);
    }
    public int tamfunc() {
        return this.func.size();
    }
    public void setfunc(Funcionario f1) {
        this.func.add(f1);
    }

}
