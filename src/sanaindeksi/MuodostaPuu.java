/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.util.ArrayList;

/**
 *
 * @author Kati
 *
 * Tutkitaan käyttäjän antamien parametrien perusteella minkälainen puurakenne
 * tiedostosta muodostetaan Oletusarvoisesti muodostetaan perusTrie
  
 * 
 */


public class MuodostaPuu {

    private ArrayList<String> tiedostonRivit;
    Trie trie = new Trie();

    /**
     *
     * @param tiedostonRivit Merkkijonoja sisältävä joustava taulukko, jossa
     * kukin tiedoston rivi on omalla rivillään
     * @param tiedostoNumero Viite siihen monesko tiedosto on käsittelyssä
     */
    public MuodostaPuu(ArrayList<String> tiedostonRivit, int tiedostoNumero) {
        this.tiedostonRivit = tiedostonRivit;
        trie = perusTrie(tiedostoNumero);
    }

    public MuodostaPuu() {
    }

    /**
     * Luodaan perusTrie, jossa lapset on talletettu linkitetylle listalle
     *
     * @param tiedostoNumero
     * @return Trie-hakupuu
     */
    public Trie perusTrie(int tiedostoNumero) {

        int riviNumero = 0;
        for (String rivi : tiedostonRivit) {
            System.out.println("rivi ennen korvausta: " + rivi);
            rivi = rivi.replaceAll("[,.:!;\"?]", "");
            System.out.println("rivi korvauksen jälkeen: " + rivi);
            String rivinSanat[] = rivi.split(" ");
            System.out.println("rivinSanat: ");
            for (int i = 0; i < rivinSanat.length; i++) {
                System.out.println(rivinSanat[i]);
            }
            for (int i = 0; i < rivinSanat.length; i++) {
                System.out.println("rivinSanat: " + rivinSanat[i]);
                System.out.println("tiedostoNumero: " + tiedostoNumero);
                System.out.println("riviNumero: " + riviNumero);
                trie = trie.lisaaSana(rivinSanat[i], tiedostoNumero, riviNumero);
            }
            riviNumero++;
        }

        return trie;
    }

    /**
     *
     * @param haettavaSana minkä sanan esiintymistä ladatuista tiedostoista etsitään
     * @return loydetytRivit kertoo millä riveillä kussakin ladatussa tiedostossa haettava sana esiintyy
     */
    public int [][] haeSana(String haettavaSana) {
        System.out.println("Metodi haeSana");
        int[][] loydetytRivit = trie.etsiSana(haettavaSana);
        if (loydetytRivit != null) {
            tulostaRivit(loydetytRivit);
        }
        return loydetytRivit;
    }

    private void tulostaRivit(int[][] loydetytRivit) {
        System.out.println("tulostaRivit");
        for (int i = 0; i < loydetytRivit.length; i++) {
            for (int j = 0; j < loydetytRivit.length; j++) {
                System.out.print(loydetytRivit[i][j] + " ");
            }
            System.out.println("");
        }
//        System.out.println("löydetyt:");
//        for (int i = 0; i < loydetytRivit.length; i++) {
//            for (int j = 0; j < loydetytRivit.length; j++) {
//                if (loydetytRivit[i][j] > Integer.MIN_VALUE) {
//                    System.out.println(tiedostonRivit.get(loydetytRivit[i][j]));
//                }
//
//            }
//        }
    }

    public Trie lisaaTiedosto(ArrayList<String> luettuTiedosto, int tiedostoLaskuri) {
        System.out.println("MuodostaPuu olio, lisaaTiedosto metodi");
        this.tiedostonRivit = luettuTiedosto;;
        trie = perusTrie(tiedostoLaskuri);
        return trie;
    }
}
