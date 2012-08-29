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
public class LisaysJarjestaminen {

    /**
     *
     * @param jarjestettavaLista
     * @return
     */
    public static LinkitettyLista jarjesta(LinkitettyLista jarjestettavaLista) {
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
