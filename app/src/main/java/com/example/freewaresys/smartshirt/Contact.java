package com.example.freewaresys.smartshirt;

/**
 * Created by Freeware Sys on 4/4/2016.
 */
public class Contact {
    int id;
    String username,password,email,case_patient,doctorname;

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getDoctorname(){
        return this.username;
    }

    public void setDoctorname(String doctorname){
        this.doctorname=doctorname;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getCase_patient(){
        return this.case_patient;
    }

    public void setCase_patient(String case_patient){
        this.case_patient=case_patient;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email=email;
    }
}
