/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import apurakenteet.JoustavaKaksiulotteinenTaulukko;
import apurakenteet.JoustavaTaulukko;

/**
 *
 * Tutkitaan käyttäjän antamien parametrien perusteella minkälainen puurakenne
 * tiedostosta muodostetaan. Oletusarvoisesti muodostetaan teeTrie
 *
 * @author Kati
 *
 */
public class MuodostaPuu {
    //private String [] tiedostonRivit;

    //private ArrayList<String> tiedostonRivit;
    private JoustavaTaulukko tiedostonRivit;
    Trie trie = new Trie();
    DT_Trie dtTrie = new DT_Trie();
    int trieValinta;

    /**
     * Konstruktori joka saa parametrinaan luetun tiedoston rivit taulukoituna
     * sekä tiedoston numeron joista trie-hakupuu luodaan
     *
     * @param tiedostonRivit Merkkijonoja sisältävä joustava taulukko, jossa
     * kukin tiedoston rivi on omalla rivillään
     * @param tiedostoNumero Viite siihen monesko tiedosto on käsittelyssä
     */
    //public MuodostaPuu(JoustavaTaulukko tiedostonRivit, int tiedostoNumero, int trieValinta) {
    public MuodostaPuu(int trieValinta) {
        //this.tiedostonRivit = tiedostonRivit;
        this.trieValinta = trieValinta;

        //trie = teeTrie(tiedostoNumero);

    }

    /**
     * Tyhjä konstruktori
     */
    public MuodostaPuu() {
    }

    /**
     * Luodaan teeTrie, jossa lapset on talletettu linkitetylle listalle
     *
     * @param tiedostoNumero
     * @return Trie-hakupuu
     */
    //public Trie teeTrie(int tiedostoNumero) {
    public Object teeTrie(int tiedostoNumero) {
        //System.out.println("teeTrie");
        int riviNumero = 0;
        //for (String rivi : tiedostonRivit) {
        for (int i = 0; i < tiedostonRivit.getI(); i++) {
            String rivi = (String) tiedostonRivit.getJoustavaListaItem(i);
            //System.out.println("rivi ennen korvausta: " + rivi);

            rivi = rivi.replaceAll("[,.:!;\"?]", "");
//            System.out.println("rivi korvauksen jälkeen: " + rivi);
            String rivinSanat[] = rivi.split(" ");
//            System.out.println("rivinSanat: ");
//            for (int i = 0; i < rivinSanat.length; i++) {
//                System.out.println(rivinSanat[i]);
//            }

            for (int j = 0; j < rivinSanat.length; j++) {
         //       System.out.println("rivinSanat: " + rivinSanat[j]);
         //       System.out.println("tiedostoNumero: " + tiedostoNumero);
         //       System.out.println("riviNumero: " + riviNumero);
                switch (trieValinta) {
                    case 1:
          //              System.out.println("perus");
                        trie = trie.lisaaSana(rivinSanat[j], tiedostoNumero, riviNumero);
                        break;
                    case 2:
                        dtTrie = dtTrie.lisaaSana(rivinSanat[j], tiedostoNumero, riviNumero);
                        break;
                    default:
                        trie = trie.lisaaSana(rivinSanat[j], tiedostoNumero, riviNumero);
                        break;
                }

            }
            riviNumero++;
        }
        switch (trieValinta) {
            case 1:
                return trie;
            case 2:
                return dtTrie;
            default:
                return trie;
        }

        //return trie;
//        return null;
    }

    /**
     * Metodi haeSana hakee parametrina saavansa sanan esiintyvyyttä hakupuusta
     *
     * @param haettavaSana sana, jota etsitään luetuista tiedostoista
     * @return loydetytRivit kertoo millä riveillä kussakin tiedostossa haettava
     * sana esiintyy
     */
    //public int[][] haeSana(String haettavaSana) {
    public JoustavaKaksiulotteinenTaulukko haeSana(String haettavaSana) {
//        System.out.println("Metodi haeSana");
        //int[][] loydetytRivit = trie.etsiSana(haettavaSana)
        JoustavaKaksiulotteinenTaulukko loydetytRivit = null;
        switch (trieValinta) {
            case 1:
                loydetytRivit = trie.etsiSana(haettavaSana);
                break;
            case 2:
                loydetytRivit = dtTrie.etsiSana(haettavaSana);
                // Testitulostus
//                if (loydetytRivit != null) {
//                    tulostaRivit(loydetytRivit);
//                }
                break;
            default:
                loydetytRivit = trie.etsiSana(haettavaSana);
                break;

        }
        //JoustavaKaksiulotteinenTaulukko loydetytRivit = trie.etsiSana(haettavaSana);
//       if (loydetytRivit != null) {
//            tulostaRivit(loydetytRivit);
//        }
        return loydetytRivit;
    }

    /**
     * Metodi tulostaRivit tulostaa niiden tiedostojen ne rivit ja rivinumerot,
     * joilta haettava sana löytyi
     *
     * @param loydetytRivit taulukko, missä on rivit esittävät luettuja
     * tiedostoja ja sarakkeet ilmaisevat millä rivillä kyseisessä tiedostossa
     * haettava sana esiintyy
     */
    private void tulostaRivit(JoustavaKaksiulotteinenTaulukko loydetytRivit) {
       // System.out.println("tulostaRivit");
        for (int i = 0; i < loydetytRivit.getJoustavaTaulukkoLength(); i++) {
            for (int j = 0; j < loydetytRivit.getJoustavaTaulukkoBreadth(); j++) {
                System.out.print(loydetytRivit.getJoustavaTaulukkoAlkio(i, j) + " ");
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

    //public Trie lisaaTiedosto(ArrayList<String> luettuTiedosto, int tiedostoLaskuri) {
    /**
     * Metodi lisaaTiedosto lisää trie hakupuuhun uuden tiedoston
     *
     * @param luettuTiedosto käyttäjän antaman tiedoston rivit
     * @param tiedostoLaskuri tiedoston numero
     * @return trie, palauttaa viitteen päivitettyyn trie hakupuuhun
     */
    public Object lisaaTiedosto(JoustavaTaulukko luettuTiedosto, int tiedostoLaskuri) {
        //System.out.println("MuodostaPuu olio, lisaaTiedosto metodi");
        //this.tiedostonRivit = luettuTiedosto;
        this.tiedostonRivit = luettuTiedosto;

        return teeTrie(tiedostoLaskuri);

    }
}
