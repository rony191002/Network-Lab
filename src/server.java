import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started..");

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected..");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());


            try {
                //read from client
                Object cMs = ois.readObject();
                System.out.println("From Client" + (String) cMs);

                String serverMsg = (String)cMs;

                serverMsg = serverMsg.toUpperCase();
                //sent to client
                oos.writeObject(serverMsg);

               } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);

            }
        }
    }
}
