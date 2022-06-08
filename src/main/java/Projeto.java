import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Projeto {
    private String nome;
    private String acronimo;
    private GregorianCalendar data_inicio;
    private int duracao;
    private GregorianCalendar data_fim;
    public ArrayList<Pessoa> Pessoas = new ArrayList<Pessoa>();
    private Docente IP;
    public ArrayList<Tarefa> Tarefas_concluidas;
    public ArrayList<Tarefa> Tarefas;
    public Projeto(String nome,String acronimo, GregorianCalendar data_inicio,int duracao,Docente IP){
        this.nome = nome;
        this.acronimo = acronimo;
        this.data_inicio = data_inicio;
        this.duracao = duracao;
        this.data_fim = null;
        this.Pessoas = new ArrayList<Pessoa>();
        this.IP= IP;
        Pessoas.add(IP);
        this.Tarefas = new ArrayList<Tarefa>();
        this.Tarefas_concluidas = new ArrayList<Tarefa>();
    }

    public void add_Pessoa(Pessoa e){
        Pessoas.add(e);
    }
    
    public void add_Tarefa(Tarefa e){
        Tarefas.add(e);
    }
    
    public void remove_Tarefa(Tarefa e){
        Tarefas.remove(e);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public GregorianCalendar getData_inicio() {
        return data_inicio;
    }
    public void setData_inicio(GregorianCalendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Docente getIP() {
        return IP;
    }

    public void setIP(Docente IP) {
        this.IP = IP;
    }

    public GregorianCalendar getData_fim() {
        return data_fim;
    }

    public void setData_fim(GregorianCalendar data_fim) {
        this.data_fim = data_fim;
    }
    public void associa_pessoas(Projeto proj,Pessoa pessoa){
        proj.Pessoas.add(pessoa);
    }
    public void cria_tarefa(ArrayList<Tarefa> tarefas,String tipo,GregorianCalendar data_inicio,int duracao_estimada,Pessoa pessoa_responsavel){
        Tarefa tarefa = new Tarefa(tipo,data_inicio,duracao_estimada,pessoa_responsavel);
        tarefas.add(tarefa);
    }
    @Override
    public String toString(){
        return nome;
    }
}
