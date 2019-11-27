
package visor;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Gerente {
    public void preenchestoque(Estoque e1){//método de gerente que busca as informacoes de um estoque em um arquivo texto
                                           //e atualiza os atributos de um objeto estoque com essas informacoes
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
 
    public void relatorio(Estoque e1,Caixa[] fil,int flag){//metodo de gerente que cria dois arquivos texto contento informaçoes
                                           //das vendas realizadas: quantidade inicial de produtos no estoque, quantidade final de produtos
                                           //no estoque, nome do funcionario que realizou a venda e o caixa em que a venda foi realizada,
                                           //total de vendas por caixa,total de vendas por cliente
      try{
       if(flag==0){
      FileOutputStream arquivo= new FileOutputStream("relatorio1.txt");
      PrintWriter pf=new PrintWriter(arquivo);
        pf.println("Relatorio do inicio do dia:");
        for(int i=0;i<e1.contagem();i++){
        pf.println(e1.getproduto(i).getnome());
        pf.println(e1.getproduto(i).getpreco());
        pf.println(e1.getproduto(i).getqnt());
        pf.println("------------------");
        }pf.close();
        arquivo.close();
       }
       else{float t=0;
           FileOutputStream arquivo= new FileOutputStream("relatorio2.txt");
            PrintWriter pf=new PrintWriter(arquivo);
            pf.println("Relatorio do fim do dia:");
            for(int i=0;i<e1.contagem();i++){
            pf.println(e1.getproduto(i).getnome());
            pf.println(e1.getproduto(i).getpreco());
            pf.println(e1.getproduto(i).getqnt());
            pf.println("------------------");
            }
            pf.println("Total de vendas por caixa:");
            for(int j=0;j<3;j++){
                if(fil[j].getUtilizado()==1){
                pf.println(fil[j].getNomedocaixa());
                pf.println(fil[j].getTotal());}}
            for(int j=0;j<3;j++){
                if(fil[j].getUtilizado()==1){
                pf.println("Vendas realizadas no decorrer do dia por cada caixa:");
                for (int k=0;k<fil[j].tamcliente();k++){
                t=0;
                pf.println("Vendas realizada por:");
                pf.println(fil[j].getfunc(k).getNome());
                pf.println("No caixa:");
                pf.println(fil[j].getNomedocaixa());
                for(int l=0;l<fil[j].getClientela(k).getcarrinho().tamanhocarrinho();l++){
                for(int p=0;p<e1.contagem();p++){
                    if(fil[j].getClientela(k).getcarrinho().getitem(l).getnome().equals(e1.getproduto(p).getnome())){
                        t=t+e1.getproduto(p).getpreco()*fil[j].getClientela(k).getcarrinho().getitem(l).getqnt();
                        }
                }
                }
                pf.println(t);}
                }
            }
       pf.close();
        arquivo.close();}
       }catch(Exception e){
      System.out.println("erro");
      }
}}
