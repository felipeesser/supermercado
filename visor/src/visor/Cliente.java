
package visor;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cliente {
    private String forma_pag;
    private float carteira;
    private Carrinho meucarrinho;
    public float getCarteira() {
        return carteira;
    }
    public String getformapag(){
    return this.forma_pag;
    }
    public void setformapag(String pagamento){
    this.forma_pag=pagamento;
    }
    public Carrinho getcarrinho(){
    return this.meucarrinho;
    }
    public void setcarrinho(Carrinho car){
    this.meucarrinho=car;
    }
    
    public void adiciona_carrinho(Estoque e1,int ncliente,BuscaPreco bp){//adiciona produtos no carrinho de um
                                                                         //a partir de um arquivo
        try{
         
       InputStreamReader in;
       BufferedReader buf;
       try (FileInputStream arq = new FileInputStream("compras.txt")) {
           in = new InputStreamReader(arq);
           buf = new BufferedReader(in);
           String linha;
           int i=0;
           int cont=0;
           int cont2=0;
           Produto p1=new Produto();
           Carrinho c1=new Carrinho();
           do{linha=buf.readLine();
               if(linha!=null){
                   if(linha.equals("#")){
                   cont2++;
                   if(cont2>ncliente+1)break;
                   i=0;
                   cont=1;
                   }
                   if(cont2==ncliente+1){
                       if(i==1){
                           if(linha.equals("cartao")){
                           this.forma_pag=linha;
                   
                           linha=buf.readLine();
                           cont=2;}
                           else{this.forma_pag=linha;
                    
                           linha=buf.readLine();
                           this.carteira=Float.valueOf(linha);
                  
                           cont=2;
                           }
                           
                    }
                   if(i==2){
                       if(linha.equals("verifica")){
                           linha=buf.readLine();
                           bp.consulta_preco(linha,e1);
                           cont=3;
                   }else{
                           linha=buf.readLine();
                            cont=3;
                       }}
                   if(i==3){p1.setnome(linha);
                   cont=4;
                   }
                   if(i==4){p1.setqnt(Integer.valueOf(linha));
                   cont=5;
                   }
                   if(cont==5){c1.setitem(p1);
                       cont=3;
                   }
                   i=cont;
                   if(i==3){
                    p1=new Produto();
                   }
               }}
           }while(linha!=null);
           this.setcarrinho(c1);
       }
       in.close();
       buf.close();
        }catch(IOException | NumberFormatException e){
            System.out.println("erro");
       }
    }
}
