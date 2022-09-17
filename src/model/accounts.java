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
    private float amount;
    private int id_user;
    private int id_finance_state;

    public accounts() {
    }

    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_finance_state() {
        return id_finance_state;
    }

    public void setId_finance_state(int id_finance_state) {
        this.id_finance_state = id_finance_state;
    }
    
    
}
