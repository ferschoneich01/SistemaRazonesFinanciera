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
public class file_detail {
     public int id_file_detail;
     public int id_file;
     public String empresa;
     public String periodo;

    public file_detail(int id_file_detail, int id_file, String empresa, String periodo) {
        this.id_file_detail = id_file_detail;
        this.id_file = id_file;
        this.empresa = empresa;
        this.periodo = periodo;
    }

    public file_detail() {
    }

     

    public int getId_file_detail() {
        return id_file_detail;
    }

    public void setId_file_detail(int id_file_detail) {
        this.id_file_detail = id_file_detail;
    }

    public int getId_file() {
        return id_file;
    }

    public void setId_file(int id_file) {
        this.id_file = id_file;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
     
     
}
