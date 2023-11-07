package application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import swing.*;
import database.*;
public class FIND_STUDENT extends JFrame implements ActionListener {
    SButton[] buttons = new SButton[3];
    STextField[] fields = new STextField[3];
    SLabel[] labels = new SLabel[4];
    SCombo[] combos = new SCombo[4];
    Integer[] strs3 = {};
    TransactionManager tm;

    public FIND_STUDENT(){
        this.getContentPane().setLayout(new FlowLayout());
        tm = new TransactionManager();

        strs3=tm.returnIndexes().toArray(new Integer[0]);

        buttons[0] = new SButton("FIND STUDENT","Show information about selected student", 300,100);
        buttons[1] = new SButton("UPDATE STUDENT","Chcnage information about selected student", 300,200);
        buttons[2] = new SButton("CLOSE","cancel operation",300,300);

        combos[0] = new SCombo(strs3,100,100);
        labels[0] = new SLabel("index",
                combos[0].returnX(),
                combos[0].returnY());

        for (int i=0;i<3;i++){
            add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        add(labels[0]);
        add(combos[0]);

        setSize(600,800);
        setResizable(false);
        setLayout(null);
        setTitle("Find student with a selected index");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        switch(action){
            case "FIND STUDENT":
                System.out.println("Student data from: ");
                tm.find_student((Integer) combos[0].getSelectedItem());
                break;
            case "UPDATE STUDENT":
                UPDATE_STUDENT us = new UPDATE_STUDENT();
                break;
            case "CLOSE":
                dispose();
                break;
        }
    }
}
