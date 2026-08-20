package services;

import entities.Doctor;
import entities.Surgeon;
import interfaces.Manageable;
import interfaces.Searchable;

public class DoctorService implements Manageable, Searchable {
    private Doctor[] doctors;
    private int count;

    public DoctorService(){
        doctors = new Doctor[100];
        count=0;
    }

    @Override
    public void add(Object item) {
        if (item == null || !(item instanceof Doctor)) {
            System.out.println("Invalid: not a doctor.");
            return;
        }
        if (count >= doctors.length) {
            System.out.println("list is full.");
            return;
        }
        doctors[count] = (Doctor) item;
        count = count + 1;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    @Override
    public Object[] getAll() {
        Object[] result = new Object[count]; //create list with actual size
        for (int i = 0; i < count; i++) {
            result[i] = doctors[i]; //copy each item
        }
        return result; //return copied list
    }

    @Override
    public Object[] search(String keyword) {
        int repeat = 0;
        for (int i = 0; i < count; i++) {
            if (doctors[i].getId().equalsIgnoreCase(keyword)) {
                repeat++; //count how many times id got repeated
            }
        }
        Object[] result = new Object[repeat]; //create list to copy items
        int pos = 0; //for position
        for (int i = 0; i < count; i++) {
            if (doctors[i].getId().equalsIgnoreCase(keyword)) {
                result[pos++]=doctors[i]; //copy matching item
            }
        }
        return result; //return list
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (doctors[i].getId().equalsIgnoreCase(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void addSurgeon(Surgeon s){add(s);}

    public void assignPatient(String doctorID, String patientID){
        Object found = searchById(doctorID);
        if (found == null) {
            System.out.println("No Doctor with id " + doctorID);
            return;
        }
        Doctor t = (Doctor) found;
        t.assignPatient(patientID);
    }

    public void listBySpecialization(String specialization){
        System.out.println("--- Doctors of " + specialization + " ---");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (doctors[i].getSpecialization().equalsIgnoreCase(specialization)) {
                doctors[i].displaySummary();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("(none)");
        }

    }

    public void availableDoctors(){
        System.out.println("--- Available doctors (doctor load < 7) ---");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (doctors[i].getPatientLoad() < 7) {
                doctors[i].displaySummary();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("(none)");
        }
    }
}
