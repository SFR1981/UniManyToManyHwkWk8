import db.DBCourse;
import db.DBHelper;
import db.DBInstructor;
import db.DBLesson;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course = new Course("java", "phd");
        DBHelper.save(course);
        Instructor instructor = new Instructor("Mr Jones");
        DBHelper.save(instructor);
        Lesson lesson = new Lesson("Hibernate", 1, course, instructor);
        DBHelper.save(lesson);
        Student student = new Student("Harry", 40, 1, course);
        DBHelper.save(student);

        Mentor mentor = new Mentor("Mr Smith", student);
        DBHelper.save(mentor);


        List<Student> students = DBCourse.getStudentsFromCourse(course);
        List<Lesson> lessons = DBInstructor.getLessonsFromInstructor(instructor);
        List<Lesson> foundLessons = DBLesson.getLessonsFromStudent(student);
        List<Student> foundStudents = DBLesson.getStudentsFromLesson(lesson);
    }

}
