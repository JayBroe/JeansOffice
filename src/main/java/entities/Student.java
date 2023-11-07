package entities;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    private int student_id;
    private Major major;
    private Year year;
    private Form form;
    private String name;
    private String surname;
    public Student() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    public int getStudent_id() {
        return student_id;
    }
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "YEAR_ID")
    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAJOR_ID")
    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FORM_ID")
    public Form getForm() {
        return form;
    }
    public void setForm(Major major) {
        this.form = form;
    }

    public void setStudent(int student_id) {
        this.student_id = student_id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
    public void setSurname(String surname){
        this.surname=surname;
    }
    public String getSurname(){
        return surname;
    }
    public void setForm(Form form) {
        this.form=form;
    }
}
