import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{

    public static AddStudent addStudent;
    public static ListStudent listStudent;
    public static MainMenu menu;

    public MainFrame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(null);

        menu = new MainMenu();
        menu.setLocation(0,0);
        add(menu);

        addStudent = new AddStudent();
        addStudent.setLocation(0,0);
        addStudent.setVisible(false);
        add(addStudent);

        listStudent = new ListStudent();
        listStudent.setLocation(0,0);
        listStudent.setVisible(false);
        add(listStudent);



        repaint();
    }
}