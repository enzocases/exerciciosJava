
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel extends Produto {
    
    private static final double DESCONTO = 0.25;
    private static final int PRAZO_DESCONTO = 7;
    private LocalDate dataDeValidade;
    
    public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate validade){
        super(desc, precoCusto, margemLucro);
        
        if(validade.isBefore(LocalDate.now())){
            
            throw new IllegalArgumentException("Validade anterior ao dia de hoje!!");
            
        }
        dataDeValidade = validade;
    }
    
    @Override
    public double valorVenda(){
        double desconto = 0.0;
        int diasValidade= LocalDate.now().until(dataDeValidade).getDays();
        if(diasValidade <= PRAZO_DESCONTO){
            desconto = DESCONTO;
            
        }
        return(precoCusto * (1+margemLucro))* (1- desconto);
    }
    
    @Override
    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        String dados = super.toString();
        dados += "Inválido até" + formato.format(dataDeValidade);
        return dados;
    }
}
