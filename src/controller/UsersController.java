/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.users;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Fernando
 */
public class UsersController {

    //Conectar a la base de datos
    private ConexionDB conectar;
    private Connection conn;
    private users u;

    public UsersController() {
        conectar = new ConexionDB();
        u = new users();
    }

    public users getUser(String username) {

        String sql;
        try {
            conn = conectar.getConexion();
            sql = "select * from users where username = '"+username+"'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);

            //rellenado de objeto
            while (rs.next()) {
                u.setId_user(rs.getInt(1));
                u.setFullname(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }

        return u;
    }

    public void AgregarUsuarios(users user) {
        PreparedStatement ps;
        String sql;

        try {
            conn = conectar.getConexion();
            sql = "insert into users(fullname, username, pass) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado correctamente :)");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión:" + e.getMessage());
        }
    }

}
