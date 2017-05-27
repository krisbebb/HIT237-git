/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author kris
 */
public class WeatherHistory implements Database {

//    private ArrayList<WeatherObservation> history = new ArrayList<>();
    private BinaryTree history = new BinaryTree();

    public WeatherHistory() {

    }

    @Override
    public void loadObservationsFromHTMLFile() {
        try {
            Document doc = Jsoup.connect("http://rengland.spinetail.cdu.edu.au/observations/").get();

            Elements data = doc.select("tr"); // select all rows
            data.remove(0); // remove headings row

            for (Element tr : data) {
                Elements tds = tr.getElementsByTag("td");
                Elements ths = tr.getElementsByTag("th");

                String Place = ths.text();
                String[] rowData = tds.text().split(" ");
                String Date = rowData[0];
                Double Temperature = Double.parseDouble(rowData[1]);
                Double Humidity = Double.parseDouble(rowData[2]);
                Double UVIndex = Double.parseDouble(rowData[3]);
                Double WindSpeed = Double.parseDouble(rowData[4]);
                WeatherObservation day = new WeatherObservation(Place, Date, Temperature, Humidity, UVIndex, WindSpeed);
                history.add(day);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public String getObservations() {
        String observations = history.toString();
        return observations;
    }

    public void addDay(WeatherObservation day) {
        history.add(day);
    }

//    public void addDay() {
//        File myFile = new File("observations.txt");
//        FileReader fileReader = null;
//        BufferedReader reader = null;
//        String line = null;
//        try {
//            fileReader = new FileReader(myFile);
//            reader = new BufferedReader(fileReader);
//
//            while ((line = reader.readLine()) != null) {
//
//                String[] data = line.split(" ");
//
//                String Place = data[0];
//                String Date = data[1];
//                Double Temperature = Double.parseDouble(data[2]);
//                Double Humidity = Double.parseDouble(data[3]);
//                Double UVIndex = Double.parseDouble(data[4]);
//                Double WindSpeed = Double.parseDouble(data[5]);
//                WeatherObservation day = new WeatherObservation(Place, Date, Temperature, Humidity, UVIndex, WindSpeed);
//                history.add(day);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(WeatherHistory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            if (reader != null) {
//                reader.close();
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(WeatherHistory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

//    public WeatherObservation getDay(int dayIndex) {
//        return history.get(dayIndex);
//    }
//
//    public void removeDay(int dayIndex) {
//        history.remove(dayIndex);
//
//    }

//    public void writeToFile() {
//        File myFile = new File("bufferedoutput.txt");
//        FileReader fileWriter = null;
//        BufferedWriter writer = null;
//        String line = null;
//        try {
//            writer = new BufferedWriter(new FileWriter(myFile));
//            for (WeatherObservation day : history) {
//                writer.write(day.getPlace());
//                writer.write("\t");
//                writer.write(day.getDate());
//                writer.write("\t");
//                String temperature = Double.toString(day.getTemperature());
//                writer.write(temperature);
//                writer.write("\t");
//                String humidity = Double.toString(day.getHumidity());
//                writer.write(humidity);
//                writer.write("\t");
//                String uvindex = Double.toString(day.getUVIndex());
//                writer.write(uvindex);
//                writer.write("\t");
//                String windspeed = Double.toString(day.getWindSpeed());
//                writer.write(windspeed);
//                writer.newLine();
////System.out.println(day.toString());
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                writer.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//    }

    @Override
    public String toString() {

        return ("\nWeather History: - \n" + history);
    }

    @Override
      public void checkWeatherByDate(String string) {
     
       System.out.println("Testing");
      
   }
}

class BinaryTree {
    private Node root;
    
    public BinaryTree() {
    root = null;
    }
    
    public void add(WeatherObservation value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(root, value);
        }
    }
    
    public void getNodeValues() {
      System.out.println("first node: " + root.value);
      System.out.println("second node: " + root.right.value);
      System.out.println("third node: " + root.left.value);
    }

    public Node searchTree(String string) {
        System.out.println(root.search(root, string));
        return root.search(root, string);
    }
        
    
    public void printTree() {
        root.print(root);
    }

}     
