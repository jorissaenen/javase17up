package be.abis.exercise.model;

import java.time.LocalDate;

public class CompanySession extends Session {

    private int numberOfParticipants;
    private String organizingCompany;

    public CompanySession(Course course, String language, LocalDate startDate, int numberOfParticipants, String organizingCompany) {
        super(course, language, startDate);
        this.numberOfParticipants = numberOfParticipants;
        this.organizingCompany = organizingCompany;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getOrganizingCompany() {
        return organizingCompany;
    }

    public void setOrganizingCompany(String organizingCompany) {
        this.organizingCompany = organizingCompany;
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("There will be " + numberOfParticipants  + " participants.");
    }
}
