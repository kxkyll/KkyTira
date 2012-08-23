/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package main;


import java.io.IOException;
import kayttoliittyma.TekstiLiittyma;

/**
 *
 * @author Kati
 * Sanahakuohjelman Main luokka
 * 
 */

public class Main {

      
    /**
     * Main metodi, käynnistetään Sanahakuohjelman tekstipohjainen käyttöliittymä
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
              
        TekstiLiittyma tekstiKaytto = new TekstiLiittyma();
        tekstiKaytto.kaynnisty();
                
    }

}
