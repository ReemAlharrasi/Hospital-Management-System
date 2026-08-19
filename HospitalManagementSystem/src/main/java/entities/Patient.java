package entities;

public class Patient extends Person{
    private String bloodGroup,emergencyContact,registrationDate;

    private String[] allergies;
    private int allergyCount;

    private String[] recordIds;
    private int recordCount;

    private double outstandingBalance;
    private boolean isInsured;

    //constructor
    public Patient(String id, String firstName, String lastName, String dateOfBirth, String gender,
                   String phoneNumber, String email, String address, String nationalId, int age,
                   boolean activeStatus , String bloodGroup, String emergencyContact,String registrationDate,
                   double outstandingBalance, boolean isInsured) {

        //person part (super class)
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus);

        //patient part (child class)
        this.bloodGroup=bloodGroup;
        this.emergencyContact=emergencyContact;
        this.registrationDate=registrationDate;
        this.allergies= new String[50];
        this.allergyCount=0;
        this.recordIds=new String[50];
        this.recordCount=0;
        this.outstandingBalance=outstandingBalance;
        this.isInsured=isInsured;
    }

    //getters
    public String getBloodGroup() {return bloodGroup;}
    public String getEmergencyContact() {return emergencyContact;}
    public String getRegistrationDate() {return registrationDate;}
    public String[] getAllergies() {return allergies;}
    public int getAllergyCount() {return allergyCount;}
    public String[] getRecordIds() {return recordIds;}
    public int getRecordCount() {return recordCount;}
    public double getOutstandingBalance() {return outstandingBalance;}
    public boolean isInsured() {return isInsured;}

    //setters
    public void setBloodGroup(String bloodGroup) {this.bloodGroup = bloodGroup;}
    public void setEmergencyContact(String emergencyContact) {this.emergencyContact = emergencyContact;}
    public void setRegistrationDate(String registrationDate) {this.registrationDate = registrationDate;}
    public void setAllergies(String[] allergies) {this.allergies = allergies;}
    public void setAllergyCount(int allergyCount) {this.allergyCount = allergyCount;}
    public void setRecordIds(String[] recordIds) {this.recordIds = recordIds;}
    public void setRecordCount(int recordCount) {this.recordCount = recordCount;}
    public void setOutstandingBalance(double outstandingBalance) {this.outstandingBalance = outstandingBalance;}
    public void setInsured(boolean insured) {isInsured = insured;}

    //methods

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("[Patient details]");
        System.out.println("Blood Group: "+getBloodGroup());
        System.out.println("Emergency contact: "+getEmergencyContact());
        System.out.println("Registeration Date: "+getRegistrationDate());
        System.out.println("Outstanding Balance: "+getOutstandingBalance());
        System.out.println("Allergies : "+getAllergyCount()+", Records: "+getRecordCount());
    }
}
