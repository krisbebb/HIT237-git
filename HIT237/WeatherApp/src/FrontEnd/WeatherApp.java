package FrontEnd;

import BackEnd.*;

public class WeatherApp {

    public static void main(String[] args) {

        Database db = new WeatherHistory();

        GUI weatherApp = new GUI();
        weatherApp.BuildGUI();
  

    }

}
