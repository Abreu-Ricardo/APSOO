import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class VendaDAO {

    public ArrayList<Venda> emiteRelatorioVendaBanco(){
        //A ser implementado

        ArrayList<Venda> vendas= new ArrayList<Venda>(); 
        return vendas;
    }

    public void insereVendaBanco(Venda venda){
        
        String sql = "INSERT INTO venda(idVenda, idFuncionario, carroDaVenda, idCliente, dataVenda, situacao) VALUES (?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Cria conexão
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            pstm.setInt(1, venda.getIdVenda());
            pstm.setString(2, venda.getIdFuncionario());
            pstm.setString(3, venda.getCarroDaVenda().getPlaca());
            pstm.setInt(4, venda.getClienteDaVenda().getIdCliente());


            java.util.Date utilStartDate = venda.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

            pstm.setDate(5, sqlStartDate);
            pstm.setString(6, venda.getSituacao());
           

            pstm.execute();
        }catch(Exception e){
            e.printStackTrace();
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
    }


    



}
