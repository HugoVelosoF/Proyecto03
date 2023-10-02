/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author User
 */
public class DAOingreso {
    
    private int _ID_INGRESO;
    private String _VCH_INGRESO_NOMBRE;

    public void setID_INGRESO(int _ID_INGRESO) {
        this._ID_INGRESO = _ID_INGRESO;
    }

    public int getID_INGRESO() {
        return _ID_INGRESO;
    }

    public String getVCH_INGRESO_NOMBRE() {
        return _VCH_INGRESO_NOMBRE;
    }

    public void setVCH_INGRESO_NOMBRE(String _VCH_INGRESO_NOMBRE) {
        this._VCH_INGRESO_NOMBRE = _VCH_INGRESO_NOMBRE;
    }

    public DAOingreso() {
    }
    
    public DAOingreso(int _ID_INGRESO, String _VCH_INGRESO_NOMBRE) {
        this._ID_INGRESO = _ID_INGRESO;
        this._VCH_INGRESO_NOMBRE = _VCH_INGRESO_NOMBRE;
    }
    
    public Boolean ValidaSubida(String nom){
        boolean flag = true;
        if(!nom.isEmpty()){setVCH_INGRESO_NOMBRE(nom);}
        else{return false;}
        return flag;
    }
    
}
