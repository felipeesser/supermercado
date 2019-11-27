
package visor;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Produto> itens = new ArrayList<Produto>();//lista que contem objetos Produto
    public void setitem(Produto p1){
        this.itens.add(p1);
    }
    public Produto getitem(int i){
    return this.itens.get(i);
    }
    public int tamanhocarrinho(){
    return this.itens.size();}
    
}
