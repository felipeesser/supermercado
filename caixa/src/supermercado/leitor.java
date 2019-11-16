
package supermercado;

public abstract class leitor {
    public void consulta_preco(String p,estoque e1){
    System.out.println("Cliente consultou o preco do seguinte produto->");
    for(int i=0;i<e1.contagem();i++){
    if(p.equals(e1.getproduto(i).getnome())){
        System.out.println(e1.getproduto(i).getnome());
    System.out.println(e1.getproduto(i).getpreco());
    }
    }
    }
}
