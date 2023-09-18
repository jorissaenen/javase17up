package be.abis.exercise.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PublicSession extends Session {

    List<String> participants = new ArrayList<String>();

    public PublicSession(Course course, String languageCode, LocalDate startDate) {
        super(course, languageCode, startDate);
    }

    public void addParticipant(String firstName, String lastName){
        participants.add(firstName + " " + lastName);
    }

    public void printInfo(){
        super.printInfo();
        System.out.println("The participants are: ");
        participants.forEach(System.out::println);
    }


}
