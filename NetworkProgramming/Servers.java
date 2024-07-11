package NetworkProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers {
    /*Servers
    After a connection is established, a server application uses the same kind of Socket
    object for its side of the communications. However, to accept a connection from a
    client, it must first create a ServerSocket, bound to the correct port. Let’s recreate the
    previous conversation from the server’s point of view:
    */

    //Meanwhile, on foo.bar.com...

    public static void main(String[] args) {
        try {
            ServerSocket listener = new ServerSocket(1234);

            boolean finished = true;
            while (!finished) {
                Socket client = listener.accept();//wait for connection

                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                //read a byte
                byte someByte = (byte) in.read();

                // read a newline or carriage-return-delimited string
                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
                String someString = bin.readLine();

                // write a byte
                out.write(43);

                // say goodbye
                PrintWriter pout = new PrintWriter(out, true);
                pout.println("Goodbye!");

                client.close();

            }
            listener.close();
        } catch (IOException ae) {
        }

    }
}
