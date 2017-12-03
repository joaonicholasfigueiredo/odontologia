<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Serviço</title>
    </head>
    <body>
        <!--Esta página é extremamente parecida com a página de html, porém, nela é adicionada as funções do jsp.
        Aqui será apontada para qual pagina deverá aparecer primeiro ao executar o projeto.-->
        
        <!--OBS: e nexessário um arquivo chamado web.xml na pasta WEB-INF para exercutar o projeto-->
        <jsp:forward page="/ServicoController?action=listarservico" />
    </body>
</html>
