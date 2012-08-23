/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import apurakenteet.JoustavaTaulukko;
import java.util.ArrayList;

/**
 *
 * @author Kati
 */
public class Tiedostot {
    String tiedostonNimi;
    //ArrayList <String> tiedosto;
    JoustavaTaulukko tiedosto;

    //public Tiedostot(String tiedostonNimi, ArrayList<String> tiedosto) {
    public Tiedostot(String tiedostonNimi, JoustavaTaulukko tiedosto) {
        this.tiedostonNimi = tiedostonNimi;
        this.tiedosto = tiedosto;
    }

    public String getTiedostonNimi() {
        return tiedostonNimi;
    }

//    public ArrayList<String> getTiedosto() {
//        return tiedosto;
//    }
    public JoustavaTaulukko getTiedosto() {
        return tiedosto;
    }

    
}



