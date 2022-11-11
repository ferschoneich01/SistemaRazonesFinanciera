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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.accounts;
import model.accountsRFmodel;
import model.accountsTableModel;
import model.accounts_finance_state;
import model.file;
import model.file_detail;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

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
        conn = conectar.getConexion();
    }

    public ArrayList<accounts_finance_state> getAccounts(String financeState) {
        ArrayList<accounts_finance_state> accountList = new ArrayList<accounts_finance_state>();
        try {
            
            sql = "select * from accounts_finance_state where finance_state = '" + financeState + "'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
                accountList.add(new accounts_finance_state(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return accountList;
    }

    public void addAccount(accounts_finance_state ac, String fs) {
        PreparedStatement ps;
        String sql;

        try {
            sql = "insert into accounts_finance_state(name, type, subtype,finance_state) values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, ac.getName());
            ps.setString(2, ac.getType());
            ps.setString(3, ac.getSubType());
            ps.setString(4, fs);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nueva cuenta guardada :)");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    //guardar detalles del archivo generado
    public void saveFileDetails(int file, String empresa, String periodo, String dividendos, String ir) {
        PreparedStatement ps;
        String sql;

        try {
            sql = "insert into file_detail(id_file,empresa,periodo) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, file);
            ps.setString(2, empresa);
            ps.setString(3, periodo);
            ps.setFloat(4, Float.parseFloat(dividendos));
            ps.setInt(5, Integer.parseInt(ir));
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    //obtener detalles del archivo
    public file_detail getFileDetails(int file) {
        file_detail details = new file_detail();
        try {
            
            sql = "select * from file_detail where id_file = " + file ;
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
               details = new file_detail(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4),rs.getFloat(5),rs.getInt(6));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return details;
    }
    
    public void addAccountFN(accounts ac) {
        PreparedStatement ps;
        String sql;

        //int id_account = 0;
        try {
            /*Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from accounts_finance_state where name = '"+accountName+"'");

            //rellenado de objeto
            while (rs.next()) {
                id_account = rs.getInt(1);
            }*/
            sql = "insert into accounts(id_finance_state,id_file,amount) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ac.getId_finance_state());
            ps.setInt(2, ac.getId_file());
            ps.setFloat(3, ac.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }

    public ArrayList<accounts> getAccountsFN(String financeState) {
        ArrayList<accounts> accountList = new ArrayList<accounts>();
        try {
            sql = "select * from accounts a inner join accounts_finance_state fs on a.id_finance_state = fs.id_finance_state  where id_file = " + financeState + "";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
                accountList.add(new accounts(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getFloat(4)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return accountList;
    }

    public ArrayList<accountsTableModel> getAccountsTable(int id_file) {
        ArrayList<accountsTableModel> accountList = new ArrayList<accountsTableModel>();
        try {
            sql = "select fs.name,fs.type,a.amount from accounts a inner join accounts_finance_state fs on a.id_finance_state = fs.id_finance_state  where id_file = " + id_file + "";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
                accountList.add(new accountsTableModel(rs.getString(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return accountList;
    }
    
    public ArrayList<accountsRFmodel> getAccountsRF(int id_file) {
        ArrayList<accountsRFmodel> accountList = new ArrayList<accountsRFmodel>();
        try {
            sql = "select fs.name,fs.type,fs.subtype,a.amount from accounts a inner join accounts_finance_state fs on a.id_finance_state = fs.id_finance_state  where id_file = " + id_file + "";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
                accountList.add(new accountsRFmodel(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return accountList;
    }

    public ArrayList<file> getFiles(int id_user) {
        ArrayList<file> fileList = new ArrayList<file>();
        try {
            sql = "select * from files where id_user = " + id_user + " order by date_file asc";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
                fileList.add(new file(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return fileList;
    }

    public void CreateFile(String name, int id_user, String financeState) {
        PreparedStatement ps;
        String sql;

        try {

            sql = "insert into files(name,id_user,date_file) values(?,?,NOW())";
            ps = conn.prepareStatement(sql);
            ps.setString(1, financeState + name);
            ps.setInt(2, id_user);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public void deleteFile(int fileId) {
         PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM accounts WHERE id_file = ?");
            ps.setInt(1, fileId); 
            ps.executeUpdate();
            
            ps = conn.prepareStatement("DELETE FROM files WHERE id_file = ?;");
            ps.setInt(1, fileId); 
            ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public void deleteAccount(String nameAccount) {
         PreparedStatement ps;
        try {
            ps = conn.prepareStatement("DELETE FROM accounts WHERE name = ?");
            ps.setString(1, nameAccount); 
            ps.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }
    
    public void viewReportBG(int id_user, String file){
        
        try {
            
            JasperReport reporte = null;
            String path = "src\\view\\report\\reportBG.jasper";
            
            Map parametros  = new  HashMap();
            parametros.put("user",id_user);
            parametros.put("file",file);
           
            
            
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
           //JasperPrint jsubrep = JasperFillManager.
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, conn);
           
            JasperViewer view = new JasperViewer(jprint, false);
            
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(AccountsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
}
