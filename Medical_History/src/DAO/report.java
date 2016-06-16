/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.InputStream;

/**
 *
 * @author Scorpius
 */
public class report {
    
private int patient_id;
private InputStream image;
private String added_by;
private String added_on;

    public report(int patient_id, InputStream inputStream, String currentTime) {
        
        this.patient_id=patient_id;
        this.image=inputStream;
        this.added_on=currentTime;
        
        
    }

    /**
     * @return the patient_id
     */
    public int getPatient_id() {
        return patient_id;
    }

    /**
     * @param patient_id the patient_id to set
     */
    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    /**
     * @return the image
     */
    public InputStream getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(InputStream image) {
        this.image = image;
    }

    /**
     * @return the added_by
     */
    public String getAdded_by() {
        return added_by;
    }

    /**
     * @param added_by the added_by to set
     */
    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    /**
     * @return the added_on
     */
    public String getAdded_on() {
        return added_on;
    }

    /**
     * @param added_on the added_on to set
     */
    public void setAdded_on(String added_on) {
        this.added_on = added_on;
    }
    
    
    
    
}
