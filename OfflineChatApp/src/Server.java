import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args)throws Exception
    {
        ServerSocket ss= new ServerSocket(2000);
        System.out.println("Server is Ready");
        Socket socket=ss.accept();
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        
        while(true)
        {
            String data=br.readLine();
            if(data.equals("bye bye"))
                break;
            out.println(data);
        }
    }    
        
}