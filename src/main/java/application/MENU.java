package application;

import database.TransactionManager;
import swing.SButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MENU extends JFrame implements ActionListener {

    String appname;

    SButton[] buttons = new SButton[6];
    public MENU(String appname){

        this.appname=appname;

        buttons[0] = new SButton("CREATE STUDENT","Add new student to database",200,50);

        buttons[1] = new SButton("DELETE STUDENT","Delete student from database",200,170);

        buttons[2] = new SButton("SHOW ALL STUDENTS","Select all students from database",200,290);

        buttons[3] = new SButton("SHOW CHOSEN STUDENT","Select and describe chosen students",200,410);

        buttons[4] = new SButton("MANAGE DATA", "Save & retrieve selected versions of database",200, 530);

        buttons[5] = new SButton("QUIT","Quit the programme", 200,650);

        for (int i=0;i<6;i++){
            add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        setSize(600,800);
        setTitle(appname);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }




    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();
        TransactionManager tm = new TransactionManager();

        switch(action){
            case "CREATE STUDENT":
                ADD_STUDENT ad = new ADD_STUDENT();
                break;
            case "SHOW CHOSEN STUDENT":
                FIND_STUDENT fs = new FIND_STUDENT();
                break;
            case "DELETE STUDENT":
                DELETE_STUDENT ds = new DELETE_STUDENT();
                break;
            case "SHOW ALL STUDENTS":
                tm.show_students();
                break;
            case "MANAGE DATA":
                STATE_MANAGE sm = new STATE_MANAGE();
                break;
            case "QUIT":
                dispose();
                break;
        }

    }

    public static void LaunchGUI(String appname) {
        MENU frame = new MENU(appname);
    }
}
