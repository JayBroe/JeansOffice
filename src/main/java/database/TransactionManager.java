package database;

import com.github.javafaker.Faker;
import entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static database.HibernateUtility.getSessionFactory;


public class TransactionManager {

    private Session session;
    private SessionFactory factory;

    public TransactionManager() {
        factory = getSessionFactory();
        session = factory.openSession();
        session.beginTransaction();
    }

    public void show_students() {
        List ttf = session.createQuery("FROM Student").list();
        for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
            Student s = (Student) iterator.next();
            System.out.println("ID : " + s.getStudent_id());
            System.out.println("Name : " + s.getName());
            System.out.println("Surname : " + s.getSurname());
            System.out.println("Year : " + s.getYear().getYear_name());
            System.out.println("Form : " + s.getForm().getForm_name());
            System.out.println("Major : " + s.getMajor().getMajor_name());

        }
        session.getTransaction().commit();
        session.close();
    }

    public String return_students(){
        List ttf = session.createQuery("FROM Student").list();
        //String sa[] = new String[];
        for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
            Student s = (Student) iterator.next();
            return s.getName();
        }
        return "nic";
    }

    public String return_students1(){
        Student sa = new Student();
        List ttf = session.createQuery("FROM Student").list();
        for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
            Student s = (Student) iterator.next();
            sa = s;
        }
        return sa.getName();
    }


    public void delete_student(int index) {
        List ttf = session.createQuery("FROM Student").list();
        for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
            Student s = (Student) iterator.next();
            if (s.getStudent_id() == index) {
                session.delete(s);
            }
        }
        session.getTransaction().commit();
        session.close();
    }

    public void update_student(int index, String name, String surname) {
        List ttf = session.createQuery("FROM Student").list();
        for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
            Student s = (Student) iterator.next();
            if (s.getStudent_id() == index) {
                if (!name.isEmpty()) {
                    s.setName(name);
                }
                if (!surname.isEmpty()) {
                    s.setSurname(surname);
                }
            }
        }
        session.getTransaction().commit();
        session.close();
    }

    public List<Integer> returnFormsIds() {
        Session session = factory.openSession();
        session.beginTransaction();
        Integer[] tab = {};
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(tab));

        try {
            List ttf = session.createQuery("FROM Form").list();
            for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
                Form s = (Form) iterator.next();
                l.add(s.getForm_id());
            }

        }catch(HibernateException e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return l;
    }

    public List<String> returnFormsNames() {
        Session session = factory.openSession();
        session.beginTransaction();
        List<String> l = new ArrayList<String>();
        try {
            List ttf = session.createQuery("FROM Form").list();
            for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
                Form s = (Form) iterator.next();
                l.add(s.getForm_name());
            }
        }catch(HibernateException e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return l;
    }

    public List<Integer> returnMajorsIds() {
        Session session = factory.openSession();
        session.beginTransaction();
        Integer[] tab = {};
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(tab));

        try {
            List ttf = session.createQuery("FROM Major").list();
            for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
                Major s = (Major) iterator.next();
                l.add(s.getMajor_id());
            }
        }catch(HibernateException e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return l;
    }

    public List<String> returnMajorsNames() {
        Session session = factory.openSession();
        session.beginTransaction();
        List<String> l = new ArrayList<String>();
        try {
            List ttf = session.createQuery("FROM Major").list();
            for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
                Major s = (Major) iterator.next();
                l.add(s.getMajor_name());
            }
        }catch(HibernateException e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return l;
    }

    public List<Integer> returnYearIds() {
        Session session = factory.openSession();
        session.beginTransaction();
        Integer[] tab = {};
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(tab));

        try {
            List ttf = session.createQuery("FROM Year").list();
            for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
                Year s = (Year) iterator.next();
                l.add(s.getYear_id());
            }
        }catch(HibernateException e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return l;
    }

    public List<Integer> returnYearsNames() {
        Session session = factory.openSession();
        session.beginTransaction();
        Integer[] tab = {};
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(tab));

        try {
            List ttf = session.createQuery("FROM Year").list();
            for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
                Year s = (Year) iterator.next();
                l.add(s.getYear_name());
            }
        }catch(HibernateException e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return l;
    }

    public List<Integer> returnIndexes() {
        Session session = factory.openSession();
        session.beginTransaction();
        Integer[] tab = {};
        List<Integer> l = new ArrayList<Integer>(Arrays.asList(tab));

        try {
            List ttf = session.createQuery("FROM Student").list();
            for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
                Student s = (Student) iterator.next();
                l.add(s.getStudent_id());
            }
        }catch(HibernateException e){
            e.printStackTrace();
        } finally{
            session.close();
        }
        return l;
    }


    public void add_student(String name, String surname, int vyear, int vform, int vmajor) {

        Student student = new Student();

        Year year = (Year) session.get(Year.class, vyear);
        Form form = (Form) session.get(Form.class, vform);
        Major major = (Major) session.get(Major.class, vmajor);

        student.setName(name);
        student.setSurname(surname);
        student.setYear(year);
        student.setForm(form);
        student.setMajor(major);

        session.save(student);

        session.getTransaction().commit();
        session.close();
    }

    public void create_random_student(){
        Session session = factory.openSession();
        session.beginTransaction();

        try {
            Student s = new Student();

            Random r = new Random();
            Faker faker = new Faker();

            List<Integer> list = returnFormsIds();
            int[] array = list.stream().mapToInt(i -> i).toArray();
            int randomForm = r.nextInt(1,array.length);

            List<Integer> list1 = returnMajorsIds();
            int[] array1 = list1.stream().mapToInt(i -> i).toArray();
            int randomMajor = r.nextInt(1,array1.length);

            List<Integer> list2 = returnYearIds();
            int[] array2 = list2.stream().mapToInt(i -> i).toArray();
            int randomYear = r.nextInt(1,array2.length);

            Form form = (Form) session.get(Form.class, randomForm);
            Major major = (Major) session.get(Major.class, randomMajor);
            Year year = (Year) session.get(Year.class, randomYear);

            Form form1 = (Form) session.get(Form.class, 1);
            Major major1 = (Major) session.get(Major.class, 11);
            Year year1 = (Year) session.get(Year.class, 1);


            s.setForm(form);
            s.setMajor(major);
            s.setYear(year);
            s.setName(faker.name().firstName());
            s.setSurname(faker.name().lastName());
            session.save(s);

        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        session.close();
    }

    public void find_student(int index){
        List ttf = session.createQuery("FROM Student").list();
        for (Iterator iterator = ttf.iterator(); iterator.hasNext(); ) {
            Student s = (Student) iterator.next();
            if (s.getStudent_id() == index) {
                System.out.println("ID : " + s.getStudent_id());
                System.out.println("Name : " + s.getName());
                System.out.println("Surname : " + s.getSurname());
                System.out.println("Year : " + s.getYear().getYear_name());
                System.out.println("Form : " + s.getForm().getForm_name());
                System.out.println("Major : " + s.getMajor().getMajor_name());
            }
        }
        session.getTransaction().commit();
        session.close();
    }

    public void save_database(String what) {
        Session session = factory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            LocalDate ld = LocalDate.now();
            LocalTime lt = LocalTime.now();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS " +what+ " (\n" +
                    "`student_id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
                    "`form_id` BIGINT NOT NULL,\n" +
                    "`major_id` BIGINT NOT NULL,\n" +
                    "`year_id` BIGINT NOT NULL,\n" +
                    "`name` varchar(45) NOT NULL,\n" +
                    "`surname` varchar(45) NOT NULL,\n" +
                    "PRIMARY KEY (`student_id`),\n" +
                    "KEY `fk_form1` (`form_id`),\n" +
                    "KEY `fk_major1` (`major_id`),\n" +
                    "KEY `fk_year1` (`year_id`),\n" +
                    "CONSTRAINT `"+what+"_form1` FOREIGN KEY (`form_id`) REFERENCES `forms` (`form_id`),\n" +
                    "CONSTRAINT `"+what+"_major1` FOREIGN KEY (`major_id`) REFERENCES `majors` (`major_id`),\n" +
                    "CONSTRAINT `"+what+"_year1` FOREIGN KEY (`year_id`) REFERENCES `years` (`year_id`)\n" +
                    ") AUTO_INCREMENT=100000;").executeUpdate();
            session.createNativeQuery("INSERT INTO "+what+" SELECT * FROM students").executeUpdate();
            session.createNativeQuery("INSERT INTO replicas (CopyName,Date,Time) VALUES ('"+what+"','"+ld+"','"+lt+"')").executeUpdate();

            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.beginTransaction();
        session.getTransaction().commit();
    }

    public void retrieve_database(String what){
        Session session = factory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.createNativeQuery( "SET FOREIGN_KEY_CHECKS = 0;").executeUpdate();
            session.createNativeQuery( "TRUNCATE table "+what).executeUpdate();
            session.createNativeQuery( "SET FOREIGN_KEY_CHECKS = 1;").executeUpdate();
            session.createNativeQuery( "INSERT INTO students SELECT * FROM "+what).executeUpdate();

            tx.commit();

        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.beginTransaction();
        session.getTransaction().commit();
    }

    public void show_replicas(){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createNativeQuery( "SELECT id, CopyName, Date, Time FROM Replicas;");
            List<Object[]> rows = query.list();
            for(Object[] row : rows) {
                Replicas rep = new Replicas();

                LocalDate ld = LocalDate.now();
                LocalTime lt = LocalTime.now();

                rep.setReplicas_id((int) Long.parseLong(row[0].toString()));
                rep.setCopyName(row[1].toString());
                rep.setDate(LocalDate.parse(row[2].toString()));
                rep.setTime(LocalTime.parse(row[3].toString()));
                System.out.println("ID: "+rep.getReplicas_id());
                System.out.println("Name of the replica: "+rep.getCopyName());
                System.out.println("Date: "+rep.getDate());
                System.out.println("Time: "+rep.getTime());
            }
            tx.commit();
        }catch (HibernateException e){
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        session.beginTransaction();
        session.getTransaction().commit();
    }
}