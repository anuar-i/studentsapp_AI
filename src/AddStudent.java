import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudent extends Container{
    public static JButton btnBack, btnAdd;
    private JLabel label,labelName,labelSurname,labelAge;
    public static JTextField textName, textSurname,textAge;

    public AddStudent(){
        Students st = new Students();
        setLayout(null);
        setSize(500,500);

        label = new JLabel("ADD STUDENT");
        label.setLocation(70,100);
        label.setSize(100,30);
        add(label);

        btnBack = new JButton("Back");
        btnBack.setLocation(100,350);
        btnBack.setSize(300,30);
        add(btnBack);

        btnAdd = new JButton("Add");
        btnAdd.setLocation(100,300);
        btnAdd.setSize(300,30);
        add(btnAdd);

        labelName = new JLabel("Name:");
        labelName.setBounds(70,130,70,30);
        add(labelName);
        textName = new JTextField();
        textName.setBounds(150,130,250,30);
        add(textName);

        labelSurname = new JLabel("Surname:");
        labelSurname.setBounds(70,170,70,30);
        add(labelSurname);
        textSurname = new JTextField();
        textSurname.setBounds(150,170,250,30);
        add(textSurname);

        labelAge = new JLabel("Age:");
        labelAge.setBounds(70,210,70,30);
        add(labelAge);
        textAge = new JTextField();
        textAge.setBounds(150,210,250,30);
        add(textAge);
    }
}