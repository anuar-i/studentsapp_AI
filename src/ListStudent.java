
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ListStudent extends Container{
    private JLabel label;
    private JButton btn;

    public ListStudent(){
        setLayout(null);
        setSize(500,500);

        label = new JLabel("List STUDENT");
        label.setLocation(100,100);
        label.setSize(100,30);
        add(label);

        btn = new JButton("Back");
        btn.setLocation(100,350);
        btn.setSize(300,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Main.frame.listStudent.setVisible(false);
                Main.frame.menu.setVisible(true);
                Main.frame.repaint();
            }
        });
        add(btn);
    }
}