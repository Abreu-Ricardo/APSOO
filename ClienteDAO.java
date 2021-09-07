import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO{

    //CRUD


    //CREATE
    public void save(Cliente cliente){

        String sql = "INSERT INTO clientes(cpf,nome,rua,numero,bairro,cidade,uf,telefone,email) VALUES (?,?,?,?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Cria conexão
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cliente.getCpf());
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getRua());
            pstm.setInt(4, cliente.getNumero());
            pstm.setString(5, cliente.getBairro());
            pstm.setString(6, cliente.getCidade());
            pstm.setString(7, cliente.getUf());
            pstm.setString(8, cliente.getTelefone());
            pstm.setString(9, cliente.getEmail());

            System.out.println("cliente.getCpf()");

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


    //READ
    public List<Cliente> getClientes(){

        String sql = "SELECT * FROM clientes";

        List<Cliente> clientes = new ArrayList<Cliente>();

        Connection conn = null;

        PreparedStatement pstm = null;

        //Classe pra pegar dados do banco
        ResultSet rset = null;


        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()){
                Cliente cliente  = new Cliente("1","1","1",1,"1","1","1","1","1");

                cliente.setCpf(rset.getString("cpf"));
                cliente.setNome(rset.getString("nome"));
                cliente.setRua(rset.getString("rua"));
                cliente.setNumero(rset.getInt("numero"));
                cliente.setBairro(rset.getString("bairro"));
                cliente.setCidade(rset.getString("cidade"));
                cliente.setUf(rset.getString("uf"));
                cliente.setTelefone(rset.getString("telefone"));
                cliente.setEmail(rset.getString("email"));

                clientes.add(cliente);




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

        return clientes;


    } 

    //UPDATE
    public void update(Cliente cliente){

        String sql = "UPDATE clientes SET nome = ? , rua = ? , numero = ?, bairro = ? , cidade = ?, uf = ?, telefone = ?, email = ? " +
                    "WHERE cpf = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            //Criar conexão com o banco
            conn = Conexao.createConnectionToMySQL();

            //Classe pra executar query
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            //Adicionar valores para atualizar
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getRua());
            pstm.setInt(3, cliente.getNumero());
            pstm.setString(4, cliente.getBairro());
            pstm.setString(5, cliente.getCidade());
            pstm.setString(6, cliente.getUf());
            pstm.setString(7, cliente.getTelefone());
            pstm.setString(8, cliente.getEmail());

            //cpf do registro que vai ser alterado
            pstm.setString(9, cliente.getCpf());

            //Executar
            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
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


    //DELETE
    public void deleteByCPF(String cpf){


        String sql = "DELETE FROM clientes WHERE cpf = ? ";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            conn = Conexao.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);


            pstm.setString(1, cpf);

            pstm.execute();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
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