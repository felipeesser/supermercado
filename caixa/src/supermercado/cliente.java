
package supermercado;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class cliente extends leitor {
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
    
    public void adiciona_carrinho(estoque e1,int ncliente){
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
           produto p1=new produto();
           carrinho c1=new carrinho();
           do{linha=buf.readLine();
               if(linha!=null){
                   if(linha.equals("#")){
                   cont2++;
                   if(cont2>ncliente)break;
                   i=0;
                   cont=1;
                   }
                   if(cont2==ncliente){
                   if(i==1){
                       if(linha.equals("verifica")){
                           linha=buf.readLine();
                           this.consulta_preco(linha,e1);
                           cont=2;
                   }else{
                           linha=buf.readLine();
                            cont=2;
                       }}
                   if(i==2){p1.setnome(linha);
                   cont=3;
                   }
                   if(i==3){p1.setqnt(Integer.valueOf(linha));
                   cont=4;
                   }
                   if(cont==4){c1.setitem(p1);
                       cont=2;
                   }
                   i=cont;
                   if(i==2){
                    p1=new produto();
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
    public void declaracarrinho(){
    while(!this.meucarrinho.carvazio()){
        produto k=this.meucarrinho.getitem();
    System.out.println(k.getnome());
    System.out.println(k.getqnt());
    }
    }
}
