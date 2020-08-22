import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static Socket socket;
    public static ObjectOutputStream outStream;

    public static MainFrame frame;
    private static Connection connection;
    public static void main(String[]args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentsapp?useUnicode=true&serverTimezone=UTC","root", ""
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        frame = new MainFrame();
        frame.setVisible(true);



    }

    public static void addStudent(Students st){

        PackageData pd = new PackageData();
        pd.setOperationType("ADD");
        pd.setStudent(st);

        try{
            outStream.writeObject(pd);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
