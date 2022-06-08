/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joao Governo
 */
import java.util.ArrayList;
public class Pessoa {
    private String nome;
    private String email;
    ArrayList<Tarefa> tarefas;
    ArrayList<Projeto> projetos;
    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.tarefas= new ArrayList<Tarefa>();
        this.projetos = new ArrayList<Projeto>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return nome;
    }
}
