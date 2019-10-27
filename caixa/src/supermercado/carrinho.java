
package supermercado;
import java.util.ArrayList;

public class carrinho {
    private ArrayList<produto> itens = new ArrayList();
    public void setitem(produto p1){
        this.itens.add(p1);
    }
    public produto getitem(){
    return this.itens.remove(0);
    }
    public boolean carvazio(){
    return this.itens.isEmpty();}
    
}
