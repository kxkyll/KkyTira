/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import apurakenteet.JoustavaKaksiulotteinenTaulukko;
import apurakenteet.JoustavaTaulukko;
import apurakenteet.LomitusJarjestaminen;

/**
 * Trie solmu, jossa lapset talletettu dynaamiseen tauluun (DT)
 * kirjain = solmun kirjain
 * sijaintiTekstissa kertoo missä tiedostossa ja rivillä sana esiintyy
 * sarake kertoo mikä on seuraava tyhjä sarake sijaintiTekstissä taulussa
 * lapsiTaulukko pitää sisällään tämän solmun lapsisolmut
 * @author Kati
 */
public class DT_TrieSolmu {
    char kirjain;
    private boolean sananVikaKirjain;
    //private int[][] sijaintiTekstissa;
    private JoustavaKaksiulotteinenTaulukko sijaintiTekstissa;
    private int indeksi;
    private JoustavaTaulukko lapsiTaulukko;

    /**
     * Konstruktori asettaa solmu kirjain muuttujan arvoksi parametrina 
     * saavansa kirjaimen
     * @param kirjain solmun datakenttään kirjain talletettava arvo
     */
    
    public DT_TrieSolmu(char kirjain) {
        this.kirjain = kirjain;
        this.sananVikaKirjain = false;
//        this.sijaintiTekstissa = new int[10][10];
        this.sijaintiTekstissa = new JoustavaKaksiulotteinenTaulukko (1);
        this.lapsiTaulukko = new JoustavaTaulukko(20);
        this.indeksi = 0;
        this.sijaintiTekstissa.alustaPienimmallaMahdollisella();
        //alustaSijaintiTekstissa();
    }

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
     * @return palauttaa TrieSolmun lapsitaulukon
     */

    public JoustavaTaulukko getLapsiTaulukko() {
        System.out.println("getLapsiTaulukko");
        return lapsiTaulukko;
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
     * Metodi etsii löytyykö hakupuun tämän solmun lapsista parametrina saatua kirjainta
     * @param kirjain etsittävä kirjain
     * @return palauttaa viitteen lapsisolmuun, josta etsitty kirjain löytyy,
     * mikäli kirjainta ei löydy palautetaan null
     *
     */
    public DT_TrieSolmu etsiKirjain(char kirjain) {
       System.out.println("etsiKirjain " + kirjain);
        for (int ind = 0; ind < lapsiTaulukko.getJoustavaListaLength();ind++) {
            DT_TrieSolmu loydettySolmu = (DT_TrieSolmu)lapsiTaulukko.getJoustavaListaItem(ind);
            if (loydettySolmu == null) {
                System.out.println("indeksi: " +ind);
                System.out.println("loydettySolmu on null");
            }
            if (loydettySolmu == null || loydettySolmu.getKirjain() == kirjain) {
                return loydettySolmu;
            }
        }
       
        return null;
    }

    /**
     * Lisätään uusi lapsi lapsitaulukkoon
     * @param uusiLapsi solmu joka lisätään Trie hakupuuhun
     * 
     */
    public DT_TrieSolmu lisaaLapsi(DT_TrieSolmu uusiLapsi) {
        lapsiTaulukko.setI(indeksi);
        lapsiTaulukko.lisaaJoustavaanTaulukkoon(uusiLapsi);
        indeksi++;
        //return this;
        LomitusJarjestaminen lomitusjarjesta = new LomitusJarjestaminen ();
        lapsiTaulukko = lomitusjarjesta.jarjesta(lapsiTaulukko);
        tulostaLapsiTaulukko (lapsiTaulukko);
        return uusiLapsi;
        
    }

    private void tulostaLapsiTaulukko(JoustavaTaulukko taulukko) {
        System.out.println("tulosta LapsiTaulukko");
        int i = 0;
        while (taulukko.getJoustavaListaItem(i) != null) {
            DT_TrieSolmu apuSolmu = (DT_TrieSolmu) taulukko.getJoustavaListaItem(i);
            System.out.println(apuSolmu.getKirjain());
            i++;
        }
    }

    
}
