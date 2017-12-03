package br.com.odonto.util;

/*Importações feitas para desenvolver esse arquivo*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    /*Estabelece o tipo de conexão*/
    private static Connection connection = null;
    
    /*Verifica a conexão, o caminho, o banco que está sendo utilizado. E realiza a conexão com ele.*/
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                
                String driver = "org.postgresql.Driver";
                /*Aqui deve se por o caminho do banco de dados com quem ele irá se relacionar*/
                String url = "jdbc:postgresql://localhost:5432/odontologia";
                String user = "postgres";
                String password = "123456";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
