/**
 * Apurakenteet pakkaus sisältää tarvittavia avustavia tietorakenteita
 */
package apurakenteet;


/**
 *
 * JoustavaTaulukko olio korvaa Sanahaku ohjelmassa tarvittavat osat
 * kaksiulotteisesta ArrayList rakenteesta
 *
 * @author Kati
 *
 */
public class JoustavaKaksiulotteinenTaulukko {

    /**
     *
     *
     * Sisältää dataoliot: 
     * joustavaKaksiulotteinenTaulukko joka on joustavan mittainen
     * kaksiulotteinen taulukko, oletuskoko 10 x 10 alkiota  
     * sarakeIndeksi, joka on indeksitaulukon ensimmäiseen tyhjään alkioon
     *
     * @author Kati
     */
    private Object[][] joustavaKaksiulotteinenTaulukko;
    private int sarakeIndeksi;

    /**
     * Konstruktori alustaa joustavanTaulukon 10 x 10 alkion mittaiseksi ja
     * sarakeIndeksin parametrin indeksi osoittamaan arvoon
     * @param indeksi taulukon indeksin alkuarvo
     */
    public JoustavaKaksiulotteinenTaulukko(int indeksi) {

        this.joustavaKaksiulotteinenTaulukko = new Object[10][10];
        this.sarakeIndeksi = indeksi;
    }

    /**
     * Konstruktori alustaa joustavanTaulukon parametrina saavansa koko
     * muuttujan kokoiseksi ja sarakeIndeksin parametrin indeksi osoittamaan arvoon
     *
     * @param koko taulukon alustuskoko
     * @param indeksi taulukon indeksin alkuarvo
     */
    public JoustavaKaksiulotteinenTaulukko(int koko, int indeksi) {
        this.joustavaKaksiulotteinenTaulukko = new Object[koko][koko];
        this.sarakeIndeksi = indeksi;
    }

    /**
     * Metodi getJoustavaTaulukko palauttaa joustavaTaulukko objektin
     *
     * @return palauttaa joustavaTaulukko-objektin
     */
    public Object[][] getJoustavaTaulukko() {

        return joustavaKaksiulotteinenTaulukko;
    }

        /**
     * Metodi getJoustavaTaulukkoAlkio palauttaa indeksien osoittaman alkion 
     * int muodossa
     *
     * @param i indeksi haluttuun alkioon
     * @param j indeksi haluttuun alkioon
     * @return palauttaa joustavaTaulukko-objektin indeksien osoittaman alkion
     */
    public int getJoustavaTaulukkoAlkio(int i, int j) {

        int alkio;
        alkio = (Integer)joustavaKaksiulotteinenTaulukko[i][j];
        return alkio;
    }

    
    
    /**
     * Metodi getSarakeIndeksi palauttaa sarake indeksin arvon, joka osoittaa
     * taulukon rivin ensimmäiseen tyhjään alkioon
     *
     * @return sarakeIndeksi rivin ensimmäinen tyhjä alkio
     */
    public int getSarakeIndeksi() {
        return sarakeIndeksi;
    }

    /**
     * Metodi getJoustavaListaLength palauttaa joustavan listan pituuden siis
     * taulukon koko kapasiteetti
     *
     * @return joustavanTaulukko.length, joustavan taulukon pituus
     */
    public int getJoustavaTaulukkoLength() {
        return joustavaKaksiulotteinenTaulukko.length;
    }

    /**
     *
     * @return palauttaa joustavaKaksiulotteinenTaulukko[0].length;
     */
    public int getJoustavaTaulukkoBreadth() {
        return joustavaKaksiulotteinenTaulukko[0].length;
    }

    /**
     * Metodi lisaaKaksiulotteiseenJoustavaanTaulukkoon lisää parametrina
     * saavansa objektin joustavanTaulukon seuraavaan tyhjään paikkaan
     * parametrin rivi osoittamalle riville, jos taulukko on täynnä,
     * suurennetaan taulukkoa
     *
     * @param lisattava taulukkoon lisättävä alkio
     * @param rivi mille taulukon riville tieto lisätään
     */
    public void lisaaKaksiulotteiseenJoustavaanTaulukkoon(int rivi, Object lisattava) {
        int taulukonPituus = this.getJoustavaTaulukkoLength();
        int taulukonLeveys = this.getJoustavaTaulukkoBreadth();
        if (rivi < taulukonPituus && sarakeIndeksi < taulukonLeveys) {
            joustavaKaksiulotteinenTaulukko[rivi][sarakeIndeksi] = lisattava;
            sarakeIndeksi++;
        } else {

            Object[][] uusiTaulukko = new Object[taulukonLeveys * 2][taulukonPituus * 2];
            uusiTaulukko = siirraTaulukonTiedot(uusiTaulukko, joustavaKaksiulotteinenTaulukko);
            joustavaKaksiulotteinenTaulukko = uusiTaulukko;
            joustavaKaksiulotteinenTaulukko[rivi][sarakeIndeksi] = lisattava;
            sarakeIndeksi++;
        }
    }
    
    /**
     * Metodi siirraTaulukonTiedot siirtää taulukon tiedot pieneksi jääneestä taulukosta
     * uuteen suurempaan taulukkoon
     * @param kohdeTaulu uusi suurempi taulukko jonne tiedot kopioidaan
     * @param lahdeTaulu vanha taulukko josta tiedot kopioidaan
     * @return palauttaa taulukon joka on suurempi kuin alkuperäinen, mutta sisältää alkuperäisen tiedot
     */

    private Object[][] siirraTaulukonTiedot(Object[][] kohdeTaulu, Object[][] lahdeTaulu) {
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
    
     /**
     * Alustaa joustavan kaksiulotteisen taulukon sisällön asettamalla jokaiseen
     * taulukon alkioon pienimmän mahdollisen kokonaisluvun Integer.MIN_VALUE
     */
    public void alustaPienimmallaMahdollisella() {
        for (int i = 0; i < joustavaKaksiulotteinenTaulukko.length; i++) {
            for (int j = 0; j < joustavaKaksiulotteinenTaulukko[0].length; j++) {
                joustavaKaksiulotteinenTaulukko[i][j] = Integer.MIN_VALUE;
            }
        }
    }


}
