import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server started:...");

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected:...");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                //receive from client
                Object cMsg = ois.readObject();
                System.out.println("From Client" + (String) cMsg);
                //sent to client

                String sermessage = (String) cMsg;
                sermessage = sermessage.toUpperCase();
                oos.writeObject(sermessage);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
