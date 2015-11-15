<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%out.println(getServletContext().
		getInitParameter("nomeAplicacao")); %></title>

<link rel="stylesheet" 
href="<%=request.getContextPath()%>/css/base.css">

<link rel="stylesheet" 
href="<%=request.getContextPath()%>/css/tabela.css">		
</head>
<body>
	<h1>Alteração de usuários</h1>

	<form action="<%=request.getContextPath()%>/ServletGeral" 
			method="post">
		<h3><c:out value="${msg}"></c:out></h3>

		<input type="hidden" name="nomeFuncionalidade">
		<input type="hidden" name="nomeFuncao">
		<input type="hidden" name="id" value="<%=request.getAttribute("id") %>">
			
		<table>
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome" maxlength="40"
						value="<%=request.getAttribute("nome") %>"></td>
			</tr>
			
			<tr>
				<td>Endereco</td>
				<td><input type="text" name="endereco" maxlength="40"
						value="<%=request.getAttribute("endereco") %>"></td>
			</tr>
			
			<tr>
				<td>CPF</td>
				<td><input type="text" name="cpf" maxlength="11"
							value="<%=request.getAttribute("cpf") %>"></td>
			</tr>
			
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" maxlength="6"
							value="<%=request.getAttribute("login") %>"></td>
			</tr>
			
			<tr>
				<td>Senha</td>
				<td><input type="password" name="senha" maxlength="6"
					value="<%=request.getAttribute("senha") %>"></td>
			</tr>
			
			<tr>
				<td>Confirma Senha</td>
				<td><input type="password" name="confirmaSenha" maxlength="6"></td>
			</tr>
			
			<tr>
				<td>Status</td>
				<td><input type="checkbox" name="status" 
					checked="<%=request.getAttribute("status") %>"></td>
			</tr>
				
			<tr>
				<td align="center">
					<input type="button" value="Gravar" 
					onclick="botaoGravarAlteracao()">
				</td>
				<td align="center">
					<input type="reset" value="Limpar">
				</td>
			</tr>	
		</table>
		<br>
		<hr>
	</form>
	<script type="text/javascript">
		function botaoGravarAlteracao(){
			document.forms[0].nomeFuncionalidade.value = "USUARIOS";
			document.forms[0].nomeFuncao.value = "GRAVAR_ALTERACAO";
			document.forms[0].submit();
		}
	</script>

</body>
</html>