package services;

import entities.Appointment;
import entities.Patient;
import entities.Doctor;
import interfaces.Manageable;
import interfaces.Searchable;
import utils.HelperUtils;

public class AppointmentService implements Manageable, Searchable {
    private Appointment[] appointments;
    private int count;

    public AppointmentService() {
        appointments = new Appointment[100];
        count = 0;
    }
/*
public Appointment(String appointmentId, String patientId, String doctorId, String appointmentDate,
                       String appointmentTime, String status, String reason, boolean isFollowUp) {

 */
    public Appointment schedule(String patientId, String doctorId, String appointmentDate){
        String id = HelperUtils.generateId("AP");
        Appointment a = new Appointment(id,patientId,doctorId,appointmentDate,"Unset","Active","unknown",false);
        add(a);
        return a;
    }

    public Appointment schedule(String patientId, String doctorId, String appointmentDate,String appointmentTime){
        Appointment a = schedule(patientId,doctorId,appointmentDate);
        a.setAppointmentTime(appointmentTime);
        return a;
    }

    public Appointment schedule(Patient p , Doctor d,String reason ){
        Appointment a = schedule(p.getId(),d.getId(),"2026-08-20");
        a.addNotes(reason);
        return a;
    }

    @Override
    public void add(Object item) {
        if (item == null || !(item instanceof Appointment)) {
            System.out.println("Invalid: not an appointment.");
            return;
        }
        if (count>=appointments.length){
            System.out.println("List is full");

        }else{
            appointments[count]= (Appointment) item;
            count++;
        }
    }

    @Override
    public boolean removeById(String id) {
        for (int i = 0; i < count; i++) {
            if (appointments[i].getAppointmentId().equalsIgnoreCase(id)) {
                //remove item by shifting
                for (int j = i; j < count - 1; j++) {
                    appointments[j] = appointments[j + 1];
                }
                //delete last value(duplicate) and decrement count
                appointments[count - 1] = null;
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
            result[i] = appointments[i]; //copy each item
        }
        return result; //return copied list
    }

    @Override
    public Object[] search(String keyword) {
        int repeat = 0;
        for (int i = 0; i < count; i++) {
            if (appointments[i].getAppointmentId().equalsIgnoreCase(keyword)) {
                repeat++; //count how many times id got repeated
            }
        }
        Object[] result = new Object[repeat]; //create list to copy items
        int pos = 0; //for position
        for (int i = 0; i < count; i++) {
            if (appointments[i].getAppointmentId().equalsIgnoreCase(keyword)) {
                result[pos++]=appointments[i]; //copy matching item
            }
        }
        return result; //return list
    }

    @Override
    public Object searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (appointments[i].getAppointmentId().equalsIgnoreCase(id)) {
                return appointments[i];
            }
        }
        return null;
    }

    private Appointment getAppointment(int i) {
        return appointments[i];
    }
}
