package com.gap.atpractice.model;


/**
 * Created by jporras on 6/26/2017.
 */
public class FormDataModel 
{
    private String FirstName;
    private String LastName;
    private String Company;
    private String Country;
    private String State;
    private String StateCode;
    private String Email;
    private String Phone;
    private String ZipCode;
    private String ReferredReseller;
    private String Reseller;
    private Boolean OptIn;
    private String StdCode;
    private String AreaCode;  //check in Registration project

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCompany() {
        return Company;
    }

    public String getCountry() {
        return Country;
    }

    public String getPhone() {
        return Phone;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public String getEmail()
    {
        return  Email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
