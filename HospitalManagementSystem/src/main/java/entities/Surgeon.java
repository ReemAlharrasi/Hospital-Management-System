package entities;

public class Surgeon extends Doctor{
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
}
