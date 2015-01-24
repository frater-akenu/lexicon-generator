/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.akenu.lexicongenerator.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.akenu.lexicongenerator.objects.LexiconObject;

/**
 *
 * @author akenu
 */
public class Storage {
    private LexiconObject toBeStored;

    public Storage(LexiconObject toBeStored) {
        this.toBeStored = toBeStored;
    }
    
    public void save() {
        try {
            JAXBContext jaxbc = JAXBContext.newInstance(LexiconObject.class);
            Marshaller m = jaxbc.createMarshaller();
            
            m.marshal(this.toBeStored, System.out);
        } catch (JAXBException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void save(String filename) {
        try {
            JAXBContext jaxbc = JAXBContext.newInstance(LexiconObject.class);
            Marshaller m = jaxbc.createMarshaller();
            
            FileOutputStream fos = new FileOutputStream(filename);
            m.marshal(this.toBeStored, fos);
            fos.close();
            
        } catch (JAXBException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LexiconObject load(String filename) {
        try {
            JAXBContext jaxbc = JAXBContext.newInstance(LexiconObject.class);
            Unmarshaller u = jaxbc.createUnmarshaller();
            
            FileInputStream fileInputStream = new FileInputStream(filename);
            Object unmarshal = u.unmarshal(fileInputStream);
            this.toBeStored = (LexiconObject)unmarshal;
            
            return this.toBeStored;
            
        } catch (JAXBException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
        
    public void save(File file) {
        try {
            JAXBContext jaxbc = JAXBContext.newInstance(LexiconObject.class);
            Marshaller m = jaxbc.createMarshaller();
            
            m.marshal(this.toBeStored, file);
            
        } catch (JAXBException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LexiconObject load(File file) {
        try {
            JAXBContext jaxbc = JAXBContext.newInstance(LexiconObject.class);
            Unmarshaller u = jaxbc.createUnmarshaller();
            
            Object unmarshal = u.unmarshal(file);
            this.toBeStored = (LexiconObject)unmarshal;
            
            return this.toBeStored;
            
        } catch (JAXBException ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
        
        
    
}
