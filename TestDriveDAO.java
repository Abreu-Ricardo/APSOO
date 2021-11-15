import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class TestDriveDAO {

    public String verificaDisponibilidadeTestDriveBanco(ArrayList<String> carrosPlacas, LocalDate data){
        //A implementar

          
        String ret = "";

        for(int i = 0; i < carrosPlacas.size() ; i++){

            String sql;

            sql = "SELECT * FROM venda.testdrive where placaCarro = ? AND dataAgendada = ?";
         
    
   
    
            Connection conn = null;
    
            PreparedStatement pstm = null;
    
            //Classe pra pegar dados do banco
            ResultSet rset = null;
    
    
            try{
                conn = Conexao.createConnectionToMySQL();
    
                pstm = (PreparedStatement) conn.prepareStatement(sql);
    
                pstm.setString(1, carrosPlacas.get(i));

                Date dateSQL = Date.valueOf(data);
                pstm.setDate(2, dateSQL);

    
                rset = pstm.executeQuery();
    

                if(rset.next() == false){
                    ret = carrosPlacas.get(i);
                    i = carrosPlacas.size();

                }

    
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





        }






        return ret;
    }

    public void insereTestDriveBanco(TestDrive testDrive){

        String sql = "INSERT INTO venda.testdrive(placaCarro, cpfClente, dataAgendada) VALUES (?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Cria conexão
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            
            //pstm.setInt(1, venda.getIdVenda());
            pstm.setString(1, testDrive.getCarroPlaca());
            pstm.setString(2, testDrive.getCpfCliente());

            Date dateSQL = Date.valueOf(testDrive.getData());
            pstm.setDate(3, dateSQL);


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
