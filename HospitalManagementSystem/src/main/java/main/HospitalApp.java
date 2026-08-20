package main;

import entities.*;
import utils.HelperUtils;

public class HospitalApp {
    private Person[] people = new Person[100];
    private int count;

    void main(){
        people[count++]=new Person(HelperUtils.generateId("P"),"Person","1");
        people[count++]= new Patient(HelperUtils.generateId("PA"), "patient", "1", "1998-07-20", "Female", "91234567", "unknown", "Muscat", "123456789", 28, true, "A+", "92345678", "2026-08-20", 75.50, true);
        people[count++]=new Doctor(HelperUtils.generateId("DR"),"Doctor","1","2000-01-01","Female","9093 9430","Dr@hospital.om","Ghala","12321",26,true,"Kids",5,234.5,true);
        people[count++]= new Nurse(HelperUtils.generateId("NR"), "nurse", "1", "1995-05-10", "Female", "99999999", "nurse@hospital.om", "Muscat", "12345678", 31, true, "D01", "Morning", 5);
        people[count++]= new InPatient(HelperUtils.generateId("IPA"), "inpatient", "1", "1995-05-10", "Male", "91234567", "unknown", "Muscat", "123456789", 31, true, "O+", "98765432", "2026-08-20", 150.50, true, "2026-08-20", "R101", 25.0, 5);
        people[count++]= new Surgeon(HelperUtils.generateId("SR"), "surgeon", "1", "1985-03-15", "Male", "92345678", "surgeon@email.com", "Muscat", "123456789", 41, true, "heart surgery", 15, 50.0, true, 120, true);

        printAll();
        countByType();
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            people[i].displayInfo();
            System.out.println();
        }
    }

    public void countByType(){
        int patients=0;
        int inpatients=0;
        int surgeons=0;
        int doctors=0;
        int nurses=0;
        //count
        for (int i = 0; i < count; i++) {
            Person p = people[i];
            if (p instanceof InPatient) inpatients++;
            else if (p instanceof Patient) patients++;
            else if (p instanceof Surgeon) surgeons++;
            else if (p instanceof Doctor) doctors++;
            else if (p instanceof Nurse) nurses++;
        }
        //display
        System.out.println("In Patients: "+inpatients);
        System.out.println("patients: "+patients);
        System.out.println("surgeons: "+surgeons);
        System.out.println("doctors: "+doctors);
        System.out.println("nurses: "+nurses);
    }

    public Person findOldest(){
        if (count == 0) {
            return null;
        }
        Person oldest = people[0];
        for (int i = 1; i < count; i++) {
            if (people[i].getAge() > oldest.getAge()) {
                oldest = people[i];
            }
        }
        return oldest;
    }

}
