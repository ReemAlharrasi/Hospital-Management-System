package entities;

public class Doctor extends Person{
    private String specialization;
    private Integer experienceYears;
    private Double consultationFee;

    private String[] timeSlots;
    private int slotCount;

    private String[] assignedPatientIds;
    private int patientCount;

    private boolean isOnCall;


    public Doctor(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email,
                  String address, String nationalId, int age, boolean activeStatus, String specialization, int experienceYears,
                  double consultationFee,boolean isOnCall) {
        //parent part
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);

        //child part
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        setConsultationFee(consultationFee);
        this.timeSlots = new String[50];
        this.slotCount = 0;
        this.assignedPatientIds = new String[50];
        this.patientCount = 0;
        setOnCall(isOnCall);
    }

    //getters
    public String getSpecialization() {return specialization;}
    public Integer getExperienceYears() {return experienceYears;}
    public Double getConsultationFee() {return consultationFee;}
    public String[] getTimeSlots() {return timeSlots;}
    public int getSlotCount() {return slotCount;}
    public String[] getAssignedPatientIds() {return assignedPatientIds;}
    public int getPatientCount() {return patientCount;}
    public boolean isOnCall() {return isOnCall;}

    //setters
    public void setSpecialization(String specialization) {this.specialization = specialization;}
    public void setExperienceYears(Integer experienceYears) {this.experienceYears = experienceYears;}
    public void setConsultationFee(Double consultationFee) {this.consultationFee = consultationFee;}
    public void setTimeSlots(String[] timeSlots) {this.timeSlots = timeSlots;}
    public void setSlotCount(int slotCount) {this.slotCount = slotCount;}
    public void setAssignedPatientIds(String[] assignedPatientIds) {this.assignedPatientIds = assignedPatientIds;}
    public void setPatientCount(int patientCount) {this.patientCount = patientCount;}
    public void setOnCall(boolean onCall) {isOnCall = onCall;}


}
