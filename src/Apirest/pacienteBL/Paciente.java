/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Apirest.pacienteBL;

/**
 *
 * @author Emiliosk11
 */
public class Paciente {
    String rut;
    String nom_pac;
    String fec_nac;
    int num_tel;
    String email;
    
    
    public Paciente() {
        this.rut = "";
        this.nom_pac = "";
        this.fec_nac = "";
        this.num_tel = 0;
        this.email = "";
    }


    public Paciente(String rut, String nom_pac, String fec_nac, int num_tel, String email) {
        this.rut = rut;
        this.nom_pac = nom_pac;
        this.fec_nac = fec_nac;
        this.num_tel = num_tel;
        this.email = email;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNom_pac() {
        return nom_pac;
    }

    public void setNom_pac(String nom_pac) {
        this.nom_pac = nom_pac;
    }

    public String getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(String fec_nac) {
        this.fec_nac = fec_nac;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

        
    
    
    
    
    
    
    
    
    
    
}
