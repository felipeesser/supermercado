
package visor;

public class Produto {
    private String nome;
    private float preco;
    private int quantidade;
    public float getpreco(){
    return this.preco;
    }
    public void setpreco(float preco){
    this.preco=preco;
    }
    public String getnome(){
    return this.nome;
    }
    public void setnome(String nome){
    this.nome=nome;
    }
    public int getqnt(){
    return this.quantidade;
    }
    public void setqnt(int qnt){
    this.quantidade=qnt;
    }
}
