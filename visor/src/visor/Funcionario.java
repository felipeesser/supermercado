
package visor;

import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private ArrayList<Caixa> box= new ArrayList<Caixa>();
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Caixa getbox(int i) {
        return this.box.get(i);
    }
    public int tambox() {
        return this.box.size();
    }
    public void setbox(Caixa b1) {
        this.box.add(b1);
    }
}
