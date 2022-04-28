/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Apirest.pacienteBL;
import java.util.List;
import java.util.LinkedList;
import java.sql.*;
import Conectar.Conectar;
import com.google.gson.Gson;

/**
 *
 * @author Emiliosk11
 */
public class PacienteDAO implements IPaciente {
    private Connection con = Conectar.getConexion();

    @Override
    public boolean create(Paciente paciente) {
        String sql = "insert into paciente values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, paciente.getRut());
            ps.setString(2, paciente.getNom_pac());
            ps.setString(3, paciente.getFec_nac());
            ps.setInt(4, paciente.getNum_tel());
            ps.setString(5, paciente.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String rut) {
        String sql = "delete from paciente where rut = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(String rut, int num_tel, String email) {
        String sql = "update paciente set num_tel, email where rut = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, num_tel);
            ps.setString(2, email);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e ){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Paciente> findByAll() {
        String sql = "select * from paciente";
        Paciente paciente = null;
        List<Paciente> lista = new LinkedList<Paciente>();
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setRut(rs.getString("rut"));
                paciente.setNom_pac(rs.getString("nom_pac"));
                paciente.setFec_nac(rs.getString("fec_nac"));
                paciente.setNum_tel(rs.getInt("num_tel"));
                paciente.setEmail(rs.getString("email"));
                lista.add(paciente);
            }
            return lista;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Paciente findByRut(String rut) {
        String sql = "select * from paciente where rut = ?";
        ResultSet rs = null;
        Paciente paciente = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rut);
            rs = ps.executeQuery();
            boolean estado = rs.next();
            if (estado == false) {
                return null;
            }
            else {
                paciente = new Paciente();
                paciente.setRut(rs.getString("rut"));
                paciente.setNom_pac(rs.getString("nom_pac"));
                paciente.setFec_nac(rs.getString("fec_nac"));
                paciente.setNum_tel(rs.getInt("num_tel"));
                paciente.setEmail(rs.getString("email"));
                return paciente;
            }
            
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String toJson(Paciente paciente) {
        Gson gson = new Gson();
        return gson.toJson(paciente);
    }

    @Override
    public String toJson(List<Paciente> paciente) {
        Gson gson = new Gson();
        return gson.toJson(paciente);
    }
    
    
}
