/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apurakenteet;

/**
 *
 * @author Kati
 */
public class JoustavaTaulukko {

    private String[] joustavaTaulukko;
    private int i;

    public JoustavaTaulukko() {
        this.joustavaTaulukko = new String[100];
        this.i = 0;
    }

    public String[] getJoustavaLista() {
        return joustavaTaulukko;
    }

    public int getI() {
        return i;
    }

    public String getJoustavaListaItem(int ind) {
        if (ind >= 0 && ind <= i) {
            return joustavaTaulukko[ind];
        }
        return null;
    }

    public int getJoustavaListaLength() {
        return joustavaTaulukko.length;
    }

    public boolean lisaaJoustavaanTaulukkoon(String lisattava) {
        if (i < joustavaTaulukko.length) {
            joustavaTaulukko[i] = lisattava;
            i++;
        } else {
            kasvataJoustavaTaulukko();
            joustavaTaulukko[i] = lisattava;
            i++;
        }

        return false;
    }

    private void kasvataJoustavaTaulukko() {
        String[] apuTaulukko = new String[joustavaTaulukko.length * 2];
        for (int ind = 0; ind < apuTaulukko.length; ind++) {
            if (ind < joustavaTaulukko.length) {
                apuTaulukko[ind] = joustavaTaulukko[ind];
            } else {
                apuTaulukko[ind] = null;
            }
        }
        joustavaTaulukko = apuTaulukko;
    }
}
