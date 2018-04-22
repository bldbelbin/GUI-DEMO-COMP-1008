package movies;

import java.io.FileWriter;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Jarvis
 */
public class FXMLMoviesDocumentController implements Initializable {
    
    //ChoiceBox for movie titles
    @FXML private TextField titleTextField;
    
    //ComboBox for Actors selection
    @FXML private TextField actorsTextField;
    
    // RadioButton section for Genre
    @FXML private RadioButton familyRadioButton;
    @FXML private RadioButton thrillerRadioButton;
    @FXML private RadioButton musicRadioButton;
    @FXML private RadioButton comedyRadioButton;
    @FXML private RadioButton scifiRadioButton;
    @FXML private RadioButton adventureRadioButton;
    @FXML private RadioButton actionRadioButton;
    @FXML private RadioButton fantasyRadioButton;  
    @FXML private RadioButton horroRadioButton;
    @FXML private RadioButton romanceRadioButton;
    @FXML private RadioButton crimeRadioButton;
    @FXML private RadioButton documentryRadioButton;
    @FXML private RadioButton mysteryRadioButton;
    @FXML private RadioButton dramaRadioButton;
    
    // year released slider
    @FXML private Slider lengthInMinsSlider;
    @FXML private Label sliderLabel;
    
    //Texfield to add length in mins
    @FXML private TextField yearTextField;
    
    //Button to Write to File
    @FXML private Button writeToFileButton;
    
    // Label to display if the file was written
    @FXML private Label writeToFileLabel;
    
    private ToggleGroup genreSelectedToggle;
    
    @FXML
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // slider for the film length
        lengthInMinsSlider.setMin(0);
        lengthInMinsSlider.setMax(240);
        lengthInMinsSlider.setShowTickLabels(true);
        lengthInMinsSlider.setShowTickMarks(true);
        lengthInMinsSlider.setMajorTickUnit(10);
        lengthInMinsSlider.setMinorTickCount(5);
        updateLengthSliderLabel();
        
        //configure toggle group
        this.genreSelectedToggle = new ToggleGroup();
        this.familyRadioButton.setToggleGroup(genreSelectedToggle);
        this.thrillerRadioButton.setToggleGroup(genreSelectedToggle);
        this.thrillerRadioButton.setToggleGroup(genreSelectedToggle);
        this.musicRadioButton.setToggleGroup(genreSelectedToggle);
        this.comedyRadioButton.setToggleGroup(genreSelectedToggle);
        this.scifiRadioButton.setToggleGroup(genreSelectedToggle);
        this.adventureRadioButton.setToggleGroup(genreSelectedToggle);
        this.actionRadioButton.setToggleGroup(genreSelectedToggle);
        this.fantasyRadioButton.setToggleGroup(genreSelectedToggle);
        this.horroRadioButton.setToggleGroup(genreSelectedToggle);
        this.romanceRadioButton.setToggleGroup(genreSelectedToggle);
        this.crimeRadioButton.setToggleGroup(genreSelectedToggle);
        this.documentryRadioButton.setToggleGroup(genreSelectedToggle);
        this.mysteryRadioButton.setToggleGroup(genreSelectedToggle);
        this.dramaRadioButton.setToggleGroup(genreSelectedToggle);
        
    }  
    
    /**
     * Method to update the slider label to show length in minutes
     */
    
     public void updateLengthSliderLabel()
    {
        this.sliderLabel.setText(String.format("%.0f",lengthInMinsSlider.getValue()));   
    }
     
     /**
      * Method to write data entered into a text file
      */
     public void writeToFileButtonPushed () {
         
      String genre = ((RadioButton) this.genreSelectedToggle.getSelectedToggle()).getText();
      sliderLabel.setText(String.format("%.0f", this.lengthInMinsSlider.getValue()));
      String title = this.titleTextField.getText();
      String actor =  this.actorsTextField.getText();
      int year = (Integer.parseInt(this.yearTextField.getText()));
       
      Movie movie = new Movie(title, actor, genre, year, (int)this.lengthInMinsSlider.getValue());
    
         try (FileWriter writer = new FileWriter("moviecatalogue.txt",true)){

           
             writer.write(movie.toString()+"\n");
             
             
                writeToFileLabel.setText("Success");

         } 
         catch (Exception e)
         {
               System.out.println(e);    
               writeToFileLabel.setText("All Fields Must Be Filled");
         }
         
     }
}
