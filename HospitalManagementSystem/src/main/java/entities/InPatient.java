package entities;

public class InPatient extends Patient {
    private String admissionDate, roomNumber;
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
        if (admissionDate != null && !admissionDate.isEmpty()) this.admissionDate = admissionDate;
        else System.out.println("admission Date can not be empty");
    }

    public void setRoomNumber(String roomNumber) {
        if (roomNumber != null && !roomNumber.isEmpty()) this.roomNumber = roomNumber;
        else System.out.println("room Number can not be empty");
    }

    public void setDailyCharges(double dailyCharges) {
        if (dailyCharges>=0) this.dailyCharges = dailyCharges;
        else System.out.println("dailyCharges can not be negative");

    }

    public void setDaysAdmitted(Integer daysAdmitted) {
        if (daysAdmitted>=0) this.daysAdmitted = daysAdmitted;
        else System.out.println("days Admitted can not be negative");
    }

    //getters

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("[Patient details]");
    }


}
