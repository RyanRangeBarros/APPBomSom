package com.ryanandvinicius.bomsomapp.model;

import java.util.Date;

public class Employee {

    private String cpf;
    private String name;
    private String email;
    private String number;
    private Date birthDate;
    private Address address;

    public Employee(String cpf, String name, String email, String number, Date birthDate, String street, String district, int addressNumber, String complement) {
        setCpf(cpf);
        setName(name);
        setNumber(number);
        setBirthDate(birthDate);
        setAddress(street,district,addressNumber,complement);
    }



    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    private void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(String street, String district, int number, String complement){

        setAddress(new Address(this.cpf,street,district,number,complement));
    }


    @Override public boolean equals(Object o){
        if (!(o instanceof Employee)){
            return false;
        }

        Employee employee = (Employee) o;
        return this.cpf == employee.cpf;
    }
}
