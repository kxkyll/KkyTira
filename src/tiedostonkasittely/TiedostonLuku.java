/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostonkasittely;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kati TiedostonLuku luokka hoitaa tiedostonlukemisen käyttäjän antaman
 * tiedostosijainnin perusteella
 */
public class TiedostonLuku {

    private ArrayList<String> tiedostonRiviLista = null;

    /**
     * Metodi lueTiedostoLevylta lukee käyttäjän antaman tiedoston levyltä
     * @param tiedostonnimi Käyttäjän antama tiedostonnimi hakemistopolkuineen
     * @return ArrayList<String> Käyttäjän antaman tiedostonnimen mukaan luettu tiedoston sisältö riveittäin
     * @throws IOException  
     */
    // Testitiedosto C:\Users\Kati\Documents\Opiskelu\Tekstit\testirivit.txt
    public ArrayList<String> lueTiedostoLevylta(String tiedostonnimi) throws IOException {
        BufferedReader tiedostonLukija = null;
        String tiedostonRivi = null;
        tiedostonRiviLista = new ArrayList<String>();
        try {

            tiedostonLukija = new BufferedReader(new FileReader(tiedostonnimi));
//            System.out.println("tiedosto avattu lukemista varten");
            while ((tiedostonRivi = tiedostonLukija.readLine()) != null) {
                tiedostonRiviLista.add(tiedostonRivi);
            }


        } catch (FileNotFoundException ex) {
            System.out.println("Tiedoston avaaminen ei onnistunut");
            Logger.getLogger(TiedostonLuku.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tiedostonLukija != null) {
            try {
                tiedostonLukija.close();
//                System.out.println("tiedosto suljettu");
            } catch (IOException ex) {
                System.out.println("Tiedoston sulkeminen ei onnistunut");
                Logger.getLogger(TiedostonLuku.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

//        System.out.println("jehuu loppuun päästiin");
        return tiedostonRiviLista;

    }

    //    public ArrayList<String> lueTiedostoLevylta(String tiedostonNimi) throws IOException {
//        System.out.println("Tiedostonnimi: " +tiedostonNimi);
//        try {
//            Scanner tiedostonLukija = new Scanner(tiedostonNimi);
//            int riviNumero = 1;
//           
//            while (tiedostonLukija.hasNextLine()) {
//                System.out.println("Rivinumero: " +riviNumero );
//                String riviTeksti = tiedostonLukija.nextLine();
//                System.out.println("Riviteksti: " +riviTeksti);
//                tiedostonRivit.add(riviTeksti);
//                //tiedostonRivit.add(tiedostonLukija.nextLine());
//            }
//            tiedostonLukija.close();
//        } catch (Exception tiedostoVirhe) {
//            System.out.println("Virhe tiedoston käsittelyssä");
//
//        }
//
//
//        return tiedostonRivit;
//    }

    
    
    
    /**
     * Metodi lueTiedostoNetista lukee käyttäjän antaman tiedoston internetistä
     *
     * @param ladattavaTiedosto Käyttäjän antama tiedostonnimi
     */
    public void lueTiedostoNetista(String ladattavaTiedosto) {
        BufferedReader tiedostonLukija = null;
        String tiedostonRivi = null;
        tiedostonRiviLista = new ArrayList<String>();
        
        HttpURLConnection yhteys;
    }
}
