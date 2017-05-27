/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author kris
 */
public class TestWeatherHistory {

    public static void main(String[] args) {
        System.out.println("WeatherObservation Class Testing: ");
        // Create WeatherObservation object Day1
        // use default constructor and individual methods to test all methods
        System.out.println("\nTesting Default Constructor and toString method:");
        WeatherObservation day1 = new WeatherObservation();
        String obsDay1 = day1.toString();
        System.out.println(obsDay1);

        // TestWeatherHistory set and get methods for day1
        System.out.println("\nTesting set and get methods for the class: \n");
        day1.setPlace("Brisbane");
        day1.setDate("23/2/2012");
        day1.setTemperature(40.2);
        day1.setHumidity(80);
        day1.setUVIndex(10);
        day1.setWindSpeed(45.7);

        System.out.println("Place: " + day1.getPlace());
        System.out.println("Date: " + day1.getDate());
        System.out.println("Temperature: " + day1.getTemperature());
        System.out.println("Humidity: " + day1.getHumidity());
        System.out.println("UV Index: " + day1.getUVIndex());
        System.out.println("Wind Speed: " + day1.getWindSpeed());

        // Create WeatherObservation object Day2
        // use constructor (data, data, data, data, ...)
        System.out.println("\nTesting Overloaded Constructor and toString method:");
        WeatherObservation day2 = new WeatherObservation("Sydney", "3/4/1992",
                28, 55, 2, 17);
        String obsDay2 = day2.toString();
        System.out.println(obsDay2);

        // Create WeatherHistoryObject - twoDayHistory
        // use default constructor
        System.out.println("\nWeatherHistory Class Testing: ");
        WeatherHistory twoDayHistory = new WeatherHistory();

        // print ArrayList
        String weatherArray = twoDayHistory.toString();

        System.out.println("\nTesting Default Constructor and toString method: \n"
                + weatherArray);

        // add Day1
        twoDayHistory.addDay(day1);

        // print ArrayList
        twoDayHistory.toString();

        // add Day2
        twoDayHistory.addDay(day2);

        // print ArrayList
        weatherArray = twoDayHistory.toString();
        System.out.println("\nTesting ArrayList after adding 2 days: \n"
                + weatherArray);

//        // get and print one element
//        WeatherObservation secondDay = twoDayHistory.getDay(1);
//        System.out.println("\nAccessing second day in the List: \n" + secondDay);
//
//        // remove one element
//        twoDayHistory.removeDay(0);

        // print ArrayList
        weatherArray = twoDayHistory.toString();
        System.out.println("Testing ArrayList after removing first day: \n"
                + weatherArray);

    }
}
