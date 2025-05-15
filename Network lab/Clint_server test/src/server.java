import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static <ObjectInputStreamt> void main(String[] args) throws IOException {
        System.out.println("Server started");
        ServerSocket serverSocket = new ServerSocket(22222);

        while (true){

        Socket socket = serverSocket.accept();
        System.out.println("Clint conected");
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        try {
            Object cMsg = ois.readObject();
            System.out.println("From client: "+(String) cMsg);
            String clMessage = (String) cMsg;

            //clMessage = clMessage.toUpperCase();
            clMessage = "Hello";
            oos.writeObject(clMessage);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
         }
        }
     }
}
