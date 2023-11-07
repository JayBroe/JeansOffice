package application;

import database.TransactionManager;
import swing.SButton;
import swing.SLabel;
import swing.STextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class STATE_MANAGE extends JFrame implements ActionListener {
    SButton[] buttons = new SButton[4];
    STextField[] fields = new STextField[3];
    SLabel[] labels = new SLabel[1];
    public STATE_MANAGE() {
        this.getContentPane().setLayout(new FlowLayout());

        buttons[0] = new SButton("SAVE STATE", "Save db state", 300, 100);
        buttons[1] = new SButton("RETRIEVE STATE", "Load previous version of data", 300, 300);
        buttons[2] = new SButton("SHOW REPLICAS", "Show every saved replica", 300, 500);
        buttons[3] = new SButton("CLOSE", "Cancel operation", 50, 500);

        fields[0] = new STextField("Name your db replica: ", 150, 30);
        labels[0] = new SLabel("add/retreieve",
                fields[0].returnX() - 40,
                fields[0].returnY());
        for (int i = 0; i < 4; i++) {
            add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        add(fields[0]);
        add(labels[0]);

        setSize(600, 800);
        setResizable(false);
        setLayout(null);
        setTitle("SAVE STATE OF THE DATABASE");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        Instant instant = Instant.now();
        String action = ae.getActionCommand();
        TransactionManager tm = new TransactionManager();
        switch (action) {
            case "SAVE STATE":
                System.out.println("Database state saved at: " + instant + " with name " + fields[0].getText());
                tm.save_database(fields[0].getText());
                break;
            case "RETRIEVE STATE":
                System.out.println("Database restored from point: " + instant);
                //tm.retrieve_database();
                tm.retrieve_database(fields[0].getText());
                break;
            case "SHOW REPLICAS":
                System.out.println("Database restored from point: " + instant);
                tm.show_replicas();
                break;
            case "CLOSE":
                dispose();
                break;
        }
    }
}
