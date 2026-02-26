package at.spengergasse.spring_thymeleaf.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fahrzeuge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;   // integer nicht int

    private String marke;
    private int maxGeschwindigkeit;
    private double preis;

    public Integer getId() {   // ← WICHTIG
            return id;
    }

    public void setId(Integer id) {
            this.id = id;
    }

    public String getMarke() {
            return marke;
    }

    public void setMarke(String marke) {
            this.marke = marke;
    }

    public int getMaxGeschwindigkeit() {
            return maxGeschwindigkeit;
    }

    public void setMaxGeschwindigkeit(int maxGeschwindigkeit) {
            this.maxGeschwindigkeit = maxGeschwindigkeit;
    }

    public double getPreis() {
            return preis;
    }

    public void setPreis(double preis) {
            this.preis = preis;
    }
}
