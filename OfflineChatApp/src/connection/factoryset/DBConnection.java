package connection.factoryset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    static Connection connection = null;
    static
    {
        
        try 
        {
            
           //Class.forName("com.mysql.cj.jdbc.Driver");
           
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tanu");
        }catch(SQLException ex)
        {
        ex.printStackTrace();
        }
    }

    public static Connection getDBConnection()throws Exception
    {
        if(connection.isClosed())
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tanu");
        return connection;
    }
}