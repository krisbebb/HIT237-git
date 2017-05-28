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
public class TestMethods {
     public static void main(String[] args) {
         WeatherHistory historyNew = new WeatherHistory();
         historyNew.loadObservationsFromHTMLFile();
         
         //String preorder = historyNew.getObservations();
         //System.out.println("Testing print preorder");
         //System.out.println(preorder);
         
         System.out.println("Testing toString");
         String preorder = historyNew.toString();
         System.out.println(preorder);
         historyNew.toString();
     
         
         String output = historyNew.checkWeatherByDate("1/01/2015");
         if (output != "Results by date: ") {
         System.out.println(output);
         
        } else {
             System.out.println("No results to display");
         }
     }    
}
