/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import apurakenteet.JoustavaKaksiulotteinenTaulukko;
import apurakenteet.JoustavaTaulukko;
import java.io.IOException;
import java.util.Scanner;
import sanaindeksi.MuodostaPuu;
import sanaindeksi.Tiedostot;
import tiedostonkasittely.TiedostonLuku;

/**
 *
 * SanaHakuohjelman tekstipohjainen käyttöliittymä
 *
 * @author Kati
 */
public class TekstiLiittyma {

    static Scanner lukija = new Scanner(System.in);
    TiedostonLuku tiedostonLuku = new TiedostonLuku();
    JoustavaTaulukko luetutTiedostot;
    //ArrayList<Tiedostot> luetutTiedostot;

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
        luetutTiedostot = new JoustavaTaulukko('t');
        System.out.println("Anna ladattavan tiedoston hakupolku ja nimi (tyhjä merkkijono lopettaa)");
        while (jatka) {
            while (lisaaTiedostoja) {
                String ladattavaTiedosto = kysyTiedosto();
                if (ladattavaTiedosto.isEmpty() || ladattavaTiedosto.contentEquals(" ")) {
                    lisaaTiedostoja = false;
                } else {
                    System.out.println("Annoit tiedoston: " + ladattavaTiedosto);
                    if (ladattavaTiedosto.endsWith("txt")) {
                        long tiedostonKasittelynAloitusHetki = System.currentTimeMillis();
                        long tiedostonKasittelynAloitusHetkiNs = System.nanoTime();
                        luettuTiedosto = tiedostonLuku.lueTiedostoLevylta(ladattavaTiedosto);
                        long tiedostonKasittelynLopetusHetki = System.currentTimeMillis();
                        long tiedostonKasittelynLopetusHetkiNs = System.nanoTime();
                        long puunMuodostamisenAloitusHetki = System.currentTimeMillis();
                        long puunMuodostamisenAloitusHetkiNs = System.nanoTime();

                        if (luettuTiedosto != null) {

                            luetutTiedostot.lisaaJoustavaanTaulukkoon(new Tiedostot(ladattavaTiedosto, luettuTiedosto));

                            tiedostonKasittelynLopetusHetki = System.currentTimeMillis();
                            tiedostonKasittelynLopetusHetkiNs = System.nanoTime();

                            tiedostoLaskuri++;
                            puunMuodostamisenAloitusHetki = System.currentTimeMillis();
                            puunMuodostamisenAloitusHetkiNs = System.nanoTime();

                            if (muodostaPuu != null) {
                                muodostaPuu.lisaaTiedosto(luettuTiedosto, tiedostoLaskuri);
                            } else {
                                //muodostaPuu = new MuodostaPuu(luettuTiedosto, tiedostoLaskuri, 1);
                                muodostaPuu = new MuodostaPuu(1);
                                muodostaPuu.lisaaTiedosto(luettuTiedosto, tiedostoLaskuri);
                            }
                        } else {
                            puunMuodostamisenAloitusHetki = System.currentTimeMillis();
                            puunMuodostamisenAloitusHetkiNs = System.nanoTime();
                            System.out.println("Tiedostonnimi virheellinen");
                        }
                        long puunMuodostamisenLopetusHetki = System.currentTimeMillis();
                        long puunMuodostamisenLopetusHetkiNs = System.nanoTime();
                        System.out.println("Tiedoston käsittely vei: " + (tiedostonKasittelynLopetusHetki - tiedostonKasittelynAloitusHetki) + " millisekuntia");
                        System.out.println("Tiedoston käsittely vei: " + ((tiedostonKasittelynLopetusHetkiNs - tiedostonKasittelynAloitusHetkiNs) / 1000) + " mikrosekuntia");
                        System.out.println("Puun muodostaminen vei: " + (puunMuodostamisenLopetusHetki - puunMuodostamisenAloitusHetki) + " millisekuntia");
                        System.out.println("Puun muodostaminen vei: " + ((puunMuodostamisenLopetusHetkiNs - puunMuodostamisenAloitusHetkiNs) / 1000) + " mikrosekuntia");
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
                long haunAloitusHetki = System.currentTimeMillis();
                long haunAloitusHetkiNs = System.nanoTime();
                //int[][] loydetytRivit = muodostaPuu.haeSana(haettavaSana);
                JoustavaKaksiulotteinenTaulukko loydetytRivit = muodostaPuu.haeSana(haettavaSana);
                long haunLopetusHetki = System.currentTimeMillis();
                long haunLopetusHetkiNs = System.nanoTime();
                long hakuYhteensa = haunLopetusHetki - haunAloitusHetki;
                long hakuYhteensaMikroSek = (haunLopetusHetkiNs - haunAloitusHetkiNs) / 1000;
                if (loydetytRivit != null) {
                    long tulostuksenAloitusHetki = System.currentTimeMillis();
                    long tulostuksenAloitusHetkiNS = System.nanoTime();
                    tulostaLoydetytRivit(loydetytRivit);
                    long tulostuksenLopetusHetki = System.currentTimeMillis();
                    long tulostuksenLopetusHetkiNS = System.nanoTime();
                    long tulostusYhteensa = tulostuksenLopetusHetki - tulostuksenAloitusHetki;
                    long tulostusYhteensaMikroSek = (tulostuksenLopetusHetkiNS - tulostuksenAloitusHetkiNS) / 1000;
                    System.out.println("Hakeminen vei:                      " + (haunLopetusHetki - haunAloitusHetki) + " millisekuntia");
                    System.out.println("Hakeminen vei: " + hakuYhteensaMikroSek + " mikrosekuntia");
                    System.out.println("Tulostaminen vei:                   " + (tulostuksenLopetusHetki - tulostuksenAloitusHetki) + " millisekuntia");
                    System.out.println("Tulostaminen vei: " + tulostusYhteensaMikroSek + " mikrosekuntia");
                    System.out.println("Hakeminen ja tulostaminen yhteensä: " + (haunLopetusHetki - haunAloitusHetki) + (tulostuksenLopetusHetki - tulostuksenAloitusHetki) + " millisekuntia");
                    System.out.println("Hakeminen ja tulostaminen yhteensä: " + (hakuYhteensaMikroSek + tulostusYhteensaMikroSek) + " mikrosekuntia");
                } else {
                    System.out.println("Haettavaa sanaa " + haettavaSana + " ei löytynyt");
                    System.out.println("Hakeminen vei:                      " + (haunLopetusHetki - haunAloitusHetki) + " millisekuntia");
                }

            }

        }
    }

    /**
     * Metodi tulostaLoydetytRivit tulostaa tiedostoittain ne rivit, joilla
     * haettava sana esiintyy
     *
     * @param loydetytRivit taulukko joka sisältää löydettyjen rivien
     * rivinumerot, kukin rivi sisältää yhden tiedoston osumat
     */
    //public void tulostaLoydetytRivit(int[][] loydetytRivit) {
    public void tulostaLoydetytRivit(JoustavaKaksiulotteinenTaulukko loydetytRivit) {
        System.out.println("Haun tulos:");
        Boolean tiedostonNimiTulostettu = false;
        //for (int i = 1; i < loydetytRivit.length; i++) {
        for (int i = 1; i < loydetytRivit.getJoustavaTaulukkoLength(); i++) {

            //for (int j = 1; j < loydetytRivit.length; j++) {
            for (int j = 1; j < loydetytRivit.getJoustavaTaulukkoLength(); j++) {

                //if (loydetytRivit.[i][j] > Integer.MIN_VALUE) {
                if (loydetytRivit.getJoustavaTaulukkoAlkio(i, j) > Integer.MIN_VALUE) {
                    // Tiedostot loydetty = luetutTiedostot.get(i - 1);
                    Tiedostot loydetty = (Tiedostot) luetutTiedostot.getJoustavaListaItem(i - 1);
                    if (!tiedostonNimiTulostettu) {
                        System.out.println("Tiedostosta: " + loydetty.getTiedostonNimi() + " löytyivät rivit: ");
                        tiedostonNimiTulostettu = true;
                    }
                    //ArrayList<String> loydettyRivit = loydetty.getTiedosto();
                    JoustavaTaulukko loydettyRivit = loydetty.getTiedosto();
                    //System.out.println("rivi " + ((loydetytRivit[i][j]) + 1) + ": " + loydettyRivit.get(loydetytRivit[i][j]));

                    System.out.println("rivi " + (loydetytRivit.getJoustavaTaulukkoAlkio(i, j) + 1) + ": " + loydettyRivit.getJoustavaListaItem(loydetytRivit.getJoustavaTaulukkoAlkio(i, j)));

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
