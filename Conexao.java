import java.sql.*;

public class Conexao {

    //Coloque o username e o password correspondetes ao seu usuario do mysql
    private static final String USERNAME = "ricardo";
    private static final String PASSWORD = "123456";

    //Defina o nome do esquema com Apsoo, ou troque o nome pelo nome desejado
    private static final String URL = "jdbc:mysql://localhost:3306/venda";


    public static Connection createConnectionToMySQL() throws Exception{
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        return connection;

    }



}