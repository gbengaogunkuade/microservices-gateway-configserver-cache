package com.ogunkuade.employee.dto;


public class EmployeeRequest {

    private String name;
    private String email;
    private String bloodGroup;

    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, String email, String bloodGroup) {
        this.name = name;
        this.email = email;
        this.bloodGroup = bloodGroup;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "EmployeeRequest{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}

