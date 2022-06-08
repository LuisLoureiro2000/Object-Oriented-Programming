/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joao Governo
 */
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Programa extends JFrame{
    /**
     * @param args the command line arguments
     */   
   
    private ArrayList<Projeto> lista_Projetos;
    public ArrayList<Pessoa> lista_Pessoas;
    public String[] nomes_pessoas = new String[20]; //Mudar para arraylist<String>
    public String[] nomes_docentes = new String[20]; // Pode-se retirar 'new String[5]'
    public String[] nomes_projetos = new String[5]; 
   public String[] tarefa_tipo = {"Desenvolvimente", "Documentacao", "Design"};
    //public String[] nomes_tarefas = new String[20];
   // public DefaultComboBoxModel tarefa_tipo = new DefaultComboBoxModel();
    public DefaultComboBoxModel nomes_tarefas = new DefaultComboBoxModel();
    public DefaultComboBoxModel nomes_pessoas_projeto2 = new DefaultComboBoxModel();
    public DefaultListModel nomes_pessoas_projeto = new DefaultListModel();
    public DefaultListModel nomes_projeto_concluidos = new DefaultListModel();
    public DefaultListModel nomes_projeto_nao_concluidos = new DefaultListModel();
    private String tipo=null;
    private String projeto= null;
    
     private JPanel main_menu;
    private JLabel label_1, label_2, label_3, label_4, label_5, label_6, label_7, label_8, label_9, label_10, label_11; 
    private JTextField text_1, text_2,  text_3,  text_4, text_5, text_6, text_7, text_8, text_9, text_10, text_11;
    // Main Menu Buttons
    private JButton button_criar_projeto, button_abrir_projetos, button_3, button_4, button_registar_pessoas;
    private JButton button_cria_projeto, button_save;
    // Registar Nova Pessoa Buttons
    private JButton button_docente, button_doutorado, button_mestre, button_licensiado, button_cria_pessoa;
    // Abrir Projeto Buttons & ComboBoxs
    private JButton button_abre_projeto, button_criar_tarefa, button_associar_pessoa, button_eliminar_tarefa, button_atualizar_tarefa;
    private JComboBox comboBox_projetos, comboBox_tarefas, comboBox_tipo_tarefas, comboBox_escolher_p, comboBox_lista_tarefas;
    private JButton button_listar_tarefas_conc,button_listar_tarefas_nao_ini;      
    private JComboBox comboBox_pessoas, comboBox_docentes, comboBox_tarefas_conc,comboBox_tarefas_nao_ini;
    private JList show_pessoas; //retirar
    private JList show_proj_conc, show_proj_nao_conc;
    private JScrollPane show_pessoas_scroller,show_proj_conc_scroller, show_proj_nao_conc_scroller;
    
    JButton button_custo = new JButton("Custo");
    
        
    public Programa(){
        super(); 
        // Auxiliares - JLabel
        // Auxiliares - JLabel
        label_1 = new JLabel();
        label_2 = new JLabel();
        label_3 = new JLabel();
        label_4 = new JLabel();
        label_5 = new JLabel();
        label_6 = new JLabel();
        label_7 = new JLabel();
        label_8 = new JLabel();
        label_9 = new JLabel();
        label_10 = new JLabel();
        label_11 = new JLabel();
        // Auxiliares - JTextField
        text_1 = new JTextField(10);
        text_2 = new JTextField(10);
        text_3 = new JTextField(10);
        text_4 = new JTextField(10);
        text_5 = new JTextField(10);
        text_6 = new JTextField(5);
        text_7 = new JTextField(5);
        text_8 = new JTextField(5);
        text_9 = new JTextField(5); 
        text_10 = new JTextField(5);
        text_11 = new JTextField(5);
        // Auxiliares - JButton
            // JButton do Registar Nova Pessoa
        button_docente = new JButton("Criar docente");
        button_doutorado = new JButton("Criar doutorado");
        button_mestre = new JButton("Criar mestre");
        button_licensiado = new JButton("Criar licensiado");
        button_cria_pessoa = new JButton("Criar");     
            // JButton do Abrir Projeto
        button_associar_pessoa = new JButton("Associar pessoa");
        button_criar_tarefa = new JButton("Criar tarefa");
        button_eliminar_tarefa = new JButton("Eliminar ");
         button_abre_projeto = new JButton("Abrir");
         button_atualizar_tarefa = new JButton("Atualizar");
                 button_listar_tarefas_conc = new JButton("concluidas");
        button_listar_tarefas_nao_ini = new JButton("nao iniciadas");
            // JButton do Criar Projeto
        button_cria_projeto = new JButton("Criar");

        //Auxiliares -JComboBox
        comboBox_projetos = new JComboBox();    
        comboBox_pessoas = new JComboBox();
        comboBox_docentes = new JComboBox();
        comboBox_tarefas = new JComboBox();
        comboBox_escolher_p = new JComboBox();
        comboBox_lista_tarefas = new JComboBox();
        comboBox_tipo_tarefas = new JComboBox(tarefa_tipo);  
             comboBox_tarefas_conc = new JComboBox();
        comboBox_tarefas_nao_ini = new JComboBox();
        
        //Auxiliares - JScrollPane
        show_pessoas_scroller = new JScrollPane();
        show_proj_conc_scroller = new JScrollPane();
        show_proj_nao_conc_scroller = new JScrollPane();
        //Auxiliares - JLists
        show_pessoas = new JList();
        show_proj_conc = new JList();
        show_proj_conc = new JList();
        show_proj_nao_conc = new JList();

        //comboBox_pessoas.addActionListener(new read_pessoa());
     
         // Auxiliares - Listenes
            // Listeners do Registar Nova Pessoa
        button_docente.addActionListener(new button_docente_Listener());
        button_doutorado.addActionListener(new button_doutorado_Listener());
        button_mestre.addActionListener(new button_mestre_Listener());
        button_licensiado.addActionListener(new button_licensiado_Listener());
        button_cria_pessoa.addActionListener(new button_cria_pessoa_Listener());
            // Listeners do Abrir Projeto
        button_abre_projeto.addActionListener(new button_abre_projeto_Listener());
        button_associar_pessoa.addActionListener(new button_associar_pessoa_Listener());
        button_eliminar_tarefa.addActionListener(new button_eliminar_tarefa_Listener());
        button_criar_tarefa.addActionListener(new button_criar_tarefa_Listener());
        button_atualizar_tarefa.addActionListener(new button_atualizar_tarefa_Listener());
        //button_listar_tarefas_conc.addActionListener(new button_listar_tarefas_conc_Listener());
        button_listar_tarefas_nao_ini.addActionListener(new button_listar_tarefas_nao_iniciadas_Listener());
        
         //button_associa.addActionListener(new button_associa_Listener());
        //comboBox_projetos.addActionListener(new button_abrir_Listener());
        
        // Main Action Buttons
        button_criar_projeto = new JButton("Criar projeto");
        button_abrir_projetos = new JButton("Abrir projeto");
        button_3 = new JButton("Listar projetos nao conluidos");
        button_4 = new JButton("Listar projetos concluidos");
        button_registar_pessoas = new JButton("Registar nova Pessoa");
        button_save = new JButton("Salvar dados");
        main_menu = new JPanel();
         
        main_menu.setLayout(null);
        button_criar_projeto.setBounds(20, 50, 200, 20);
        button_abrir_projetos.setBounds(20, 100, 200, 20);
        button_3.setBounds(20, 150, 200, 20);
        button_4.setBounds(20, 200, 200, 20);  
        button_registar_pessoas.setBounds(20, 250, 200, 20);
        button_save.setBounds(20,300,200,20);
        //lista_nomes.setBounds(250,50, 125, 100);
        
        // Listeners
        button_criar_projeto.addActionListener(new button_criar_Listener());
        button_abrir_projetos.addActionListener(new button_abrir_projetos_Listener());
        button_cria_projeto.addActionListener(new button_criar_projeto_Listener());
        button_save.addActionListener(new button_save_dados_Listener());
        button_4.addActionListener(new button_listar_conc_Listener());;
        button_3.addActionListener(new button_listar_nao_conc_Listener());
        button_registar_pessoas.addActionListener(new button_registar_pessoas_Listener());
        //button_regista.addActionListener(new button_registar_Listener());
        
        
        
        main_menu.add(button_criar_projeto);
        main_menu.add(button_abrir_projetos);
        main_menu.add(button_3);
        main_menu.add(button_4);
        main_menu.add(button_registar_pessoas);
        this.add(main_menu);
        } 
    
        private class button_criar_Listener implements ActionListener{ 
            //@Override
            public void actionPerformed(ActionEvent e){
                clean();
                atualiza_docentes();
                comboBox_docentes = new JComboBox(nomes_docentes);
                label_1.setText("Nome: ");
                label_2.setText("Acronimo: ");
                label_3.setText("Data inicio: ");
                label_4.setText("Data fim: ");
                label_5.setText("Duracao estimada: ");
                label_6.setText("Pessoa responsavel: ");
                // Bounds
                comboBox_docentes.setBounds(420, 300, 150, 20);
                button_cria_projeto.setBounds(300, 350, 200, 40);
                text_1.setBounds(420, 50, 150, 20);
                text_2.setBounds(420, 100, 150, 20);
                text_3.setBounds(420, 150, 150, 20);
                text_4.setBounds(420, 200, 150, 20);
                text_5.setBounds(420, 250, 150, 20);
                label_1.setBounds(300, 50, 120, 20);
                label_2.setBounds(300, 100, 120, 20);
                label_3.setBounds(300, 150, 120, 20);
                label_4.setBounds(300, 200, 120, 20);
                label_5.setBounds(300, 250, 120, 20);
                label_6.setBounds(300, 300, 120, 20);          
                main_menu.add(button_cria_projeto);
                main_menu.add(label_1);
                main_menu.add(label_2);
                main_menu.add(label_3);
                main_menu.add(label_4);
                main_menu.add(label_5);
                main_menu.add(label_6);
                main_menu.add(text_1);
                main_menu.add(text_2);
                main_menu.add(text_3);
                main_menu.add(text_4);
                main_menu.add(text_5);
                main_menu.add(comboBox_docentes);
                //main_menu.revalidate();
                main_menu.repaint();         
            } 
        }
        
        private class button_criar_projeto_Listener implements ActionListener{
            //@Override
            public void actionPerformed(ActionEvent e){
                Docente responsavel;
                int a=0,duracao;
                String line = text_3.getText();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date;
                GregorianCalendar data_inicio = new GregorianCalendar();
                GregorianCalendar data_fim = new GregorianCalendar();
                try {
                    date = df.parse(line);
                    data_inicio.setTime(date);
                } catch (ParseException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                }
                line = text_5.getText();
                duracao = Integer.parseInt(line);
                line = (String) comboBox_docentes.getSelectedItem();
                responsavel = procura_docente(line,lista_Pessoas);
                line = text_4.getText();
                try {
                    date = df.parse(line);
                    data_fim.setTime(date);
                } catch (ParseException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                }
                Projeto novo_projeto = new Projeto(text_1.getText(),text_2.getText(),data_inicio,duracao,responsavel);
                novo_projeto.setData_fim(data_fim);
                for(int i=0;i<lista_Projetos.size();i++){
                    if(lista_Projetos.get(i).getNome().equals(novo_projeto.getNome())){
                        a++;
                    }
                }
                if(a==0){
                    lista_Projetos.add(novo_projeto);
                }
            }
            
        }
        
        private class button_abrir_projetos_Listener implements ActionListener{ 
            public void actionPerformed(ActionEvent e){
                clean();
                atualiza_projetos();
                comboBox_projetos = new JComboBox(nomes_projetos);
                button_abre_projeto.setBounds(350,150, 175, 20);
                comboBox_projetos.setBounds(300, 50, 300, 50);              
                main_menu.add(comboBox_projetos);
                main_menu.add(button_abre_projeto);
                main_menu.revalidate();
                main_menu.repaint();
            }
        }
        
        // Abre projeto
        private class button_abre_projeto_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String option = comboBox_projetos.getSelectedItem().toString();
                Date date_inicio = new Date();
                for(Projeto i : lista_Projetos){
                    if(  option.equals(i.getNome()) ){
                        String aux;
                        projeto = i.getNome();
                        nomes_pessoas_projeto.removeAllElements();
                        nomes_tarefas.removeAllElements();
                        nomes_pessoas_projeto2.removeAllElements();
                        for(Pessoa j : i.Pessoas){
                             if( j.getNome() != null){
                             nomes_pessoas_projeto.addElement(j.getNome());
                             nomes_pessoas_projeto2.addElement(j.getNome());
                             }
                        }   
                        for(Tarefa l : i.Tarefas){  
                             aux = l.get_tipo() + "  -  " + l.getNome_pessoa()+"  -  "+ l.getData_inicio().getTime()+"  -  "+l.getTaxa_execucao();
                             nomes_tarefas.addElement(aux); 
                             aux=null;
                        }
                        date_inicio=i.getData_inicio().getTime();
                        label_1.setText("Nome: " + i.getNome());
                        label_2.setText("Acronimo: " + i.getAcronimo());
                        label_3.setText("Data de inicio: "+ date_inicio);
                        label_4.setText("Duracao estimada: "+ i.getDuracao()+ " meses");
                        label_5.setText("Data de fim: " + i.getData_fim());
                        label_6.setText("Pessoas: ");
                        label_7.setText("Tarefas: ");
                        
                        label_8.setText("Tipo: ");
                        label_9.setText("Data inicio: ");
                        label_10.setText("Duracao estimada: ");
                        label_11.setText("Pessoa Responsavel: ");
                        
                        show_pessoas = new JList(nomes_pessoas_projeto);
                        show_pessoas_scroller = new JScrollPane(show_pessoas);                      
                        comboBox_tarefas.setModel(nomes_tarefas);
                        comboBox_escolher_p.setModel(nomes_pessoas_projeto2);
                        //
                        comboBox_tarefas.setBounds(270, 200, 400, 30);
                        label_1.setBounds(50, 250, 200, 20);
                        label_2.setBounds(50, 300, 200, 20);
                        label_3.setBounds(50, 350, 200, 20);
                        label_4.setBounds(50, 400, 200, 20);
                        label_5.setBounds(50, 450, 200, 20);
                        label_6.setBounds(50, 500, 200, 20);
                        label_7.setBounds(300, 285, 200, 20);
                        label_8.setBounds(300, 390, 200, 20);
                        label_9.setBounds(300, 430, 120, 20);
                        label_10.setBounds(300, 470, 120, 20);
                        label_11.setBounds(300, 510, 140, 20);
                        // Adicionar text fields
                        text_6.setBounds(300, 450, 30, 20);
                        text_7.setBounds(340, 450, 30, 20);
                        text_8.setBounds(380, 450, 30, 20);
                        text_9.setBounds(300, 490, 100, 20);
                        show_pessoas_scroller.setBounds(50,520, 100, 80);
                        comboBox_tipo_tarefas.setBounds(300, 410, 120, 20);
                        comboBox_escolher_p.setBounds(300, 530, 100, 20);
                        button_associar_pessoa.setBounds(50, 600, 140, 20);
                        button_criar_tarefa.setBounds(300, 560, 110, 20);                   
                        button_eliminar_tarefa.setBounds(270, 250, 90, 20);
                        button_atualizar_tarefa.setBounds(420, 250, 90, 20);
                        
                        button_custo.setBounds(500, 400, 100, 20);
                        main_menu.add(button_custo);
                        
                        main_menu.add(label_1);
                        main_menu.add(label_2);
                        main_menu.add(label_3);
                        main_menu.add(label_4);
                        main_menu.add(label_5);
                        main_menu.add(label_6);
                        main_menu.add(label_8);
                        main_menu.add(label_9);
                        main_menu.add(label_10);
                        main_menu.add(label_11);
                        main_menu.add(text_6);
                        main_menu.add(text_7);
                        main_menu.add(text_8);
                        main_menu.add(text_9);
                        main_menu.add(comboBox_tarefas);
                        main_menu.add(comboBox_tipo_tarefas);
                        main_menu.add(comboBox_escolher_p);
                        main_menu.add(show_pessoas_scroller);
                        main_menu.add(button_associar_pessoa);
                        main_menu.add(button_criar_tarefa);
                        main_menu.add(button_eliminar_tarefa);
                        main_menu.add(button_atualizar_tarefa);
                        main_menu.repaint();
                    }
                }
            }
        }
        
        private class button_custo_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                for(Projeto i :)
            
            
            }
        
        }
        
        private class button_criar_tarefa_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                int inicio_d, inicio_m, inicio_a, num=0; 
                String tipo_tarefa=null;
                inicio_d = Integer.parseInt(text_6.getText());
                inicio_m = Integer.parseInt(text_7.getText());
                inicio_a = Integer.parseInt(text_8.getText());
                if( comboBox_tipo_tarefas.getSelectedIndex() == 0){
                    tipo_tarefa = "Desenvolvimento";
                }else if(comboBox_tipo_tarefas.getSelectedIndex() == 1){
                    tipo_tarefa = "Documentaçao";
                }else if(comboBox_tipo_tarefas.getSelectedIndex() == 2){
                    tipo_tarefa = "Design";
                }
                
                System.out.println(tipo_tarefa);
                try{
                    String duracao = text_9.getText();
                     num = Integer.parseInt(duracao);
                
                }catch(NumberFormatException k){
                        System.out.println("Erro a converter texto em inteiro");                     
                }
                String resp = (String)nomes_pessoas_projeto2.getSelectedItem();
                Tarefa nova_tarefa;
                GregorianCalendar data_inicio;
                for(Projeto i : lista_Projetos){
                    if(i.getNome().equals(projeto)){
                        System.out.println("Encontrou");
                        for(Pessoa j : i.Pessoas){
                            if( j.getNome().equals(resp) ){    
                                data_inicio = new GregorianCalendar(inicio_a, inicio_m, inicio_d);
                                nova_tarefa = new Tarefa(tipo_tarefa, data_inicio, num, j);
                                if(tipo_tarefa != null){
                                i.add_Tarefa(nova_tarefa);
                                }
                                break;
                            }
                        }
                    }
                }
                System.out.println(tipo_tarefa);          
            }
        }
        
        private class button_eliminar_tarefa_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                   String option = comboBox_tarefas.getSelectedItem().toString();
                    String[] parts = option.split("  -  ");
                   for(Projeto i : lista_Projetos){
                        if(projeto.equals(i.getNome())){
                        for(Tarefa j : i.Tarefas){
                              if(j.get_tipo().equals(parts[0]) &&j.getNome_pessoa().equals(parts[1])){
                                   i.remove_Tarefa(j);
                            }
                        }
                    }
                }
             }
        }
        private class button_atualizar_tarefa_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String value = JOptionPane.showInputDialog(null, "Introduza o valor", "Input", JOptionPane.QUESTION_MESSAGE);
                float num=0;
                try{
                    num = Float.parseFloat(value);           
                }catch(NumberFormatException k){
                        System.out.println("Erro a converter texto em inteiro");                     
                    }
                String option = comboBox_tarefas.getSelectedItem().toString();
                String[] parts = option.split("  -  ");

                for(Projeto i : lista_Projetos){
                    if(projeto.equals(i.getNome())){
                        for(Tarefa j : i.Tarefas){                         
                            if(j.get_tipo().equals(parts[0]) &&j.getNome_pessoa().equals(parts[1])){  
                                if(num!=0)j.setTaxa_execucao(num);
                            }
                        }
                    }
                
                }
            }  
        }
        
         private class button_save_dados_Listener implements ActionListener{
            //@Override
            public void actionPerformed(ActionEvent e){
                //centro.escrita_file_bin();
            }
         }
         private class button_registar_pessoas_Listener implements ActionListener{
             public void actionPerformed(ActionEvent e){ 
                 clean();
                 button_docente.setBounds(50, 350, 150, 30);
                 button_doutorado.setBounds(50, 400, 150, 30);
                 button_mestre.setBounds(50, 450, 150, 30);
                 button_licensiado.setBounds(50, 500, 150, 30);     
                 main_menu.add(button_docente);
                 main_menu.add(button_doutorado);
                 main_menu.add(button_mestre);
                 main_menu.add(button_licensiado);             
                 main_menu.repaint();
             }     
         }
         
         private class button_docente_Listener implements ActionListener{
             public void actionPerformed(ActionEvent e){
                        clean_registo();
                        tipo = "docente";
                        label_1.setText("Nome: ");
                        label_2.setText("Email: ");
                        label_3.setText("NM: ");
                        label_4.setText("Area de Investigacao: ");     
                        button_cria_pessoa.setBounds(250, 550, 100, 40);
                        label_1.setBounds(250, 350, 150, 20);
                        label_2.setBounds(250, 400, 150, 20);
                        label_3.setBounds(250, 450, 150, 20);
                        label_4.setBounds(250, 500, 150, 20);
                        text_1.setBounds(250, 375, 150, 20);
                        text_2.setBounds(250, 425, 150, 20);
                        text_3.setBounds(250, 475, 150, 20);
                        text_4.setBounds(250, 525, 150, 20);  
                        main_menu.add(label_1);
                        main_menu.add(label_2);
                        main_menu.add(label_3);
                        main_menu.add(label_4);            
                        main_menu.add(text_1);
                        main_menu.add(text_2);
                        main_menu.add(text_3);
                        main_menu.add(text_4);
                        main_menu.add(button_cria_pessoa);
                        main_menu.revalidate();
                        main_menu.repaint();
             }
         }
         
         private class button_doutorado_Listener implements ActionListener{
          public void actionPerformed(ActionEvent e){
                        clean_registo();
                        tipo = "doutorado";
                        label_1.setText("Nome: ");
                        label_2.setText("Email: ");
                        label_3.setText("Data de inicio (dd/MM/yyyy): ");
                        label_4.setText("Data de fim (dd/MM/yyyy): ");
                        button_cria_pessoa.setBounds(250, 550, 100, 40);
                        label_1.setBounds(250, 350, 150, 20);
                        label_2.setBounds(250, 400, 170, 20);
                        label_3.setBounds(250, 450, 170, 20);
                        label_4.setBounds(250, 500, 150, 20);
                        text_1.setBounds(250, 375, 150, 20);
                        text_2.setBounds(250, 425, 150, 20);
                        text_9.setBounds(250, 475, 30, 20);
                        text_10.setBounds(290, 475, 30, 20); 
                        text_11.setBounds(330, 475, 30, 20);
                        text_6.setBounds(250, 525, 30, 20);
                        text_7.setBounds(290, 525, 30, 20);
                        text_8.setBounds(330, 525, 30, 20);
                        main_menu.add(label_1);
                        main_menu.add(label_2);
                        main_menu.add(label_3);
                        main_menu.add(label_4);            
                        main_menu.add(text_1);
                        main_menu.add(text_2);
                        main_menu.add(text_6);
                        main_menu.add(text_7);
                        main_menu.add(text_8);
                        main_menu.add(text_9);
                        main_menu.add(text_10);
                        main_menu.add(text_11);
                        main_menu.add(button_cria_pessoa);
                        main_menu.revalidate();
                        main_menu.repaint();
             }
         }
         
         private class button_mestre_Listener implements ActionListener{
          public void actionPerformed(ActionEvent e){
                        clean_registo();
                        tipo = "mestre";
                        label_1.setText("Nome: ");
                        label_2.setText("Email: ");
                        label_3.setText("Data de inicio (dd/MM/yyyy): ");
                        label_4.setText("Data de fim (dd/MM/yyyy): ");  
                        button_cria_pessoa.setBounds(250, 550, 100, 40);
                        label_1.setBounds(250, 350, 150, 20);
                        label_2.setBounds(250, 400, 150, 20);
                        label_3.setBounds(250, 450, 170, 20);
                        label_4.setBounds(250, 500, 170, 20);
                        text_1.setBounds(250, 375, 150, 20);
                        text_2.setBounds(250, 425, 150, 20); 
                        text_9.setBounds(250, 475, 30, 20);
                        text_10.setBounds(290, 475, 30, 20); 
                        text_11.setBounds(330, 475, 30, 20);
                        text_6.setBounds(250, 525, 30, 20);
                        text_7.setBounds(290, 525, 30, 20);
                        text_8.setBounds(330, 525, 30, 20);
                        main_menu.add(label_1);
                        main_menu.add(label_2);
                        main_menu.add(label_3);
                        main_menu.add(label_4);            
                        main_menu.add(text_1);
                        main_menu.add(text_2);
                        main_menu.add(text_6);
                        main_menu.add(text_7);
                        main_menu.add(text_8);
                        main_menu.add(text_9);
                        main_menu.add(text_10);
                        main_menu.add(text_11);
                        main_menu.add(button_cria_pessoa);
                        main_menu.revalidate();
                        main_menu.repaint();
             }
         }
                 
         private class button_licensiado_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
            clean_registo();
            tipo = "licensiado";
            label_1.setText("Nome: ");
            label_2.setText("Email: ");
            label_3.setText("Data de inicio (dd/MM/yyyy): ");
            label_4.setText("Data de fim (dd/MM/yyyy): ");   
            button_cria_pessoa.setBounds(250, 550, 100, 40);
            label_1.setBounds(250, 350, 150, 20);
            label_2.setBounds(250, 400, 150, 20);
            label_3.setBounds(250, 450, 170, 20);
            label_4.setBounds(250, 500, 170, 20);
            text_1.setBounds(250, 375, 150, 20);
            text_2.setBounds(250, 425, 150, 20);   
            text_9.setBounds(250, 475, 30, 20);
            text_10.setBounds(290, 475, 30, 20); 
            text_11.setBounds(330, 475, 30, 20);
            text_6.setBounds(250, 525, 30, 20);
            text_7.setBounds(290, 525, 30, 20);
            text_8.setBounds(330, 525, 30, 20);
            main_menu.add(label_1);
            main_menu.add(label_2);
            main_menu.add(label_3);
            main_menu.add(label_4);            
            main_menu.add(text_1);
            main_menu.add(text_2);
            main_menu.add(text_6);
            main_menu.add(text_7);
            main_menu.add(text_8);
            main_menu.add(text_9);
            main_menu.add(text_10);
            main_menu.add(text_11);
            main_menu.add(button_cria_pessoa);
            main_menu.revalidate();
            main_menu.repaint();
             }
         }
                 
        private class button_cria_pessoa_Listener implements ActionListener{         
            public void actionPerformed(ActionEvent e){
                Pessoa nova;
                int num, val=0;
                String nome = text_1.getText();
                String email = text_2.getText();
                try{
                    switch(tipo) {
                        case "docente":
                            String f1 = text_3.getText();
                            num = Integer.parseInt(f1);
                            String area = text_4.getText();
                            val = procura_repetido_pessoa(nome);
                            if(val==0){
                                nova = new Docente(nome, email, num, area);
                                lista_Pessoas.add(nova);
                            }   break;
                        case "doutorado":
                            {
                                int inicio_d, inicio_m, inicio_a;
                                int fim_d, fim_m, fim_a;
                                fim_d = Integer.parseInt(text_6.getText());
                                fim_m = Integer.parseInt(text_7.getText());
                                fim_a = Integer.parseInt(text_8.getText());
                                inicio_d = Integer.parseInt(text_9.getText());
                                inicio_m = Integer.parseInt(text_10.getText());
                                inicio_a = Integer.parseInt(text_11.getText());
                                GregorianCalendar data_inicio = new GregorianCalendar(inicio_a, inicio_m, inicio_d);
                                GregorianCalendar data_fim = new GregorianCalendar(fim_a, fim_m, fim_d);
                                val = procura_repetido_pessoa(nome);
                                if(val==0){
                                    nova = new Doutorado(nome, email, data_inicio, data_fim);
                                    lista_Pessoas.add(nova);
                                }          break;
                            }
                        case "mestre":
                            {
                                int inicio_d, inicio_m, inicio_a;
                                int fim_d, fim_m, fim_a;
                                fim_d = Integer.parseInt(text_6.getText());
                                fim_m = Integer.parseInt(text_7.getText());
                                fim_a = Integer.parseInt(text_8.getText());
                                inicio_d = Integer.parseInt(text_9.getText());
                                inicio_m = Integer.parseInt(text_10.getText());
                                inicio_a = Integer.parseInt(text_11.getText());
                                GregorianCalendar data_inicio = new GregorianCalendar(inicio_a, inicio_m, inicio_d);
                                GregorianCalendar data_fim = new GregorianCalendar(fim_a, fim_m, fim_d);
                                val = procura_repetido_pessoa(nome);
                                if(val==0){
                                    nova = new Mestre(nome, email, data_inicio, data_fim);
                                    lista_Pessoas.add(nova);
                                }          break;
                            }
                        case "licensiado":
                            {
                                int inicio_d, inicio_m, inicio_a;
                                int fim_d, fim_m, fim_a;
                                fim_d = Integer.parseInt(text_6.getText());
                                fim_m = Integer.parseInt(text_7.getText());
                                fim_a = Integer.parseInt(text_8.getText());
                                inicio_d = Integer.parseInt(text_9.getText());
                                inicio_m = Integer.parseInt(text_10.getText());
                                inicio_a = Integer.parseInt(text_11.getText());
                                GregorianCalendar data_inicio = new GregorianCalendar(inicio_a, inicio_m, inicio_d);
                                GregorianCalendar data_fim = new GregorianCalendar(fim_a, fim_m, fim_d);
                                val = procura_repetido_pessoa(nome);
                                if(val==0){
                                    nova = new Licensiado(nome, email, data_inicio, data_fim);
                                    lista_Pessoas.add(nova);
                                }          break;
                            }
                        default:
                            break;
                    }          
                main_menu.revalidate();
                main_menu.repaint();
             }catch(NumberFormatException k){
                        System.out.println("Erro a converter texto em inteiro");                     
                    }
         }
        }
        
        private class button_listar_tarefas_nao_iniciadas_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String option = comboBox_projetos.getSelectedItem().toString();
                comboBox_tarefas_nao_ini.removeAllItems();
                 for(Projeto i : lista_Projetos){
                     if(option.equals(i.getNome())){
                        for(Tarefa j : i.Tarefas){
                            if(j.getTaxa_execucao() == 0){
                                comboBox_tarefas_nao_ini.addItem(j.get_tipo()+"-" + j.getData_inicio());
                            }
                        }
                    }     
                }
                comboBox_tarefas_nao_ini.setBounds(600,500,110,20);
                main_menu.add(comboBox_tarefas_nao_ini);
            }
        }
        
        private class button_listar_tarefas_nao_concluidas_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                String option = comboBox_projetos.getSelectedItem().toString();
                comboBox_tarefas_nao_ini.removeAllItems();
                 for(Projeto i : lista_Projetos){
                     if(option.equals(i.getNome())){
                        for(Tarefa j : i.Tarefas){
                            if(j.getTaxa_execucao() == 0){
                                comboBox_tarefas_nao_ini.addItem(j.get_tipo()+"-" + j.getData_inicio());
                            }
                        }
                    }     
                }
                comboBox_tarefas_nao_ini.setBounds(600,500,110,20);
                main_menu.add(comboBox_tarefas_nao_ini);
            }
        }   
        
        
        
        public int procura_repetido_pessoa(String nome){
            int a=0;
            for(Pessoa i: lista_Pessoas){
                if( i.getNome().equals(nome) ){
                    a++;
                }

            } 
            return a;
        }
 private class button_listar_conc_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
            atualiza_projetos();
            clean();
            Projeto aux;
            Date date2 = new Date();
            nomes_projeto_concluidos.removeAllElements();
                for(int i=0;i<lista_Projetos.size();i++){
                    aux=lista_Projetos.get(i);
                    if(aux.getData_fim() != null){
                        nomes_projeto_concluidos.addElement(aux.getNome());
                        date2=aux.getData_fim().getTime();
                    }
                }
                System.out.println(nomes_projeto_concluidos);
                show_proj_conc = new JList(nomes_projeto_concluidos);
                show_proj_conc_scroller = new JScrollPane(show_proj_conc);
                show_proj_conc_scroller.setBounds(50,400, 100, 50);
                main_menu.add(show_proj_conc_scroller);
            }
        }
        
        private class button_listar_nao_conc_Listener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                atualiza_projetos();
                Date date_aux = new Date();
                Date date_fim_aux = new Date();
                int month,month_dur,month_final;
                clean();
                Projeto aux;
                nomes_projeto_nao_concluidos.removeAllElements();
                for(int i=0;i<lista_Projetos.size();i++){
                    aux=lista_Projetos.get(i);
                    if(aux.getData_fim() != null){
                        date_aux = aux.getData_inicio().getTime();
                        date_fim_aux = aux.getData_fim().getTime();
                        month_final = date_fim_aux.getMonth();
                        month = date_aux.getMonth();
                        month_dur = month + aux.getDuracao();
                        if(month_dur < month_final)
                            nomes_projeto_nao_concluidos.addElement(aux.getNome());  
                    }
                }
                System.out.println(nomes_projeto_nao_concluidos);
                show_proj_nao_conc = new JList(nomes_projeto_nao_concluidos);
                show_proj_nao_conc_scroller = new JScrollPane(show_proj_nao_conc);
                show_proj_nao_conc_scroller.setBounds(50,520, 100, 50);
                main_menu.add(show_proj_nao_conc_scroller);
            }
        }    
     
        private class button_associar_pessoa_Listener implements ActionListener{
            String value;
            Pessoa nova;
            public void actionPerformed(ActionEvent e){
                value = JOptionPane.showInputDialog(null, "Introduza o nome", "Input", JOptionPane.QUESTION_MESSAGE);
                for(Pessoa i: lista_Pessoas){
                    if( value.equals(i.getNome())){
                        for(Projeto j : lista_Projetos){
                            if( projeto.equals(j.getNome())){
                                j.Pessoas.add(i);
                            }
                        }
                    }
                }
                main_menu.repaint();
            } 
        }
        
         private class button_abrir_Listener implements ActionListener{
             public void actionPerformed(ActionEvent e){
                Projeto novo; 
                String nome_p = String.valueOf(comboBox_projetos.getSelectedItem());
                 //novo = Main.procura_projeto(nome_p);
             }
         }
         
        public void clean(){
           // main_menu.remove(comboBox_projetos);
            tipo = null;
            projeto = null;
            main_menu.remove(label_1);
            main_menu.remove(label_2);
            main_menu.remove(label_3);
            main_menu.remove(label_4);
            main_menu.remove(label_5);
            main_menu.remove(label_6);
            main_menu.remove(label_7);
            main_menu.remove(label_8);
            main_menu.remove(label_9);
            main_menu.remove(label_10);
            main_menu.remove(label_11);
            main_menu.remove(text_1);
            main_menu.remove(text_2);
            main_menu.remove(text_3);
            main_menu.remove(text_4);
            main_menu.remove(text_5);
            main_menu.remove(text_6);
            main_menu.remove(text_7);
            main_menu.remove(text_8);
            main_menu.remove(text_9);
            main_menu.remove(text_10);
            main_menu.remove(text_11);
            text_1.setText("");
            text_2.setText("");
            text_3.setText("");
            text_4.setText("");
            text_5.setText("");
            main_menu.remove(comboBox_projetos);
            main_menu.remove(comboBox_pessoas);
            main_menu.remove(comboBox_docentes);
            main_menu.remove(comboBox_tarefas);
            main_menu.remove(comboBox_escolher_p);
            main_menu.remove(comboBox_tipo_tarefas);
            main_menu.remove(button_cria_projeto);
            main_menu.remove(button_abre_projeto);
            main_menu.remove(button_associar_pessoa);
            main_menu.remove(button_docente);
            main_menu.remove(button_doutorado);
            main_menu.remove(button_mestre);
            main_menu.remove(button_licensiado);
            main_menu.remove(button_cria_pessoa);
            main_menu.remove(button_eliminar_tarefa);   
            main_menu.remove(button_criar_tarefa);
            main_menu.remove(button_atualizar_tarefa);
            main_menu.remove(show_pessoas_scroller);
            main_menu.remove(show_pessoas); //ok?
            main_menu.remove(comboBox_tarefas_nao_ini);
            main_menu.remove(comboBox_tarefas_conc);
            main_menu.remove(button_listar_tarefas_nao_ini);
            main_menu.remove(button_listar_tarefas_conc);
            main_menu.repaint();
        }   
        
        public void clean_registo(){
            main_menu.remove(label_1);
            main_menu.remove(label_2);
            main_menu.remove(label_3);
            main_menu.remove(label_4);
            main_menu.remove(text_1);
            main_menu.remove(text_2);
            main_menu.remove(text_3);
            main_menu.remove(text_4);
           main_menu.remove(text_6);
            main_menu.remove(text_7);
            main_menu.remove(text_8);
            main_menu.remove(text_9);
            main_menu.remove(text_10);
            main_menu.remove(text_11);

        }
        
        public void atualiza_projetos(){
            int j=0;       
            for(Projeto i : lista_Projetos){
                nomes_projetos[j] = (i.getNome());
                j++;
             }           
        }
        
        public void atualiza_docentes(){
            atualiza_pessoas();
            int j=0;
            for(Pessoa i: lista_Pessoas){
                if( i instanceof Docente ){
                    nomes_docentes[j] = (i.getNome());
                    j++;
                }
            }
        
        }

        public void atualiza_pessoas(){
            int j=0;
            for(int i = 0; i < lista_Pessoas.size(); i++) {   
                nomes_pessoas[j] = lista_Pessoas.get(i).getNome();
                j++;
            }       
        }
       public Docente procura_docente(String string,ArrayList<Pessoa> pessoas){
           Docente responsavel;
            for(int i = 0; i < pessoas.size(); i++) {   
            if (string.equals(pessoas.get(i).getNome())){
                responsavel = (Docente) pessoas.get(i);
                return responsavel;
            }
            }
            return null;
        } 
       
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        // TODO code application logic here;
        centro_investigacao centro = new centro_investigacao();
        centro.leitura_file_obj();
        
        Programa programa = new Programa();
        programa.lista_Projetos = new ArrayList<>(centro.Projetos);
        programa.lista_Pessoas = new ArrayList<>(centro.Pessoas);
        programa.atualiza_pessoas();
        programa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        programa.setTitle("Teste");        
        programa.setSize(700, 700);      
        programa.setVisible(true);
      
    } 
}
