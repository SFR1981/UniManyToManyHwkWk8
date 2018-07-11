package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class DBLesson {


    private static Session session;

    //what do we need to do?
    // give a list of lessons from a student

    public static List<Lesson> getLessonsFromStudent(Student student){
        List<Lesson> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Lesson.class);
            cr.add(Restrictions.eq("course", student.getCourse()));
            results = cr.list();

        }catch (HibernateException e){
            e.printStackTrace();

        }finally{
            session.close();
        }
        return results;
    }

    public static List<Student> getStudentsFromLesson(Lesson lesson){
        List<Student> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria cr = session.createCriteria(Student.class);
            cr.add(Restrictions.eq("course", lesson.getCourse()));
            results = cr.list();

        }catch (HibernateException e){
            e.printStackTrace();

        }finally{
            session.close();
        }
        return results;
    }




}
