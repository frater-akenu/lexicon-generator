/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexicon.generator.objects;

import java.util.TreeMap;
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
public class lexiconObjectTest {
    
    public lexiconObjectTest() {
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

    @Test
    public void testFullTest() {
        System.out.println("getBBCode");
        LexiconObject instance = new LexiconObject();
        instance.addDefinition("a", "x");
        instance.addDefinition("c", "z");
        instance.addDefinition("b", "y");
        String result = instance.getBBCode();
        
        System.out.println(result);
    }
    
}
