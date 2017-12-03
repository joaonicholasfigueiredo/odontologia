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
        <title>Marcar Consulta</title>
    </head>
    <body>
        
        <script>
            $(function() {
                $('input[consultacosultorio=consultadata]').datepicker();
            });
        </script>
        
        <form method="POST" action='ConsultaController' name="frmAddUser">
        
        Consulta ID : <input type="text" readonly="readonly" name="consultaid"
            value="<c:out value="${cadastroconsulta.consultaid}" />" /> <br />
        
        Dia da consulta : <input
            type="text" name="consultadata"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${cadastroconsulta.consultadata}" />" /> <br /> 
        
        Horário da Consulta : <input
            type="text" name="consultahora"
            value="<c:out value="${cadastroconsulta.consultahora}" />" /> <br /> 
        
        Consultório : <input
            type="text" name="consultaconsultorio"
            value="<c:out value="${cadastroconsulta.consultaconsultorio}" />" /> <br /> 
        
        Dentista : <input type="text" name="consultadentista"
            value="<c:out value="${cadastroconsulta.consultadentista}" />" /> <br />
        
        Paciente : <input type="text" name="consultapaciente"
            value="<c:out value="${cadastroconsulta.consultapaciente}" />" /> <br />
        
        <input type="submit" value="Submit" />
    </form>
    </body>
</html>
