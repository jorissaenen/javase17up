package be.abis.exercise.model;

import be.abis.exercise.util.DateUtils;

import java.time.LocalDate;

public sealed class Session permits PublicSession,CompanySession {

    private Course course;
    private String language;
    private LocalDate startDate;

    public Session(Course course, String language, LocalDate startDate) {
        this.course = course;
        this.language = language;
        this.startDate = startDate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void printInfo() {
        String message = """
                The session about %s will start on %s. 
                It will be taught in %s.""";
        System.out.println(message.formatted(course.title(), DateUtils.format(startDate), language));
    }
}
