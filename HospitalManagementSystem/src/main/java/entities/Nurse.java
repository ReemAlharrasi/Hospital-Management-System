package entities;

import interfaces.Displayable;

public class Nurse extends Person implements Displayable {
    private String departmentId;
    private String shift;

    private String[] assignedPatientIds;
    private Integer patientCount;

    private Integer yearsOfService;

    private static final String[] ALLOWED_SHIFT = { "morning", "evening", "night" };


    public Nurse(String id, String firstName, String lastName, String dateOfBirth,
                 String gender, String phoneNumber, String email, String address,
                 String nationalId, int age, boolean activeStatus, String departmentId,
                 String shift, int yearsOfService) {
        //parent class
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);

        //child class
        setDepartmentId(departmentId);
        setShift(shift);
        this.assignedPatientIds = new String[100];
        this.patientCount = 0;
        setYearsOfService(yearsOfService);
    }

    //setters
    public void setDepartmentId(String departmentId) {
        if (departmentId != null && !departmentId.isEmpty()) this.departmentId = departmentId;
        else System.out.println("Address can not be empty");
    }
    public void setShift(String shift) {
        if (shift != null && !shift.isEmpty()) {
            for (String allowed : ALLOWED_SHIFT) {
                if (allowed.equalsIgnoreCase(shift.trim())) {
                    this.shift = shift;
                    return;
                }
            }
            System.out.println("shift entered is   m  not allowed");
        } else System.out.println("shift can not be empty");
    }
    public void setYearsOfService(Integer yearsOfService) {
        if (yearsOfService>=0)this.yearsOfService = yearsOfService;
        else System.out.println("Invalid: years of service can not be negative.");
    }

    //getters
    public String getDepartmentId() {return departmentId;}
    public String getShift() {return shift;}
    public String[] getAssignedPatientIds() {return assignedPatientIds;}
    public Integer getPatientCount() {return patientCount;}
    public Integer getYearsOfService() {return yearsOfService;}


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("[Nurse details]");
        System.out.println("Department Id: "+getDepartmentId());
        System.out.println("Shift: "+getShift());
        System.out.println("Years of service: "+getYearsOfService());
        System.out.println("Patients: "+getPatientCount());
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

    public void unassignPatient(String patient){
        for (int i=0; i<patientCount;i++){
            if (patient.equalsIgnoreCase(assignedPatientIds[i])){
                //found
                for (int j=i;j<patientCount;j++){
                    assignedPatientIds[j]=assignedPatientIds[j+1];//shift everything to the left
                }
                return;
            }
        }
        //not found
        System.out.println(patient+ " Not Found!");
    }

    public int getPatientLoad(){
        return this.patientCount;
    }

    public boolean isNightShift(){
        return (getShift().strip().equalsIgnoreCase("night"));
    }
}
