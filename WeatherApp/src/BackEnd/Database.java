package BackEnd;

public interface Database {

    public void loadObservationsFromHTMLFile();

// http://rengland.spinetail.cdu.edu.au/observations/
    public String getObservations();
   public String checkWeatherByDate(String date);

}
