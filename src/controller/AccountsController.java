/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.accounts_finance_state;

/**
 *
 * @author Scarleth
 */
public class AccountsController {

    private ConexionDB conectar;
    private Connection conn;
    private accounts_finance_state account;
    private String sql;
    
    public AccountsController() {
        account = new accounts_finance_state();
        conectar = new ConexionDB();
    }
    
    public ArrayList<accounts_finance_state> getAccounts(String financeState){
        ArrayList<accounts_finance_state> accountList = new ArrayList<accounts_finance_state>();
        try {
            conn = conectar.getConexion();
            sql = "select * from accounts_finance_state where finance_state = '"+financeState+"'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
                accountList.add(new accounts_finance_state(rs.getInt(1),rs.getString(2),rs.getString(3)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
        
        return accountList;
    }
    
    public void addAccount(accounts_finance_state ac, String fs){
        PreparedStatement ps;
        String sql;

        try {
            conn = conectar.getConexion();
            
            sql = "insert into accounts_finance_state(name, type, subtype,finance_state) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ac.getName());
            ps.setString(2, ac.getType());
            ps.setString(3, "");
            ps.setString(4, fs);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nueva cuenta guardada :)");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public void addAccountFN(String accountName, int id_file, float amount){
        PreparedStatement ps;
        String sql;
        
        int id_account = 0;
        try {
            conn = conectar.getConexion();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from accounts_finance_state where name = '"+accountName+"'");

            //rellenado de objeto
            while (rs.next()) {
                id_account = rs.getInt(1);
            }
            sql = "insert into accounts(id_finance_state,id_file,amount) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_account);
            ps.setInt(2, id_file);
            ps.setFloat(3, amount);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
}
