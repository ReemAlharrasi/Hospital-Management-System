package services;

import entities.Patient;
import entities.InPatient;
import interfaces.Manageable;
import interfaces.Searchable;
import utils.HelperUtils;

public class PatientService implements Manageable, Searchable {
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
        add(p);
        return p;

    }

    public Patient addPatient(String firstName, String lastName, int age, String bloodGroup){
        Patient p =addPatient(firstName,lastName,age);
        p.setBloodGroup(bloodGroup);
        return p;
    }
    public Patient addPatient(Patient p){
        p.setId(HelperUtils.generateId("PA"));
        add(p);
        return p;
    }

    @Override
    public void add(Object item) {
        if (item == null || !(item instanceof Patient)) {
            System.out.println("Rejected: not a student.");
            return;
        }
        if (count>=patients.length){
            System.out.println("List is full");
        }else{
            patients[count]= (Patient) item;
            count++;
        }

    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (patients[i].getId().equalsIgnoreCase(id)) {
                //remove item by shifting
                for (int j = i; j < count - 1; j++) {
                    patients[j] = patients[j + 1];
                }
                //delete last value(duplicate) and decrement count
                patients[count - 1] = null;
                count = count - 1;
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] getAll() {
        Object[] result = new Object[count]; //create list with actual size
        for (int i = 0; i < count; i++) {
            result[i] = patients[i]; //copy each item
        }
        return result; //return copied list
    }

    @Override
    public Object[] search(String keyword) {
        int repeat = 0;
        for (int i = 0; i < count; i++) {
            if (patients[i].getId().equalsIgnoreCase(keyword)) {
                repeat++; //count how many times id got repeated
            }
        }
        Object[] result = new Object[repeat]; //create list to copy items
        int pos = 0; //for position
        for (int i = 0; i < count; i++) {
            if (patients[i].getId().equalsIgnoreCase(keyword)) {
                result[pos++]=patients[i]; //copy matching item
            }
        }
        return result; //return list
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (patients[i].getId().equalsIgnoreCase(id)) {
                return patients[i];
            }
        }
        return null;
    }

    public void updateContact(String id, String phone, String email) {
        Object found = searchById(id);
        if (found == null) {
            System.out.println("No Patient with id " + id);
            return;
        }
        Patient p = (Patient) found;
        p.updateContact(phone, email);
    }

    public void listInPatients() {
        System.out.println("In Patients -----");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (patients[i] != null && patients[i] instanceof InPatient) {
                patients[i].displaySummary();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("(none)");
        }
    }

    public double totalOutstanding() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total = total + patients[i].getOutstandingBalance();
        }
        return total;
    }
}
