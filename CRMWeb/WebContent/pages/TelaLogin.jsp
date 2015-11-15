<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 
href="<%=request.getContextPath()%>/css/base.css">

<title><%out.println(getServletContext().
		getInitParameter("nomeAplicacao")); %></title>
</head>
<body>
	<form action="../ServletLogin" method="post">
		<table>
			<tr>
				<td><h1>Autenticação</h1></td>
			</tr>
		</table>	
	
		<table>
			<tr>
				<td>Login</td>
				<td><input type="text" name="login"></td>
			</tr>
			
			<tr>
				<td>Senha</td>
				<td><input type="password" name="senha"></td>
			</tr>

			<tr>
				<td><input type="submit" name="botaoLogar" value="OK"></td>
				<td><input type="reset" name="botaoLimpar" value="Limpar"></td>
			</tr>
		</table>
	</form>
</body>
</html>