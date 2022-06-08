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


public class Tarefa {
    private String tipo;
    private GregorianCalendar data_inicio;
    private GregorianCalendar data_fim;
    private int duracao_estimada;
    private float taxa_de_execucao;
    private Pessoa pessoa_responsavel;
    private double taxa_de_esforco;
    Tarefa(String tipo,GregorianCalendar data_inicio,int duracao_estimada,Pessoa pessoa_responsavel){
        this.tipo = tipo;
        this.data_inicio=data_inicio;
        this.data_fim = null;
        this.duracao_estimada = duracao_estimada;
        this.taxa_de_execucao = 0;
        this.pessoa_responsavel= pessoa_responsavel;
        if(tipo.equals("Design")){
            this.taxa_de_esforco = 0.5;
        }
        else if(tipo.equals("Desenvolvimento")){
            this.taxa_de_esforco = 1;
        }
        else if(tipo.equals("Documentacao")){
            this.taxa_de_esforco = 0.25;
        }
    }
    public GregorianCalendar getData_inicio() {
        return data_inicio;
    }

    public String get_tipo(){
        return tipo;
    }
    
    public void setData_inicio(GregorianCalendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getDuracao_estimada() {
        return duracao_estimada;
    }
    
    public float getTaxa_execucao(){
        return taxa_de_execucao;
    }

    public void setTaxa_execucao(float n){
        this.taxa_de_execucao = n;
    }
    
    public void setDuracao_estimada(int duracao_estimada) {
        this.duracao_estimada = duracao_estimada;
    }

    public Pessoa getPessoa_responsavel() {
        return pessoa_responsavel;
    }
    
    public String getNome_pessoa(){
        return pessoa_responsavel.getNome();
    }

    public void setPessoa_responsavel(Pessoa pessoa_responsavel) {
        this.pessoa_responsavel = pessoa_responsavel;
    }

    public double getTaxa_de_esforco() {
        return taxa_de_esforco;
    }

    public void setTaxa_de_esforco(double taxa_de_esforco) {
        this.taxa_de_esforco = taxa_de_esforco;
    }
}