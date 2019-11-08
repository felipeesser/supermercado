
package supermercado;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class cliente {
    private String forma_pag;
    private float troco;
    private float carteira;
    private carrinho meucarrinho;
    public String getformapag(){
    return this.forma_pag;
    }
    public void setformapag(String pagamento){
    this.forma_pag=pagamento;
    }
    public carrinho getcarrinho(){
    return this.meucarrinho;
    }
    public void setcarrinho(carrinho car){
    this.meucarrinho=car;
    }
    
    public void adiciona_carrinho(){
        try{
       InputStreamReader in;
       BufferedReader buf;
       try (FileInputStream arq = new FileInputStream("compras.txt")) {
           in = new InputStreamReader(arq);
           buf = new BufferedReader(in);
           String linha;
           int i=0;
           int cont=0;
           produto p1=new produto();
           carrinho c1=new carrinho();
           do{linha=buf.readLine();
               if(linha!=null){
                   if(i==0){p1.setnome(linha);
                   cont=1;
                   }
                   if(i==1){p1.setqnt(Integer.valueOf(linha));
                   cont=2;
                   }
                   if(cont==2){c1.setitem(p1);
                       cont=0;
                   }
                   i=cont;
                   if(i==0){
                    p1=new produto();
                   }
               }
           }while(linha!=null);
           this.setcarrinho(c1);
       }
       in.close();
       buf.close();
        }catch(IOException | NumberFormatException e){
            System.out.println("erro");
       }
    }
    public void declaracarrinho(){
    while(!this.meucarrinho.carvazio()){
        produto k=this.meucarrinho.getitem();
    System.out.println(k.getnome());
    System.out.println(k.getqnt());
    }
    }
}
