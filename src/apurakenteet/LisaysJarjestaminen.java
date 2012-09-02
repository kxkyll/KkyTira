/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apurakenteet;

import java.text.Collator;
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
        Collator vertailija = Collator.getInstance();
        char apukirjain;
        String tamaKirjain;
        String seuraavaKirjain;
        while (seuraava != null) {
            apukirjain = jarjestettavaLista.getListaSolmu().getKirjain();
            tamaKirjain = Character.toString(apukirjain);
            apukirjain = seuraava.getListaSolmu().getKirjain();
            seuraavaKirjain = Character.toString(apukirjain);

            //while (jarjestettavaLista.getListaSolmu().getKirjain() > seuraava.getListaSolmu().getKirjain()) {
            while ((vertailija.compare(tamaKirjain, seuraavaKirjain) < 0)) {
                if (seuraava.getSeuraava() != null) {
                    seuraava = seuraava.getSeuraava();
                    apukirjain = seuraava.getListaSolmu().getKirjain();
                    seuraavaKirjain = Character.toString(apukirjain);
                } else {
                    break;
                }
            }
            //if (jarjestettavaLista.getListaSolmu().getKirjain() > seuraava.getListaSolmu().getKirjain()) {
            if ((vertailija.compare(tamaKirjain, seuraavaKirjain) > 0)) {
                LinkitettyLista apu = jarjestettavaLista.getSeuraava();
                jarjestettavaLista.setSeuraava(jarjestettavaLista);
                jarjestettavaLista = apu;
            }

            seuraava = jarjestettavaLista.getSeuraava();
        }
        return jarjestettavaLista;

    }

    public JoustavaTaulukko jarjestaTaulukko(JoustavaTaulukko jarjestettavaTaulukko) {

        Collator vertailija = Collator.getInstance();

        int taulukonPituus = jarjestettavaTaulukko.getJoustavaListaLength();
        if (taulukonPituus > 1) {
            //  System.out.println("taulukon pituus : " + taulukonPituus);
            for (int i = 1; i < taulukonPituus; i++) {
                int j = i;
                //        System.out.println("i: " + i + "j: " + j);
                DT_TrieSolmu oikeaSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j);
                DT_TrieSolmu vasenSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j - 1);
                if (oikeaSolmu == null) {
                    //        System.out.println("oikea null");
                    return jarjestettavaTaulukko;
                } else {
                    //      System.out.println("oikeaSolmu: " + oikeaSolmu);
                }
                if (vasenSolmu == null) {
                    //    System.out.println("vasen null");
                    return jarjestettavaTaulukko;
                } else {
                    //  System.out.println("vasenSolmu: " + vasenSolmu);
                }
                char k = oikeaSolmu.getKirjain();
                String oikeakirjain = Character.toString(k);
                k = vasenSolmu.getKirjain();
                String vasenkirjain = Character.toString(k);
//                if (vertailija.compare(oikeakirjain, vasenkirjain) < 0) {
//                    System.out.println("oikeakirjain: " + oikeakirjain + " on pienempi ");
//
//                } else {
//                    System.out.println("vasenkirjain: " + vasenkirjain + " on pienempi ");
//                }
                //while (oikeaSolmu.getKirjain() < vasenSolmu.getKirjain() && j > 0 || oikeaSolmu != null && vasenSolmu != null) {
                while ((vertailija.compare(oikeakirjain, vasenkirjain) < 0)) {

                    DT_TrieSolmu apuSolmu = oikeaSolmu;
                    jarjestettavaTaulukko.lisaaAlkioIndeksilla(j, vasenSolmu);
                    jarjestettavaTaulukko.lisaaAlkioIndeksilla(j - 1, apuSolmu);
                    //Testitulostus, vaihtuko järjestys
//                    oikeaSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j);
//                    vasenSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j - 1);
//                    System.out.println("oikea nyt: " + oikeaSolmu.getKirjain());
//                    System.out.println("vasen nyt: " + vasenSolmu.getKirjain());

                    j--;
                    if (j > 0) {
                        oikeaSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j);
                        vasenSolmu = (DT_TrieSolmu) jarjestettavaTaulukko.getJoustavaListaItem(j - 1);
                        if (oikeaSolmu == null || vasenSolmu == null) {
                            break;
                        }
                        k = oikeaSolmu.getKirjain();
                        oikeakirjain = Character.toString(k);
                        k = vasenSolmu.getKirjain();
                        vasenkirjain = Character.toString(k);
                    } else {
                        break;
                    }
                }

            }
        }

        return jarjestettavaTaulukko;
    }
}
