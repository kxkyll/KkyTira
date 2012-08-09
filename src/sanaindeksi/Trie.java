/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

/**
 *
 * @author Kati
 */
public class Trie {

    private TrieSolmu juuriSolmu;

    public Trie() {
        this.juuriSolmu = new TrieSolmu(' ');
    }

    public Trie lisaaSana(String sana, int tiedostoNumero, int riviNumero) {
        System.out.println("lisaaSana");
        TrieSolmu nykyinenSolmu;
        int vikanKirjaimenPaikka;

        if (sana.length() > 0) {
            sana = sana.replace(",.!?", ""); //todo: voiko välimerkit vain poistaa, 
            // vai pitäisikö niistä tehdä omat sanat ?
            // entäpä erikoismerkit, kuten @£$€{[]}\"'#¤%&/()=*
            sana = sana.toLowerCase();
            System.out.println("sana: " +sana);
            vikanKirjaimenPaikka = sana.length() - 1;
            
            // eka viritelmä
//            char ekaKirjain = sana.charAt(0);
//            nykyinenSolmu = juuriSolmu.etsiKirjain(ekaKirjain);
//            if (nykyinenSolmu == null) { // siis juuren lapsista ei löytynyt ekan sanan ekan kirjaimen mukaista lasta
//                //lisätään juuren lapsilistalle uusi solmu
//                TrieSolmu uusiLapsi = new TrieSolmu (ekaKirjain);
//                boolean add = juuriSolmu.lapsiLista.add(uusiLapsi);
//                juuriSolmu.lisaaLapsi(uusiLapsi);
//            }
            nykyinenSolmu = juuriSolmu;
            for (int i = 0; i < sana.length(); i++) {
                TrieSolmu uusiLapsi = nykyinenSolmu.etsiKirjain(sana.charAt(i)); // etsitään löytyykö solmua joka jo sisältää kirjaimen
               
                if (uusiLapsi != null) {
                    System.out.println("uusiLapsi ei null");
                    nykyinenSolmu = uusiLapsi; // löytyi: mennään hakupuun seuraavalle tasolle
                } else {
                    System.out.println("uusiLapsi on null");
                    uusiLapsi = new TrieSolmu (sana.charAt(i)); // ei löytynyt: tehdään uusi lapsi
                    nykyinenSolmu = nykyinenSolmu.lisaaLapsi(uusiLapsi); // lisätään uusi lapsi lapsilistalle
                    
                }
                if (i == vikanKirjaimenPaikka) {
                    System.out.println("vika kirjain");
                    nykyinenSolmu.setSananVikaKirjain(true);
                    System.out.println("vikakirjain astettu");
                    nykyinenSolmu.setSijaintiTekstissa(tiedostoNumero, riviNumero);
                }
            }

        }
        return this;

    }

    public boolean etsiSana(String sana) {
        boolean loytyikoSana = false;
        return loytyikoSana;
    }
}
