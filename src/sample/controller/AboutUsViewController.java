package sample.controller;

import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * About us scene
 */
public class AboutUsViewController {

    /**
     * Method to load profile view (set center after click button About Us on side menu)
     * @return mainView
     */
    public HBox loadAboutUsView(){

        HBox mainView = new HBox();
        VBox firstPerson = new VBox();
        VBox secondPerson = new VBox();
        firstPerson.setPrefWidth(500);
        secondPerson.setPrefWidth(500);



        Label dominikNameLabel = new Label("Drąg Dominik");
        Label arystydesNameLabel = new Label("Krukar Arystydes");

        Hyperlink dominikEmail = new Hyperlink("\n\ndominikdrag98@gmail.com");
        Hyperlink arystydesEmail = new Hyperlink("\n\narystydes.krukar@gmail.com");

        Hyperlink dominikGit = new Hyperlink("https://github.com/dragdominique");
        Hyperlink arystydesGit = new Hyperlink("https://github.com/Arys1998");


        Text aboutDominik = new Text("\n\nLorem ipsum dolor sit amet,\n consectetur adipiscing elit. Donec sit amet scelerisque massa.\n Quisque tortor ex, sollicitudin cursus ante sed,\n eleifend lacinia felis. Vivamus tincidunt risus et\n lectus venenatis condimentum. Ut condimentum \nnunc lacinia dolor fermentum lacinia. Donec non diam\n in ipsum molestie vestibulum. Sed et risus eu ante\n iaculis dapibus quis id nisi. Phasellus \nfeugiat suscipit risus, id semper nunc commodo\n ut. Sed vel ligula aliquet nulla sodales vestibulum\n in non erat. Integer fringilla faucibus nunc eu \nvestibulum. Nullam sit amet velit pretium,\n iaculis quam a, lobortis mauris.");
        Text aboutArystydes = new Text("\n\nI'm second year computer sciencie student,\n on Military University of Technology in Warsaw.\n Currently I'm doing project in swift for my mobilabs course.\n My hobby is weightlifting and in the near future i will be \npreparing for the Polish youth championship in weightlifting. \n");
        aboutArystydes.setFont(Font.font("veradana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        aboutDominik.setFont(Font.font("veradana", FontWeight.BOLD, FontPosture.REGULAR, 16));


        firstPerson.getChildren().addAll(dominikNameLabel,dominikEmail,dominikGit, aboutDominik);
        secondPerson.getChildren().addAll(arystydesNameLabel,arystydesEmail,arystydesGit, aboutArystydes);

        firstPerson.setPadding(new Insets(10,10,10,10));
        secondPerson.setPadding(new Insets(10,10,10,10));

        mainView.getChildren().addAll(firstPerson,secondPerson);


        return mainView;
    }

}
