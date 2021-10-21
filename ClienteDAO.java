import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    

    public String buscaPessoaBanco(String credencial){
        //Precisa ser implementado
        
        boolean tipoPessoa = true;
        String sql;


        if(credencial.length()==11){
            sql = "SELECT nome FROM venda.pessoaf where cpf = ?";
        }else{
            sql = "SELECT nomeFantasia FROM venda.pessoaj where cnpj = ?";
            tipoPessoa = false;
        }


        String ret = "";

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

            if(tipoPessoa==true)
                ret = rset.getString("nome");
            else
                ret = rset.getString("nomeFantasia");

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

    public Cliente getClienteBanco(String credencialCliente){

        String sql = "";  

        if(credencialCliente.length()==11){
            sql = "select venda.cliente.idCliente, venda.cliente.endereco, venda.cliente.estado, venda.cliente.cidade, venda.cliente.telefone, venda.cliente.email from venda.cliente inner join pessoaf on venda.cliente.idCliente = venda.pessoaf.idCliente where venda.pessoaf.cpf = ? ";
        }else{
            sql = "select venda.cliente.idCliente, venda.cliente.endereco, venda.cliente.estado, venda.cliente.cidade, venda.cliente.telefone, venda.cliente.email from venda.cliente inner join pessoaj on venda.cliente.idCliente = venda.pessoaj.idCliente where venda.pessoaj.cnpj = ? ";
        }

        Cliente clienteRet = new Cliente(1,"1","1","1","1","1");
    

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, credencialCliente);
            
            rset = pstm.executeQuery();

            while(rset.next()){
                

                clienteRet.setIdCliente(rset.getInt("idCliente"));
                clienteRet.setEndereco(rset.getString("endereco"));
                clienteRet.setEstado(rset.getString("estado"));
                clienteRet.setCidade(rset.getString("cidade"));
                clienteRet.setTelefone(rset.getString("telefone"));
                clienteRet.setEmail(rset.getString("email"));


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

        return clienteRet;


    } 





    public void inserirClienteBanco(Cliente cliente){
        //A ser implementado 
    }

    public void deletaClienteBanco(Cliente cliente){
        //A ser implementado 
    }     




}
