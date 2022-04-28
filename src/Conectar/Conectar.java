/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conectar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Emiliosk11
 */
public class Conectar {
    
    public static final String URL = "jdbc:mysql://localhost:3306/farmacia";
    public static final String USER = "root";
    public static final String CLAVE = "";
    
    private static Connection con = null;
    
    public static Connection getConexion() {
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch(ClassNotFoundException | SQLException e ) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
    
    public int sentenciaSQL (String sentencia) {
        try {
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
            
        }
    }
    
    public ResultSet consultarDatos(String consultar) {
        try {
            PreparedStatement ps = con.prepareStatement(consultar);
            ResultSet respuesta = ps.executeQuery();
            return respuesta;
        } catch (SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
}
