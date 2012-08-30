/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apurakenteet;

import sanaindeksi.TrieSolmu;

/**
 *
 * Lisaysjarjestminen luokka järjestää linkitetyn listan lisäysjärjestämis-algoritmia käyttäen
 * @author Kati
 */
public class LisaysJarjestaminen {

    /**
     * Metodi jarjesta järjestää parametrina saamansa linkitetyn listan aakkosjärjestykseen
     * ja palauttaa järjestetyn listan kutsuvalle metodille
     * @param jarjestettavaLista lista joka halutaan järjestää
     * @return palauttaa järjestetyn listan tyyppiä LinkitettyLista
     */
    public LinkitettyLista jarjesta(LinkitettyLista jarjestettavaLista) {
        LinkitettyLista seuraava = jarjestettavaLista.getSeuraava();
        while (seuraava != null) {

            while (jarjestettavaLista.getListaSolmu().getKirjain() > seuraava.getListaSolmu().getKirjain()) {
                // || seuraava.getSeuraava != null)
                if (seuraava.getSeuraava() != null) {
                    seuraava = seuraava.getSeuraava();
                } else {
                    break;
                }
            }
            if (jarjestettavaLista.getListaSolmu().getKirjain() > seuraava.getListaSolmu().getKirjain()) {
                LinkitettyLista apu = jarjestettavaLista.getSeuraava();
                jarjestettavaLista.setSeuraava(jarjestettavaLista);
                jarjestettavaLista = apu;
            }

            seuraava = jarjestettavaLista.getSeuraava();
        }
        return jarjestettavaLista;

    }
}
