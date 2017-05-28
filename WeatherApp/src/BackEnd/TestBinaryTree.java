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
public class TestBinaryTree {
    
     public static void main(String[] args) {
         WeatherHistory testHistory = new WeatherHistory();
//         mt.add(15);
//         mt.add(18);
//         mt.add(12);
//         
//         mt.add("Oscar");
//         mt.add("Richard");
//         mt.add("Laura");
         testHistory.loadObservationsFromHTMLFile();
//         System.out.println(testHistory.getObservations());
       
        
         System.out.println(testHistory.checkWeatherByDate("1/01/2015"));
         
         
         
     }
}
