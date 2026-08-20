package entities;

import interfaces.Displayable;
import utils.HelperUtils;

public class MedicalRecord implements Displayable {
    //attributes
    private String recordId, patientId, doctorId;
    private String visitDate, diagnosis, prescription, notes;
    private boolean isConfidential;

    //constructor


    public MedicalRecord(String recordId, String patientId, String doctorId, String visitDate,
                         String diagnosis, String prescription, String notes, boolean isConfidential) {
        setRecordId(recordId);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setVisitDate(visitDate);
        setDiagnosis(diagnosis);
        setPrescription(prescription);
        setNotes(notes);
        setConfidential(isConfidential);
    }

    //setters
    public void setRecordId(String recordId) {
        if (HelperUtils.isEmpty(recordId)) this.recordId = recordId;
        else System.out.println("record Id can not be empty");
    }
    public void setPatientId(String patientId) {
        if (patientId != null && !patientId.isEmpty()) this.patientId = patientId;
        else System.out.println("patient Id can not be empty");
    }
    public void setDoctorId(String doctorId) {
        if (HelperUtils.isEmpty(doctorId)) this.doctorId = doctorId;
        else System.out.println("doctor Id can not be empty");
    }
    public void setVisitDate(String visitDate) {
        if (HelperUtils.isEmpty(visitDate)) this.visitDate = visitDate;
        else System.out.println("visit Date can not be empty");
    }
    public void setDiagnosis(String diagnosis) {
        if (HelperUtils.isEmpty(diagnosis)) this.diagnosis = diagnosis;
        else System.out.println("diagnosis can not be empty");
    }
    public void setPrescription(String prescription) {
        if (HelperUtils.isEmpty(prescription)) this.prescription = prescription;
        else System.out.println("prescription can not be empty");
    }
    public void setNotes(String notes) {
        if (HelperUtils.isEmpty(notes)) this.notes = notes;
        else System.out.println("notes can not be empty");
    }
    public void setConfidential(boolean confidential) {isConfidential = confidential;}

    //getters
    public String getRecordId() {return recordId;}
    public String getPatientId() {return patientId;}
    public String getDoctorId() {return doctorId;}
    public String getVisitDate() {return visitDate;}
    public String getDiagnosis() {return diagnosis;}
    public String getPrescription() {return prescription;}
    public String getNotes() {return notes;}

    public void displayInfo(){
        System.out.println("----- Medical Record -----");
        System.out.println("Record ID: "+getRecordId());
        System.out.println("Patient ID: "+getPatientId());
        System.out.println("Doctor ID: "+getDoctorId());
        System.out.println("Visit Date: "+getVisitDate());
        System.out.println("Diagnosis: "+getDiagnosis());
        System.out.println("Prescription: "+getPrescription());
        System.out.println("Notes: "+getNotes());
        System.out.println("Confidential: "+isConfidential());
    }

    @Override
    public void displaySummary() {
        System.out.println("[Medical record] id: " +getRecordId()+ " - Patient ID: " + getPatientId()+ " - Doctor ID: " + getDoctorId());

    }

    public void appendNote(String note){
        //check input is not empty
        if (HelperUtils.isEmpty(note)){
            return;
        }
        //check if existing notes are empty;
        if (HelperUtils.isEmpty(getNotes())){
            setNotes(note);
        }else{
            setNotes(getNotes()+" | "+note);
        }
    }

    public void markConfidential(){
        setConfidential(true);
    }

    public boolean isConfidential() {return isConfidential;}
}
