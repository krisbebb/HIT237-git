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
public class WeatherObservation {

    private double windSpeed = 0;
    private double uVIndex = 0;
    private double humidity = 0;
    private double temperature = 0;
    private String date = "1/1/1970";
    private String place = "No location set";

    public WeatherObservation() {
    }

    public WeatherObservation(String place,
            String date, double temperature, double humidity, double uVIndex,
            double windSpeed) {

        this.place = place;
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.uVIndex = uVIndex;
        this.windSpeed = windSpeed;
    }

    public void setPlace(String place) {

        this.place = place;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public void setTemperature(double temperature) {

        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {

        this.humidity = humidity;
    }

    public void setUVIndex(double uVIndex) {

        this.uVIndex = uVIndex;
    }

    public void setWindSpeed(double windSpeed) {

        this.windSpeed = windSpeed;
    }

    public String getPlace() {
        return this.place;
    }

    public String getDate() {
        return this.date;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public double getHumidity() {
        return this.humidity;
    }

    public double getUVIndex() {
        return this.uVIndex;
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    
    @Override

    public String toString() {
        return ("\nLocation: - " + this.place
                + "\nDate: - " + this.date
                + "\nTemperature: - " + this.temperature + " Degrees"
                + "\nHumidity: - " + this.humidity + " Percent"
                + "\nUV Index: - " + this.uVIndex
                + "\nWind Speed: - " + this.windSpeed) + " km/h\n";
    }
}
class Node {
    
//    int data;
    WeatherObservation value;
    Node left;
    Node right;
    
    public Node(){
    }
    
    public Node (WeatherObservation name) {
        this.value = name;
    }
    
    public Node insert(Node node, WeatherObservation value) {
        if (node == null) {
            node = new Node(value);
        } else {
            if (value.getDate().compareTo(node.value.getDate()) <= 0) {
                    node.left = insert(node.left, value);
                    } else {
                           node.right = insert(node.right, value);
                    }
         }
        return node;
    }
    
public Node search(Node node, String date) {
        if (node == null) {
            System.out.println("Found nothing");
            return null;
        } 
        if (node.value.getDate().compareTo(date) == 0) {
            System.out.println("Found " + date);
            return node;
        } else {
            Node leftNode = search(node.left, date);
            Node rightNode = search(node.right, date);
            if (leftNode != null) {
                return leftNode;                
            } else {
                return rightNode;
            }
        }
        }     
            
    
    public void print(Node root) {
        if (root != null) {
            print(root.left);
            System.out.println("observation: " + root.value);
            print(root.right);
            
        }
        
    }
}
