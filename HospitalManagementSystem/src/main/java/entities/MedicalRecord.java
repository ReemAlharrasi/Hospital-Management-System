package entities;

public class MedicalRecord {
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
    public void setRecordId(String recordId) {this.recordId = recordId;}
    public void setPatientId(String patientId) {this.patientId = patientId;}
    public void setDoctorId(String doctorId) {this.doctorId = doctorId;}
    public void setVisitDate(String visitDate) {this.visitDate = visitDate;}
    public void setDiagnosis(String diagnosis) {this.diagnosis = diagnosis;}
    public void setPrescription(String prescription) {this.prescription = prescription;}
    public void setNotes(String notes) {this.notes = notes;}
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

    public void appendNote(String note){
        //check input is not empty
        if (note.isEmpty()){
            return;
        }
        //check if existing notes are empty;
        if (getNotes().isEmpty()){
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
