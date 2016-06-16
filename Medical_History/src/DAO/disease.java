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
public class disease {
    
    private int diseaseId;
    private int patientId;
    private String diseasename;
    private String date;
    private String symptoms;
    private String description;
    private String addedBy;
    private String addedOn;

    
    public disease(int patientId,String diseaseName,String date,String symptoms,String description,String addedBy,String addedOn){
    
        this.patientId=patientId;
        this.diseasename=diseaseName;
        this.date=date;
        this.symptoms=symptoms;
        this.description=description;
        this.addedBy=addedBy;
        this.addedOn=addedOn;
        
        
        
    }

    public disease(String name, String date, String symptom, String description, String addedBy, String addedOn) {
        this.diseasename=name;
        this.date=date;
        this.symptoms=symptom;
        this.description=description;
        this.addedBy=addedBy;
        this.addedOn=addedOn;
        
        
        
        
    }

    
    
    
    
    /**
     * @return the diseaseId
     */
    public int getDiseaseId() {
        return diseaseId;
    }

    /**
     * @param diseaseId the diseaseId to set
     */
    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
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
     * @return the symptoms
     */
    public String getSymptoms() {
        return symptoms;
    }

    /**
     * @param symptoms the symptoms to set
     */
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
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
    
    
    
}
