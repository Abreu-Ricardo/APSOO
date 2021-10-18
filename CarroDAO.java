import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CarroDAO {

    public ArrayList<String> buscaMarcasCarrosBanco(){
        //Precisa ser implementado

        String sql = "SELECT DISTINCT marca FROM venda.carro";

        ArrayList<String> listaDeMarcas = new ArrayList<String>();

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){

                listaDeMarcas.add(rset.getString("marca"));


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

        return listaDeMarcas;
    }

    public ArrayList<String> buscaModelosCarrosBanco(String marcaCarro){
        //Precisa ser implementado
        

        String sql = "SELECT modelo FROM venda.carro where marca = ?";

        ArrayList<String> listaDeModelos = new ArrayList<String>();

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, marcaCarro);

            rset = pstm.executeQuery();

            while(rset.next()){

                listaDeModelos.add(rset.getString("modelo"));


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

        return listaDeModelos;
    }

    public ArrayList<String> buscaCoresCarrosBanco(String modeloCarro){
        //Precisa ser implementado


        String sql = "SELECT cor FROM venda.carro where modelo = ?";

        ArrayList<String> listaDeCores = new ArrayList<String>();

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, modeloCarro);

            rset = pstm.executeQuery();

            while(rset.next()){

                listaDeCores.add(rset.getString("cor"));


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

        return listaDeCores;
    }

    public void inserirCarroBanco(Carro carro){
        //A ser implementado
    }

    public void deletaCarroBanco(Carro carro){
        //A ser implementado
    }



    
}
