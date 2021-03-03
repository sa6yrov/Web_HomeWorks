package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    private final static String url = "jdbc:postgresql://localhost:5432/UserWeb";
    private final static String dBDriver = "org.postgresql.Driver";
    private final static String user = "postgres";
    private final static String password = "postgres";
    public static Connection connect(){
        Connection conn = null;
        try{
            Class.forName(dBDriver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
