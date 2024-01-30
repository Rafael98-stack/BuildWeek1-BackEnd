package it.be.epicode;

import it.be.epicode.Entities.Biglietteria.TrasportoPubblico.Auto_Bus;
import it.be.epicode.Entities.Biglietteria.TrasportoPubblico.Tram;

import java.time.LocalDate;

public class App {
  public static void main(String[] args) {

    Auto_Bus autoBus1 = new Auto_Bus(true, LocalDate.of(2024,2,10),LocalDate.of(2024,3,10),LocalDate.of(2024,3,11),LocalDate.of(2025,2,9));
    System.out.println(autoBus1);

    Tram tram1 = new Tram("C110");
    System.out.println(tram1);


  }
}
