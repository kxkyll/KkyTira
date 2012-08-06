/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
 */
    public void kaynnisty() throws IOException {
        boolean jatka = true;
        boolean lisaaTiedostoja = true;
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
                        luettuTiedosto = tiedostonLuku.lueTiedostoLevylta(ladattavaTiedosto);
                        System.out.println("Tiedoston sisältö:");
                        for (String rivi:luettuTiedosto) {
                            System.out.println(rivi);
                        }
                    }
                    if (ladattavaTiedosto.endsWith("htm")) {
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
     */
    public String kysySana() {
        System.out.print("Anna haettavat sanat: ");
        return lukija.nextLine();
    }

    /**
     * Kysytään käyttäjältä ladattava tiedosto
     */
    public String kysyTiedosto() {
        System.out.print("Anna ladattavat tiedostot : ");
        return lukija.nextLine();
        
    }
}
