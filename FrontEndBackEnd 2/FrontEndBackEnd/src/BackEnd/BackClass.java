package BackEnd;

public class BackClass implements Database {

  public void printSomething() {
    System.out.println("something");
  }
  @Override
  public void loadObservationsFromHTMLFile() {
  }
  
  @Override
  public String getObservations() {
      String observations = null;
      return observations;
  }

}
