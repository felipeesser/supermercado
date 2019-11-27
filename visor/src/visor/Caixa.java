
package visor;

import java.util.ArrayList;

public class Caixa {
    private ArrayList<Cliente> clientela= new ArrayList<Cliente>();//clientes q passaram nesse caixa
    private ArrayList<Funcionario> func= new ArrayList<Funcionario>();//funcionários q atenderam nesse caixa
    private String nomedocaixa;
    private int utilizado;//flag q determina se um caixa foi utilizado no dia
    private float total;//valor total de vendas registradas no caixa

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public int getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(int i) {
        this.utilizado = i;
    }

    public String getNomedocaixa() {
        return nomedocaixa;
    }

    public void setNomedocaixa(String nomedocaixa) {
        this.nomedocaixa = nomedocaixa;
    }
    public Cliente getClientela(int i) {
        return this.clientela.get(i);
    }
    public int tamcliente() {
        return this.clientela.size();
    }
    public void setClientela(Cliente c1) {
        this.clientela.add(c1);
    }

    public Funcionario getfunc(int i) {
        return this.func.get(i);
    }
    public int tamfunc() {
        return this.func.size();
    }
    public void setfunc(Funcionario f1) {
        this.func.add(f1);
    }
    public void totalcaixa(Estoque e1){//a partir das compras de um vetor cliente define o total de vendas no caixa
                                        //tmb verifica se o cliente pagou em cartao ou dinheiro e demonstra essa 
                                        //informacao no terminal
        float l=0;
        float t=0;
        for (int i=0;i<this.tamcliente();i++){
            t=0;
            for(int j=0;j<this.getClientela(i).getcarrinho().tamanhocarrinho();j++){
                for(int k=0;k<e1.contagem();k++){
                    if(this.getClientela(i).getcarrinho().getitem(j).getnome().equals(e1.getproduto(k).getnome())){
                        l=l+e1.getproduto(k).getpreco()*this.getClientela(i).getcarrinho().getitem(j).getqnt();
                        t=t+e1.getproduto(k).getpreco()*this.getClientela(i).getcarrinho().getitem(j).getqnt();
                    }
                }
            }
            if(this.getClientela(i).getformapag().equals("dinheiro")){
                if(this.getClientela(i).getCarteira()<t){
                    System.out.println("Valor da carteira inferior ao valor da compra");
                }
                else{
            System.out.println("O troco do cliente foi de:");
            System.out.println(this.getClientela(i).getCarteira()-t);
                }
            }
            else{System.out.println("O cliente pagou com cartão");}
        }this.setTotal(l);
    }

}
