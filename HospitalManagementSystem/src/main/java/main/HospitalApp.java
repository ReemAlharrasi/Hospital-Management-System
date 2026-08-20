package main;

import entities.*;
import utils.HelperUtils;
import utils.InputHandler;

public class HospitalApp {
    private Person[] people = new Person[100];
    private int count;

    private InputHandler in = new InputHandler();

    void main(){
        hospitalSystem();
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

    public void hospitalSystem(){
        boolean running=true;
        while (running) {
            System.out.println();
            System.out.println("======= Hospital System ========");
            System.out.println("1. Patients ");
            System.out.println("2. Doctors ");
            System.out.println("3. Nurses ");
            System.out.println("4. Appointments ");
            System.out.println("5. Medical Records");
            System.out.println("6. Exit");
            int option = in.readInt("Choose: ",1,6);

            switch (option){
                case 1:
                    //patientMenu();
                    break;
                case 2:
                    //doctorMenu();
                    break;
                case 3:
                    //nurseMenu();
                    break;
                case 4:
                    //appointmentMenu();
                    break;
                case 5:
                    //recordMenu();
                    break;
                case 6:
                    System.out.println("GoodBye~");
                    break;
            }
        }
    }
}
