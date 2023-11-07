package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Forms")

public class Form {
    private int form_id;
    private String form_name;

    private Set<Student> students = new HashSet<Student>();

    public Form() {}

    public Form(String form_name) {
        this.form_name = form_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORM_ID")
    public int getForm_id() {
        return form_id;
    }
    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }
    public String getForm_name() {
        return form_name;
    }
    public void setForm_name(String form_name) {
        this.form_name = form_name;
    }
    public void addStudents(Student students) {
        this.students.add(students);
    }


}