package be.abis.exercise.test;

import be.abis.exercise.model.CompanySession;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.PublicSession;
import be.abis.exercise.model.Session;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;
import be.abis.exercise.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        CourseRepository cr = MemoryCourseRepository.getInstance();
        List<Course> courses = cr.findAllCourses();

        cr.addCourse(new Course("Java 17 Upgrade",1,625, LocalDate.of(2023,3,3)));

        courses.forEach(System.out::println);

        LocalDate today =  LocalDate.now();
        System.out.println("\nToday it is " + DateUtils.format(today) +".\n");

        List<Session> sessions = new ArrayList<>();
        sessions.add(new Session(courses.get(0),"English",LocalDate.of(2023,9,20)));

        PublicSession ps = new PublicSession(courses.get(1),"French",LocalDate.of(2023,9,21));
        ps.addParticipant("John","Doe");
        ps.addParticipant("An","Smets");
        sessions.add(ps);
        sessions.add(new CompanySession(courses.get(2),"Dutch",LocalDate.of(2023,9,22),10,"ING"));

        sessions.forEach(s-> {s.printInfo(); System.out.println();});
    }
}
