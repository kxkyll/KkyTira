/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apurakenteet;

import sanaindeksi.DT_TrieSolmu;
import sanaindeksi.TrieSolmu;

/**
 *
 * Lisaysjarjestminen luokka järjestää linkitetyn listan
 * lisäysjärjestämis-algoritmia käyttäen
 *
 * @author Kati
 */
public class LisaysJarjestaminen {

    /**
     * Metodi jarjesta järjestää parametrina saamansa linkitetyn listan
     * aakkosjärjestykseen ja palauttaa järjestetyn listan kutsuvalle metodille
     *
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

    public JoustavaTaulukko jarjestaTaulukko(JoustavaTaulukko jarjestettavaTaulukko) {
        int taulukonPituus = jarjestettavaTaulukko.getJoustavaListaLength();
        if (taulukonPituus > 1) {
            for (int i = 1; i < taulukonPituus; i++) {
                int j = i;
                
                DT_TrieSolmu oikeaSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j);
                DT_TrieSolmu vasenSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j - 1);
                while (oikeaSolmu.getKirjain() < vasenSolmu.getKirjain() && j > 0 && oikeaSolmu != null && vasenSolmu != null) {
                    DT_TrieSolmu apuSolmu = oikeaSolmu;
                    jarjestettavaTaulukko.lisaaAlkioIndeksilla(j, vasenSolmu);
                    jarjestettavaTaulukko.lisaaAlkioIndeksilla(j - 1, apuSolmu);
                    j--;
                    if (j > 0) {
                        oikeaSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j);
                        vasenSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j - 1);
                    } else {
                        break;
                    }
                }

            }
        }

        return jarjestettavaTaulukko;
    }
}
