import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(2222);
      while(true){
          System.out.println("Server start");
        Socket socket = serverSocket.accept();
        System.out.println("Server connected");
        ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());


          try {
              Object  cMsg = ois.readDouble();
              System.out.println("From client"+(String) cMsg);
              String cmessage = (String) cMsg;

              cmessage = cmessage.toUpperCase();
              oos.writeObject(cmessage);

          } catch (IOException e) {
              throw new RuntimeException(e);
          }

      }
    }
}
