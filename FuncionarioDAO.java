import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDAO {
    
    public String buscarFuncionarioBanco(String idFuncionario){ //Lembre que o id funcionário
    
        String sql;

        sql = "SELECT nome FROM venda.funcionario where cpf = ?";
  


        String ret = "";

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, idFuncionario);

            rset = pstm.executeQuery();

            rset.next();

        
            ret = rset.getString("nome");
          

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


    public ArrayList<String> buscaCpfFuncionarios(){

        String sql = "SELECT cpf FROM venda.funcionario";

        ArrayList<String> listaCpf = new ArrayList<String>();

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){

                listaCpf.add(rset.getString("cpf"));


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

        return listaCpf;        



    }

    public ArrayList<String> pegaInfoFuncionariosBanco(String credencial){

        String sql = "select venda.funcionario.cpf, venda.funcionario.nome, venda.funcionario.email, venda.telefone.tel from funcionario inner join venda.telefone on venda.funcionario.cpf = venda.telefone.cpfFunc where venda.funcionario.cpf = ? ";

        ArrayList<String> infoFunc = new ArrayList<String>();

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, credencial);

            rset = pstm.executeQuery();

            rset.next();

            infoFunc.add(rset.getString("cpf"));
            infoFunc.add(rset.getString("nome"));
            infoFunc.add(rset.getString("tel"));
            infoFunc.add(rset.getString("email"));



            

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

        return infoFunc;        



    }
    public void inserirFuncionarioBanco(Funcionario funcionario){
        //A ser implementado
    }

    public void deletaFuncionarioBanco(Funcionario funcionario){
        //A ser implementado
    }



}
