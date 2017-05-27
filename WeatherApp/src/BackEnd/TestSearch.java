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
public class TestSearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       WeatherHistory observations = new WeatherHistory();
        //observation.addDay();

        observations.loadObservationsFromHTMLFile();

//    System.out.println("is this working");
     //   String datestring = observations.checkWeatherByDate("1/01/2015");
   //     System.out.println(datestring);

        //System.out.println(observations.getObservations());

        // print ArrayList
       // String output = observations.toString();

       // System.out.println("\nTesting Default Constructor and toString method: \n"
       //         + output);

        //System.out.println("Testing file writer");
        //observations.writeToFile();

    }

}
