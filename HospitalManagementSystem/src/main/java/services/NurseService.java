package services;

import entities.Nurse;
import interfaces.Manageable;
import interfaces.Searchable;

public class NurseService implements Manageable, Searchable {

    private Nurse[] nurses;
    private int count;

    public NurseService(){
        nurses = new Nurse[100];
        count=0;
    }

    @Override
    public void add(Object item) {
        if (item == null || !(item instanceof Nurse)) {
            System.out.println("Invalid: not a nurse.");
            return;
        }
        if (count >= nurses.length) {
            System.out.println("list is full.");
            return;
        }
        nurses[count] = (Nurse) item;
        count = count + 1;
    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (nurses[i].getId().equalsIgnoreCase(id)) {
                //remove item by shifting
                for (int j = i; j < count - 1; j++) {
                    nurses[j] = nurses[j + 1];
                }
                //delete last value(duplicate) and decrement count
                nurses[count - 1] = null;
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
            result[i] = nurses[i]; //copy each item
        }
        return result; //return copied list
    }

    @Override
    public Object[] search(String keyword) {
        int repeat = 0;
        for (int i = 0; i < count; i++) {
            if (nurses[i].getId().equalsIgnoreCase(keyword)) {
                repeat++; //count how many times id got repeated
            }
        }
        Object[] result = new Object[repeat]; //create list to copy items
        int pos = 0; //for position
        for (int i = 0; i < count; i++) {
            if (nurses[i].getId().equalsIgnoreCase(keyword)) {
                result[pos++]=nurses[i]; //copy matching item
            }
        }
        return result; //return list
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (nurses[i].getId().equalsIgnoreCase(id)) {
                return nurses[i];
            }
        }
        return null;
    }

    public void listByShift(String shift){
        System.out.println("--- Nurses of " + shift + " ---");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (nurses[i].getShift().equalsIgnoreCase(shift)) {
                nurses[i].displaySummary();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("(none)");
        }
    }

    public void reassign(String pastNurseID,String newNurseID, String patientID){
        Nurse oldNurse = (Nurse) searchById(pastNurseID);
        Nurse newNurse = (Nurse) searchById(newNurseID);

        if (oldNurse == null || newNurse == null) {
            System.out.println("Nurse not found.");
            return;
        }
        oldNurse.unassignPatient(patientID);
        newNurse.assignPatient(patientID);
        System.out.println("Patient reassigned successfully.");
    }
}
