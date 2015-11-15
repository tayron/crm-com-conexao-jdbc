<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%out.println(getServletContext().
		getInitParameter("nomeAplicacao")); %></title>
</head>
<body>
	<jsp:include page="/templates/Cabecalho.jsp">
		<jsp:param  name="tituloPagina" value="Tela Principal"/>		
	</jsp:include>
	<br>
	
	<jsp:include page="/templates/Rodape.jsp"/>


</body>
</html>