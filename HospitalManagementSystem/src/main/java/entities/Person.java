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
    public void setId(String id) {this.id = id;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setGender(String gender) {this.gender = gender;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setEmail(String email) {this.email = email;}
    public void setAddress(String address) {this.address = address;}
    public void setNationalId(String nationalId) {this.nationalId = nationalId;}
    public void setAge(int age) {
        if (age>=0 && age<=120) this.age = age;
        else System.out.println("Invalid: age out of range.");
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
