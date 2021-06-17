package com.ryanandvinicius.bomsomapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

    private String id;
    private String name;
    private String description;
    private List<Employee> listEmployee;
    private Client client;
    private Date projectDate;
    private Address place;



    public Project(String id,String name, String description, List<Employee> listEmployee, Client client, Date projectDate, String street, String district, int addressNumber, String complement) {
        this.listEmployee = listEmployee;
        setId(id);
        setName(name);
        setDescription(description);
        setListEmployee(listEmployee);
        setClient(client);
        setProjectDate(projectDate);
        setPlace(street,district,addressNumber,complement);
    }


    public Project(String id,String name, String description, Employee employee, Client client, Date projectDate, String street, String district, int addressNumber, String complement) {
        this.listEmployee = new ArrayList<>();
        setId(id);
        setName(name);
        setDescription(description);
        listEmployee.add(employee);
        setClient(client);
        setProjectDate(projectDate);
        setPlace(street,district,addressNumber,complement);
    }

    public Project(String id, String name, String description, Client client, Date projectDate, Address place) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.client = client;
        this.projectDate = projectDate;
        this.place = place;
    }

    public void addEmployee(Employee employee){
        listEmployee.add(employee);
    }

    public void removeEmployee(Employee employee){
        listEmployee.remove(employee);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(Date projectDate) {
        this.projectDate = projectDate;
    }

    public Address getPlace() {
        return place;
    }

    private void setPlace(Address place) {
        this.place = place;
    }

    public void setPlace(String street, String district, int number, String complement){

        setPlace(new Address(id,street,district,number,complement));
    }



    @Override
    public boolean equals(Object o){
        if (!(o instanceof Project)){
            return false;
        }

        Project project = (Project)o;

        return this.id == project.id;
    }
}
