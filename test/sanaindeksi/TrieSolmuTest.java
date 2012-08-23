/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kati
 */
public class TrieSolmuTest {

    /**
     *
     */
    public TrieSolmuTest() {
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
        Trie testiTrie = new Trie();
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of setSananVikaKirjain method, of class TrieSolmu.
     */
    @Test
    public void testSetSananVikaKirjain() {
        System.out.println("setSananVikaKirjain");
        boolean sananVikaKirjain = true;
        TrieSolmu solmu = new TrieSolmu('u');
        solmu.setSananVikaKirjain(sananVikaKirjain);
        assertTrue(solmu.isSananVikaKirjain());
    }

// Ei vielä toteutettu    
//    /**
//     * Test of setSijaintiTekstissa method, of class TrieSolmu.
//     */
//    @Test
//    public void testSetSijaintiTekstissa() {
//        System.out.println("setSijaintiTekstissa");
//        int tiedostoNumero = 0;
//        int Rivinumero = 0;
//        TrieSolmu instance = null;
//        instance.setSijaintiTekstissa(tiedostoNumero, Rivinumero);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of getKirjain method, of class TrieSolmu.
     */
    @Test
    public void testGetKirjain() {
        System.out.println("getKirjain");
        TrieSolmu solmu = new TrieSolmu('u');
        char expResult = 'u';
        char result = solmu.getKirjain();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isSananVikaKirjain method, of class TrieSolmu.
     */
    @Test
    public void testIsSananVikaKirjain() {
        System.out.println("isSananVikaKirjain");
        TrieSolmu solmu = new TrieSolmu('u');
        boolean expResult = false;
        boolean result = solmu.isSananVikaKirjain();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLapsiLista method, of class TrieSolmu.
     */
    @Test
    public void testGetLapsiLista() {
        System.out.println("getLapsiLista");
        TrieSolmu trieSolmu = new TrieSolmu ('a');
        LinkedList expResult = new LinkedList ();
        LinkedList result = trieSolmu.getLapsiLista();
        assertEquals(expResult, result);
        
    }

//    /**
//     * Test of getSijaintiTekstissa method, of class TrieSolmu.
//     * ei vielä toteutettu       
//     */
//    @Test
//    public void testGetSijaintiTekstissa() {
//        System.out.println("getSijaintiTekstissa");
//        TrieSolmu instance = null;
//        ArrayList expResult = null;
//        ArrayList result = instance.getSijaintiTekstissa();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of etsiKirjain method, of class TrieSolmu.
     */
    @Test
    public void testEtsiKirjain() {
        System.out.println("etsiKirjain");
        TrieSolmu solmu = new TrieSolmu ('k');
        solmu.lisaaLapsi(new TrieSolmu('a'));
        
        solmu = solmu.etsiKirjain('a');

        assertNotNull(solmu);

    }

    /**
     * Test of lisaaLapsi method, of class TrieSolmu.
     */
    @Test
    public void testLisaaLapsi_tyhja() {
        System.out.println("lisaaLapsi_tyhja");
        
        TrieSolmu trieSolmu = new TrieSolmu (' ');
        
        TrieSolmu expResult = null;
        
        TrieSolmu result = trieSolmu.lisaaLapsi(null);
        assertEquals(expResult, result);
        
    }
}
