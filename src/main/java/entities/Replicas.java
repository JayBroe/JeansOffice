package entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Replicas")

public class Replicas {
    private int id;
    private String CopyName;
    private LocalDate Date;
    private LocalTime Time;

    private Set<Replicas> replicas = new HashSet<Replicas>();

    public Replicas() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")

    public int getReplicas_id() {
        return id;
    }
    public void setReplicas_id(int id) {
        this.id = id;
    }
    public String getCopyName() {
        return CopyName;
    }
    public void setCopyName(String CopyName) {
        this.CopyName = CopyName;
    }
    public LocalDate getDate(){return Date;}
    public void setDate(LocalDate Date){this.Date = Date;}
    public LocalTime getTime(){return Time;}
    public void setTime(LocalTime Time){this.Time = Time;}
}