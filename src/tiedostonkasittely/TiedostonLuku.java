/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiedostonkasittely;

import apurakenteet.JoustavaTaulukko;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * TiedostonLuku luokka hoitaa tiedostonlukemisen käyttäjän antaman
 * tiedostosijainnin perusteella
 *
 * @author Kati
 */
public class TiedostonLuku {

    //private ArrayList<String> tiedostonRiviLista = null;
    private JoustavaTaulukko tiedostonRiviLista = null;

    /**
     * Metodi lueTiedostoLevylta lukee käyttäjän antaman tiedoston levyltä
     *
     * @param tiedostonnimi Käyttäjän antama tiedostonnimi hakemistopolkuineen
     * @return ArrayList<String> Käyttäjän antaman tiedostonnimen mukaan luettu
     * tiedoston sisältö riveittäin
     *
     * Mikäli annettun tiedostonnimen mukaista tiedostoa ei löydy, tai sitä ei
     * pystytä lukemaan, jätetään tämä huomiotta ja pyydetään käyttäjältä
     * seuraava tiedosto
     */
    // Testitiedosto C:\Users\Kati\Documents\Opiskelu\Tekstit\testirivit.txt
    //public ArrayList<String> lueTiedostoLevylta(String tiedostonnimi) {
    public JoustavaTaulukko lueTiedostoLevylta(String tiedostonnimi) {
        BufferedReader tiedostonLukija = null;
        String tiedostonRivi = null;
        //tiedostonRiviLista = new ArrayList<String>();
        tiedostonRiviLista = new JoustavaTaulukko();
        try {
            try {
                //Reader in = new InputStreamReader(new FileInputStream("file"), "UTF-8")); 
                //try {
                //    BufferedReader in = new BufferedReader(
                //        new InputStreamReader(new FileInputStream("infilename"), "UTF8"));
                //    String str = in.readLine();
                //} catch (UnsupportedEncodingException e) {
                //}
                //}

                //tiedostonLukija = new BufferedReader(new FileReader(tiedostonnimi));
                tiedostonLukija = new BufferedReader(
                        new InputStreamReader(new FileInputStream(tiedostonnimi), "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                System.out.println("Tiedostoformaatti ei ole UTF-8");
                //Logger.getLogger(TiedostonLuku.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                //            System.out.println("tiedosto avattu lukemista varten");
                while ((tiedostonRivi = tiedostonLukija.readLine()) != null) {
//                    tiedostonRiviLista.add(tiedostonRivi);
                    tiedostonRiviLista.lisaaJoustavaanTaulukkoon(tiedostonRivi);
                }
            } catch (IOException ex) {
                System.out.println("Tiedoston nimi tai polku virheellinen");
                //Logger.getLogger(TiedostonLuku.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }


        } catch (FileNotFoundException ex) {
            System.out.println("Tiedoston avaaminen ei onnistunut");
            //Logger.getLogger(TiedostonLuku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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

    /**
     * Metodi lueTiedostoNetista lukee käyttäjän antaman tiedoston internetistä
     *
     * @param ladattavaTiedosto Käyttäjän antama tiedostonnimi
     */
    public void lueTiedostoNetista(String ladattavaTiedosto) {
        BufferedReader tiedostonLukija = null;
        String tiedostonRivi = null;
        //  tiedostonRiviLista = new ArrayList<String>();
        tiedostonRiviLista = new JoustavaTaulukko();

        HttpURLConnection yhteys;
    }
}
