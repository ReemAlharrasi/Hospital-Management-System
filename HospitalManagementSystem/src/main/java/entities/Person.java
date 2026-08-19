package entities;

import java.util.Objects;

public class Person {
    //attributes
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String nationalId;
    private int age;
    private boolean activeStatus;

    //constructors
    public Person(String id, String firstName, String lastName, String dateOfBirth, String gender,
              String phoneNumber, String email, String address, String nationalId, int age, boolean activeStatus) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setAddress(address);
        setNationalId(nationalId);
        setAge(age);
        setActiveStatus(activeStatus);
    }

    public Person(String id, String firstName, String lastName) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
    }

    //getters
    public String getId() {return id;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getDateOfBirth() {return dateOfBirth;}
    public String getGender() {return gender;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getEmail() {return email;}
    public String getAddress() {return address;}
    public String getNationalId() {return nationalId;}
    public int getAge() {return age;}
    public boolean isActiveStatus() {return activeStatus;}

    //setters
    public void setId(String id) {
        if(id != null && !id.isEmpty()) this.id = id;
        else System.out.println("Id can not be empty");
    }
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty()) this.firstName = firstName;
        else System.out.println("First name can not be empty");
    }
    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty()) this.lastName = lastName;
        else System.out.println("Last name can not be empty");
    }
    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth != null && !dateOfBirth.isEmpty()) this.dateOfBirth = dateOfBirth;
        else System.out.println("Date of birth can not be empty");
    }
    public void setGender(String gender) {
        if (gender != null && !gender.isEmpty()) this.gender = gender;
        else System.out.println("Gender can not be empty");
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) this.phoneNumber = phoneNumber;
        else System.out.println("Phone Number can not be empty");
    }
    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) this.email = email;
        else System.out.println("Phone Number can not be empty");
    }
    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) this.address = address;
        else System.out.println("Address can not be empty");
    }
    public void setNationalId(String nationalId) {
        if (nationalId != null && !nationalId.isEmpty()) this.nationalId = nationalId;
        else System.out.println("National ID can not be empty");
    }
    public void setAge(int age) {
        if (age>=0 && age<=120) this.age = age;
        else System.out.println("Invalid: age out of          b n" +
                "3range.");
    }
    public void setActiveStatus(boolean activeStatus) {this.activeStatus = activeStatus;}

    //methods
    public void displayInfo() {
        System.out.println("----- Person -----");
        System.out.println("Id: " + id);
        System.out.println("Name: " + getFullName());
        System.out.println("Date of birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("National id: " + nationalId);
        System.out.println("Age: " + age);
        System.out.println("Active: " + activeStatus);
    }

    // print only id + full name
    public void displaySummary() {
        System.out.println("[Person] id: " +getId()+ " - Full name:" + getFullName());
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", age=" + age +
                ", activeStatus=" + activeStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getId(), person.getId());
    }

    public boolean isAdult(){
        return getAge()>=18;
    }
}
