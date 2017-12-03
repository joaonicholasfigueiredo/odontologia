<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Cadastrar Novo Serviço</title>
    </head>
    
    <!--Aqui será feito o formulário onde irá passar as informações atraves do controller e adicionar no banco de dados
        Para isso, é necessário informar no nome do campo input o mesmo nome que a colunca do banco de dados e o valor
        declarar da mesma forma como feito na página de listagem.
        Como dito anteriormente, as informações aqui serão passadas por dentro do código, ou seja, metodo POST, ou doPost.
        -->
    <body>
         <form method="POST" action='ServicoController' name="frmAddUser">
        
        Serviço ID : <input type="text" readonly="readonly" name="servicoid"
            value="<c:out value="${cadastroservico.servicoID}" />" /> <br /> 
        
        Procedimento : <input 
            type="text" name="servicoprocedimento"
            value="<c:out value="${cadastroservico.servicoProcedimento}" />" /> <br />  
        
        Descrição do Procedimento : <input
            type="text" name="servicodescricao"
            value="<c:out value="${cadastroservico.servicoDescricao}" />" /> <br /> 
        
        Valor a ser Cobrado : <input
            type="text" name="servicovalor"
            value="<c:out value="${cadastroservico.servicoValor}" />" /> <br /> 
        
        <input type="submit" value="Submit" />
    </form>
    </body>
</html>
