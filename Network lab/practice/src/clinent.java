import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class clinent {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Client started: ");
        Socket socket = new Socket("127.0.0.1",22222);
        System.out.println("Client connected:");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        //sent to server
        oos.writeObject(message);

        try {
            Object fromserver = ois.readObject();
            System.out.println("From server: "+(String) fromserver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
