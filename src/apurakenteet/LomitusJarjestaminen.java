/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apurakenteet;

import sanaindeksi.DT_TrieSolmu;

/**
 *
 * @author Kat
 */
public class LomitusJarjestaminen {

    //private DT_TrieSolmu[] jarjestettava;
    //private DT_TrieSolmu[] aputaulu;
    private JoustavaTaulukko jarjestettava;
    private JoustavaTaulukko aputaulu;
    private int tayttoAste;

//    public LomitusJarjestaminen(DT_TrieSolmu[] jarjestettava) {
//        this.jarjestettava = jarjestettava;
//        aputaulu = new DT_TrieSolmu[jarjestettava.length];
//        tayttoAste = paljonkoTaulussaAlkioita();
//        lomitusJarjesta(0, tayttoAste);
//    }
    public LomitusJarjestaminen() {
        System.out.println("lomitusJarjestaminen");
//        this.jarjestettava = lapsiTaulukko;
//        aputaulu = new JoustavaTaulukko(jarjestettava.getJoustavaListaLength());
//        tayttoAste = paljonkoTaulussaAlkioita();
//        lomitusJarjesta(0, tayttoAste);

    }
    
    public JoustavaTaulukko jarjesta (JoustavaTaulukko lapsiTaulukko) {
        System.out.println("jarjesta");
        this.jarjestettava = lapsiTaulukko;
        aputaulu = new JoustavaTaulukko(jarjestettava.getJoustavaListaLength());
        tayttoAste = paljonkoTaulussaAlkioita();
        return lomitusJarjesta(0, tayttoAste-1);
    }

    private JoustavaTaulukko lomitusJarjesta(int alku, int loppu) {
        int keskikohta;
        if (alku < loppu) {
            System.out.println("alku "+alku +" < " +loppu +" loppu");
            keskikohta = (alku + loppu) / 2; 
            //double floor = Math.floor((alku +loppu) /2.0);
            System.out.println("keskikohta: " +keskikohta);
            //System.out.println("floor: " + floor);
            lomitusJarjesta(alku, keskikohta);
            lomitusJarjesta(keskikohta + 1, loppu);
            yhdista(alku, keskikohta, loppu);

        }
        return jarjestettava;
    }

    private void yhdista(int alku, int keskikohta, int loppu) {
        System.out.println("yhdista");
        for (int i = alku; i < loppu + 1; i++) {
            aputaulu.lisaaAlkioIndeksilla(i, jarjestettava.getJoustavaListaItem(i));

        }
        int i = alku;
        int j = keskikohta + 1;
        int k = alku;

        while (i < keskikohta && j < loppu) {
            System.out.println("i "+i +" < "+keskikohta +" keskikohta ja j " +j +" <  " +loppu +" loppu ");
            DT_TrieSolmu apuAlkioI;
            DT_TrieSolmu apuAlkioJ;
         //   if (aputaulu.getJoustavaListaItem(i) != null && aputaulu.getJoustavaListaItem(j) != null) {
         //       System.out.println("i ja j eivät null");
                apuAlkioI = (DT_TrieSolmu) aputaulu.getJoustavaListaItem(i);
                apuAlkioJ = (DT_TrieSolmu) aputaulu.getJoustavaListaItem(j);

                if (apuAlkioI.getKirjain() < apuAlkioJ.getKirjain()) {
                    System.out.println("i:n kirjain pienempi");
                    System.out.println("kirjain: " +apuAlkioI.getKirjain());
                    System.out.println("lisätään kohtaan " +k);
                    jarjestettava.lisaaAlkioIndeksilla(k, apuAlkioI);
                    //jarjestettava[k] = aputaulu[i];
                    i++;
                } else {
                    System.out.println("j:n kirjain pienempi");
                    System.out.println("kirjain: " +apuAlkioJ.getKirjain());
                    System.out.println("lisätään kohtaan " +k);
                    jarjestettava.lisaaAlkioIndeksilla(k, apuAlkioJ);
                    //jarjestettava[k] = aputaulu[j];
                    j++;
                }
         //   }
            k++;
        }
        while (i <= keskikohta) {
            System.out.println("kopioidaan loputkin taulusta takaisin jarjestetylle listalle");
            jarjestettava.lisaaAlkioIndeksilla(k, aputaulu.getJoustavaListaItem(i));
            //jarjestettava[k] = aputaulu[i];
            k++;
            i++;
        }
    }

    private int paljonkoTaulussaAlkioita() {
        System.out.println("paljonkoTaulussaAlkioita");
        int i = 0;
        for (i = 0; i < jarjestettava.getJoustavaListaLength(); i++) {
            if (jarjestettava.getJoustavaListaItem(i) == null) {
                System.out.println("i: " +1);
                return i;
            } else {
                DT_TrieSolmu apuSolmu = (DT_TrieSolmu) jarjestettava.getJoustavaListaItem(i);
                System.out.println(apuSolmu.getKirjain());
            }
        }
        System.out.println("i: " + 1);
        return i;
    }
}
