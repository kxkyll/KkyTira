/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import apurakenteet.JoustavaKaksiulotteinenTaulukko;
import apurakenteet.LinkitettyLista;

/**
 *
 * Trie rakenteen toteutus, juurisolmu ei sisällä dataa, muut
 * solmut sisältävät data-osassaan sanan yhden kirjaimen sekä listan
 * lapsisolmuista
 * @author Kati 
 *
 */
public class TrieSolmu {

    private char kirjain;
    private boolean sananVikaKirjain;
    //private int[][] sijaintiTekstissa;
    private JoustavaKaksiulotteinenTaulukko sijaintiTekstissa;
    private int sarake;
    //private LinkedList<TrieSolmu> lapsiLista;
    private LinkitettyLista lapsiLista;

    /**
     * Konstruktorissa alustetaan TrieSolmu parametrina saatavalla kirjaimella
     *
     * @param kirjain TrieSolmussa talletettava data eli sanan kirjain Lisäksi
     * oletetaan että kyseessä ei ole yksikirjaiminen sana, ts. sananVikaKirjain
     * saa arvon false ja alustetaan LinkitettyLista lapsiLista
     */
    public TrieSolmu(char kirjain) {
        //System.out.println("TrieSolmun konstruktori");
        this.kirjain = kirjain;
        this.sananVikaKirjain = false;
    //    this.sijaintiTekstissa = new int[10][10];
        this.sijaintiTekstissa = new JoustavaKaksiulotteinenTaulukko(1);
        
        this.sarake = 1;
        
        this.lapsiLista = new LinkitettyLista(this);
        //alustaSijaintiTekstissa();
        this.sijaintiTekstissa.alustaPienimmallaMahdollisella();
        
    }

    /**
     * Trie Solmun tyhjä konstruktori
     */
//    public TrieSolmu() {
//        System.out.println("TrieSolmun tyhjä konstruktori");
//        //todo: tarvitaanko tätä
//    }

    /**
     * Metodi setSananVikaKirjain asettaa sanan viimeisen kirjaimen parametriksi 
     * tiedon siitä, että kyseessä on jonkin sanan viimeinen kirjain
     * @param sananVikaKirjain ilmaisee onko tämä kirjain jonkin sanan viimeinen
     * kirjain
     */
    public void setSananVikaKirjain(boolean sananVikaKirjain) {
        this.sananVikaKirjain = sananVikaKirjain;
    }


    /**
     * Metodi setSijaintiTekstissa tallentaa sijaintiTekstissa-taulukkoon sanan
     * esiintymisrivin numeron. Jos sana esiintyy useasti, taulukko täyttyy
     * jolloin sen kokoa kasvatetaan.
     *
     * @param tiedostoNumero ilmaisee missä tiedostossa sana esiintyy
     * @param riviNumero ilmaisee monennellako rivillä kyseisessä tiedostossa
     * sana esiintyy
     *
     */
    public void setSijaintiTekstissa(int tiedostoNumero, int riviNumero) {
        sijaintiTekstissa.lisaaKaksiulotteiseenJoustavaanTaulukkoon(tiedostoNumero, riviNumero);
    }

    /**
     *
     * @param taulukko tulostaa kaksiulotteisen int taulukon sisällön. Käytetty
     * testauksen apuna
     */
    public void tulostaTaulukko(int[][] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                System.out.print(taulukko[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     *
     * @return palauttaa TrieSolmun tallentaman kirjaimen arvon
     */
    public char getKirjain() {
        return kirjain;
    }

    /**
     *
     * @return palauttaa onko kirjain jonkin sanan viimeinen kirjain
     */
    public boolean isSananVikaKirjain() {
        return sananVikaKirjain;
    }

    /**
     *
     * @return palauttaa TrieSolmun lapsilistan
     */
//    public LinkedList<TrieSolmu> getLapsiLista() {
//        return lapsiLista;
//    }
    public LinkitettyLista getLapsiLista() {
        System.out.println("getLapsiLista");
        return lapsiLista.getLinkitettyLista();
    }

    /**
     *  getSijaintiTekstissa palauttaa kaksiulotteisen joustavan taulukon
     * joka sisältää etsityn sanan esiintymiskohdat ladatuissa tiedostoissa
     * @return palauttaa sanan sijaintitaulun
     */
    public JoustavaKaksiulotteinenTaulukko getSijaintiTekstissa() {
        //System.out.println("getSijaintiTekstissa");
        return sijaintiTekstissa;
    }

    /**
     *
     * @return, metodi palauttaa sen lapsisolmun viitteen jonka arvona
     * parametrina saatu kirjain on, jos kyseistä kirjainta ei ole minkään
     * lapsisolmun arvona, metodi palauttaa arvon null
     * @param kirjain etsittävä kirjain
     * @return palauttaa viitteen lapsisolmuun, josta etsitty kirjain löytyy,
     * mikäli kirjainta ei löydy palautetaan null
     *
     */
    public TrieSolmu etsiKirjain(char kirjain) {
        //System.out.println("etsiKirjain " + kirjain);
        LinkitettyLista seuraava = this.lapsiLista.getSeuraava();
        while (seuraava != null) {
            if (seuraava.getListaSolmu().getKirjain() == kirjain) {
                return seuraava.getListaSolmu();
            } else {
                seuraava = seuraava.getSeuraava();
            }
        }
        return null;
    }

    /**
     *
     * @return, jos lapsiSolmun lisääminen onnistui metodi palauttaa viitteen
     * lapsiSolmuun, muutoin metodi palauttaa arvon null
     * @param uusiLapsi solmu joka lisätään Trie hakupuuhun
     * @return uusiLapsi tai null
     *
     */
    public TrieSolmu lisaaLapsi(TrieSolmu uusiLapsi) {
        boolean onnistui = this.lapsiLista.lisaaSolmu(uusiLapsi);
        if (onnistui) {
            return uusiLapsi;
        }
        return null;
    }

    
}
