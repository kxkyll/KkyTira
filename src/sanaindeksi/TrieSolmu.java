/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

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
    private int[][] sijaintiTekstissa;
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
        this.sijaintiTekstissa = new int[100][100]; //todo: Mieti miten sanojen sijainti kannattaa tallettaa
        this.lapsiLista = new LinkedList<TrieSolmu>();
    }

    public void setSananVikaKirjain(boolean sananVikaKirjain) {
        this.sananVikaKirjain = sananVikaKirjain;
    }

    public void setSijaintiTekstissa(int[][] sijaintiTekstissa) {
        this.sijaintiTekstissa = sijaintiTekstissa;
    }

    public char getKirjain() {
        return kirjain;
    }

    public boolean isSananVikaKirjain() {
        return sananVikaKirjain;
    }

    public LinkedList<TrieSolmu> getLapsiLista() {
        return lapsiLista;
    }

    public int[][] getSijaintiTekstissa() {
        return sijaintiTekstissa;
    }

    public TrieSolmu etsiKirjain(char kirjain) {
        TrieSolmu lapsi = null;
        for (Iterator<TrieSolmu> it = this.lapsiLista.iterator(); it.hasNext();) {
            lapsi = it.next();
            if (lapsi.getKirjain() == kirjain) {
                return lapsi;
            }
        }
        return lapsi;
    }

    public TrieSolmu lisaaLapsi(TrieSolmu uusiLapsi) {
        boolean onnistui = this.lapsiLista.add(uusiLapsi);
        if (onnistui) {
            return uusiLapsi;
        }
        return null;
    }
}
