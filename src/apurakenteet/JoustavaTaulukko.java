/**
 * Apurakenteet pakkaus sisältää tarvittavia avustavia tietorakenteita
 */
package apurakenteet;

import sanaindeksi.Tiedostot;

/**
 *
 * JoustavaTaulukko olio korvaa Sanahaku ohjelmassa tarvittavat
 * osat ArrayList rakenteesta
 * @author Kati
 
 */
public class JoustavaTaulukko {

 /**
 *
 *
 * Sisältää dataoliot joustavaTaulukko joka on joustavan mittainen
 * yksiulotteinen taulukko, oletuskoko 100 alkiota i, joka on indeksi taulukon
 * ensimmäiseen tyhjään alkioon ja ilmaisee samalla myös taulukon täyttöasteen
 * @author Kati 
 */

    
    private Object[] joustavaTaulukko;
    //private String[] joustavaTaulukko;
    private int i;

    /**
     * Konstruktori alustaa 
     *  joustavanTaulukon 100 alkion mittaiseksi ja
     *  indeksin i arvoon 0
     */
    public JoustavaTaulukko() {
        //this.joustavaTaulukko = new Object[2];
        this.joustavaTaulukko = new Object[100];
        //this.joustavaTaulukko = new String[100];
        this.i = 0;
    }
    
    public JoustavaTaulukko(int koko) {
        this.joustavaTaulukko = new Object[koko];
        this.i = 0;
    }
    
    /**
     * Konstruktori, joka alustaa joustavan taulukon Tiedosto-tyyppisillä olioilla
     * @param t 
     */
    public JoustavaTaulukko(char t ) {
        this.joustavaTaulukko = new Tiedostot [100];
        this.i = 0;
    }
    

    /**
     * Metodi getJoustavaLista palauttaa joustavaTaulukko objektin
     * @return joustavaTaulukko-objektin
     */
    public Object[] getJoustavaLista() {
        //public String[] getJoustavaLista() {
        return joustavaTaulukko;
    }

    /**
     * Metodi getI palauttaa indeksin i arvon, joka osoittaa ensimmäiseen tyhjään alkioon
     * @return i
     */
    public int getI() {
        return i;
    }

    /**
     * Metodi getJoustavaListaItem palauttaa parametrina saadun indeksin 
     * osoittaman taulukon alkion, jos alkio on listaan lisättyjen alkioiden arvoalueella
     * @param ind jonka osoittamaa alkiota pyydetään
     * @return joustavaTaulukko[ind] palauttaa joustavanTaulukon alkion tai arvon null jos indeksi osoittaa ohi taulukkoon
     * lisättyjen alkioiden
     */
    public Object getJoustavaListaItem(int ind) {
        //public String getJoustavaListaItem(int ind) {
        if (ind >= 0 && ind <= i) {
            return joustavaTaulukko[ind];
        }
        return null;
    }

    /**
     * Metodi getJoustavaListaLength palauttaa joustavan listan pituuden
     * siis taulukon koko kapasiteetti
     * @return joustavanTaulukko.length, joustavan taulukon pituus
     */
    public int getJoustavaListaLength() {
        return joustavaTaulukko.length;
    }

    /**
     * Metodi lisaaJoustavaanTaulukkoon lisää parametrina saavansa
     * objektin joustavanTaulukon seuraavaan tyhjään paikkaan,
     * jos taulukko on täynnä, suurennetaan taulukkoa
     * @param lisattava taulukkoon lisättävä alkio
     */
    public void lisaaJoustavaanTaulukkoon(Object lisattava) {
        //public boolean lisaaJoustavaanTaulukkoon(String lisattava) {
        if (i < joustavaTaulukko.length) {
            joustavaTaulukko[i] = lisattava;
            i++;

        } else {
            kasvataJoustavaTaulukko();
            joustavaTaulukko[i] = lisattava;
            i++;

        }


    }
    
    /**
     * Metodi kasvataJoustavaTaulukko kasvattaa JoustavanTaulukon kokoa
     * kaksinkertaiseksi nykyisestä
     */

    private void kasvataJoustavaTaulukko() {
        //System.out.println("kasvatetaan JoustavaaTaulukkoa");
        Object[] apuTaulukko = new Object[joustavaTaulukko.length * 2];
//        String[] apuTaulukko = new String[joustavaTaulukko.length * 2];
        for (int ind = 0; ind < apuTaulukko.length; ind++) {
            if (ind < joustavaTaulukko.length) {
                apuTaulukko[ind] = joustavaTaulukko[ind];
            } else {
                apuTaulukko[ind] = null;
            }
        }
        joustavaTaulukko = apuTaulukko;
    }
}
