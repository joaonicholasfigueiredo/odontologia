<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Consultas Marcadas</title>
    </head>
    <body>
        <table border=1>
            <thead>
                <tr>
                    <th>Consulta Id</th>
                    <th>Dia da Consulta</th>
                    <th>Horário da Consulta</th>
                    <th>Consultorio</th>
                    <th>Dentista</th>
                    <th>Paciente</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ctc}" var="cadastroconsulta">
                    <tr>
                        <td><c:out value="${cadastroconsulta.consultaID}" /></td>
                        <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${cadastroconsulta.consultaData}" /></td>
                        <td><c:out value="${cadastroconsulta.consultaHora}" /></td>
                        <td><c:out value="${cadastroconsulta.consultaConsultorio}" /></td>     
                        <td><c:out value="${cadastroconsulta.consultaDentista}" /></td>
                        <td><c:out value="${cadastroconsulta.consultaPaciente}" /></td>
                        
                        <td><a href="ConsultaController?action=edit&consultaid=<c:out value="${cadastroconsulta.consultaID}"/>">Atualizar</a></td>
                        <td><a href="ConsultaController?action=delete&consultaid=<c:out value="${cadastroconsulta.consultaID}"/>">Cancelar Consulta</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="ConsultaController?action=insert">Marcar Consulta</a></p>
    </body>
</html>
