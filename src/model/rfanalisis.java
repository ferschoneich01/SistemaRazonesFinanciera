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
public class rfanalisis {
    public int id_rf;
    public int id_file;
    public String AL;
    public String AR;
    public String AE;
    public float II;
    public int VC;
    public float CxCI;
    public int CC;
    public float CPI;
    public String BG;
    public String ER;
    public String Empresa;
    

    public rfanalisis() {
    }

    public rfanalisis(int id_rf, int id_file, String AL, String AR, String AE, float II, int VC, float CxCI, int CC, float CPI, String BG, String ER, String Empresa) {
        this.id_rf = id_rf;
        this.id_file = id_file;
        this.AL = AL;
        this.AR = AR;
        this.AE = AE;
        this.II = II;
        this.VC = VC;
        this.CxCI = CxCI;
        this.CC = CC;
        this.CPI = CPI;
        this.BG = BG;
        this.ER = ER;
        this.Empresa = Empresa;
    }

    public int getId_rf() {
        return id_rf;
    }

    public void setId_rf(int id_rf) {
        this.id_rf = id_rf;
    }

    public int getId_file() {
        return id_file;
    }

    public void setId_file(int id_file) {
        this.id_file = id_file;
    }

    public String getAL() {
        return AL;
    }

    public void setAL(String AL) {
        this.AL = AL;
    }

    public String getAR() {
        return AR;
    }

    public void setAR(String AR) {
        this.AR = AR;
    }

    public String getAE() {
        return AE;
    }

    public void setAE(String AE) {
        this.AE = AE;
    }

    public float getII() {
        return II;
    }

    public void setII(float II) {
        this.II = II;
    }

    public int getVC() {
        return VC;
    }

    public void setVC(int VC) {
        this.VC = VC;
    }

    public float getCxCI() {
        return CxCI;
    }

    public void setCxCI(float CxCI) {
        this.CxCI = CxCI;
    }

    public int getCC() {
        return CC;
    }

    public void setCC(int CC) {
        this.CC = CC;
    }

    public float getCPI() {
        return CPI;
    }

    public void setCPI(float CPI) {
        this.CPI = CPI;
    }

    public String getBG() {
        return BG;
    }

    public void setBG(String BG) {
        this.BG = BG;
    }

    public String getER() {
        return ER;
    }

    public void setER(String ER) {
        this.ER = ER;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    

    
    
    
}
