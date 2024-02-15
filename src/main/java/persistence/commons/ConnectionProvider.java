package persistence.commons;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
    private static String url;
    private static String username ;
    private static String password ;
    private static Connection connection;

    static{
        Properties properties = new Properties();
        try {
            properties.load(ConnectionProvider.class.getResourceAsStream("/env.properties"));
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        url = properties.getProperty("datasource");
        username =properties.getProperty("datasource.username");
        password = properties.getProperty("datasource.password");
    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(url,username,password);
            }

        }catch (SQLException e){
            e.getMessage();
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

}
