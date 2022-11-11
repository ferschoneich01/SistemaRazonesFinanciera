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
public class accountsRFmodel {
    public String Cuenta;
    public String Tipo;
    public String SubTipo;
    public String Monto;

    public accountsRFmodel() {
    }

    public accountsRFmodel(String Cuenta, String Tipo, String SubTipo, String Monto) {
        this.Cuenta = Cuenta;
        this.Tipo = Tipo;
        this.SubTipo = SubTipo;
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

    public String getSubTipo() {
        return SubTipo;
    }

    public void setSubTipo(String SubTipo) {
        this.SubTipo = SubTipo;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

   
    
    
}
