package br.com.odonto.bll;

/*Importações necessárias para esse arquivo*/
import java.io.IOException;
/*As 3 próximas importações são usadas apenas caso seja utilizado algum campo com formato date, mas não há problema em declara-los*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*Pacotes necessários e arquivos necessários*/
import br.com.odonto.dal.ServicoDao;
import br.com.odonto.model.Servico;

/*Para construir esse arquivo, é necessário que outros 3 estejam arrumados, sendo eles:
1º O arquivo index.JSP, conhecido como tela principal que apontará para qual pagina será guiado o projeto quando executado;
2º Uma tela que seja feita para apresentar as informações (listar, excluir cadastrar e alterar), chamada de list;
3º Uma tela que seja feita para adicionar as informações ao banco ou fazer a atualização das informações;
*/

/*Primeiro devemos fazer o extends da Função HttpServelet que serve para indicar que será feita uma conexão http*/
public class ServicoController extends HttpServlet {
    
    /*Para iniciar as funções, deve-se fazer as seguindas declarações.*/
    
    /*Versão*/
    private static final long serialVersionUID = 1L;
    
    /*Arquivo que fará o adicionar ou salvar alterações*/
    private static String INSERIR_OU_EDITAR = "/servico.jsp";
    
    /*Arquivo que irá listar, excluir, alterar*/
    private static String LISTAR_SERVICO = "/listarservico.jsp";
    
    /*Arquivo que será trabalhado.*/
    private ServicoDao servicodao;
    
    public ServicoController(){
        super();
        servicodao = new ServicoDao();
    }
    
    
    /*O doGet irá realizar as ações, passando as informações pela barra de navegação*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*Caso a conexão seja feita, será passado para a próxima página, para isso, será necessário selecionar uma ação (action)
        ou seja: Adicionar, listar, excluir, alterar*/
        String forward="";
        String action = request.getParameter("action");
        
        
        /*Primeira ação: DELETAR*/
        /*Irá guiar para a página que fará a ação de deletar, para isso, devemos chamar qual atributo iremos precisar para fazer isso
        e então apontar para a página que permitirá fazer essa ação
        Lembrando que colocar dentro do parametro, qual coluca iremos trabalhar, no caso, a coluna ID*/
        
        if (action.equalsIgnoreCase("delete")){
            int servicoId = Integer.parseInt(request.getParameter("servicoid"));
            servicodao.deleteServico(servicoId); 
            forward = LISTAR_SERVICO;
            request.setAttribute("cts", servicodao.getAllServicos());
            
            
            
        /*Segunda ação: Editar/Atualizar*/   
        /*Mesmo procedimento da primeira ação, porém, será necessário apontar qual id queremos editar*/
        }else if (action.equalsIgnoreCase("edit")){
            forward = INSERIR_OU_EDITAR;
            int servicoID = Integer.parseInt(request.getParameter("servicoid"));
            Servico servico = servicodao.getServicoById(servicoID);
            request.setAttribute("cadastroservico", servico);
            
        /*Terceira ação: Listar*/   
        /*Iremos aqui ignorar a case e então selecionar a página que irá realizar a ação de listar.*/
        } else if (action.equalsIgnoreCase("listarservico")){
            forward = LISTAR_SERVICO;
            /*aqui nós declaramos o formulário que irá apresentar as informações.*/
            request.setAttribute("cts", servicodao.getAllServicos());
        } else {
            forward = INSERIR_OU_EDITAR;
        }
        /*Quando a ação for selecionada, seguira para a próxima pagina utilizando os seguintes comandos.
        Nota-se que para a página possuir suas funções, deve ser declarado que o requisito para avançar é declarado como foward*/
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);        
    }
    
    
    
    
    
    /*No doPost as informações são passadas do fomulário para o banco de dados, utilizando o nome dos campos utilizados de forma igual
    tanto nos formulários quanto no banco de dados. É bem parecido com o arquivo DAO*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        /*Para buscarmos as informações do formulário, é necessário passar elas através de parametro, para isso fazermos as seguintes
        declarações*/
        
        Servico servico = new Servico();
        servico.setServicoProcedimento(request.getParameter("servicoprocedimento"));
        servico.setServicoDescricao(request.getParameter("servicodescricao"));
        servico.setServicoValor(Double.parseDouble(request.getParameter("servicovalor")));        

        /*E então apontamos para qual id será enviada as informações.*/
        String servicoID = request.getParameter("servicoid");
        /*CASO o ID esteja vázio, ou seja adicionar, será adicionado um novo campo no banco de dados.
        Se o ID já estiver em uso, será atualizada as informações. */
        if(servicoID == null || servicoID.isEmpty())
        {
            servicodao.addServico(servico);
        }
        else
        {
            servico.setServicoID(Integer.parseInt(servicoID));
            servicodao.updateServico(servico);
        }
        /*Após a ação ser executado, será direcionado para uma outra página, vamos usar a listar como exemplo.*/
        RequestDispatcher view = request.getRequestDispatcher(LISTAR_SERVICO);
        
        /*nota-se que devemos apontar o nome do formulário que irá apresentar as informações*/
        request.setAttribute("cts", servicodao.getAllServicos());
        view.forward(request, response);
    }
    
}
