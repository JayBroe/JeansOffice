package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Majors")

public class Major {
    private int major_id;
    private String major_name;
    private Set<Student> students = new HashSet<Student>();
    public Major() {}
    public Major(String major_name) {
        this.major_name = major_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAJOR_ID")

    public int getMajor_id() {
        return major_id;
    }
    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }
    public String getMajor_name() {
        return major_name;
    }
    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }
    public void addStudents(Student students) {
        this.students.add(students);
    }


}