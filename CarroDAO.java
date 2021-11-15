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
        

        String sql = "SELECT DISTINCT modelo FROM venda.carro where marca = ?";

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
            System.out.println("ERRO na busca de modelos(CarroDAO)");
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

    public float calculaValorBanco(String modeloCarro,String marcaCarro,String corCarro){


        String sql;

        sql = "SELECT valor FROM venda.carro where modelo = ? AND marca = ? AND cor = ?";
  


        float ret = 0.0f;

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, modeloCarro);
            pstm.setString(2, marcaCarro);
            pstm.setString(3, corCarro);


            rset = pstm.executeQuery();

            rset.next();

        
            ret = rset.getFloat("valor");
          

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


    public String buscaPlacaCarroBanco(String opcaoMarca,String opcaoModelo,String opcaoCor){

        //Precisa ser implementado
        String sql;


       
        sql = "SELECT placa FROM venda.carro where marca = ? AND modelo = ? AND cor = ?";
       


        String ret = "";

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, opcaoMarca);
            pstm.setString(2, opcaoModelo);
            pstm.setString(3, opcaoCor);

            rset = pstm.executeQuery();

            rset.next();

      
            ret = rset.getString("placa");

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

    public ArrayList<String> buscaPlacasCarrosBanco(String opcaoMarca,String opcaoModelo,String opcaoCor){

        String sql = "SELECT placa FROM venda.carro where marca = ? AND modelo = ? AND cor = ?";

        ArrayList<String> listaPlacas = new ArrayList<String>();

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, opcaoMarca);
            pstm.setString(2, opcaoModelo);
            pstm.setString(3, opcaoCor);


            rset = pstm.executeQuery();

            while(rset.next()){

                listaPlacas.add(rset.getString("placa"));


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

        return listaPlacas;        



    }

    public void inserirCarroBanco(Carro carro){
        //A ser implementado
    }

    public void deletaCarroBanco(Carro carro){
        //A ser implementado
    }



    
}
