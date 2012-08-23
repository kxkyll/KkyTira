

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import apurakenteet.JoustavaTaulukko;

/**
 *
 * @author Kati
 * Tiedostot luokka on tieto-olio, joka sisältää
 * tiedoston nimen String tyyppisessä oliossa ja
 * joustavan mittaisen taulukon
 * 
 */
public class Tiedostot {
    String tiedostonNimi;
    //ArrayList <String> tiedosto;
    JoustavaTaulukko tiedosto;

    //public Tiedostot(String tiedostonNimi, ArrayList<String> tiedosto) {
    /**
     * Konstruktori alustaa olion sijoittamalla parametrina saadun 
     * tiedoston nimen sekä tiedoston rivit joustavan mittaisen taulukon kenttiin
     * @param tiedostonNimi
     * @param tiedosto tiedostosta luetut rivit joustavanmittaisessa taulukossa
     */
    public Tiedostot(String tiedostonNimi, JoustavaTaulukko tiedosto) {
        this.tiedostonNimi = tiedostonNimi;
        this.tiedosto = tiedosto;
    }

    /**
     * Metodi getTiedostonNimi
     * @return palauttaa tiedoston nimen
     */
    public String getTiedostonNimi() {
        return tiedostonNimi;
    }

//    public ArrayList<String> getTiedosto() {
//        return tiedosto;
//    }
    /**
     * Metodi getTiedosto 
     * @return palauttaa JoustavaTaulukko tyyppisen tiedoston
     */
    public JoustavaTaulukko getTiedosto() {
        return tiedosto;
    }

    
}



