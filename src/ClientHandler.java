import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientHandler extends Thread{
        Scanner in = new Scanner(System.in);
        private Socket socket;
        private Connection connection;
        public ClientHandler(Socket socket, Connection connection) {
            this.socket = socket;
            this.connection = connection;
        }

        @Override
        public void run() {
            try{
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

                PackageData pd = new PackageData();
                pd = (PackageData) inputStream.readObject();
                System.out.println(pd + " CH");

                if (pd.operationType.equals("ADD")){
                    addStudenttoDB(pd.student);
                    System.out.println("added to DB");
                }else if(pd.operationType.equals("LIST")){
                    System.out.println("got list command");
                    pd.setStudents(getDBStudents());
                    System.out.println(pd);
                    outputStream.writeObject(pd);

                }
            }catch (Exception e){
                        e.printStackTrace();
            }
        }

    public void addStudenttoDB(Students st){
        PackageData pd = new PackageData();
        pd.setOperationType("ADD");
        pd.setStudent(st);
        System.out.println(st);
        try{
//            Statement statement = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO students (name,surname,age) VALUES(?,?,?)");
            ps.setString(1,st.getName());
            ps.setString(2,st.getSurname());
            ps.setInt(3,st.getAge());
            ps.executeUpdate();
            ps.close();
//            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Students> getDBStudents(){
        ArrayList<Students> gotSt = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM `students`");
            ResultSet result = ps.executeQuery();
            while (result.next()){
                Long id = result.getLong("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                int age = result.getInt("age");
                Students st = new Students(id,name,surname,age);
                gotSt.add(st);
            }
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return gotSt;
    }
}
