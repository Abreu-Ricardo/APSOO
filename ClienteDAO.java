import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO{

    //CRUD

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

}