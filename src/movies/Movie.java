package movies;

import java.time.LocalDate;


public class Movie {
    
    private String title, genre, actor;
    private int yearReleased; 
    private int lengthInMins;



    public Movie (String title, String actor, String genre, int yearReleased, int lengthInMins) {
        
        setTitle(title);
        setActor(actor);
        setYearReleased(yearReleased);
        setLengthInMins(lengthInMins);
        setGenre(genre);

        
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("The movie must have a title");
      }
           this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        if (actor.isEmpty()) {
            throw new IllegalArgumentException("The movie must have an actor");
        }
            this.actor = actor;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        if (genre.isEmpty()) {
            throw new IllegalArgumentException("The movie must have a genre");
        }
        this.genre = genre;
    }
    
    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
      int currentYear = LocalDate.now().getYear();    
        if (yearReleased <= currentYear) {
            this.yearReleased = yearReleased;
        }
    }
        

    public int getLengthInMins() {
            return lengthInMins;
       
    }

    public void setLengthInMins(int lengthInMins) {
        if (lengthInMins <= 240 && lengthInMins >= 1 ) {
            this.lengthInMins = lengthInMins;
        }
        else {
            throw new IllegalArgumentException("Movie length must be greater than 0 and less than 240 mins");
        }
    }
    
   @Override
    public String toString()
            
    {
        return String.format("Title: %s Actor: %s Genre: %s Year: %d Length %d", title, actor, genre, yearReleased, lengthInMins);
    }
}
