package entities;

public class InPatient extends Patient {
    private String admissionDate, roomNumber;
    private double dailyCharges;
    private Integer daysAdmitted;


    public InPatient(String id, String firstName, String lastName, String dateOfBirth,
                     String gender, String phoneNumber, String email, String address,
                     String nationalId, int age, boolean activeStatus, String bloodGroup,
                     String emergencyContact, String registrationDate, double outstandingBalance,
                     boolean isInsured) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, nationalId, age, activeStatus, bloodGroup, emergencyContact, registrationDate, outstandingBalance, isInsured);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("[Patient details]");
    }
}
