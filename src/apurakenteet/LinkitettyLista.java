/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apurakenteet;

import sanaindeksi.TrieSolmu;

/**
 *
 * @author Kati
 */
public class LinkitettyLista {

    private TrieSolmu listaSolmu;
    private LinkitettyLista seuraava;

    /**
     * Konstruktori asettaa listaSolmun ja osoittimen seuraavaan listan alkioon arvoon null
     */
    public LinkitettyLista() {
        this.listaSolmu = null;
        this.seuraava = null;
    }

    /**
     * Konstruktori asettaa listan muttujaan listaSolmu parametrinaan saavansa arvot
     * listan seuraavaan solmuun osoittava osoitin nimeltä seuraava asetetaan arvon null
     * @param solmu luotavan listan muuttujaan asetettavat arvot
     */
    public LinkitettyLista(TrieSolmu solmu) {
        this.listaSolmu = solmu;
        this.seuraava = null;
    }

    /**
     * Konstruktori asettaa listan muuttujaan listaSolmu parametrilla listaSolmu saavansa arvot
     * ja listan seuraavaan solmuun osoittava osoitin nimeltä seuraava asetetaan parametrina saadun
     * muuttujan seuraava osoittamaan arvoon
     * @param listaSolmu
     * @param seuraava
     */
    public LinkitettyLista(TrieSolmu listaSolmu, LinkitettyLista seuraava) {
        this.listaSolmu = listaSolmu;
        this.seuraava = seuraava;
    }

    /**
     * palauttaa tämän listan alkion datakenttien arvot
     * @return
     */
    public TrieSolmu getListaSolmu() {
        return listaSolmu;
    }

    /**
     *
     * @return
     */
    public LinkitettyLista getSeuraava() {
        return seuraava;
    }

    /**
     *
     * @param listaSolmu
     */
    public void setListaSolmu(TrieSolmu listaSolmu) {
        this.listaSolmu = listaSolmu;
    }

    /**
     *
     * @param seuraava
     */
    public void setSeuraava(LinkitettyLista seuraava) {
        this.seuraava = seuraava;
    }

    /**
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
     *
     * @param uusiSolmu
     * @return
     */
    public boolean lisaaSolmuJarjesttyynListaan(TrieSolmu uusiSolmu) {
        
        System.out.println("lisaaSolmuJarjestettyynListaan");
        System.out.println("Ennen lisäystä");
        tulostaLista();
        LinkitettyLista apuAlkio = null;
        LinkitettyLista nykyinenAlkio = this;
        System.out.println("nykyinen ennen lisäystä: " +nykyinenAlkio.getListaSolmu().getKirjain());
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
            System.out.println("seuraava ennen: " +nykyinenAlkio.getSeuraava().getListaSolmu().getKirjain());
            nykyinenAlkio.setSeuraava(new LinkitettyLista(uusiSolmu, apuAlkio));
            
            //nykyinenAlkio.seuraava.setSeuraava(apuAlkio);
            System.out.println("seuraava jälkeen: " +nykyinenAlkio.getSeuraava().getListaSolmu().getKirjain());
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
     *
     * @return
     */
    public LinkitettyLista getLinkitettyLista() {
        return this;
    }
    
    private void tulostaLista() {
        System.out.println("Listalla: ");
            LinkitettyLista listanSeuraava = this.getSeuraava();
        while (listanSeuraava != null) {
            System.out.println(listanSeuraava.getListaSolmu().getKirjain());
            listanSeuraava = listanSeuraava.getSeuraava();
        }
    }
}
