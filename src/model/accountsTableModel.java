/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Clase modelo para tabla de inserción temporal de cuentas que van en los estados financieros
 * @author Scarleth
 *
 */
public class accountsTableModel {
    public String Cuenta;
    public String Tipo;
    public String Monto;

    public accountsTableModel() {
    }

    public accountsTableModel(String Cuenta, String Tipo, String Monto) {
        this.Cuenta = Cuenta;
        this.Tipo = Tipo;
        this.Monto = Monto;
    }

    

    public String getCuenta() {
        return Cuenta;
    }

    public void setCuenta(String Cuenta) {
        this.Cuenta = Cuenta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }
    
    
}
