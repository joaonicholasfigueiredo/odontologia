package br.com.odonto.model;

/*Criando os atributos que serão utilizados como no banco de dados (ordem) com nomes transcritos de forma diferente*/
/*As informações aqui presentes não precisam ser parecidas como no banco de dados. 
Porém caso queria se guiar melhor, mantenha ordem como no banco*/
public class Servico {
    private int servicoID;
    private String servicoProcedimento;
    private String servicoDescricao;
    private double servicoValor;

    public int getServicoID() {
        return servicoID;
    }

    public void setServicoID(int servicoID) {
        this.servicoID = servicoID;
    }

    public String getServicoProcedimento() {
        return servicoProcedimento;
    }

    public void setServicoProcedimento(String servicoProcedimento) {
        this.servicoProcedimento = servicoProcedimento;
    }

    public String getServicoDescricao() {
        return servicoDescricao;
    }

    public void setServicoDescricao(String servicoDescricao) {
        this.servicoDescricao = servicoDescricao;
    }

    public double getServicoValor() {
        return servicoValor;
    }

    public void setServicoValor(double servicoValor) {
        this.servicoValor = servicoValor;
    }
    
    
    /*Aqui no toString aponta o atributo/metodo a seu campo no banco de dados*/
    /*Campos e ordem exatamente iguais ao do banco de dados, assim como a sua tabela*/
    public String toString(){
        return "cadastroServico [servicoid="+servicoID+
                                " ,servicoprocedimento="+servicoProcedimento+
                                " ,servicodescricao="+servicoDescricao+
                                " ,servicovalor="+servicoValor;
    }
}
