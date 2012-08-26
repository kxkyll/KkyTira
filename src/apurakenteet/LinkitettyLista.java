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
        listaSolmu = new TrieSolmu();
        seuraava = null;
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
    
    public boolean lisaaSolmu (TrieSolmu uusiSolmu){
        this.seuraava = new LinkitettyLista (uusiSolmu, null);
        return true;    
    }
    
    public LinkitettyLista getLinkitettyLista (){
        return this;
    }
}
