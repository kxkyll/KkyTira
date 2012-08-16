/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sanaindeksi;

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
public class TrieTest {
    
    public TrieTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
     //   Trie testiTrie = new Trie();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        //Trie testiTrie = new Trie();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of lisaaSana method, of class Trie.
     */
    @Test
    public void testLisaaSana() {
        System.out.println("lisaaSana");
        String sana = "";
        int tiedostoNumero = 0;
        int riviNumero = 0;
        Trie instance = new Trie();
        Trie expResult = instance;
        Trie result = instance.lisaaSana(sana, tiedostoNumero, riviNumero);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of lisaaYksiSana method, of class Trie.
     * Lisää yhden sanan ja tutkii löytyykö se puusta
     */
    
   @Test
    public void testLisaaYksiSana() {
        System.out.println("lisaaYksiSana");
        String sana = "yksisana";
        Trie testiTrie = new Trie(); 
        testiTrie = testiTrie.lisaaSana(sana, 1, 1);
        assertTrue(testiTrie.etsiSana(sana));
        
   }
   
    /**
     * Test of lisaaYksiSana method, of class Trie.
     * Lisää kaksi sanaa ja tutkii löytyvätkö ne puusta
     */
   
   @Test
    public void testLisaaKaksiSana() {
        System.out.println("lisaaKaksiSanaa");
        String sana1 = "testiyksi";
        String sana2 = "testikaksi";
        Trie testiTrie = new Trie(); 
        testiTrie = testiTrie.lisaaSana(sana1, 1, 1);
        testiTrie = testiTrie.lisaaSana(sana2, 1, 1);
        assertTrue(testiTrie.etsiSana(sana1));
        assertTrue(testiTrie.etsiSana(sana2));
        
   }
   
    /**
     * Test of lisaaSamaSana method, of class Trie.
     * Lisää sanan monta kertaa ja tutkii löytyykö se puusta
     */
   
   @Test
    public void testSamaSana() {
        System.out.println("lisaaSamaSana");
        String sana = "samasana";
        Trie testiTrie = new Trie(); 
        testiTrie = testiTrie.lisaaSana(sana, 1, 1);
        testiTrie = testiTrie.lisaaSana(sana, 1, 1);
        testiTrie = testiTrie.lisaaSana(sana, 1, 1);
        assertTrue(testiTrie.etsiSana(sana));
        
        
   }
   
   
    /**
     * Test of lisaaTyhjaSana method, of class Trie.
     */
    @Test
    
    public void testLisaaTyhjaSana() {
        System.out.println("lisaaSana");
        String sana = "";
        int tiedostoNumero = 0;
        int riviNumero = 0;
        Trie instance = new Trie();
        Trie expResult = instance;
        Trie result = instance.lisaaSana(sana, tiedostoNumero, riviNumero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of etsiSana method, of class Trie.
     */
    @Test
    public void testEtsiSana() {
        System.out.println("etsiSana");
        String sana = "";
        Trie instance = new Trie();
        boolean expResult = false;
        boolean result = instance.etsiSana(sana);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
