package FrontEnd;

import BackEnd.*;

public class FrontClass {

  public static void main(String[] args) {

    Database db = new BackClass();
// you can call the readFromHTMLfile method here
    db.loadObservationsFromHTMLFile();

    // but you can't call the printSomething method here
    // this is because it isn't part of the interface declarations
    // db.printSomething();

  }
}
