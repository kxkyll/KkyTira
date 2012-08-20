/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.util.LinkedList;

/**
 *
 * @author Kati Trie rakenteen toteutus, juurisolmu ei sisällä dataa, muut
 * solmut sisältävät data-osassaan sanan yhden kirjaimen sekä listan
 * lapsisolmuista
 *
 */
public class TrieSolmu {

    private char kirjain;
    private boolean sananVikaKirjain;
    private int[][] sijaintiTekstissa;
    private int sarake;
    private LinkedList<TrieSolmu> lapsiLista;

    /**
     * Konstruktorissa alustetaan TrieSolmu parametrina saatavalla kirjaimella
     *
     * @param kirjain TrieSolmussa talletettava data eli sanan kirjain Lisäksi
     * oletetaan että kyseessä ei ole yksikirjaiminen sana, ts. sananVikaKirjain
     * saa arvon false ja alustetaan LinkitettyLista lapsiLista
     */
    public TrieSolmu(char kirjain) {
        this.kirjain = kirjain;
        this.sananVikaKirjain = false;
        this.sijaintiTekstissa = new int[10][10];
        this.sarake = 1;
        this.lapsiLista = new LinkedList<TrieSolmu>();
        alustaSijaintiTekstissa();
    }

    /**
     *
     * @param sananVikaKirjain ilmaisee onko tämä kirjain jonkin sanan viimeinen
     * kirjain
     */
    public void setSananVikaKirjain(boolean sananVikaKirjain) {
        this.sananVikaKirjain = sananVikaKirjain;
    }

    /**
     * alustaa sijaintiTekstissa taulukon sisällön asettamalla jokaiseen
     * taulukon alkioon pienimmän mahdollisen kokonaisluvun Integer.MIN_VALUE
     */
    public void alustaSijaintiTekstissa() {
        for (int i = 0; i < sijaintiTekstissa.length; i++) {
            for (int j = 0; j < sijaintiTekstissa[0].length; j++) {
                sijaintiTekstissa[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    /**
     * Metodi setSijaintiTekstissa tallentaa sijaintiTekstissa-taulukkoon
     * sanan esiintymisrivin numeron. Jos sana esiintyy useasti, taulukko täyttyy
     * jolloin sen kokoa kasvatetaan.
     * @param tiedostoNumero ilmaisee missä tiedostossa sana esiintyy
     * @param riviNumero ilmaisee monennellako rivillä kyseisessä tiedostossa
     * sana esiintyy
     * 
     */
    public void setSijaintiTekstissa(int tiedostoNumero, int riviNumero) {
//        System.out.println("tiedostoNumero: " + tiedostoNumero);
//        System.out.println("riviNumero: " + riviNumero);
        int rivi = sijaintiTekstissa.length;
//        System.out.println("rivi (taulukon pituus): " + rivi);
//        System.out.println("taulukon leveys: " + sijaintiTekstissa[0].length);

        if (tiedostoNumero < rivi && sarake < sijaintiTekstissa[0].length) {
            //           System.out.println("laitetaan rivinumero taulukkoon");
            //           System.out.println("sarake: " + sarake);

            sijaintiTekstissa[tiedostoNumero][sarake] = riviNumero;
            sarake++;
        } else {
            System.out.println("SijaintiTekstissa taulukko täynnä: ");
            int[][] uusiTaulu = new int[sijaintiTekstissa[0].length * 2][sijaintiTekstissa.length * 2];
            uusiTaulu = siirraTaulukonTiedot(uusiTaulu, sijaintiTekstissa);
            sijaintiTekstissa = uusiTaulu;
            sijaintiTekstissa[tiedostoNumero][sarake] = riviNumero;
            sarake++;
        }
    }

    /**
     *
     * @param taulukko tulostaa kaksiulotteisen int taulukon sisällön.
     * Käytetty testauksen apuna
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
    public LinkedList<TrieSolmu> getLapsiLista() {
        return lapsiLista;
    }

    /**
     *
     * @return palauttaa sanan sijaintitaulun
     */
    public int[][] getSijaintiTekstissa() {
        System.out.println("getSijaintiTekstissa");
        return sijaintiTekstissa;
    }

    /**
     *
     * @return, metodi palauttaa sen lapsisolmun viitteen jonka arvona
     * parametrina saatu kirjain on, jos kyseistä kirjainta ei ole minkään
     * lapsisolmun arvona, metodi palauttaa arvon null
     * @param kirjain etsittävä kirjain
     *
     */
    public TrieSolmu etsiKirjain(char kirjain) {

        for (TrieSolmu l : lapsiLista) {
            System.out.println("l.getKirjain: " + l.getKirjain());
            System.out.println("kirjain: " + kirjain);
            if (l.getKirjain() == kirjain) {
                System.out.println("kirjain täsmää");
                return l;
            }
        }
        return null;
    }

    /**
     *
     * @return, jos lapsiSolmun lisääminen onnistui metodi palauttaa viitteen
     * lapsiSolmuun, muutoin metodi palauttaa arvon null
     * @param uusiLapsi
     *
     */
    public TrieSolmu lisaaLapsi(TrieSolmu uusiLapsi) {
        boolean onnistui = this.lapsiLista.add(uusiLapsi);
        if (onnistui) {
            return uusiLapsi;
        }
        return null;
    }

    /**
     * Metodi siirtää taulukossa olevat sijaintitiedot lähdetaulusta
     * kohdetauluun ja alustaa kohdetaulun tyhjäksijäävät alkiot arvolla
     * Integer.MIN_VALUE Metodia kutsutaan kun sijaintiTekstissa taulukko on
     * täyttynyt ja sen kokoa kasvatetaan
     *
     * @return, jos lapsiSolmun lisääminen onnistui metodi palauttaa viitteen
     * lapsiSolmuun, muutoin metodi palauttaa arvon null
     * 
     * @param int [][] kohdeTaulu taulukko, johon kopioidaan tietoa
     * @param int [][] lahdeTaulu taulukko, josta kopioidaan tietoa
     *
     */
    private int[][] siirraTaulukonTiedot(int[][] kohdeTaulu, int[][] lahdeTaulu) {
        for (int i = 0; i < kohdeTaulu.length; i++) {
            for (int j = 0; j < kohdeTaulu[0].length; j++) {
                if (i < lahdeTaulu.length && j < lahdeTaulu[0].length) {
                    kohdeTaulu[i][j] = lahdeTaulu[i][j];
                } else {
                    kohdeTaulu[i][j] = Integer.MIN_VALUE;
                }

            }
        }
        return kohdeTaulu;
    }
}
