import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Server started:...");
        ServerSocket serverSocket = new ServerSocket(2222);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Clint Connected:...");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Object cMsg = ois.readObject();
            String clintMsg = (String) cMsg;
            System.out.println("From Clint:" + (String) cMsg);
            clintMsg = clintMsg.toUpperCase();

            try {
                oos.writeObject(clintMsg);
                System.out.println("Send to Clint:...");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
