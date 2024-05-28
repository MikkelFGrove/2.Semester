package dk.sdu.mmmi.test;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Oliver Marco van Komen
 */
public class Person {
    
    private int id;
    
    private String name;
        
    private List<String> jobTitles;
    
    private HashMap<String, Movie> oscarsWon;

    public Person(int id, String name, List<String> jobTitles) {
        this.id = id;
        this.name = name;
        this.jobTitles = jobTitles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getJobTitles() {
        return jobTitles;
    }

    public void setJobTitles(List<String> jobTitles) {
        this.jobTitles = jobTitles;
    }

    public HashMap<String, Movie> getOscarsWon() {
        return oscarsWon;
    }

    public void setOscarsWon(HashMap<String, Movie> oscarsWon) {
        this.oscarsWon = oscarsWon;
    }
    public String toJson(){
        return "";
    }
}
