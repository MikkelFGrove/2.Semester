package dk.sdu.mmmi.test;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Oliver Marco van Komen
 */
public class Movie {
    
    private int id;
    
    private String title;
    
    private List<Genre> genres;
    
    private Person director;
    
    private HashMap<String, Person> actorsRoles;
    
    public Movie(int id, String title, List<Genre> genres, Person director, HashMap<String, Person> actorsRoles) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.director = director;
        this.actorsRoles = actorsRoles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    public String toJson(){
        return "";
    }
}