/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Apirest.pacienteBL;
import java.util.List;
import java.util.LinkedList;


/**
 *
 * @author Emiliosk11
 */
public interface IPaciente {
    boolean create(Paciente paciente);
    boolean delete(String rut);
    boolean update(String rut, int num_tel, String email);
    List<Paciente> findByAll();
    Paciente findByRut(String rut);
    String toJson(Paciente paciente);
    String toJson(List<Paciente> paciente);
}
