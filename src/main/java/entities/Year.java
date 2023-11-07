package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Years")

public class Year {
    private int year_id = 0;
    private int year_name;

    private Set<Student> students = new HashSet<Student>();

    public Year() {}

    public Year(int year_name) {
        this.year_name = year_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "YEAR_ID")
    public int getYear_id() {
        return year_id;
    }
    public void setYear_id(int year_id) {
        this.year_id = year_id;
    }
    public int getYear_name() {
        return year_name;
    }
    public void setYear_name(int year_name) {
        this.year_name = year_name;
    }
    public void addStudents(Student students) {
        this.students.add(students);
    }


}
