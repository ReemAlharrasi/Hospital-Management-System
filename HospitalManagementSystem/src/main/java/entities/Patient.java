package entities;

import interfaces.Displayable;

public class Patient extends Person implements Displayable {
    private String bloodGroup,emergencyContact,registrationDate;

    private String[] allergies;
    private Integer allergyCount;

    private String[] recordIds;
    private Integer recordCount;

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
        setBloodGroup(bloodGroup);
        setEmergencyContact(emergencyContact);
        setRegistrationDate(registrationDate);
        this.allergies= new String[50];
        this.allergyCount=0;
        this.recordIds=new String[50];
        this.recordCount=0;
        setOutstandingBalance(outstandingBalance);
        setInsured(isInsured);
    }

    //getters
    public String getBloodGroup() {return bloodGroup;}
    public String getEmergencyContact() {return emergencyContact;}
    public String getRegistrationDate() {return registrationDate;}
    public String[] getAllergies() {return allergies;}
    public int getAllergyCount() {return allergyCount;}
    public String[] getRecordIds() {return recordIds;}
    public double getOutstandingBalance() {return outstandingBalance;}
    public boolean isInsured() {return isInsured;}

    //setters
    public void setBloodGroup(String bloodGroup) {
        if (bloodGroup != null && !bloodGroup.isEmpty()) this.bloodGroup = bloodGroup;
        else System.out.println("Blood Group can not be empty");
    }
    public void setEmergencyContact(String emergencyContact) {
        if (emergencyContact != null && !emergencyContact.isEmpty()) this.emergencyContact = emergencyContact;
        else System.out.println("emergency Contact can not be empty");
    }
    public void setRegistrationDate(String registrationDate) {
        if (registrationDate != null && !registrationDate.isEmpty()) this.registrationDate = registrationDate;
        else System.out.println("registration Date can not be empty");
    }
    public void setOutstandingBalance(double outstandingBalance) {
         if (outstandingBalance>=0) this.outstandingBalance = outstandingBalance;
         else System.out.println("Invalid: balance can not be negative.");
    }
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

    public void addAllergy(String allergy){
        //ensure input is not empty
        if (allergy.isEmpty()){
            System.out.println("Invalid: Allergy cannot be empty.");
            return;
        }
        //ensure list is not full
        if (allergyCount>=allergies.length){
            System.out.println("Invalid: Allergy list is full.");
            return;
        }
        //otherwise add allergy in position of allergyCount
        allergies[allergyCount]=allergy;
        allergyCount++;
    }

    public boolean hasAllergy(String allergy){
        for (int i=0;i<allergyCount;i++){
            if(allergy.equalsIgnoreCase(allergies[i])){
                return true;
            }
        }
        return false;
    }

    public void listAllergies(){
        System.out.println("Allergies list of patient ["+getFullName()+"]");
        //if list is empty
        if (allergyCount.equals(0)){
            System.out.println("none");
            return;
        }
        //otherwise print the list
        for (int i=0;i<allergyCount;i++){
            System.out.println((i+1)+" "+ allergies[i]);
        }
    }

    public void addRecordId(String record){
        //ensure input is not empty
        if (record.isEmpty()){
            System.out.println("Invalid: record cannot be empty.");
            return;
        }
        //ensure list is not full
        if (recordCount>=recordIds.length){
            System.out.println("Invalid: record list is full.");
            return;
        }
        //otherwise add record in position of recordCount
        recordIds[recordCount]=record;
        recordCount++;
    }

    public int getRecordCount() {return recordCount;}

    public void addToBalance(double money){
        if (money<0) {
            System.out.println("Invalid: amount to add to balance can not be negative.");
            return;
        }
        setOutstandingBalance(getOutstandingBalance()+money);
    }

    public void clearBalance(){
        setOutstandingBalance(0);
        System.out.println("Outstanding balance is cleared");

    }

    public void updateContact(String phone){
        setPhoneNumber(phone);
    }

    public void updateContact(String phone,String email){
        setPhoneNumber(phone);
        setEmail(email);
    }
}
