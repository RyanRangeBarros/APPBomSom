package com.ryanandvinicius.bomsomapp.model;

import java.util.Date;

public class Client {

    private String cpf;
    private String name;
    private String email;
    private String number;
    private Address address;
    private MusicStyle style;

    public Client(String cpf, String name, String email, String number, MusicStyle style,
                  String street, String district, int addressNumber, String complement) {
        setCpf(cpf);
        setName(name);
        setNumber(number);
        setAddress(street,district,addressNumber,complement);
        setStyle(style);
    }

    public MusicStyle getStyle() {
        return style;
    }

    public void setStyle(MusicStyle style) {
        this.style = style;
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

    public Address getAddress() {
        return address;
    }

    private void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(String street, String district, int number, String complement){

        setAddress(new Address(this.cpf,street,district,number,complement));
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Client)){
            return false;
        }

        Client client = (Client)o;

        return this.cpf == client.cpf;
    }
}
