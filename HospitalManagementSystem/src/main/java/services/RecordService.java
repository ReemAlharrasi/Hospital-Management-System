package services;

import entities.MedicalRecord;
import interfaces.Manageable;
import interfaces.Searchable;

public class RecordService implements Manageable, Searchable {
    private MedicalRecord[] records;
    private int count;

    public RecordService(){
        records= new MedicalRecord[100];
        count=0;
    }

    @Override
    public void add(Object item) {
        if (item == null || !(item instanceof MedicalRecord)) {
            System.out.println("Invalid: not an medical record.");
            return;
        }
        if (count>=records.length){
            System.out.println("List is full");

        }else{
            records[count]= (MedicalRecord) item;
            count++;
        }
    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (records[i].getRecordId().equalsIgnoreCase(id)) {
                //remove item by shifting
                for (int j = i; j < count - 1; j++) {
                    records[j] = records[j + 1];
                }
                //delete last value(duplicate) and decrement count
                records[count - 1] = null;
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
            result[i] = records[i]; //copy each item
        }
        return result; //return copied list
    }

    @Override
    public Object[] search(String keyword) {
        int repeat = 0;
        for (int i = 0; i < count; i++) {
            if (records[i].getRecordId().equalsIgnoreCase(keyword)) {
                repeat++; //count how many times id got repeated
            }
        }
        Object[] result = new Object[repeat]; //create list to copy items
        int pos = 0; //for position
        for (int i = 0; i < count; i++) {
            if (records[i].getRecordId().equalsIgnoreCase(keyword)) {
                result[pos++]=records[i]; //copy matching item
            }
        }
        return result; //return list
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (records[i].getRecordId().equalsIgnoreCase(id)) {
                return records[i];
            }
        }
        return null;
    }

    public void listByPatient(String patientId){
        System.out.println("--- Medical records of " + patientId + " ---");
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (records[i].getPatientId().equalsIgnoreCase(patientId)) {
                records[i].displaySummary();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("(none)");
        }
    }

    public int countConfidential(){
        int countConfidential = 0;

        for (int i = 0; i < count; i++) {
            if (records[i].isConfidential()) {
                countConfidential++;
            }
        }

        return countConfidential;
    }
}
