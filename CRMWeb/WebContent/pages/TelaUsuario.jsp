<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%out.println(getServletContext().
		getInitParameter("nomeAplicacao")); %></title>

</head>
<body>

	<jsp:include page="/templates/Cabecalho.jsp">
		<jsp:param  name="tituloPagina" value="Manutenção de Usuarios"/>		
	</jsp:include>
	<br>

	<form action="<%=request.getContextPath()%>/ServletGeral" 
			method="post">
		<h3><c:out value="${msg}"></c:out></h3>

		<input type="hidden" name="nomeFuncionalidade">
		<input type="hidden" name="nomeFuncao">
		<input type="hidden" name="id">
			
		<table>
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome" maxlength="40"></td>
			</tr>
			
			<tr>
				<td>Endereco</td>
				<td><input type="text" name="endereco" maxlength="40"></td>
			</tr>
			
			<tr>
				<td>CPF</td>
				<td><input type="text" name="cpf" maxlength="11"></td>
			</tr>
			
			<tr>
				<td>Login</td>
				<td><input type="text" name="login" maxlength="6"></td>
			</tr>
			
			<tr>
				<td>Senha</td>
				<td><input type="password" name="senha" maxlength="6"></td>
			</tr>
			
			<tr>
				<td>Confirma Senha</td>
				<td><input type="password" name="confirmaSenha" maxlength="6"></td>
			</tr>
			
			<tr>
				<td>Status</td>
				<td><input type="checkbox" name="status"></td>
			</tr>
				
			<tr>
				<td align="center">
					<input type="button" value="Gravar" 
					onclick="botaoGravar()">
				</td>
				<td align="center">
					<input type="button" value="Listar" 
					onclick="botaoListar()">
				</td>
				<td align="center">
					<input type="reset" value="Limpar">
				</td>
			</tr>	
		</table>
		<br>
		<hr>
		
		<table id = "gridcabecalho">
			<tr>
				<th width="400">Nome</th>
				<th width="400">Endereco</th>
				<th width="100">CPF</th>
				<th width="100">Login</th>
			</tr>
		</table>
				
		<table id="grid">
			<c:forEach var="usuario" items="${listaUsuarios}">
				<tr id="gridtr">
					<td  width="400"><c:out value="${usuario.nome}"/></td>
					<td  width="400"><c:out value="${usuario.endereco}"/></td>
					<td  width="100"><c:out value="${usuario.cpf}"/></td>
					<td  width="100"><c:out value="${usuario.login}"/></td>
					<td  width="20" onclick="botaoExcluir('${usuario.id}')">
						<img height="16px" width="16px" src="images/Botaoexcluir.bmp">
					</td>
					<td  width="20" onclick="botaoAlterar('${usuario.id}')">
						<img height="16px" width="16px" src="images/botaoalterar.gif">
					</td>
					
				</tr>
			</c:forEach>
		</table>		
	</form>
	<script type="text/javascript">
		function botaoGravar(){
			document.forms[0].nomeFuncionalidade.value = "USUARIOS";
			document.forms[0].nomeFuncao.value = "GRAVAR";
			document.forms[0].submit();
		}
		
		function botaoListar(){
			document.forms[0].nomeFuncionalidade.value = "USUARIOS";
			document.forms[0].nomeFuncao.value = "LISTAR";
			document.forms[0].submit();
		}

		function botaoExcluir(id){
			document.forms[0].nomeFuncionalidade.value = "USUARIOS";
			document.forms[0].nomeFuncao.value = "EXCLUIR";
			document.forms[0].id.value = id;

			if(confirm("Tem certeza que deseja excluir esse usuário?")){
				document.forms[0].submit();
			}
		}
		function botaoAlterar(id){
			document.forms[0].nomeFuncionalidade.value = "USUARIOS";
			document.forms[0].nomeFuncao.value = "ALTERAR";
			document.forms[0].id.value = id;			
			document.forms[0].submit();
		}
		
		
	</script>
	
	<jsp:include page="/templates/Rodape.jsp"/>


</body>
</html>