/* CLIENT */
import java.io.*;
import java.net.*;
public class NetworkingClient {
    static String msg = "";
    static int portnumber = 1234;
    static Socket client = null;

    public void startclient(){



        for (int i=0; i <10; i++) {
            try {

                // Create a client socket
                client = new Socket (InetAddress.getLocalHost(), portnumber);
                System.out.println("Client socket is created" + client);

                // Create an output stream of the client socket
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);

                // Create an input stream of the client socket
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader (clientIn));

                // Create BufferedReader for a standard input
                BufferedReader stdIn = new BufferedReader(new
                        InputStreamReader(System.in));

                System.out.println("Enter your name. Type Bye to exit. ");
                // Read data from standard input device and write it
                // to the output stream of the client socket.
                msg=stdIn.readLine().trim();
                pw.println(msg);
                // Read data from the input stream of the client socket.
                System.out.println("Message returned from the server = " +
                        br.readLine());
                pw.close();
                br.close();
                client.close();
                // Stop the operation.
                if (msg.equalsIgnoreCase("Bye")) {
                    break;
                }
            } catch (IOException ie) {
                System.out.println("I/O error" + ie);
            }
        }
    }
    public NetworkingClient(){
        startclient();
    }
    public static void main(String args[]) throws IOException {
    NetworkingServer networkingServer = new NetworkingServer();
    }
}