/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.util.ArrayList;
import java.util.Iterator;
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
    private int [][] sijaintiTekstissa;
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
        this.sijaintiTekstissa = new int [10][10];
        this.sarake = 1;
        this.lapsiLista = new LinkedList<TrieSolmu>();
        alustaSijaintiTekstissa();
    }

    /**
     *
     * @param sananVikaKirjain ilmaisee onko tämä kirjain jonkin sanan viimeinen kirjain
     */
    public void setSananVikaKirjain(boolean sananVikaKirjain) {
        this.sananVikaKirjain = sananVikaKirjain;
    }

        /**
     *
     * @param  ilmaisee onko tämä kirjain jonkin sanan viimeinen kirjain
     */
    public void alustaSijaintiTekstissa () {
        for (int i= 0 ; i<sijaintiTekstissa.length;i++) {
            for (int j = 0; j< sijaintiTekstissa[0].length;j++){
                sijaintiTekstissa[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    
    
    /**
     *
     * @param tiedostoNumero ilmaisee missä tiedostossa sana esiintyy
     * @param riviNumero ilmaisee monennellako rivillä kyseisessä tiedostossa sana esiintyy
     */
    public void setSijaintiTekstissa(int tiedostoNumero, int riviNumero) {
        System.out.println("tiedostoNumero: "+tiedostoNumero);
        System.out.println("riviNumero: "+riviNumero);
        int rivi = sijaintiTekstissa.length;
        System.out.println("rivi (taulukon pituus): "+rivi);
        System.out.println("taulukon leveys: "+sijaintiTekstissa[0].length);
        
        if (tiedostoNumero < rivi && sarake < sijaintiTekstissa[0].length) {
            System.out.println("laitetaan rivinumero taulukkoon");
            System.out.println("sarake: "+sarake);
            
            sijaintiTekstissa[tiedostoNumero][sarake] = riviNumero;
            sarake++;
        } else {
            //todo suurenna taulukkoa;
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
    public int [][] getSijaintiTekstissa() {
        System.out.println("getSijaintiTekstissa");
        return sijaintiTekstissa;
    }

    

    /**
     *
     * @param kirjain, metodi etsii onko solmun jonkin lapsisolmun arvona tämä kirjain
     * @return, metodi palauttaa sen lapsisolmun viitteen jonka arvona parametrina saatu kirjain on,
     * jos kyseistä kirjainta ei ole minkään lapsisolmun arvona, metodi palauttaa arvon null
     */
    public TrieSolmu etsiKirjain(char kirjain) {
        
        for (TrieSolmu l: lapsiLista) {
            System.out.println("l.getKirjain: " +l.getKirjain());
            System.out.println("kirjain: "+kirjain);
            if (l.getKirjain() == kirjain) {
                System.out.println("kirjain täsmää");
                return l;
            }
        }
        return null;
    }

    /**
     *
     * @param uusiLapsi, lisättävä lapsiSolmu
     * @return, jos lapsiSolmun lisääminen onnistui metodi palauttaa viitteen lapsiSolmuun,
     * muutoin metodi palauttaa arvon null
     */
    public TrieSolmu lisaaLapsi(TrieSolmu uusiLapsi) {
        boolean onnistui = this.lapsiLista.add(uusiLapsi);
        if (onnistui) {
            return uusiLapsi;
        }
        return null;
    }
}
