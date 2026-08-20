package entities;

import interfaces.Displayable;

public class Doctor extends Person  implements Displayable {
    private String specialization;
    private Integer experienceYears;
    private Double consultationFee;

    private String[] timeSlots;
    private Integer slotCount;

    private String[] assignedPatientIds;
    private Integer patientCount;

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
    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.isEmpty()) this.specialization = specialization;
        else System.out.println("specialization can not be empty");
    }
    public void setExperienceYears(Integer experienceYears) {
        if (experienceYears>=0)this.experienceYears = experienceYears;
        else System.out.println("Invalid: experience years can not be negative.");
    }
    public void setConsultationFee(Double consultationFee) {
        if (consultationFee>=0)this.consultationFee = consultationFee;
        else System.out.println("Invalid: Fee can not be negative.");
    }
    public void setOnCall(boolean onCall) {isOnCall = onCall;}

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("[Doctor details]");
        System.out.println("Specialization: "+getSpecialization());
        System.out.println("Experience years: "+getExperienceYears());
        System.out.println("Consultation fee: "+getConsultationFee());
        System.out.println("On Call: "+isOnCall());
        System.out.println("Slots: "+getSlotCount()+" | Patients: "+getPatientCount());
    }

    public void addSlot(String slot){
        //ensure input is not empty
        if (slot.isEmpty()){
            System.out.println("Invalid: slot can not be empty.");
            return;
        }

        //check if list is full
        if (slotCount >= timeSlots.length) {
            System.out.println("Invalid: slot time list is full.");
            return;
        }
        //add to list
        timeSlots[slotCount] = slot;
        slotCount++;
    }

    public void removeSlot(String slot){
        for (int i=0; i<slotCount;i++){
            if (slot.equalsIgnoreCase(timeSlots[i])){
                //found
                for (int j=i;j<slotCount;j++){
                    timeSlots[j]=timeSlots[j+1];//shift everything to the left
                }
                return;
            }
        }
        //not found
        System.out.println(slot+ " Not Found!");
    }

   public boolean hasSlot(String slot){
       for (int i = 0; i < slotCount; i++) {
           if (timeSlots[i].equalsIgnoreCase(slot)) {
               return true;
           }
       }
       return false;
   }

    public void assignPatient(String patient){
        if (patient.isEmpty()){
            System.out.println("Invalid:  patient ID can not be empty.");
            return;
        }
        //check if list is full
        if (patientCount>=assignedPatientIds.length){
            System.out.println("Invalid: list is full.");
            return;
        }
        //add to list
        assignedPatientIds[patientCount]=patient;
        patientCount++;
    }
    public int getPatientLoad(){
        return this.patientCount;
    }

    public void raiseFee(double money){
        if (money<0){
            System.out.println("Invalid:  money can not be negative.");
            return;
        }
        //update fee
        setConsultationFee(getConsultationFee()+money);
    }

    public void updateFee(double fee){
        setConsultationFee(fee);
    }

    public void updateFee(double fee,String reason){
        setConsultationFee(fee);
        System.out.println(getFullName()+"'s Fee updates. reason: "+reason);
    }
}
