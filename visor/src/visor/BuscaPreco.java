
package visor;
public class BuscaPreco {
    public void consulta_preco(String p,Estoque e1){//Busca em um objeto estoque a partir do nome de um produto(String p)
                                                    //qual o seu valor, demonstra o resultado da busca no terminal
    System.out.println("Cliente consultou o preco do seguinte produto->");
    for(int i=0;i<e1.contagem();i++){
    if(p.equals(e1.getproduto(i).getnome())){
        System.out.println(e1.getproduto(i).getnome());
    System.out.println(e1.getproduto(i).getpreco());
    }
    }
    }
}
