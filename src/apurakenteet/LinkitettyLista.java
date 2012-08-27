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

    public LinkitettyLista() {
        this.listaSolmu = null;
        this.seuraava = null;
    }
    public LinkitettyLista(TrieSolmu solmu) {
        this.listaSolmu = solmu;
        this.seuraava = null;
    }

    public LinkitettyLista(TrieSolmu listaSolmu, LinkitettyLista seuraava) {
        this.listaSolmu = listaSolmu;
        this.seuraava = seuraava;
    }

    public TrieSolmu getListaSolmu() {
        return listaSolmu;
    }

    public LinkitettyLista getSeuraava() {
        return seuraava;
    }

    public void setListaSolmu(TrieSolmu listaSolmu) {
        this.listaSolmu = listaSolmu;
    }

    public void setSeuraava(LinkitettyLista seuraava) {
        this.seuraava = seuraava;
    }

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

    public LinkitettyLista getLinkitettyLista() {
        return this;
    }
}
