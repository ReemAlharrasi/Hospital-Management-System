package services;

import entities.Patient;
import entities.InPatient;
import utils.HelperUtils;

public class PatientService {
    private Patient[] patients;
    private int count;

    public PatientService() {
        patients = new Patient[100];
        count = 0;
    }

    /*
    * public Patient(String id, String firstName, String lastName, String dateOfBirth, String gender,
                   String phoneNumber, String email, String address, String nationalId, int age,
                   boolean activeStatus , String bloodGroup, String emergencyContact,String registrationDate,
                   double outstandingBalance, boolean isInsured) {

* */
    public Patient addPatient(String firstName, String lastName, int age){
        String id = HelperUtils.generateId("PA");
        Patient p = new Patient(id,firstName,lastName, "1950-01-01",
                "other", "+968 0000 0000","unknown",
                "unknown","unknown", age, true,
                "unknown","not givin",
                "2026-08-20",0,false);
        if (count>=patients.length){
            System.out.println("List is full");
        }else{
            patients[count]=p;
            count++;
        }
        return p;

    }

    public Patient addPatient(String firstName, String lastName, int age, String bloodGroup){
        Patient p =addPatient(firstName,lastName,age);
        p.setBloodGroup(bloodGroup);
        return p;
    }
    public Patient addPatient(Patient p){
        p.setId(HelperUtils.generateId("PA"));
        if (count>=patients.length){
            System.out.println("List is full");
        }else{
            patients[count]=p;
            count++;
        }
        return p;
    }
}
