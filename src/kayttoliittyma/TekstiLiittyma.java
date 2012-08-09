/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import sanaindeksi.MuodostaPuu;
import tiedostonkasittely.TiedostonLuku;

/**
 *
 * @author Kati
 * SanaHakuohjelman tekstipohjainen käyttöliittymä
 */
public class TekstiLiittyma {

    static Scanner lukija = new Scanner(System.in);
    TiedostonLuku tiedostonLuku = new TiedostonLuku();
    
/**
 *
 * Käyttäjältä kysytään ladattavia tiedostoja, kunnes annettu merkkijono on tyhjä
 * Käyttäjältä kysytään haettavia sanoja, kunnes annettu merkkijono on tyhjä.
 * @throws IOException 
 */
    public void kaynnisty() throws IOException {
        boolean jatka = true;
        boolean lisaaTiedostoja = true;
        int tiedostoLaskuri = 0;
        ArrayList<String> luettuTiedosto = new ArrayList<String>();
        System.out.println("Anna ladattavan tiedoston hakupolku ja nimi (tyhjä merkkijono lopettaa)");
        while (jatka) {
            while (lisaaTiedostoja) {
                String ladattavaTiedosto = kysyTiedosto();
                if (ladattavaTiedosto.isEmpty() || ladattavaTiedosto.contentEquals(" ")){
                    lisaaTiedostoja = false;
                } else {
                    System.out.println("Annoit tiedoston: " +ladattavaTiedosto);
                    if (ladattavaTiedosto.endsWith("txt") ) {
                        tiedostoLaskuri ++;
                        luettuTiedosto = tiedostonLuku.lueTiedostoLevylta(ladattavaTiedosto);
                        System.out.println("Tiedoston sisältö:");
                        for (String rivi:luettuTiedosto) {
                            System.out.println(rivi);
                        }
                        MuodostaPuu muodostaPuu = new MuodostaPuu (luettuTiedosto, tiedostoLaskuri);
                    }
                    if (ladattavaTiedosto.endsWith("html")) {
                        tiedostonLuku.lueTiedostoNetista(ladattavaTiedosto);
                    }
                }
            }
            
            String haettavaSana = kysySana();
            if (haettavaSana.isEmpty() || haettavaSana.contentEquals(" ")) {
                jatka = false;
            }
        }
    }

    /**
     * Kysytään käyttäjältä haettavat sanat
     * 
     * @return String Käyttäjän antama hakusana
     */
    public String kysySana() {
        System.out.print("Anna haettavat sanat: ");
        return lukija.nextLine();
    }

    /**
     * Kysytään käyttäjältä ladattava tiedosto
     * 
     * @return String Käyttäjän antama tiedostonnimi
     */
    public String kysyTiedosto() {
        System.out.print("Anna ladattavat tiedostot : ");
        return lukija.nextLine();
        
    }
}
