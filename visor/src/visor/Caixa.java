
package visor;

import java.util.ArrayList;

public class Caixa {
    private ArrayList<Produto> vendas= new ArrayList<Produto>();

    public Produto getVendas(int i) {
        return this.vendas.get(i);
    }

    public void setVendas(Produto pro) {
        this.vendas.add(pro);
    }
}
