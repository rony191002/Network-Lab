import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class clint {

    public static void main(String[] args) throws IOException {
        System.out.println("Clint Started:..");
        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("Clint connected:..");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        //sent to server
        oos.writeObject(message);

        try {
            //receive from server
            Object fromServer = ois.readObject();
            System.out.println("From server: " +(String) fromServer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
