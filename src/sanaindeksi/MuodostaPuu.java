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
 * Tutkitaan käyttäjän antamien parametrien  perusteella minkälainen puurakenne tiedostosta muodostetaan
 * Oletusarvoisesti muodostetaan perusTrie
 */
public class MuodostaPuu {
    
private ArrayList<String> tiedostonRivit;
    Trie Trie = new Trie();
    /**
     *
     * @param tiedostonRivit Merkkijonoja sisältävä joustava taulukko, jossa kukin tiedoston rivi on omalla rivillään
     * @param tiedostoNumero Viite siihen monesko tiedosto on käsittelyssä
     */
    public MuodostaPuu(ArrayList<String> tiedostonRivit, int tiedostoNumero) {
        this.tiedostonRivit = tiedostonRivit;
        Trie = perusTrie(tiedostoNumero);
    }
    
    /**
     * Luodaan perusTrie, jossa lapset on talletettu linkitetylle listalle
     * @param tiedostoNumero
     * @return Trie-hakupuu 
     */
    public   Trie perusTrie(int tiedostoNumero) {
        int riviNumero = 0;
        for (String rivi: tiedostonRivit) {
            String rivinSanat [] = rivi.split(" ");
            for (int i = 0; i < rivinSanat.length; i++) {
              Trie = Trie.lisaaSana(rivi, tiedostoNumero, riviNumero); 
            }
            riviNumero++;
        }
    
    return Trie;
}
    
    
    
}
