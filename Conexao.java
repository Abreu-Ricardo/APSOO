import java.sql.*;

public class Conexao {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final String URL = "jdbc:mysql://localhost:3306/Apsoo";


    public static Connection createConnectionToMySQL() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        return connection;

    }






}