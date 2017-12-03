package br.com.odonto.model;

import java.sql.Date;

/*Criando os atributos que serão utilizados como no banco de dados (ordem) com nomes transcritos de forma diferente*/
/*As informações aqui presentes não precisam ser parecidas como no banco de dados. 
Porém caso queria se guiar melhor, mantenha ordem como no banco*/
public class Dentista {
    private long dentistaID;
    private String dentistaNome;
    private long dentistaCPF;
    private Date dentistaIdade;
    private String dentistaCRO;
    private String dentistaEmail;
    private String dentistaSenha;
    private String dentistaTelefone;
    private String dentistaStatus; 

    public long getDentistaID() {
        return dentistaID;
    }

    public void setDentistaID(long dentistaID) {
        this.dentistaID = dentistaID;
    }

    public String getDentistaNome() {
        return dentistaNome;
    }

    public void setDentistaNome(String dentistaNome) {
        this.dentistaNome = dentistaNome;
    }

    public long getDentistaCPF() {
        return dentistaCPF;
    }

    public void setDentistaCPF(long dentistaCPF) {
        this.dentistaCPF = dentistaCPF;
    }

    public Date getDentistaIdade() {
        return dentistaIdade;
    }

    public void setDentistaIdade(Date dentistaIdade) {
        this.dentistaIdade = dentistaIdade;
    }

    public String getDentistaCRO() {
        return dentistaCRO;
    }

    public void setDentistaCRO(String dentistaCRO) {
        this.dentistaCRO = dentistaCRO;
    }

    public String getDentistaEmail() {
        return dentistaEmail;
    }

    public void setDentistaEmail(String dentistaEmail) {
        this.dentistaEmail = dentistaEmail;
    }

    public String getDentistaSenha() {
        return dentistaSenha;
    }

    public void setDentistaSenha(String dentistaSenha) {
        this.dentistaSenha = dentistaSenha;
    }

    public String getDentistaTelefone() {
        return dentistaTelefone;
    }

    public void setDentistaTelefone(String dentistaTelefone) {
        this.dentistaTelefone = dentistaTelefone;
    }

    public String getDentistaStatus() {
        return dentistaStatus;
    }

    public void setDentistaStatus(String dentistaStatus) {
        this.dentistaStatus = dentistaStatus;
    }
    
    /*Aqui no toString aponta o atributo/metodo a seu campo no banco de dados*/
    /*Campos e ordem exatamente iguais ao do banco de dados, assim como a sua tabela*/
    public String toString(){
        return "cadastroDentista [dentistaid="+dentistaID+
                                " ,dentistanome="+dentistaNome+
                                " ,dentistacpf="+dentistaCPF+
                                " ,dentistaidade="+dentistaIdade+
                                " ,dentistacro="+dentistaCRO+
                                " ,dentistaemail="+dentistaEmail+
                                " ,dentistasenha="+dentistaSenha+
                                " ,dentistatelefone="+dentistaTelefone+
                                " ,dentistastatus="+dentistaStatus;
    }
}
