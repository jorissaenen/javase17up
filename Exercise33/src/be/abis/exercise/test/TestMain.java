package be.abis.exercise.test;

import be.abis.exercise.model.CompanySession;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.PublicSession;
import be.abis.exercise.model.Session;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;
import be.abis.exercise.util.DateUtils;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class TestMain {

    public static void main(String[] args) {

        var cr = MemoryCourseRepository.getInstance();
        var courses = cr.findAllCourses();

        cr.addCourse(new Course("Java 17 Upgrade",1,625, LocalDate.of(2023,3,3)));

        courses.forEach(System.out::println);

        var today =  LocalDate.now();
        System.out.println("\nToday it is " + DateUtils.format(today) +".\n");

        var sessions = new ArrayList<Session>();
        sessions.add(new Session(courses.get(0),"English",LocalDate.of(2023,9,20)));

        var ps = new PublicSession(courses.get(1),"French",LocalDate.of(2023,9,21));
        ps.addParticipant("John","Doe");
        ps.addParticipant("An","Smets");
        sessions.add(ps);
        var cs = new CompanySession(courses.get(2),"Dutch",LocalDate.of(2023,9,22),10,"ING");
        sessions.add(cs);

        CourseRepository.printWelcomeMessage();

        var nf = NumberFormat.getCompactNumberInstance();
        nf.setMinimumFractionDigits(1);
        for (Session s : sessions){
            s.printInfo();
            if (s instanceof CompanySession compSession){
                System.out.println("The price is " + nf.format(compSession.calculatePrice()) + ".");
            }
            System.out.println();
        }

        var now = LocalTime.now();
        var dtf1 = DateTimeFormatter.ofPattern("kk:mm");
        var dtf2 = DateTimeFormatter.ofPattern("B").withLocale(Locale.forLanguageTag("NL"));
        String message = "Op dit moment is het %s %s.";
        System.out.println(message.formatted(dtf1.format(now),dtf2.format(now)));


    }
}
