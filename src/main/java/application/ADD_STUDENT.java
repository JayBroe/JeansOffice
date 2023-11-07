package application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import swing.*;
import database.*;
public class ADD_STUDENT extends JFrame implements ActionListener {

    SButton[] buttons = new SButton[7];
    STextField[] fields = new STextField[6];
    SLabel[] labels = new SLabel[6];
    SCombo[] combos = new SCombo[4];
    TransactionManager tm = new TransactionManager();

    Integer[] forms_ids = tm.returnFormsIds().toArray(new Integer[0]);
    String[] forms_names = tm.returnFormsNames().toArray(new String[0]);
    Integer[] years_ids = tm.returnYearIds().toArray(new Integer[0]);
    Integer[] majors_ids = tm.returnMajorsIds().toArray(new Integer[0]);
    String[] majors_names = tm.returnMajorsNames().toArray(new String[0]);
    public ADD_STUDENT(){
        this.getContentPane().setLayout(new FlowLayout());

        System.out.println(tm.returnMajorsNames());

        fields[0] = new STextField(100,200);
        labels[0] = new SLabel("name",
                fields[0].returnX()-20,
                fields[0].returnY());
        fields[1] = new STextField(100,300);
        labels[1] = new SLabel("surname",
                fields[1].returnX()-20,
                fields[1].returnY());
        combos[0] = new SCombo(years_ids,100,400);
        labels[2] = new SLabel("year",
                combos[0].returnX()-20,
                combos[0].returnY());
        combos[1] = new SCombo(forms_ids,List.of(forms_names),100,500);
        labels[3] = new SLabel("form",
                combos[1].returnX()-20,
                combos[1].returnY());
        combos[2] = new SCombo(majors_ids,List.of(majors_names),100,600);
        labels[4] = new SLabel("major",
                combos[2].returnX()-20,
                combos[2].returnY());
        buttons[0] = new SButton("CREATE STUDENT","Add new student",330,50);

        buttons[1] = new SButton("CREATE RANDOM STUDENT","Add student with random data",330,200);

        buttons[2] = new SButton("CLOSE","Cancel",330,350);

        for (int i=0;i<3;i++){
            add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        add(fields[0]);
        add(labels[0]);

        add(fields[1]);
        add(labels[1]);

        add(combos[0]);
        add(labels[2]);

        add(combos[1]);
        add(labels[3]);

        add(combos[2]);
        add(labels[4]);

        setSize(600,900);
        setResizable(false);
        setLayout(null);
        setTitle("Please add new student");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        String action = ae.getActionCommand();
        switch(action){
            case "CREATE STUDENT":
                tm.add_student(
                        fields[0].getText(),
                        fields[1].getText(),
                        (Integer) (Integer) combos[0].getSelectedItem(),
                        (Integer) (Integer) combos[1].getSelectedItem(),
                        (Integer) (Integer) combos[2].getSelectedItem()
                );
                break;
            case "CREATE RANDOM STUDENT":
                tm.create_random_student();
                break;
            case "CLOSE":
                dispose();
                break;
        }
    }
}
