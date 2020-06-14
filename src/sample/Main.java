package sample;

import io.quicktype.Converter;
import io.quicktype.Rate;
import io.quicktype.Welcome;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import sample.controller.MainViewController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author arystydeskrukar
 * @author dominikdrag
 * @version 1.0
 */
public class Main extends Application {
    private MainViewController mainViewController = new MainViewController();
    private Converter converter = new Converter();
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @param primaryStage
     * @throws Exception
     * Starts the program
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainViewController.setMainStage(primaryStage);
        mainViewController.setupMainScene();
        Rate rate = new Rate();
        rate.mid = 4.44;

        try{
            URL url = new URL("https://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json&fbclid=IwAR0aPGYTYbRI3vSww9ZaWnGxe2Lg4heJFateaIJvDMbGC0MgsheAypVAc_E");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            System.out.println("Poloczano");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                content.append(inputLine);
            }
            System.out.println(content);

            rate = Converter.fromJsonString(String.valueOf(content));
            rate.getMid();
            in.close();
        } catch (IOException e){
            System.out.println("EEEEE Dziobal");
        }
    }

}

        