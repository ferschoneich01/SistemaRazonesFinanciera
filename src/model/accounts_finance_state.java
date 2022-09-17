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
public class accounts_finance_state {
    public int id_finance_state;
    public String name;
    public String type;
    
    public accounts_finance_state(){
        
    }

    public accounts_finance_state(int id_finance_state, String name, String type) {
        this.id_finance_state = id_finance_state;
        this.name = name;
        this.type = type;
    }
    
    

    public int getId_finance_state() {
        return id_finance_state;
    }

    public void setId_finance_state(int id_finance_state) {
        this.id_finance_state = id_finance_state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    
    
}
