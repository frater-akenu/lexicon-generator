/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexicon.generator.storage;

import lexicon.generator.objects.LexiconObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akenu
 */
public class StorageTest {
    
    public StorageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class Storage.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        LexiconObject lexiconObject = new LexiconObject();
        
        lexiconObject.addDefinition("c", "a");
        lexiconObject.addDefinition("b", "x");
        lexiconObject.addDefinition("a", "d");
        
        Storage instance = new Storage(lexiconObject);
        instance.save();
        
    }
    
    @Test
    public void testSaveToFile() {
        System.out.println("Save to file");
        LexiconObject lo = new LexiconObject();
        
        lo.addDefinition("c", "x");
        lo.addDefinition("d", "x");
        lo.addDefinition("a", "z");
        
        Storage storage = new Storage(lo);
        storage.save("test.txt");
    }
    
    @Test
    public void testLoadFromFile() {
        System.out.println("Load from file");
        LexiconObject lo = new LexiconObject();
        Storage storage = new Storage(lo);
        lo = storage.load("test.txt");
        
        System.out.println(lo.getBBCode());
    }
    
}
