/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lexicon.generator.objects;

import java.io.Serializable;
import java.util.TreeMap;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author akenu
 */
@XmlRootElement
public class LexiconObject implements Serializable {
    private TreeMap treemap = new TreeMap<String, String>();

    public LexiconObject() {
    }

    public TreeMap getTreemap() {
        return treemap;
    }

    public void setTreemap(TreeMap treemap) {
        this.treemap = treemap;
    }
    
    
    public void addDefinition(String definition, String meaning) {
        this.treemap.put(definition, meaning);
    }
    
    public String readDefinition(String definition) {
        if(this.treemap.containsKey(definition)) {
            return (String)this.treemap.get(definition);
        } else {
            return null;
        }
    }
    
    public String getBBCode() {
        StringBuffer sb = new StringBuffer();
        
        for(Object key : treemap.keySet()) {
            String definition = (String)key;
            String meaning = (String)treemap.get(key);
            
            sb.append("[b]").append(definition).append("[/b]\n");
            sb.append(meaning).append("\n\n");
        }
        
        return sb.toString();
    }
}
