/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import apurakenteet.JoustavaKaksiulotteinenTaulukko;
import apurakenteet.JoustavaTaulukko;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kati
 */
public class MuodostaPuuTest {
    
    /**
     *
     */
    public MuodostaPuuTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of teeTrie method, of class MuodostaPuu.
     */
    @Test
    public void testPerusTrie() {
        System.out.println("perusTrie");
        int tiedostoNumero = 0;
        MuodostaPuu instance = new MuodostaPuu(1);
        Trie expResult = null;
        Trie result = (Trie) instance.teeTrie(tiedostoNumero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haeSana method, of class MuodostaPuu.
     */
    @Test
    public void testHaeSana() {
        System.out.println("haeSana");
        String haettavaSana = "";
        MuodostaPuu instance = new MuodostaPuu();
        JoustavaKaksiulotteinenTaulukko expResult = null;
        JoustavaKaksiulotteinenTaulukko result = instance.haeSana(haettavaSana);
        //assertArrayEquals(expResult, result);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lisaaTiedosto method, of class MuodostaPuu.
     */
    @Test
    public void testLisaaTiedosto() {
        System.out.println("lisaaTiedosto");
        JoustavaTaulukko luettuTiedosto = null;
        int tiedostoLaskuri = 0;
        MuodostaPuu instance = new MuodostaPuu(1);
        Trie expResult = null;
        Trie result = (Trie) instance.lisaaTiedosto(luettuTiedosto, tiedostoLaskuri);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
