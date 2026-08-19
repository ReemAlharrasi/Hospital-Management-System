package entities;

public class Nurse extends Person{
    private String departmentId;
    private String shift;

    private String[] assignedPatientIds;
    private Integer patientCount;

    private Integer yearsOfService;


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
    public void setDepartmentId(String departmentId) {this.departmentId = departmentId;}
    public void setShift(String shift) {this.shift = shift;}
    public void setAssignedPatientIds(String[] assignedPatientIds) {this.assignedPatientIds = assignedPatientIds;}
    public void setPatientCount(Integer patientCount) {this.patientCount = patientCount;}
    public void setYearsOfService(Integer yearsOfService) {this.yearsOfService = yearsOfService;}

    //getters
    public String getDepartmentId() {return departmentId;}
    public String getShift() {return shift;}
    public String[] getAssignedPatientIds() {return assignedPatientIds;}
    public Integer getPatientCount() {return patientCount;}
    public Integer getYearsOfService() {return yearsOfService;}

}
