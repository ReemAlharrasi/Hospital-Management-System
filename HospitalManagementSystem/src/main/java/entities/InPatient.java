package entities;

import interfaces.Displayable;
import utils.HelperUtils;

public class InPatient extends Patient implements Displayable { //Person → Patient → InPatient
    private String admissionDate, roomNumber,admissionState;
    private double dailyCharges;
    private Integer daysAdmitted;


    public InPatient(String id, String firstName, String lastName, String dateOfBirth,
                     String gender, String phoneNumber, String email, String address,
                     String nationalId, int age, boolean activeStatus, String bloodGroup,
                     String emergencyContact, String registrationDate, double outstandingBalance,
                     boolean isInsured, String admissionDate , String roomNumber,double dailyCharges,
                     int daysAdmitted) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus, bloodGroup, emergencyContact, registrationDate, outstandingBalance, isInsured);
        setAdmissionDate(admissionDate);
        setRoomNumber(roomNumber);
        setDailyCharges(dailyCharges);
        setDaysAdmitted(daysAdmitted);
    }

    //setters
    public void setAdmissionDate(String admissionDate) {
        if (HelperUtils.isEmpty(admissionDate)) this.admissionDate = admissionDate;
        else System.out.println("admission Date can not be empty");
    }

    public void setRoomNumber(String roomNumber) {
        if (HelperUtils.isEmpty(roomNumber)) this.roomNumber = roomNumber;
        else System.out.println("room Number can not be empty");
    }

    public void setDailyCharges(double dailyCharges) {
        if (HelperUtils.isPositive(dailyCharges)) this.dailyCharges = dailyCharges;
        else {
            this.dailyCharges =0;
            System.out.println("dailyCharges can not be negative");
        }

    }

    public void setDaysAdmitted(Integer daysAdmitted) {
        if (HelperUtils.isPositive(daysAdmitted)) this.daysAdmitted = daysAdmitted;
        else {
            this.daysAdmitted =0;
            System.out.println("days Admitted can not be negative");
        }
    }

    public void setAdmissionState(String admissionState) {
        if (HelperUtils.isEmpty(admissionState)) this.admissionState = admissionState;
        else System.out.println("admission State can not be empty");
    }

    //getters
    public String getAdmissionDate() {return admissionDate;}
    public String getRoomNumber() {return roomNumber;}
    public double getDailyCharges() {return dailyCharges;}
    public Integer getDaysAdmitted() {return daysAdmitted;}

    @Override
    public void displayInfo() {
        super.displayInfo(); //Person → Patient → InPatient
        System.out.println("[InPatient details]");
        System.out.println("Admission date: "+getAdmissionDate());
        System.out.println("room Number: "+getRoomNumber());
        System.out.println("daily Charges: "+getDailyCharges());
        System.out.println("daysA dmitted: "+getDaysAdmitted());
    }

    public void admit(){
        setAdmissionState("Admitted");
        setActiveStatus(true);
    }

    public void discharge(){
        setAdmissionState("Discharged");
        setActiveStatus(false);
    }

    public double totalRoomCost(){
        if (getDaysAdmitted() == null) {
            System.out.println("incomplete data. cost can not be calculated yet.\nset days admitted and daily cost.");
            return 0;
        } else return (double) getDaysAdmitted()*getDailyCharges();
    }
}
