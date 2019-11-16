
package supermercado;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Supermercado {
    private funcionario[] funcionarios=new funcionario[5];
    private Caixa[] filas=new Caixa[3];
    private gerente Gerente;
    private estoque Estoque;
    private ArrayList<cliente> clientes= new ArrayList();
    public void setEstoque(estoque e) {
        this.Estoque=e;
    }
    public estoque getEstoque() {
        return this.Estoque;
    }
    public int sizecliente() {
        return this.clientes.size();
    }
    public void setCliente(cliente c) {
        this.clientes.add(c);
    }
    public funcionario getFuncionarios(int i) {
        return funcionarios[i];
    }

    public void setFuncionarios(funcionario fun) {
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

    public gerente getGerente() {
        return Gerente;
    }

    public void setGerente(gerente Gerente) {
        this.Gerente = Gerente;
    }
    public void abre(){
       gerente g1=new gerente();
       estoque e1=new estoque();
       g1.preenchestoque(e1);
       this.setEstoque(e1);
       this.setGerente(g1);
        try{
       InputStreamReader in;
       BufferedReader buf;
       try (FileInputStream arq = new FileInputStream("compras.txt")) {
           in = new InputStreamReader(arq);
           buf = new BufferedReader(in);
           String linha;
           cliente c1=new cliente();
           do{linha=buf.readLine();
               if(linha!=null){
                  if (linha.equals("#")){
                       c1=new cliente();
                       this.setCliente(c1);
                       }
           }}while(linha!=null);
       }
       in.close();
       buf.close();
        }catch(IOException | NumberFormatException e){
            System.out.println("erro");
       }
    }
    public void compras(){
    for (int i=0;i<this.clientes.size();i++){
        
    this.clientes.get(i).adiciona_carrinho(this.getEstoque(),i);
    }
        }
}
