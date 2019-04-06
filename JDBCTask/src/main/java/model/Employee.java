package model;

public class Employee {
    public int Id, phone;
    public String firstName, middleName, lastName, email;
    public Employee(int Id, int phone, String fistName, String middleName, String lastName, String email){
        this.Id = Id;
        this.phone = phone;
        this.firstName = fistName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
    }
    
}
