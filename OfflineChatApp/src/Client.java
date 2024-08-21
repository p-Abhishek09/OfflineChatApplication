import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.System.in;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.net.Socket;

public class Client
{
    static Client client=new Client();
    static  Scanner sc=new Scanner(in);
    
    public void loginThen() throws Exception
    {
        Connection con = connection.factoryset.DBConnection.getDBConnection();
        out.println("Enter Id and Password");
        String uId=sc.next();
        String uPass=sc.next();
        
        PreparedStatement st1 = con.prepareStatement("select * from chattab where userid=? and password=?");
        st1.setString(1, uId);
        st1.setString(2, uPass);
        ResultSet rs  = st1.executeQuery();
        
        if(rs.next())
        {
            out.println("Enter IP Address to Chat......");
            String ipAddress=sc.next();
            Socket socket = new Socket(ipAddress,2000);
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            PrintStream ps = new PrintStream(socket.getOutputStream());
            
            while(true)
            {
                String data = br.readLine();
                if(data==null)
                    break;
                ps.println(data);
                
               
            }
        } 
        else
        {
            out.println("Hey Man!!! What is this...hmmmmmm!!!! Firstly Create the account!!! Otherwise i will throw you outside");
        }
    }
    public static void main(String[] args)throws Exception
    {
        out.println("---WELCOME TO CHAT APP---");
        out.println("Are you a new User?\nType Y for YES\nType N for NO");
        char ch = sc.next().charAt(0);
        if(ch=='Y' || ch=='y')
        {
            out.println("Create the Account First");
            Connection con = connection.factoryset.DBConnection.getDBConnection();
            Scanner sc=new Scanner(in);
            out.println("Enter User Id:");
            String id = sc.next();
            out.println("Enter Password");
            String pass = sc.next();
            out.println("Enter Fullname:");
            String fullName = sc.next();
            
            PreparedStatement st = con.prepareStatement("insert into chattab values(?,?,?)");
            st.setString(1,id);
            st.setString(2,pass);
            st.setString(3,fullName);
            st.executeUpdate();
            out.println("Your Account has been created!\nNow Login to chat");
            client.loginThen();                        
        }
        else
        {
            client.loginThen();
        }
    }
}