package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scarleth
 */
public class accounts {
    private int id_account;
    private int id_finance_state;
    private int id_file;
    private float amount;

    public accounts() {
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public int getId_finance_state() {
        return id_finance_state;
    }

    public void setId_finance_state(int id_finance_state) {
        this.id_finance_state = id_finance_state;
    }

    public int getId_file() {
        return id_file;
    }

    public void setId_file(int id_file) {
        this.id_file = id_file;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
    
    
    
}
