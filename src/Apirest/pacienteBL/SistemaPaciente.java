/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Apirest.pacienteBL;
import Apirest.pacienteBL.Paciente;
import Apirest.pacienteBL.PacienteDAO;

/**
 *
 * @author Emiliosk11
 */
public class SistemaPaciente {
    
    
    
    public static void main(String[] args) {
        Paciente paciente = new Paciente("20.965.896-8", "Juan Pérez", "20-10-1990", 968547896, "juan@gmail.com");
        PacienteDAO pac_dao = new PacienteDAO();
        pac_dao.create(paciente);
        System.out.println(pac_dao.toJson(pac_dao.findByAll()));
        
    }
    
}
