import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        try{
            ServerSocket server = new ServerSocket(1989);
            System.out.println("Waiting for client");
            while (true){
                Socket socket = server.accept();
//                SocketThread socketThread = new SocketThread(socket);
//                socketThread.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
