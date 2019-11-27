
package visor;

public class Produto {//um objeto Produto contem os atributos nome,preco e quantidade
                      //as informacoes de produtos contidos no estoque e no carrinho de um cliente
                      // sao atribuidas a partir de dois arquivos texto, mas os produtos contidos no carrinho do cliente nao
                      //possuem o atributo preco
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
