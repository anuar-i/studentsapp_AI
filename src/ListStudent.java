
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ListStudent extends Container{
    private JLabel label;
    public static JButton btn;
    public static JTable table;
    private JScrollPane scrollPane;

    public ListStudent(){
        setLayout(null);
        setSize(500,500);

        label = new JLabel("List STUDENT");
        label.setLocation(100,100);
        label.setSize(100,30);
        add(label);

        //Создаем таблицу
        table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);
        table.setSize(100,150);




        //Создаем панель для прокрутки
        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,150);
        add(scrollPane);


//
//        PackageData pd = new PackageData();
//        pd.setOperationType("LIST");
//        generateTable(Client.getStudents(pd));

        btn = new JButton("Back");
        btn.setLocation(100,350);
        btn.setSize(300,30);

        add(btn);
    }


}

