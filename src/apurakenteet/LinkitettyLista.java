/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apurakenteet;

import sanaindeksi.TrieSolmu;

/**
 * LinkitettyLista on yksisuuntainen linkitetty lista joka sisältää data-oliona
 * TrieSolmu tyyppisen muuttujan sekä linkin seuraavaan lista-olioon
 *
 * @author Kati
 */
public class LinkitettyLista {

    private TrieSolmu listaSolmu;
    private LinkitettyLista seuraava;

    /**
     * Konstruktori asettaa listaSolmun ja osoittimen seuraavaan listan alkioon
     * arvoon null
     */
    public LinkitettyLista() {
        this.listaSolmu = null;
        this.seuraava = null;
    }

    /**
     * Konstruktori asettaa listan muttujaan listaSolmu parametrinaan saavansa
     * arvot listan seuraavaan solmuun osoittava osoitin nimeltä seuraava
     * asetetaan arvon null
     *
     * @param solmu luotavan listan muuttujaan asetettavat arvot
     */
    public LinkitettyLista(TrieSolmu solmu) {
        this.listaSolmu = solmu;
        this.seuraava = null;
    }

    /**
     * Konstruktori asettaa listan muuttujaan listaSolmu parametrilla listaSolmu
     * saavansa arvot ja listan seuraavaan solmuun osoittava osoitin nimeltä
     * seuraava asetetaan parametrina saadun muuttujan seuraava osoittamaan
     * arvoon
     *
     * @param listaSolmu
     * @param seuraava
     */
    public LinkitettyLista(TrieSolmu listaSolmu, LinkitettyLista seuraava) {
        this.listaSolmu = listaSolmu;
        this.seuraava = seuraava;
    }

    /**
     * palauttaa tämän listan alkion tieto-olion datakenttien arvot
     *
     * @return
     */
    public TrieSolmu getListaSolmu() {
        return listaSolmu;
    }

    /**
     * palauttaa tämän listan seuraavan lista-olion
     *
     * @return
     */
    public LinkitettyLista getSeuraava() {
        return seuraava;
    }

    /**
     * asettaa listan tieto-olion listaSolmun arvoksi parametrinaan saavansa
     * muuttujan arvot
     *
     * @param listaSolmu listan tieto-olioon talletettavat arvot
     */
    public void setListaSolmu(TrieSolmu listaSolmu) {
        this.listaSolmu = listaSolmu;
    }

    /**
     * asettaa linkin listan seuraavaan lista-olioon
     *
     * @param seuraava
     */
    public void setSeuraava(LinkitettyLista seuraava) {
        this.seuraava = seuraava;
    }

    /**
     * lisää uuden solmun listan viimeiseksi
     *
     * @param uusiSolmu
     * @return
     */
    public boolean lisaaSolmu(TrieSolmu uusiSolmu) {
//        System.out.println("lisaaSolmu"); 

        LinkitettyLista nykyinenAlkio = this;
        LinkitettyLista seuraavaAlkio = this.getSeuraava();
        while (seuraavaAlkio != null) {
            nykyinenAlkio = seuraavaAlkio;
            seuraavaAlkio = nykyinenAlkio.getSeuraava();
        }

        nykyinenAlkio.setSeuraava(new LinkitettyLista(uusiSolmu, null));
        return true;
    }

    /**
     * Lisätään järjestettyyn lapsilistaan uusi solmu. Solmut ovat
     * lexicograafisessa järjestyksessä
     *
     * @param uusiSolmu lisättävä solmu
     * @return palauttaa true jos lisääminen onnistui
     */
    public boolean lisaaSolmuJarjesttyynListaan(TrieSolmu uusiSolmu) {

        System.out.println("lisaaSolmuJarjestettyynListaan");
        System.out.println("Ennen lisäystä");
        tulostaLista();
        LinkitettyLista apuAlkio = null;
        LinkitettyLista nykyinenAlkio = this;
        System.out.println("nykyinen ennen lisäystä: " + nykyinenAlkio.getListaSolmu().getKirjain());
        LinkitettyLista seuraavaAlkio = nykyinenAlkio.getSeuraava();

        while (seuraavaAlkio != null) {
            System.out.println("seuraava ei null");
            if (uusiSolmu.getKirjain() > nykyinenAlkio.getListaSolmu().getKirjain()) {
                System.out.println("uusi kirjain suurempi kuin nykyinen kirjain");
                nykyinenAlkio = seuraavaAlkio;
                seuraavaAlkio = nykyinenAlkio.getSeuraava();
            } else {
                apuAlkio = seuraavaAlkio;
                break;
            }
        }
        if (seuraavaAlkio != null) {
            System.out.println("seuraava ennen: " + nykyinenAlkio.getSeuraava().getListaSolmu().getKirjain());
            nykyinenAlkio.setSeuraava(new LinkitettyLista(uusiSolmu, apuAlkio));

            //nykyinenAlkio.seuraava.setSeuraava(apuAlkio);
            System.out.println("seuraava jälkeen: " + nykyinenAlkio.getSeuraava().getListaSolmu().getKirjain());
            System.out.println("Lisätty väliin");
            tulostaLista();
            return true;
        } else {
            System.out.println("Lisätty loppuun");

            nykyinenAlkio.setSeuraava(new LinkitettyLista(uusiSolmu, null));
            tulostaLista();
            return true;
        }

    }

    /**
     * palauttaa Linkitetyn listan
     * @return
     */
    public LinkitettyLista getLinkitettyLista() {
        return this;
    }

    /**
     * tulostaa Listan alkiot, käytetty testauksen apuvälineenä
     * 
     */
    private void tulostaLista() {
        System.out.println("Listalla: ");
        LinkitettyLista listanSeuraava = this.getSeuraava();
        while (listanSeuraava != null) {
            System.out.println(listanSeuraava.getListaSolmu().getKirjain());
            listanSeuraava = listanSeuraava.getSeuraava();
        }
    }
}
