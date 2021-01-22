package starter.shelter;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import starter.Animals.Animal;
import starter.Animals.Animals;
import starter.Animals.Gender;
import starter.Reservation;

import java.net.URL;
import java.util.ResourceBundle;

public class ShelterController implements Initializable {

    private Reservation reservation;
    private Animals currSpecies = Animals.CAT;
    private String name = "";
    private String badHabbits = "";
    private Gender gender;
    private Animal selectedAnimal;

    public ShelterController() {
        this.reservation = new Reservation();
    }
//    @FXML // ResourceBundle that was given to the FXMLLoader
//    private ResourceBundle resources;
//
//    @FXML // URL location of the FXML file that was given to the FXMLLoader
//    private URL location;

    @FXML // fx:id="speciesChoice"
    private ChoiceBox<String> speciesChoice;

    @FXML
    private Button addAnimalBtn;

    @FXML
    private TextField animalName;
    @FXML
    private Label selectedName;
    @FXML
    private TextField reserverName;
    @FXML
    private TextField badHabits;
    @FXML
    private ToggleGroup toggleGroup1;
    @FXML
    ListView<Animal> animalList;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL location, ResourceBundle resources) {
        speciesChoice.getItems().setAll("Cat", "Dog");
        speciesChoice.setValue("Cat");


        speciesChoice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> selected, String oldSpecies, String newSpecies) {
                var type = getCurrSpecies(speciesChoice.getValue());
                currSpecies = type;
                if (oldSpecies != null) {
                    switch(oldSpecies) {
                        case "Cat":
                            currSpecies = Animals.CAT;
                            break;
                        case "Dog":
                            currSpecies = Animals.DOG;
                            break;

                    }
                }
                if (newSpecies != null) {
                    switch(newSpecies) {
                        case "Cat":
                            currSpecies = Animals.CAT;
                            break;
                        case "Dog":
                            currSpecies = Animals.DOG;
                            break;
                    }
                }
            }
        });
        
        animalList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Animal>(){
            @Override
            public void changed(ObservableValue<? extends Animal> observableValue, Animal animal, Animal t1) {
                if(t1 != null){
                    selectedAnimal = t1;
                    selectedName.setText(t1.getName());
                    return;
                }
                if(animal != null){
                    selectedAnimal = animal;
                    selectedName.setText(animal.getName());
                }

            }
        });
    }

    @FXML
    public void AddAnimalBtnClicked(MouseEvent mouseEvent) {
        this.name = animalName.getText();
        this.badHabbits = badHabits.getText();
        var selected = (RadioButton) this.toggleGroup1.getSelectedToggle();
        var selectedValue = selected.getText();
        this.gender = selectedValue.equals("Male") ? Gender.Male : Gender.Female;
        switch(currSpecies){
            case CAT:
                reservation.NewCat(name, gender, badHabbits);
                break;
            case DOG:
                reservation.NewDog(name, gender);
                break;
            default:
                break;
        }
        this.UpdateView();
    }

    @FXML
    public void reserveAnimalBtnClicked(MouseEvent mouseEvent) {

        this.selectedAnimal.Reserve(this.reserverName.getText());
        this.UpdateView();
        var x = reservation;
        var y =1;
    }

    public Animals getCurrSpecies(String name) {
        switch(name){
            case "Cat":
                return Animals.CAT;
            case "Dog":
                return Animals.DOG;
            default:
                return Animals.UNKNOWN;
        }
    }

    public void UpdateView(){
        ObservableList<Animal> items = FXCollections.observableArrayList();
        items.addAll(this.reservation.getAnimals());
        animalList.setItems(items);
    }
}
