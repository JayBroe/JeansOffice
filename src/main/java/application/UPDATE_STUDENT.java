package application;

import database.TransactionManager;
import swing.SButton;
import swing.SCombo;
import swing.SLabel;
import swing.STextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UPDATE_STUDENT extends JFrame implements ActionListener {

    SButton[] buttons = new SButton[4];
    STextField[] fields1 = new STextField[4];
    SLabel[] labels = new SLabel[4];
    SCombo[] combos = new SCombo[5];
    Integer[] strs3 = {};
    TransactionManager tm;

    public UPDATE_STUDENT(){
        tm = new TransactionManager();
        strs3=tm.returnIndexes().toArray(new Integer[0]);

        this.getContentPane().setLayout(new FlowLayout());

        buttons[0] = new SButton("UPDATE STUDENT",300,200);
        buttons[1] = new SButton("CLOSE",300,400);

        combos[0] = new SCombo(strs3,100,100);
        labels[0] = new SLabel("index",
                combos[0].returnX(),
                combos[0].returnY());
        fields1[0] = new STextField(100,200);
        labels[1] = new SLabel("name",
                fields1[0].returnX(),
                fields1[0].returnY());
        fields1[1] = new STextField(100,300);
        labels[2] = new SLabel("surname",
                fields1[1].returnX(),
                fields1[1].returnY());
        fields1[2] = new STextField(100,400);
        labels[3] = new SLabel("Major",
                combos[1].returnX(),
                combos[1].returnY());
        fields1[3] = new STextField(100,400);
        labels[4] = new SLabel("Form",
                combos[2].returnX(),
                combos[2].returnY());

        add(combos[0]);
        add(labels[0]);

        add(fields1[0]);
        add(labels[1]);

        add(fields1[1]);
        add(labels[2]);


        buttons[0].addActionListener(this);
        buttons[1].addActionListener(this);

        add(buttons[0]);
        add(buttons[1]);

        setSize(600,900);
        setResizable(false);
        setLayout(null);
        setTitle("Update new student");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();
        TransactionManager tm = new TransactionManager();
        switch (action) {
            case "UPDATE STUDENT":
                tm.update_student(
                        (Integer) (Integer) combos[0].getSelectedItem(),
                        fields1[0].getText(),
                        fields1[1].getText()
                );
                break;
            case "CLOSE":
                dispose();
                break;
        }
    }
}
