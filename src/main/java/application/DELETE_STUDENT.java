package application;

import database.TransactionManager;
import swing.SButton;
import swing.SCombo;
import swing.SLabel;

import javax.swing.*;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DELETE_STUDENT extends JFrame implements ActionListener {

    SButton[] buttons = new SButton[3];
    SLabel[] labels = new SLabel[3];
    SCombo[] combos = new SCombo[4];
    Integer[] strs3 = {};
    TransactionManager tm;

    public DELETE_STUDENT() {
        this.getContentPane().setLayout(new FlowLayout());
        tm = new TransactionManager();
        strs3 = tm.returnIndexes().toArray(new Integer[0]);

        buttons[0] = new SButton("DELETE STUDENT", "delete selected student entity", 300, 0);
        buttons[1] = new SButton("CLOSE", "cancel operation", 300, 200);

        combos[0] = new SCombo(strs3, 100, 100);
        labels[0] = new SLabel("index",
                combos[0].returnX(),
                combos[0].returnY());

        for (int i = 0; i <= 1; i++) {
            add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        add(combos[0]);
        add(labels[0]);

        setSize(600, 800);
        setResizable(false);
        setLayout(null);
        setTitle("Delete student with a selected index");
        setVisible(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        TransactionManager tm = new TransactionManager();
        switch(action){
            case "DELETE STUDENT":
                tm.delete_student((Integer) (Integer) combos[0].getSelectedItem());
                System.out.println("deleted.");
                break;
            case "CLOSE":
                dispose();
                break;
        }
    }
}
