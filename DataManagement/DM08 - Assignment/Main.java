package dk.sdu.mmmi.test;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Oliver Marco van Komen
 */
public class Main {
    // Genre Creation

    Genre crimeGenre = new Genre(1, "Crime");
    Genre dramaGenre = new Genre(2, "Drime");
    Genre thrillerGenre = new Genre(3, "Thriller");
    Genre comedyGenre = new Genre(4, "Comedy");

    // Person Creation
    Person bongJoonHo = new Person(1, "Bong Joon Ho",
            new ArrayList<String>() {
        {
            add("Director");
            add("Writer");
            add("Producer");
        }
    }
    );
    Person toddPhillips = new Person(2, "Todd Phillips",
            new ArrayList<String>() {
        {
            add("Director");
            add("Writer");
            add("Producer");
        }
    }
    );
    Person joaquinPhoenix = new Person(3, "Joaquin Phoenix",
            new ArrayList<String>() {
        {
            add("Actor");
            add("Producer");
        }
    }
    );
    Person robertDeNiro = new Person(4, "Robert De Niro",
            new ArrayList<String>() {
        {
            add("Actor");
            add("Producer");
        }
    }
    );
    Person kangHoSong = new Person(5, "Kang-ho Song",
            new ArrayList<String>() {
        {
            add("Actor");
        }
    }
    );
    Person sodamPark = new Person(6, "So-dam Park",
            new ArrayList<String>() {
        {
            add("Actress");
        }
    }
    );

    // Movie Creation
    Movie parasite = new Movie(1, "Parasite",
            new ArrayList<Genre>() {
        {
            add(dramaGenre);
            add(thrillerGenre);
            add(comedyGenre);
        }
    },
            bongJoonHo,
            new HashMap<String, Person>() {
        {
            put("Ki Taek", kangHoSong);
            put("Ki Jung", sodamPark);
        }
    }
    );
    Movie joker = new Movie(2, "Joker",
            new ArrayList<Genre>() {
        {
            add(crimeGenre);
            add(dramaGenre);
            add(thrillerGenre);
        }
    },
            toddPhillips,
            new HashMap<String, Person>() {
        {
            put("Arthur Fleck", joaquinPhoenix);
            put("Murray Franklin", robertDeNiro);
        }
    }
    );

    // Convert the three arrays (genres, persons, movies) into a .json file
    public void jsonExercise() {


        ArrayList<Genre> genres = new ArrayList<Genre>() {
            {
                add(crimeGenre);
                add(dramaGenre);
                add(thrillerGenre);
                add(comedyGenre);
            }
        };

        ArrayList<Person> persons = new ArrayList<Person>() {
            {
                add(bongJoonHo);
                add(toddPhillips);
                add(joaquinPhoenix);
                add(robertDeNiro);
                add(kangHoSong);
                add(sodamPark);
            }
        };

        ArrayList<Movie> movies = new ArrayList<Movie>() {
            {
                add(parasite);
                add(joker);
            }
        };
    }
}
