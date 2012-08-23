/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import apurakenteet.JoustavaTaulukko;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import sanaindeksi.MuodostaPuu;
import sanaindeksi.Tiedostot;
import tiedostonkasittely.TiedostonLuku;

/**
 *
 * @author Kati SanaHakuohjelman tekstipohjainen käyttöliittymä
 */
public class TekstiLiittyma {

    static Scanner lukija = new Scanner(System.in);
    TiedostonLuku tiedostonLuku = new TiedostonLuku();
    ArrayList<Tiedostot> luetutTiedostot;

    /**
     *
     * Käyttäjältä kysytään ladattavia tiedostoja, kunnes annettu merkkijono on
     * tyhjä Käyttäjältä kysytään haettavia sanoja, kunnes annettu merkkijono on
     * tyhjä.
     *
     * @throws IOException
     */
    public void kaynnisty() throws IOException {
        MuodostaPuu muodostaPuu = null;// = new MuodostaPuu();
        boolean jatka = true;
        boolean lisaaTiedostoja = true;
        int tiedostoLaskuri = 0;
        JoustavaTaulukko luettuTiedosto = new JoustavaTaulukko();
        //ArrayList<String> luettuTiedosto = new ArrayList<String>();
        luetutTiedostot = new ArrayList<Tiedostot>();
        System.out.println("Anna ladattavan tiedoston hakupolku ja nimi (tyhjä merkkijono lopettaa)");
        while (jatka) {
            while (lisaaTiedostoja) {
                String ladattavaTiedosto = kysyTiedosto();
                if (ladattavaTiedosto.isEmpty() || ladattavaTiedosto.contentEquals(" ")) {
                    lisaaTiedostoja = false;
                } else {
                    System.out.println("Annoit tiedoston: " + ladattavaTiedosto);
                    if (ladattavaTiedosto.endsWith("txt")) {

                        luettuTiedosto = tiedostonLuku.lueTiedostoLevylta(ladattavaTiedosto);
                        if (luettuTiedosto != null) {
                            System.out.println("luetutTiedostot: " + luetutTiedostot.toString());
                            luetutTiedostot.add(new Tiedostot(ladattavaTiedosto, luettuTiedosto));

                            System.out.println("Tiedoston sisältö:");
//                            String [] apuTaulukko = luettuTiedosto.getJoustavaLista();
//                            for (String rivi : apuTaulukko) {
//                                System.out.println(rivi);
//                            }
                            for (int i = 0; i< luettuTiedosto.getI();i++) {
                                System.out.println(luettuTiedosto.getJoustavaListaItem(i));
                            }
                            tiedostoLaskuri++;
                            System.out.println("tiedostoLaskuri: " + tiedostoLaskuri);
                            if (muodostaPuu != null) {
                                System.out.println("Muodostapuu ei ole null, lisätään tiedosto");
                                muodostaPuu.lisaaTiedosto(luettuTiedosto, tiedostoLaskuri);
                            } else {
                                System.out.println("MuodostaPuu on null, luodaan uusi puu");
                                muodostaPuu = new MuodostaPuu(luettuTiedosto, tiedostoLaskuri);
                            }
                        } else {
                            System.out.println("Tiedostonnimi virheellinen");
                        }
                    }
                    if (ladattavaTiedosto.endsWith("html")) {
                        tiedostonLuku.lueTiedostoNetista(ladattavaTiedosto);
                    }
                }
            }

            String haettavaSana = kysySana();
            if (haettavaSana.isEmpty() || haettavaSana.contentEquals(" ")) {
                jatka = false;
            } else {
                int[][] loydetytRivit = muodostaPuu.haeSana(haettavaSana);
                if (loydetytRivit != null) {
                    tulostaLoydetytRivit(loydetytRivit);
                } else {
                    System.out.println("Haettavaa sanaa " + haettavaSana + " ei löytynyt");
                }
            }

        }
    }

    public void tulostaLoydetytRivit(int[][] loydetytRivit) {
        System.out.println("löydetyt:");
        Boolean tiedostonNimiTulostettu = false;
        for (int i = 1; i < loydetytRivit.length; i++) {

            for (int j = 1; j < loydetytRivit.length; j++) {
                if (loydetytRivit[i][j] > Integer.MIN_VALUE) {
                    Tiedostot loydetty = luetutTiedostot.get(i - 1);
                    if (!tiedostonNimiTulostettu) {
                        System.out.println("Tiedostosta: " + loydetty.getTiedostonNimi() + " löytyivät rivit: ");
                        tiedostonNimiTulostettu = true;
                    }
                    //ArrayList<String> loydettyRivit = loydetty.getTiedosto();
                    JoustavaTaulukko loydettyRivit = loydetty.getTiedosto();
                    //System.out.println("rivi " + ((loydetytRivit[i][j]) + 1) + ": " + loydettyRivit.get(loydetytRivit[i][j]));
                    System.out.println("rivi " + ((loydetytRivit[i][j]) + 1) + ": " + loydettyRivit.getJoustavaListaItem(loydetytRivit[i][j]));

                }

            }
            tiedostonNimiTulostettu = false;

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
