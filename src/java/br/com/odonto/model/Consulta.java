package br.com.odonto.model;

import java.util.Date;

/*Criando os atributos que serão utilizados como no banco de dados (ordem) com nomes transcritos de forma diferente*/
/*As informações aqui presentes não precisam ser parecidas como no banco de dados. 
Porém caso queria se guiar melhor, mantenha ordem como no banco*/
public class Consulta {
    private long consultaID;
    private Date consultaData;
    private String consultaHora;
    private String consultaConsultorio;
    private String consultaDentista;
    private String consultaPaciente;

    public long getConsultaID() {
        return consultaID;
    }

    public void setConsultaID(long consultaID) {
        this.consultaID = consultaID;
    }

    public Date getConsultaData() {
        return consultaData;
    }

    public void setConsultaData(Date consultaData) {
        this.consultaData = consultaData;
    }

    public String getConsultaHora() {
        return consultaHora;
    }

    public void setConsultaHora(String consultaHora) {
        this.consultaHora = consultaHora;
    }

    public String getConsultaConsultorio() {
        return consultaConsultorio;
    }

    public void setConsultaConsultorio(String consultaConsultorio) {
        this.consultaConsultorio = consultaConsultorio;
    }

    public String getConsultaDentista() {
        return consultaDentista;
    }

    public void setConsultaDentista(String consultaDentista) {
        this.consultaDentista = consultaDentista;
    }

    public String getConsultaPaciente() {
        return consultaPaciente;
    }

    public void setConsultaPaciente(String consultaPaciente) {
        this.consultaPaciente = consultaPaciente;
    }
    
    
    /*Aqui no toString aponta o atributo/metodo a seu campo no banco de dados*/
    /*Campos e ordem exatamente iguais ao do banco de dados, assim como a sua tabela*/
    @Override
    public String toString(){
        return "cadastroConsulta consultaid="+consultaID+
                                " ,consultadata="+consultaData+
                                " ,consultahora="+consultaHora+
                                " ,consultaconsultorio="+consultaConsultorio+
                                " ,consultadentista="+consultaDentista+
                                " ,consultapaciente="+consultaPaciente;
    }
    
    
}
