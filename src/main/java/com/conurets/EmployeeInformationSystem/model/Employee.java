package com.conurets.EmployeeInformationSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Employee_tl")
public class Employee extends BaseModel {

    @Column(name="name", columnDefinition = "VARCHAR", length = 100)
    private String name;

    @Column(name="cnic", columnDefinition = "VARCHAR", length = 15)
    private String cnic;

    @Column(name="age", columnDefinition = "INTEGER")
    private Integer age;

    //    @NotBlank
    //    @Temporal(TemporalType.DATE)
    //    @JsonFormat(pattern="yyyy-MM-dd")

    @Column(name="dob", columnDefinition = "DATE")
    private Date dob;

    @Column(name="role", columnDefinition = "VARCHAR")
    private String role;

    public Employee(String name, String cnic, Integer age, Date dob, String role) {
        super();
        this.name = name;
        this.cnic = cnic;
        this.age = age;
        this.dob = dob;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
