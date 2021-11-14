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
        
        String sql = "INSERT INTO venda( idFuncionario, carroDaVenda, idCliente, dataVenda, situacao) VALUES (?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Cria conexão
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //pstm.setInt(1, venda.getIdVenda());
            pstm.setString(1, venda.getIdFuncionario());
            pstm.setString(2, venda.getCarroDaVenda().getPlaca());
            pstm.setInt(3, venda.getClienteDaVenda().getIdCliente());


            java.util.Date utilStartDate = venda.getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

            pstm.setDate(4, sqlStartDate);
            pstm.setString(5, venda.getSituacao());
           

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



    public int contaVendas(){ 
    
        String sql;

        sql = "select count(idVenda) from venda.venda;";
  


        int ret = 0;

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            rset.next();

        
            ret = rset.getInt("count(idVenda)");
          

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }

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
