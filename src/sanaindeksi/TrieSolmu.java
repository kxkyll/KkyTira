/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.util.LinkedList;

/**
 *
 * @author Kati
 */
public class TrieSolmu {
    private char kirjain;
    private boolean sananVikaKirjain;
    private int [][] sijaintiTekstissa;
    private LinkedList<TrieSolmu> lapsiLista;
    
/**
 * Konstruktorissa alustetaan TrieSolmu parametrina saatavalla kirjaimella
 * @param kirjain TrieSolmussa talletettava data eli sanan kirjain
 * Lisäksi oletetaan että kyseessä ei ole yksikirjaiminen sana, ts. sananVikaKirjain saa arvon false
 * ja alustetaan LinkitettyLista lapsiLista
 */
    public TrieSolmu(char kirjain) {
        this.kirjain = kirjain;
        this.sananVikaKirjain = false;
        this.sijaintiTekstissa = new int [100][100]; //todo: Mieti miten sanojen sijainti kannattaa tallettaa
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
    
    
}
