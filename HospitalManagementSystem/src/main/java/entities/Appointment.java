package entities;

public class Appointment {
    private String appointmentId, patientId, doctorId;
    private String appointmentDate, appointmentTime, status, reason;
    private boolean isFollowUp;

    //constructor
    public Appointment(String appointmentId, String patientId, String doctorId, String appointmentDate,
                       String appointmentTime, String status, String reason, boolean isFollowUp) {
        setAppointmentId(appointmentId);
        setPatientId(patientId);
        setDoctorId(doctorId);
        setAppointmentDate(appointmentDate);
        setAppointmentTime(appointmentTime);
        setStatus(status);
        setReason(reason);
        setFollowUp(isFollowUp);
    }

    //setters
    public void setAppointmentId(String appointmentId) {this.appointmentId = appointmentId;}
    public void setPatientId(String patientId) {this.patientId = patientId;}
    public void setDoctorId(String doctorId) {this.doctorId = doctorId;}
    public void setAppointmentDate(String appointmentDate) {this.appointmentDate = appointmentDate;}
    public void setAppointmentTime(String appointmentTime) {this.appointmentTime = appointmentTime;}
    public void setStatus(String status) {this.status = status;}
    public void setReason(String reason) {this.reason = reason;}
    public void setFollowUp(boolean followUp) {isFollowUp = followUp;}

    //getters
    public String getAppointmentId() {return appointmentId;}
    public String getPatientId() {return patientId;}
    public String getDoctorId() {return doctorId;}
    public String getAppointmentDate() {return appointmentDate;}
    public String getAppointmentTime() {return appointmentTime;}
    public String getStatus() {return status;}
    public String getReason() {return reason;}
    public boolean isFollowUp() {return isFollowUp;}

    //methods
    public void displayInfo(){
        System.out.println("----- Medical Record -----");
        System.out.println("Appointment ID: "+getAppointmentId());
        System.out.println("Patient ID: "+getPatientId());
        System.out.println("Doctor ID: "+getDoctorId());
        System.out.println("Appointment Date: "+getAppointmentDate());
        System.out.println("Appointment time: "+getAppointmentTime());
        System.out.println("Status: "+getStatus());
        System.out.println("Reason: "+getReason());
        System.out.println("Follow up:: "+isFollowUp());
    }

    public void cancel() {
        setStatus("Cancelled");
    }

    public void complete() {
        setStatus("Completed");
    }

}

