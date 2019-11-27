
package visor;

import java.util.ArrayList;

public class Funcionario {
    private String nome;
    private ArrayList<Cliente> comprador= new ArrayList<Cliente>();
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Cliente getcomprador(int i) {
        return this.comprador.get(i);
    }
    public int tamcomprador() {
        return this.comprador.size();
    }
    public void setcomprador(Cliente c1) {
        this.comprador.add(c1);
    }
    public void tiraestoque(Estoque e1){//faz baixa no estoque
        int l;
        for (int i=0;i<this.tamcomprador();i++){
            for(int j=0;j<this.getcomprador(i).getcarrinho().tamanhocarrinho();j++){
                for(int k=0;k<e1.contagem();k++){
                    if(this.getcomprador(i).getcarrinho().getitem(j).getnome().equals(e1.getproduto(k).getnome())){
                        l=e1.getproduto(k).getqnt()-this.getcomprador(i).getcarrinho().getitem(j).getqnt();
                        e1.getproduto(k).setqnt(l);
                    }
                }
            }
        }
    }
}
