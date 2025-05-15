import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Clint {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Clint started:..");
        Socket socket = new Socket("127.0.0.1", 2222);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        System.out.println("Clint Connected:..");
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        //send to server
        oos.writeObject(message);

        try {
            //receive from server
            Object fromServer = ois.readObject();
            System.out.println("From Server:"+(String)fromServer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
