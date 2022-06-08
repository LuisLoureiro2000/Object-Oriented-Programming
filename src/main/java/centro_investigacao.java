/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joao Governo
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class centro_investigacao {
    public static ArrayList<Projeto> Projetos = new ArrayList<Projeto>();
    public ArrayList<Pessoa> Pessoas = new ArrayList<Pessoa>();
    ArrayList<Projeto> projetos_conc = new ArrayList<Projeto>();
    ArrayList<Projeto> projetos_nao_conc = new ArrayList<Projeto>();
    public String nomes_pessoas[];
    public String nomes_projetos[];
    
    
    public centro_investigacao() {
        //leitura_file_obj();
    }
    
    
    public void add_Projeto(Projeto e){
        Projetos.add(e);
    }
        public void cria_projeto(String nome,String acronimo, GregorianCalendar data_inicio,int duracao,Docente IP){
        Projeto proj = new Projeto(nome,acronimo,data_inicio,duracao,IP);
        Projetos.add(proj);
    }
        public void regista_pessoas(String nome, String email){
        Pessoa pessoa = new Pessoa(nome,email);
        Pessoas.add(pessoa);
    }
    public void lista_nao_concluidos(Projeto projeto){
        Projeto aux;
        aux = procura_projeto(projeto.getNome(),Projetos);
        //verificar se data_fim < data_inicio + duracao
            Projetos.remove(aux);
            projetos_nao_conc.add(aux);
    }
    
    public void lista_projetos_concluidos(Projeto projeto){
        Projeto aux;
        aux = procura_projeto(projeto.getNome(),Projetos);
        //verificar se data_fim < data_inicio + duracao
             Projetos.remove(aux);
             projetos_conc.add(aux);
    }
    public void read_projetos() throws ParseException {
        String nome, acronimo,email,tipo;
        GregorianCalendar data_inicio = new GregorianCalendar();
        GregorianCalendar data_fim = new GregorianCalendar();
        Docente IP;
        Date date;
        ArrayList<Pessoa> pessoas;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Tarefa> tarefas;
        Tarefa tarefa;
        int duracao;
        Pessoa pessoa_responsavel;
        Projeto auxiliar;
        Pessoa pessoa;
        File f = new File("Projeto.txt");
        if(f.exists() && f.isFile()) {
        try {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        line = br.readLine();
        while(line != null){
            pessoas= new ArrayList<>();
            tarefas = new ArrayList<>();
            nome = line;
            System.out.println(nome);
            line = br.readLine();
            acronimo = line;
            System.out.println(acronimo);
            line = br.readLine();
            date =df.parse(line);
            data_inicio.setTime(date);
            System.out.println(data_inicio);
            line = br.readLine();
            duracao = Integer.parseInt(line);
            line = br.readLine();
            email = line;
            IP =  (Docente) procura(email,Pessoas);
            pessoas.add(IP);
            line = br.readLine();
            auxiliar = new Projeto(nome,acronimo,data_inicio,duracao,IP);
            while(!line.equals("---")){
                pessoa = procura(line,Pessoas);
                pessoas.add(pessoa);
                line = br.readLine();
            }
            while (!line.equals("-----")){
                line = br.readLine();
                tipo = line;
                if(tipo.equals("Desenvolvimento")){
                    line = br.readLine();
                    date =df.parse(line);
                    data_inicio.setTime(date);
                    line = br.readLine();
                    duracao = parseInt(line);
                    line = br.readLine();
                    pessoa_responsavel = procura(line,Pessoas);
                    tarefa=new Tarefa(tipo,data_inicio,duracao,pessoa_responsavel);
                    tarefas.add(tarefa);
                    line = br.readLine();
                }
                else if(tipo.equals("Documentacao")){
                    line = br.readLine();
                    date =df.parse(line);
                    data_inicio.setTime(date);
                    line = br.readLine();
                    duracao = parseInt(line);
                    line = br.readLine();
                    pessoa_responsavel = procura(line,Pessoas);
                    tarefa=new Tarefa(tipo,data_inicio,duracao,pessoa_responsavel);
                    tarefas.add(tarefa);
                    line = br.readLine();
                }
                else if(tipo.equals("Design")){
                    line = br.readLine();
                    date =df.parse(line);
                    data_inicio.setTime(date);
                    line = br.readLine();
                    duracao = parseInt(line);
                    line = br.readLine();
                    pessoa_responsavel = procura(line,Pessoas);
                    tarefa=new Tarefa(tipo,data_inicio,duracao,pessoa_responsavel);
                    tarefas.add(tarefa);
                    line = br.readLine();
                }
            }
            line = br.readLine();
            auxiliar.Tarefas=tarefas;
            auxiliar.Pessoas=pessoas;
            Projetos.add(auxiliar);
        }
        br.close();
        } catch (FileNotFoundException ex) {
        System.out.println("Erro a abrir ficheiro dos projetos.");
        } catch (IOException ex) {
        System.out.println("Erro a ler ficheiro dos projetos.");
        }
        } else {
        System.out.println("Ficheiro dos projetos não existe.");
        }

    }
    public void read_pessoas() throws ParseException{
        Date date;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String nome,email,tipo,area_de_investigacao;
        GregorianCalendar data_inicio_bolsa = new GregorianCalendar();
        GregorianCalendar data_fim_bolsa = new GregorianCalendar();
        int NM;
        Pessoa auxiliar;
        Docente auxiliar2;
        Licensiado auxiliar3;
        Mestre auxiliar4;
        Doutorado auxiliar5;
        File f = new File("Pessoas.txt");
        if(f.exists() && f.isFile()) {
        try {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        line = br.readLine();
        while(line != null){
            nome = line;
            line = br.readLine();
            email = line;
            line = br.readLine();
            tipo = line;
            if(tipo.equals("Docente")){
                line = br.readLine();
                NM = Integer.parseInt(line);
                line = br.readLine();
                area_de_investigacao = line;
                auxiliar2 = new Docente(nome,email,NM,area_de_investigacao);
                Pessoas.add(auxiliar2);
                line = br.readLine();
            }
            else if(tipo.equals("Bolseiro")){
                line = br.readLine();
                if(line.equals("Licensiado")){
                    line = br.readLine();
                    date =df.parse(line);
                    data_inicio_bolsa.setTime(date);
                    line = br.readLine();
                    date =df.parse(line);
                    data_fim_bolsa.setTime(date);
                    auxiliar3 = new Licensiado(nome,email,data_inicio_bolsa,data_fim_bolsa);
                    Pessoas.add(auxiliar3);
                    line = br.readLine();
                }
                else if(line.equals("Mestre")){
                    line = br.readLine();
                    date =df.parse(line);
                    data_inicio_bolsa.setTime(date);
                    line = br.readLine();
                    date =df.parse(line);
                    data_fim_bolsa.setTime(date);
                    auxiliar4 = new Mestre(nome,email,data_inicio_bolsa,data_fim_bolsa);
                    Pessoas.add(auxiliar4);
                    line = br.readLine();
                }
                else if(line.equals("Doutorado")){
                    line = br.readLine();
                    date =df.parse(line);
                    data_inicio_bolsa.setTime(date);
                    line = br.readLine();
                    date =df.parse(line);
                    data_fim_bolsa.setTime(date);
                    auxiliar5 = new Doutorado(nome,email,data_inicio_bolsa,data_fim_bolsa);
                    Pessoas.add(auxiliar5);
                    line = br.readLine();
                }
                else{
                    System.out.println("Erro a ler ficheiro das pessoas.");
                }
            }
            else{
                System.out.println("Erro a ler ficheiro das pessoas.");
            }
        }
        br.close();
        } catch (FileNotFoundException ex) {
        System.out.println("Erro a abrir ficheiro das pessoas.");
        } catch (IOException ex) {
        System.out.println("Erro a ler o ficheiro das pessoas.");
        }
        } else {
        System.out.println("Ficheiro das pessoas não existe.");
        }
    }
    public void leitura_file_obj() throws FileNotFoundException, IOException, ParseException {
        File projeto_bin = new File("projeto_bin.obj");
        File pessoas_bin = new File("pessoas_bin.obj");
        Projeto projeto;
        Pessoa pessoa;
        if(projeto_bin.exists() && !projeto_bin.isDirectory()){
            try {
                FileInputStream fis = new FileInputStream(projeto_bin);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while((projeto = (Projeto)ois.readObject())!=null)
                    Projetos.add(projeto);
                ois.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro.");
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro a converter objeto.");
            }
            try {
                FileInputStream fis = new FileInputStream(pessoas_bin);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while((pessoa = (Pessoa)ois.readObject())!=null)
                    Pessoas.add(pessoa);
                ois.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro.");
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro a converter objeto.");
            }
        }
        else{
            read_pessoas();
            read_projetos();
        }
    }
    public void escrita_file_bin(){
        File projeto_bin = new File("projeto_bin.obj");
        File pessoas_bin = new File("pessoas_bin.obj");
        Projeto projeto;
        Pessoa pessoa;
        if(projeto_bin.exists() && !projeto_bin.isDirectory()){
            try {
                FileOutputStream fos = new FileOutputStream(pessoas_bin);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for(int i=0;i<Pessoas.size();i++){
                    oos.writeObject(Pessoas.get(i));
                }
                oos.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro.");
            }
            try {
                FileOutputStream fos = new FileOutputStream(projeto_bin);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for(int i=0;i<Projetos.size();i++){
                    oos.writeObject(Projetos.get(i));
                }
                oos.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro.");
            }
        }
    }
    public Pessoa procura(String string,ArrayList<Pessoa> pessoas){
        for(int i = 0; i < pessoas.size(); i++) {   
            if (string.equals(pessoas.get(i).getEmail())){
                return pessoas.get(i);
            }
        }
        return null;
    }
   public Projeto procura_projeto(String string,ArrayList<Projeto> projetos){
        for(int i = 0; i < projetos.size(); i++) {   
            if (string.equals(projetos.get(i).getNome())){
                return projetos.get(i);
            }
        }
        return null;
    }
}
