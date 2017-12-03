
package br.com.odonto.model;

import java.sql.Date;

/*Criando os atributos que serão utilizados como no banco de dados (ordem) com nomes transcritos de forma diferente*/
/*As informações aqui presentes não precisam ser parecidas como no banco de dados. 
Porém caso queria se guiar melhor, mantenha ordem como no banco*/
public class Cliente {
     private long clienteID;
    private String clienteNome;
    private long clienteCPF;
    private Date clienteIdade;
    private String clienteTelefone;
    private String clienteEndereco;
    private String clienteSenha;
    private String clienteConsulta;
    private String clienteServico;
    private String clienteSexo;
    private String clienteStatus;

    public long getClienteID() {
        return clienteID;
    }

    public void setClienteID(long clienteID) {
        this.clienteID = clienteID;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public long getClienteCPF() {
        return clienteCPF;
    }

    public void setClienteCPF(long clienteCPF) {
        this.clienteCPF = clienteCPF;
    }

    public Date getClienteIdade() {
        return clienteIdade;
    }

    public void setClienteIdade(Date clienteIdade) {
        this.clienteIdade = clienteIdade;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public void setClienteTelefone(String clienteTelefone) {
        this.clienteTelefone = clienteTelefone;
    }

    public String getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(String clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }

    public String getClienteSenha() {
        return clienteSenha;
    }

    public void setClienteSenha(String clienteSenha) {
        this.clienteSenha = clienteSenha;
    }

    public String getClienteConsulta() {
        return clienteConsulta;
    }

    public void setClienteConsulta(String clienteConsulta) {
        this.clienteConsulta = clienteConsulta;
    }

    public String getClienteServico() {
        return clienteServico;
    }

    public void setClienteServico(String clienteServico) {
        this.clienteServico = clienteServico;
    }

    public String getClienteSexo() {
        return clienteSexo;
    }

    public void setClienteSexo(String clienteSexo) {
        this.clienteSexo = clienteSexo;
    }

    public String getClienteStatus() {
        return clienteStatus;
    }

    public void setClienteStatus(String clienteStatus) {
        this.clienteStatus = clienteStatus;
    }
    
    
    /*Aqui no toString aponta o atributo/metodo a seu campo no banco de dados*/
    /*Campos e ordem exatamente iguais ao do banco de dados, assim como a sua tabela*/
    public String toString(){
        return "cadastroCliente [clienteid="+clienteID+
                                " ,clientenome="+clienteNome+
                                " ,clientecpf="+clienteCPF+
                                " ,clienteidade="+clienteIdade+
                                " ,clientetelefone="+clienteTelefone+
                                " ,clienteendereco="+clienteEndereco+
                                " ,clientesenha="+clienteSenha+
                                " ,clienteconsulta="+clienteConsulta+
                                " ,clienteservico="+clienteServico+
                                " ,clientesexo="+clienteSexo+
                                " ,clientestatus="+clienteStatus;
    }
}
