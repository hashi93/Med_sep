/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Scorpius
 */
public class treatments {
    
    private int treatmentId;
    private int patientId;
    private String diseasename;
    private String date;
    private String treatment;
    private String description;
    private String addedBy;
    private String addedOn;

    public treatments(int patient_id, String diseaseName, String date, String treatment, String description, String addedby, String currentTime) {
      
        this.patientId=patient_id;
        this.diseasename=diseaseName;
        this.date=date;
        this.treatment=treatment;
        this.description=description;
        this.addedBy=addedby;
        this.addedOn=currentTime;
        
        
        
        
    }

    public treatments(String name, String date, String treatment, String description, String addedBy, String addedOn) {
        this.diseasename=name;
        this.date=date;
        this.treatment=treatment;
        this.description=description;
        this.addedBy=addedBy;
        this.addedOn=addedOn;
        
        
        
        
    }

    
    /**
     * @return the patientId
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * @param patientId the patientId to set
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    /**
     * @return the diseasename
     */
    public String getDiseasename() {
        return diseasename;
    }

    /**
     * @param diseasename the diseasename to set
     */
    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the treatment
     */
    public String getTreatment() {
        return treatment;
    }

    /**
     * @param treatment the treatment to set
     */
    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the addedBy
     */
    public String getAddedBy() {
        return addedBy;
    }

    /**
     * @param addedBy the addedBy to set
     */
    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    /**
     * @return the addedOn
     */
    public String getAddedOn() {
        return addedOn;
    }

    /**
     * @param addedOn the addedOn to set
     */
    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    /**
     * @return the treatmentId
     */
    public int getTreatmentId() {
        return treatmentId;
    }

    /**
     * @param treatmentId the treatmentId to set
     */
    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }
    
    
    
    
    
    
    
}
