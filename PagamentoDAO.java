import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO{

    public boolean inserePagamentoBanco(Pagamento pagamento){

        boolean ret = true;

        String sql = "INSERT INTO venda.pagamento(idVenda, valor, tipoPagamento, desconto) VALUES (?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Cria conexão
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setInt(1, pagamento.getIdVenda());
            pstm.setFloat(2, (float)pagamento.getValor());
            pstm.setInt(3, pagamento.getTipoDePagamento());
            pstm.setFloat(4, (float)pagamento.getDesconto());



            pstm.execute();
        }catch(Exception e){
            e.printStackTrace(); ret=false;
        }finally{

            //fechar conexões
            try{
                if(pstm!=null){
                    pstm.close();
                }

                if(conn!=null){
                    conn.close();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    
        return ret;

    }



    
}
