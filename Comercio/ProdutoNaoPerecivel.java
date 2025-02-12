
public class ProdutoNaoPerecivel extends Produto {
    
    public ProdutoNaoPerecivel(String desc,Double precoCusto, Double margemLucro){
        super(desc, precoCusto, margemLucro);
    }
    
    public ProdutoNaoPerecivel(String desc, Double precoCusto){
        
        super(desc, precoCusto);
        
    }
    
    public double valorVenda(){
        return precoCusto * (1+margemLucro);
    }
    
}
