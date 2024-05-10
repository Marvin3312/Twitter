/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package redsocial1;

import java.util.Properties;
import com.mysql.cj.Session;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


/**
 *
 * @author saman
 */
public class Usuarios {
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String edad;
    private String sexo;
    private String estadocivil;

    public Usuarios() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }
     public  void registrarUsuario(String nombre, String apellido, String correoElectronico, String contraseña, int edad, String sexo, String estadoCivil) {
        String url = "jdbc:mysql://localhost:3306/prueba";
        String usuarioDB = "root";
        String contraseñaDB = "root";

        try (Connection conn = DriverManager.getConnection(url, usuarioDB, contraseñaDB)) {
            String sql = "INSERT INTO usuarios (Nombre, Apellido, CorreoElectronico, Contraseña, Edad, Sexo, EstadoCivil) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, correoElectronico);
            statement.setString(4, contraseña);
            statement.setInt(5, edad);
            statement.setString(6, sexo);
            statement.setString(7, estadoCivil);

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Usuario registrado exitosamente");
            } else {
                System.out.println("Error al registrar usuario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean inicioDeSesion(String correo, String contraseña) {
        String url = "jdbc:mysql://localhost:3306/prueba";
        String user = "root";
        String password = "root";
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM usuarios WHERE CorreoElectronico = ? AND Contraseña = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, correo);
            statement.setString(2, contraseña);
            ResultSet result = statement.executeQuery();
            return result.next(); // Devuelve true si encuentra una coincidencia
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
     
    
}
