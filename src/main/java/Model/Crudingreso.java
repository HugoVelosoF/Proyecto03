/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DAOingreso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */

public class Crudingreso {
    Conexion conexion = new Conexion();
    
    /*
    Funcion que agrega informacion en la tabla TBL_INGRESO
    */
    public String Create(Object obj){
        DAOingreso ingreso = (DAOingreso) obj;
        Connection connection;
        PreparedStatement pst;
        String query = "INSERT INTO TBL_INGRESO VALUES (?)";
        String respuesta;
        
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(),conexion.getUsuario(),conexion.getPassword());
            
            pst = (PreparedStatement) connection.prepareStatement(query);
            pst.setString(1,ingreso.getVCH_INGRESO_NOMBRE());
            respuesta = Integer.toString(pst.executeUpdate());
        }
        catch(ClassNotFoundException | SQLException ex){
            respuesta = ex.getMessage();
        }
        return respuesta;
    }
    
    /*
    Funcion que realiza la busqueda de informacion en la base de datos en el parametro VCH_INGRESO_NOMBRE
    */
    public List<DAOingreso> Read_Search(String parametro){
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_INGRESO WHERE VCH_INGRESO_NOMBRE = '" + parametro + "'";
        ResultSet rs;
        
        List<DAOingreso> ListaNombre = new ArrayList<>();
        try{
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(),conexion.getUsuario(),conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                DAOingreso Nombres = new DAOingreso();
                Nombres.setID_INGRESO(rs.getInt("ID_INGRESO"));
                Nombres.setVCH_INGRESO_NOMBRE(rs.getString("VCH_INGRESO_NOMBRE"));
                ListaNombre.add(Nombres);
            }
            rs.close();
        }
            catch(SQLException | ClassNotFoundException ex){
            ex.getMessage();
        }
        return ListaNombre;
        
    } 
}
