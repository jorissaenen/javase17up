package be.abis.exercise.repository;


import be.abis.exercise.model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findAllCourses();
    void addCourse(Course c);

    static void printWelcomeMessage(){
        System.out.println(findMessage());
    }

    private static String findMessage(){
        return "Welcome";
    }
}
