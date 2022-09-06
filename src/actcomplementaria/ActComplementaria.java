package actcomplementaria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author garu1
 */
public class ActComplementaria {

    private static Connection prepareDatabase() {
        String jdbcDriver = "com.mysql.cj.jdbc.Driver";
        String serverPath = "jdbc:mysql://localhost:3306/rocgdatabase";
        String username = "root";
        String Password = "";
        Connection conn = null;
        Statement stmt = null;
        /*boolean checkIfDatabaseExists = false;
        String createNewDatabase = "CREATE DATABASE IF NOT EXISTS rocgdatabase";
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users(" +
                "clv_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(255) NOT NULL,"+
                "aPaterno VARCHAR(255) NOT NULL,"+ 
                "aMaterno VARCHAR(255) NOT NULL);";
        
        String createAdminTable = "CREATE TABLE IF NOT EXISTS admin(" +
                "usuario VARCHAR(255) NOT NULL PRIMARY KEY,"+
                "contrasena VARCHAR(255) NOT NULL);";
        */        
        
        //Cargar el contenedor
        try {
            Class.forName(jdbcDriver);
            System.out.println("Jdbc cargado");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Jdbc no cargo");
            System.out.println(ex.getMessage());
        }
        
        //Conectar al servidor
        try {
            conn = DriverManager.getConnection(serverPath, username, Password);
            System.out.println("Conectado al servidor");
        }
        catch (SQLException ex) {
            System.out.println("Fallo para conectarse al servidor");
            System.out.println(ex.getMessage());
        }
        
        //Crear base de datos si no existe
        /*try {
            stmt = conn.createStatement();
            int newDatabaseCreated = stmt.executeUpdate(createNewDatabase);
            if (newDatabaseCreated > 0) {
                System.out.println("Base datos creada");
                checkIfDatabaseExists = true;
            }
            else {
                System.out.println("La base datos ya existe");
                checkIfDatabaseExists = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            conn = DriverManager.getConnection(serverPath + "/rocgdatabase", username, Password);
            stmt = conn.createStatement();
            int newTableCreated = stmt.executeUpdate(createUsersTable);
            if (newTableCreated > 0) {
                System.out.println("Tabla de usuarios creada");
            }
            else {
                System.out.println("La tabla ya existe");
            }
        }
        catch (SQLException ex) {
            System.out.println("Un error");
            ex.printStackTrace();
        }
        
        try {
            int newTableCreated = stmt.executeUpdate(createAdminTable);
            if (newTableCreated > 0) {
                System.out.println(newTableCreated);
                System.out.println("Tabla de admin creada");
            }
            else {
                System.out.println("Admin tabla creada");
            }
        }
        catch (SQLException ex) {
            System.out.println("Un error");
            ex.printStackTrace();
        }
        
        try {
            String adminData = "INSERT INTO IF NOT EXISTS admin (usuario, contrasena) VALUES (?,?)";
            PreparedStatement prepStat = conn.prepareStatement(adminData);
            prepStat.setString(1, "admin");
            prepStat.setString(2, "123");
            int adminInserted = prepStat.executeUpdate();
            if (adminInserted > 0) {
                System.out.println("Admin agregado");
            }
        } catch (SQLException ex) {
            System.out.println("Un error");
            ex.printStackTrace();
        }*/
        return conn;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = prepareDatabase();
        LogIn promtLogin = new LogIn("Iniciar sesión", new int[] {10, 10, 350, 200}, conn);
    } 
}
