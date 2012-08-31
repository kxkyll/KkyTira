/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import apurakenteet.JoustavaTaulukko;

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
    private int[][] sijaintiTekstissa;
    private int sarake;
    private JoustavaTaulukko lapsiTaulukko;

    public DT_TrieSolmu(char kirjain) {
        this.kirjain = kirjain;
        this.sananVikaKirjain = false;
        this.sijaintiTekstissa = new int[10][10];
        this.sarake = 1;
        
        this.lapsiTaulukko = new JoustavaTaulukko(20);
        //alustaSijaintiTekstissa();
    }
    
}
