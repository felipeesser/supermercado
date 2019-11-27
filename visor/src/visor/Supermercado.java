
package visor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class Supermercado {
    private Funcionario[] funcionarios=new Funcionario[5];
    private Caixa[] filas=new Caixa[3];
    private Gerente Gerente;
    private Estoque Estoque;
    private ArrayList<Cliente> clientes= new ArrayList<Cliente>();
    public void setEstoque(Estoque e) {
        this.Estoque=e;
    }
    public Cliente getClientes(int i) {
        return this.clientes.get(i);
    }
    public Estoque getEstoque() {
        return this.Estoque;
    }
    public int sizecliente() {
        return this.clientes.size();
    }
    public void setCliente(Cliente c) {
        this.clientes.add(c);
    }
    public Funcionario getFuncionarios(int i) {
        return funcionarios[i];
    }

    public void setFuncionarios(Funcionario fun) {
        for (int i = 0; i < this.funcionarios.length; i++) {
      if (this.funcionarios[i] == null) {
        this.funcionarios[i] = fun;
        break;
    }}
    }

    public Caixa getFilas(int i) {
        return filas[i];
    }

    public void setFilas(Caixa fil) {
        for (int i = 0; i < this.filas.length; i++) {
      if (this.filas[i] == null) {
        this.filas[i] = fil;
        break;
    }}
    }

    public Gerente getGerente() {
        return Gerente;
    }

    public void setGerente(Gerente Gerente) {
        this.Gerente = Gerente;
    }
    public void abre(){
        for(int u=0;u<5;u++){
            Funcionario f=new Funcionario();
            if(u==0)f.setNome("Felipe");
            if(u==1)f.setNome("Victor");
            if(u==2)f.setNome("Paulo");
            if(u==3)f.setNome("Pecanha");
            if(u==4)f.setNome("Victor");
            this.setFuncionarios(f);
            }
        for(int c=0;c<3;c++){
            Caixa cx=new Caixa();
            if(c==0){cx.setNomedocaixa("Caixa1");
            cx.setUtilizado(0);
            this.setFilas(cx);}
            if(c==1){cx.setNomedocaixa("Caixa2");
            cx.setUtilizado(0);
            this.setFilas(cx);}
            if(c==2){cx.setNomedocaixa("Caixa3");
            cx.setUtilizado(0);
            this.setFilas(cx);
            }
        }
       Gerente g1=new Gerente();
       Estoque e1=new Estoque();
       g1.preenchestoque(e1);
       this.setEstoque(e1);
       this.setGerente(g1);
       this.getGerente().relatorio(this.getEstoque(), filas, 0);
        try{
       InputStreamReader in;
       BufferedReader buf;
       try (FileInputStream arq = new FileInputStream("compras.txt")) {
           in = new InputStreamReader(arq);
           buf = new BufferedReader(in);
           String linha;
           Cliente c1=new Cliente();
           do{linha=buf.readLine();
               if(linha!=null){
                  if (linha.equals("#")){
                       c1=new Cliente();
                       this.setCliente(c1);
                       }
           }}while(linha!=null);
       }
       in.close();
       buf.close();
        }catch(IOException | NumberFormatException e){
            System.out.println("erro");
       }
        for (int i=0;i<this.clientes.size();i++){
        
    this.clientes.get(i).adiciona_carrinho(this.getEstoque(),i);
    }
        }
    public void consulta_preco(String p,Estoque e1){
    System.out.println("Cliente consultou o preco do seguinte produto->");
    for(int i=0;i<e1.contagem();i++){
    if(p.equals(e1.getproduto(i).getnome())){
        System.out.println(e1.getproduto(i).getnome());
    System.out.println(e1.getproduto(i).getpreco());
    }
    }
    }
    public void compras(){
        int j=0;
        int k=0;
        for(int i=0;i<this.sizecliente();i++){
     
           this.filas[j].setClientela(this.getClientes(i));
           this.funcionarios[k].setcomprador(this.getClientes(i));
           this.filas[j].setfunc(this.getFuncionarios(k));
           if(i<3){
           this.filas[i].setUtilizado(1);}
           if(k<4)k++;
           if(k==4)k=0;
           if(j<2)j++;
           if(j==2)j=0;
        }
        for(int o=0;o<3;o++){
            this.filas[o].totalcaixa(this.getEstoque());
        }
        for (int m=0;m<5;m++){
        this.funcionarios[m].tiraestoque(this.getEstoque());}
        this.getGerente().relatorio(this.getEstoque(), filas, 1);
    }
}