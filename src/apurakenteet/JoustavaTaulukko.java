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
    private Object[] joustavaTaulukko;
    //private String[] joustavaTaulukko;
    private int i;

    /**
     *
     */
    public JoustavaTaulukko() {
            this.joustavaTaulukko = new Object[100];
        //this.joustavaTaulukko = new String[100];
        
        this.i = 0;
    }

    /**
     *
     * @return
     */
    public Object[] getJoustavaLista() {
    //public String[] getJoustavaLista() {
        return joustavaTaulukko;
    }

    /**
     *
     * @return
     */
    public int getI() {
        return i;
    }

    /**
     *
     * @param ind
     * @return
     */
    public Object getJoustavaListaItem(int ind) {
    //public String getJoustavaListaItem(int ind) {
        if (ind >= 0 && ind <= i) {
            return joustavaTaulukko[ind];
        }
        return null;
    }

    /**
     *
     * @return
     */
    public int getJoustavaListaLength() {
        return joustavaTaulukko.length;
    }

    /**
     *
     * @param lisattava
     */
    public void lisaaJoustavaanTaulukkoon(Object lisattava) {
    //public boolean lisaaJoustavaanTaulukkoon(String lisattava) {
        if (i < joustavaTaulukko.length) {
            joustavaTaulukko[i] = lisattava;
            i++;
            
        } else {
            kasvataJoustavaTaulukko();
            joustavaTaulukko[i] = lisattava;
            i++;
            
        }

     
    }

    private void kasvataJoustavaTaulukko() {
        Object[] apuTaulukko = new Object[joustavaTaulukko.length * 2];
//        String[] apuTaulukko = new String[joustavaTaulukko.length * 2];
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
