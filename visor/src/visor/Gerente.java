
package visor;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class Gerente {

    /**preenche o estoque inserindo novos produtos, com nome, preço e quantidade**/
    public void preenchestoque(Estoque e1){
   try{
       InputStreamReader in;
       BufferedReader buf;
       try (FileInputStream arq = new FileInputStream("arq.txt")) {
           in = new InputStreamReader(arq);
           buf = new BufferedReader(in);
           String linha;
           int i=0;
           int cont=0;
           Produto p1=new Produto();
           do{linha=buf.readLine();
               if(linha!=null){
                   if(i==0){p1.setnome(linha);
                   cont=1;
                   }
                   if(i==1){p1.setpreco(Float.valueOf(linha));
                   cont=2;
                   }
                   if(i==2){p1.setqnt(Integer.valueOf(linha));
                       cont=3;
                   }
                   if(cont==3){
                       e1.setproduto(p1);
                       cont=0;
                   }
                   i=cont;
                   if(i==0){
                p1=new Produto();
                   }
               }
           }while(linha!=null);
       }
       in.close();
       buf.close();
        }catch(IOException | NumberFormatException e){
            System.out.println("erro");
       }
    }

    /**retorna uma lista dos produtos, suas quantidades e preços que estão registrados no estoque**/
    public void declaraestoque(Estoque e1){
        for(int i=0;i<e1.contagem();i++){
            System.out.println(e1.getproduto(i).getnome());
            System.out.println(e1.getproduto(i).getpreco());
            System.out.println(e1.getproduto(i).getqnt());
        }
}
    //public void relatorio(){
     //   try{}
     //   catch(Exception e){}
    //}
}
