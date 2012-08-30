/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

/**
 *
 * 
 * Trie luokka sisältää Trie hakupuun ja sen metodit
 * @author Kati
 */
public class Trie {

    private TrieSolmu juuriSolmu;

    /**
     * Konstruktori luo tyhjän Trie hakupuun
     */
    public Trie() {
        this.juuriSolmu = new TrieSolmu(' ');
    }

    /**
     * Metodi lisaaSana lisää parametrina saamiaan sanoja Trie hakupuuhun,
     * sanan viimeisen kirjaimen TrieSolmuun talletetaan lisäksi tieto siitä,
     * että kyseinen sana on viimeinen sekä taulukoidaan misää tiedostossa ja rivillä
     * sana esiintyy
     * 
     * @param sana hakupuuhun lisättävä sana
     * @param tiedostoNumero viite tiedostoon, jossa sana esiintyy
     * @param riviNumero viite riville, jossa sana esiintyy
     * @return viite päivitettyyn Trie hakupuuhun
     */
    public Trie lisaaSana(String sana, int tiedostoNumero, int riviNumero) {
        //System.out.println("lisaaSana");
        TrieSolmu nykyinenSolmu;
        int vikanKirjaimenPaikka;

        if (sana.length() > 0) {
            
            sana = sana.toLowerCase();
          //System.out.println("sana: " + sana);
            vikanKirjaimenPaikka = sana.length() - 1;

            nykyinenSolmu = juuriSolmu;
            for (int i = 0; i < sana.length(); i++) {
                TrieSolmu uusiLapsi = nykyinenSolmu.etsiKirjain(sana.charAt(i)); // etsitään löytyykö solmua joka jo sisältää kirjaimen

                if (uusiLapsi != null) {
                   // System.out.println("uusiLapsi ei null");
                    nykyinenSolmu = uusiLapsi; // löytyi: mennään hakupuun seuraavalle tasolle
                } else {
                   // System.out.println("uusiLapsi on null");
                    uusiLapsi = new TrieSolmu(sana.charAt(i)); // ei löytynyt: tehdään uusi lapsi
                   // System.out.println("uusiLapsi kirjain: " + uusiLapsi.getKirjain());
                    nykyinenSolmu = nykyinenSolmu.lisaaLapsi(uusiLapsi); // lisätään uusi lapsi lapsilistalle
                }

                if (i == vikanKirjaimenPaikka) {
                   // System.out.println("vika kirjain");
                    nykyinenSolmu.setSananVikaKirjain(true);
                    //System.out.println("vikakirjain astettu");
                    nykyinenSolmu.setSijaintiTekstissa(tiedostoNumero, riviNumero);
                }
            }
        }
        return this;
    }

    /**
     * Metodi etsiSana etsii esiinty parametrina saatu merkkijono
     * kokonaisuudessaan, jossakin Trie-hakupuuhun ladatussa tiedostossa
     * Mikäli sana esiintyy, palautetaan taulukko, josta ilmenee missä tiedostoissa 
     * sekä millä riveillä sana esiintyy
     * 
     * @param sana etsittävä sana
     * @return kaksiulotteinen kokonaislukutaulukko, jossa rivi kertoo missä tiedostossa
     * sana esiintyy ja sarake kertoo rivin, jossa sana esiintyy 
     * 
     * Mikäli sanaa ei löydy, metodi palauttaa arvon null
     */
    public int[][] etsiSana(String sana) {
        //System.out.println("Metodi etsiSana");
        //System.out.println("etsittävä sana: " + sana);

        TrieSolmu nykyinenSolmu;
        TrieSolmu lapsiSolmu;

        if (sana.length() > 0) {
            sana = sana.toLowerCase();
            nykyinenSolmu = juuriSolmu;
       //     System.out.println("sana.length: " + sana.length());

            for (int i = 0; i < sana.length(); i++) {
          //      System.out.println("indeksi i: " + i);
          //      System.out.println("etsittävä kirjain: " + sana.charAt(i));

                lapsiSolmu = nykyinenSolmu.etsiKirjain(sana.charAt(i));

                if (lapsiSolmu != null) {
                    nykyinenSolmu = lapsiSolmu;
            //        System.out.println("lapsi ei ole null");
                } else {
              //    System.out.println("oikeaa ei löytynyt");
                    return null; // kirjainta ei löytynyt  
                }
            }

            if (nykyinenSolmu.isSananVikaKirjain()) {
                //System.out.println("on vika kirjain");
                //return true; //kirjaimet löytyivät ja merkkijonon viimeinen kirjain ilmaisee kyseessä olevan sana
                return nykyinenSolmu.getSijaintiTekstissa();
                
            }
        }

        //System.out.println("ei löydy ei");
        return null;
    }
}