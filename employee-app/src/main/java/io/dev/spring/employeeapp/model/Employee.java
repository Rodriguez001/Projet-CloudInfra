package io.dev.spring.employeeapp.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Firstname;
    private String Lastname;
    private String email;
    @Column(name = "date_of_birth")
    private Date dob;
    private String gender;
    private String Education;
    private String company;
    private int experience;
    private int packages;

    public Employee() {
    }
  
    public Employee(long id, String firstname, String lastname, String email, Date dob, String gender, String education,
            String company, int experience, int packages) {
        
        super();
        this.id = id;
        Firstname = firstname;
        Lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        Education = education;
        this.company = company;
        this.experience = experience;
        this.packages = packages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String compagny) {
        this.company = compagny;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }
    
    
}
