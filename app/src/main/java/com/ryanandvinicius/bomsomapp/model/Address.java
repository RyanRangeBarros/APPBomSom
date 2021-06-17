package com.ryanandvinicius.bomsomapp.model;

public class Address {



    private String foreignId;
    private String street;
    private String district;
    private int number;
    private String complement;

    public Address(String foreignId, String street, String district, int number, String complement) {
        this.foreignId = foreignId;
        this.street = street;
        this.district = district;
        this.number = number;
        this.complement = complement;
    }

    public String getForeignId() {
        return foreignId;
    }

    public void setForeignId(String foreignId) {
        this.foreignId = foreignId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override public boolean equals(Object o){
        if (!(o instanceof Address)){
            return false;
        }

        Address address = (Address)o;
        return this.street.equals(address.street) &&
                this.number == address.number &&
                this.district.equals(address.district);
    }
}
