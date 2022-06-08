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


public class Bolseiro extends Pessoa {
    private GregorianCalendar data_inicio;
    private GregorianCalendar data_fim;
    private int custo;
    Bolseiro(String nome, String email,GregorianCalendar data_inicio,GregorianCalendar data_fim){
        super(nome,email);
        this.data_inicio= data_inicio;
        this.data_fim = data_fim;
    }

    public GregorianCalendar getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(GregorianCalendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public GregorianCalendar getData_fim() {
        return data_fim;
    }

    public void setData_fim(GregorianCalendar data_fim) {
        this.data_fim = data_fim;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

}