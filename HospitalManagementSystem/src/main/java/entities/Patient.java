package entities;

public class Patient extends Person{
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
}
