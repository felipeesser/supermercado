
package supermercado;

public class supermercado {

 
    public static void main(String[] args) {
        estoque e1=new estoque();
        gerente g1=new gerente();
        g1.preenchestoque(e1);
        g1.declaraestoque(e1);
        cliente c1=new cliente();
        c1.adiciona_carrinho();
        c1.declaracarrinho();
    }
    
}
