<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Serviços Cadastrados</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Servico Procedimento</th>
                    <th>Servico Descrição</th>
                    <th>Valor do Serviço</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <!--Aqui declaramos a tabela onde será feita a disposição das informações
                    para apresentar uma informação, deve-se usar o seguinte formato $ {}, tudo junto claro
                    pois assim é oq chamamos de 'chamar váriavel'. E devemos chamar a tabela opr alguma abreviação
                    para que possa ser utilizada na classe controller. A abreviaçao deve ser posta no campo 'items'.
                    Agora insiva as variaveis declaradas no arquivo model.
                -->
                <c:forEach items="${cts}" var="cadastroservico">
                    <tr>
                        <td><c:out value="${cadastroservico.servicoID}" /></td>
                        <td><c:out value="${cadastroservico.servicoProcedimento}"/></td>
                        <td><c:out value="${cadastroservico.servicoDescricao}"/></td>
                        <td><c:out value="${cadastroservico.servicoValor}"/></td>
                        
                        <!--Aqui irá apontar qual função será realizada, atualizar ou apagar indicando o ID desejado-->
                        <td><a href="ServicoController?action=delete&servicoid=<c:out value="${cadastroservico.servicoID}"/>">Apagar</a></td>
                        <td><a href="ServicoController?action=edit&servicoid=<c:out value="${cadastroservico.servicoID}"/>">Atualizar</a></td>
                    </tr>
                </c:forEach>
            </tbody>       
        </table>
         <!--Aqui irá apontar qual função será realizada, cadastrar.-->           
        <p><a href="ServicoController?action=insert">Cadastrar</a></p>
    </body>
</html>
