import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ketnoicsdl {

    public static Connection KetNoiCSDL() {
        String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=QLDV;encrypt=true;trustServerCertificate=true";

        String USER = "sa";
        String PASS = "123456789";

        Connection conn = null;

        try {
        
            Class.forName(JDBC_DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
           
        } catch (ClassNotFoundException e) {
         
            e.printStackTrace();
        } catch (SQLException se) {
          
            se.printStackTrace();
        }

        return conn;
    }

}


