package services;

import entities.Appointment;
import entities.Patient;
import entities.Doctor;
import utils.HelperUtils;

public class AppointmentService {
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
        if (count>=appointments.length){
            System.out.println("List is full");
        }else{
            appointments[count]=a;
            count++;
        }
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
}
