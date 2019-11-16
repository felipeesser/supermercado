
package supermercado;
import java.util.ArrayList;
public class estoque  {
    private ArrayList<produto> produtos = new ArrayList();
    public void setproduto(produto p1){
    this.produtos.add(p1);
    }
    public produto getproduto(int i){
    return this.produtos.get(i);
    }
    public int contagem(){
        return this.produtos.size();
    }
   }
