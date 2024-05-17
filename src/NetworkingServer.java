
    /* SERVER - may be enhanced to work for multiple clients */
import java.net.*;
import java.io.*;
    public class NetworkingServer {
        static int portnumber = 1234;
        static ServerSocket server = null;
        static Socket client;
        public void startServer() throws IOException {

                while (true) {
                    System.out.println("Waiting for the client request");
                    //creating socket and waiting for client connection
                    Socket socket = server.accept();
                    // Read data from the client
                    InputStream clientIn = client.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
                    String msgFromClient = br.readLine();
                    System.out.println("Message received from client = " + msgFromClient);
                    // Send response to the client
                    if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye")) {
                        OutputStream clientOut = client.getOutputStream();
                        PrintWriter pw = new PrintWriter(clientOut, true);
                        String ansMsg = "Hello, " + msgFromClient;
                        pw.println(ansMsg);

                    }
                    //terminate the server if client sends exit request
                    else if (msgFromClient.equalsIgnoreCase("exit")) break;
                }
            server.close();
            client.close();
        }
        public NetworkingServer() throws IOException {
            startServer();
        }
        public static void main(String [ ] args) throws IOException {

            NetworkingServer networkingServer = new NetworkingServer();

                    }


        }