/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemarazonesfinanciera;

import controller.ConexionDB;
import view.FrmLogin;

/**
 *
 * @author Fernando
 */
public class SistemaRazonesFinanciera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Iniciar app
        FrmLogin login = new FrmLogin();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
}
