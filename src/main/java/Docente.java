/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joao Governo
 */
import java.util.GregorianCalendar;
public class Docente extends Pessoa{
    private int NM;
    private String area_de_investigacao;
    Docente(String nome,String email,int NM,String area_de_investigacao){
        super(nome,email);
        this.NM=NM;
        this.area_de_investigacao = area_de_investigacao;
    }
    
    public int getNM() {
        return NM;
    }

    public void setNM(int NM) {
        this.NM = NM;
    }

    public String getArea_de_investigacao() {
        return area_de_investigacao;
    }

    public void setArea_de_investigacao(String area_de_investigacao) {
        this.area_de_investigacao = area_de_investigacao;
    }

}