package entities;

public class Appointment {
    private String appointmentId, patientId, doctorId;
    private String appointmentDate, appointmentTime, status, reason;
    private boolean isFollowUp;


    private static final String[] ALLOWED_STATUS = { "Active", "Completed", "Cancelled" };

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
    public void setAppointmentId(String appointmentId) {
        if (appointmentId != null && !appointmentId.isEmpty()) this.appointmentId = appointmentId;
        else System.out.println("appointment Id can not be empty");
    }
    public void setPatientId(String patientId) {
        if (patientId != null && !patientId.isEmpty()) this.patientId = patientId;
        else System.out.println("patient Id can not be empty");
    }
    public void setDoctorId(String doctorId) {
        if (doctorId != null && !doctorId.isEmpty()) this.doctorId = doctorId;
        else System.out.println("doctor Id can not be empty");
    }
    public void setAppointmentDate(String appointmentDate) {
        if (appointmentDate != null && !appointmentDate.isEmpty()) this.appointmentDate = appointmentDate;
        else System.out.println("appointment Date can not be empty");
    }
    public void setAppointmentTime(String appointmentTime) {
        if (appointmentTime != null && !appointmentTime.isEmpty()) this.appointmentTime = appointmentTime;
        else System.out.println("appointment Time can not be empty");
    }
    public void setStatus(String status) {
        if (status != null && !status.isEmpty()) {
            for (String allowed : ALLOWED_STATUS) {
                if (allowed.equalsIgnoreCase(status.trim())) {
                    this.status = status;
                    return;
                }
            }
            System.out.println("status entered is not allowed");
        } else System.out.println("status  can not be empty");
    }
    public void setReason(String reason) {
        if (reason != null && !reason.isEmpty()) this.reason = reason;
        else System.out.println("reason can not be empty");
    }
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

    public void reschedule(String date, String time){
        setAppointmentTime(time);
        setAppointmentDate(date);
        setStatus("Active");
    }

    public boolean isPast(String date){
        if (date.isEmpty() || getAppointmentDate().isEmpty()) return false;
        return getAppointmentDate().compareTo(date) < 0;
    }

    public void addNotes(String notes){
        if (notes == null || notes.isEmpty()){
            return;
        }
        if (getReason() == null || getReason().isEmpty()){
            setReason(notes);
        } else{
            setReason(getReason()+" | "+ notes);
        }
    }

    public void addNotes(String notes,String author){
        addNotes(notes+"[by "+ author +"]");
    }
}

