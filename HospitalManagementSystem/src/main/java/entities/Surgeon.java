package entities;

import interfaces.Displayable;

public class Surgeon extends Doctor implements Displayable {
    //attributes
    private Integer surgeriesPerformed;
    private boolean operationTheatreAccess;
    private String[] upcomingSurgeries;
    private int surgeryCount;

    //constructor
    public Surgeon(String id, String firstName, String lastName, String dateOfBirth, String gender, String phoneNumber, String email, String address, String nationalId, int age, boolean activeStatus, String specialization, int experienceYears, double consultationFee, boolean isOnCall, Integer surgeriesPerformed, boolean operationTheatreAccess) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus, specialization, experienceYears, consultationFee, isOnCall);
        setSurgeriesPerformed(surgeriesPerformed);
        setOperationTheatreAccess(operationTheatreAccess);
        this.upcomingSurgeries = new String[50];
        this.surgeryCount = 0;
    }

    //setters
    public void setSurgeriesPerformed(Integer surgeriesPerformed) {
        if (surgeriesPerformed>=0)this.surgeriesPerformed = surgeriesPerformed;
        else System.out.println("Number of surgeriesPerformed cannot be negative");
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }

    //getters
    public Integer getSurgeriesPerformed() {return surgeriesPerformed;}
    public boolean isOperationTheatreAccess() {return operationTheatreAccess;}
    public String[] getUpcomingSurgeries() {return upcomingSurgeries;}
    public int getSurgeryCount(){return surgeryCount;}

    //methods
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("[Surgeon details]");
        System.out.println("Number of surgeriesPerformed: "+getSurgeriesPerformed());
        System.out.println("operation theatre access: "+isOperationTheatreAccess());
        System.out.println("Upcoming surgeries: "+getSurgeryCount());
    }

    public void performSurgery(){
        setSurgeriesPerformed(getSurgeryCount()+1);
    }

    public void scheduleSurgery(String upcoming){
        //ensure input is not empty
        if (upcoming.isEmpty()){
            System.out.println("Invalid: slot can not be empty.");
            return;
        }

        //check if list is full
        if (surgeryCount >= upcomingSurgeries.length) {
            System.out.println("Invalid: slot time list is full.");
            return;
        }
        //add to list
        upcomingSurgeries[surgeryCount] = upcoming;
        surgeryCount++;
    }

    public int getUpcomingCount(){return this.surgeryCount;}

}
