/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Scarleth
 */
public class file {
    public int id_file;
    public String name;
    public int id_user;
    public String date_file;

    public file() {
    }

    public file(int id_file, String name, int id_user, String date_file) {
        this.id_file = id_file;
        this.name = name;
        this.id_user = id_user;
        this.date_file = date_file;
    }

    

    public int getId_file() {
        return id_file;
    }

    public void setId_file(int id_file) {
        this.id_file = id_file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDate_file() {
        return date_file;
    }

    public void setDate_file(String date_file) {
        this.date_file = date_file;
    }
    
    
    
    
}
