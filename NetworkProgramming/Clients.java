package NetworkProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Clients {
    /*Clients
    A client application opens a connection to a server by constructing a Socket that
    specifies the hostname and port number of the desired server
    */

    public static void main(String [] args)
    {
        try {
            Socket sock = new Socket("wupost.wustl.edu", 25);
            
            /*The constructor can also
            accept a string containing the host’s raw IP address:    */
            Socket sock2 = new Socket("22.66.89.167", 25);
        } catch (UnknownHostException ae) {
            System.out.println("can't find host.");
        } catch (IOException e) {
            System.out.println("Error connecting to host");
        }
        /*This code fragment attempts to connect a Socket to port 25 (the SMTP mail service)
        of the host wupost.wustl.edu. The client handles the possibility that the hostname
        can’t be resolved (UnknownHostException) and that it might not be able to connect to
        it (IOException). In the preceding case, Java used DNS, the standard Domain Name
        Service, to resolve the hostname to an IP address for us. 
        */
        try{
            Socket server = new Socket("foo.bar.com",1234);
            InputStream in = server.getInputStream();
            OutputStream out = server.getOutputStream();

            //write a byte 
            out.write(42);

            //write a newline or carriage return delimited string
            PrintWriter pout = new PrintWriter(out,true);
            pout.println("hello!");

            //read a byte
            byte back = (byte)in.read();

            // read a newline or carriage return delimited string
            BufferedReader bin = new BufferedReader( new InputStreamReader( in ) );
            String response = bin.readLine();

            server.close();
        } catch (IOException e) {
        }
        
        /*In this exchange, the client first creates a Socket for communicating with the server.
        The Socket constructor specifies the server’s hostname (foo.bar.com) and a prear‐
        ranged port number (1234). Once the connection is established, the client writes a
        single byte to the server using the OutputStream’s write() method. To send a string
        of text more easily, it then wraps a PrintWriter around the OutputStream. Next, it
        performs the complementary operations: reading a byte back from the server using
        InputStream’s read() method and then creating a BufferedReader from which to get
        a full string of text. The client then terminates the connection with the close()
        method. All these operations have the potential to ggenerate IOExceptions; our appli‐
        cation will deal with these using the catch clause.
        
        */
    }
}
