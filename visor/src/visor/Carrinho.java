
package visor;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens = new ArrayList<Produto>();
    public void setitem(Produto p1){
        this.itens.add(p1);
    }
    public Produto getitem(){
    return this.itens.remove(0);
    }

    /**checa se o carrinho esta vazio**/
    public boolean carvazio(){
    return this.itens.isEmpty();}
    
}
