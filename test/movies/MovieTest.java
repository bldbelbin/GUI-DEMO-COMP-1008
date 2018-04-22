
package movies;

import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jarvis
 */
public class MovieTest {
    
    Movie movie;
    
    public MovieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        movie = new Movie("Back to the Future", "Michael J Fox", "Comedy, Sci-Fi", 1985, 106);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Movie.
     */
    @Test
    public void testGetTitle() {
        
        String expResult = "Back to the Future";
        String result = movie.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class Movie.
     */
    @Test
    public void testSetTitle() {

        movie.setTitle("While You Were Sleeping");
        String result = movie.getTitle();
        assertEquals("While You Were Sleeping", result);
    }

    /**
     * Test of getActor method, of class Movie.
     */
    @Test
    public void testGetActor() {
      
        String expResult = "Michael J Fox";
        String result = movie.getActor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActor method, of class Movie.
     */
    @Test
    public void testSetActor() {
        movie.setActor("Sandra Bullock");
        assertEquals("Sandra Bullock", movie.getActor());
    }
    
    /**
     * Test setTitle Invalid, of class Movie
     */
    @Test
    public void testSetTileInvalid() {
        String title = "";
        try {
            movie.setTitle(title);
            fail("The setTitle method with an empty argument should have triggered an exception");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     * Actor setActor Invalid, of class Movie
     */
      @Test
    public void testSetActorInvalid() {
        String actor = "";
        try {
            movie.setActor(actor);
            fail("The setActor method with an empty argument should have triggered an exception");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    
    /**
     * Test of getGenre method, of class Movie.
     */
    @Test
    public void testGetGenre() {
  
        String expResult = "Comedy, Sci-Fi";
        String result = movie.getGenre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGenre method, of class Movie.
     */
    @Test
    public void testSetGenre() {
        movie.setGenre("Romance");
        assertEquals("Romance", movie.getGenre());
    }

    /**
     * Test setGenre method, of class Movie with an invalid empty argument
     */
    @Test
    public void testSetGenreInvalid() {
        String genre = "";
        try {
            movie.setGenre("");
            fail("setGenre with an empty argument should trigger an exception");   
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
        
    }
    
    
    /**
     * Test of getYearReleased method, of class Movie.
     */
    @Test
    public void testGetYearReleased() {
       
        int expResult = 1985;
        int result = movie.getYearReleased();
        assertEquals(expResult, result);
    }
    
     /**
     * Test setYearReleased method, of class Movie
     */
    @Test 
    public void testSetYearReleased() {
        movie.setYearReleased(2014);
        assertEquals(2014, movie.getYearReleased());
    }

    /**
     * Test of getLengthInMins method, of class Movie.
     */
    @Test
    public void testGetLengthInMins() {
        int expResult = 106;
        int result = movie.getLengthInMins();
        assertEquals(expResult, result);
    }
    
     /**
     * Test setLengthInMins method, of class Movie 
     */
    @Test
    public void testSetLengthInMins() {
        int lengthInMins = 100;
        movie.setLengthInMins(lengthInMins);
        assertEquals(lengthInMins, movie.getLengthInMins(),0);
    }
    
    /**
     * Testing to see if an exception is thrown if length in minutes is too low
     */
    @Test
    public void testGetLengthInMinsInvalidLow() {
        int lengthInMins = 0;
        try{
            movie.setLengthInMins(lengthInMins);
            fail("Length in mins must start at 1, 0 should have triggered an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
    
     /**
     * Testing to see if an exception is thrown if length in minutes is too high
     */
    @Test
    public void testGetLengthInMinsInvalidHigh() {
         int lengthInMins = 241;
        try{
            movie.setLengthInMins(lengthInMins);
            fail("Max movie length is 240, 241 should have triggered an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e);
        }
    }
}
