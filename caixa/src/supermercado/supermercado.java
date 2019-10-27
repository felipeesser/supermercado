
package supermercado;

public class supermercado {

 
    public static void main(String[] args) {
        estoque e1=new estoque();
        e1.preenchestoque();
        e1.declaraestoque();
        cliente c1=new cliente();
        c1.adiciona_carrinho();
        c1.declaracarrinho();
    }
    
}
