<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
	<div>
		<form action="cliente" method="post">
		<table>
			<tr>
				<td colspan="2"><input type="text" id="cpf" name="cpf" placeholder="CPF" 
					size="50" value="<c:if test="${not empty cliente }">${cliente.cpf }</c:if>">
				</td>
				<td><input type="submit" value="Buscar" id="button" name="button">
			</tr>		
			<tr>
				<td colspan="3"><input type="text" id="nome" name="nome" placeholder="Nome" 
					size="80" value="<c:if test="${not empty cliente }">${cliente.nome }</c:if>">
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="text" id="logradouro" name="logradouro" 
					placeholder="Logradouro" size="80" 
					value="<c:if test="${not empty cliente }">${cliente.logradouro }</c:if>">
				</td>
			</tr>
			<tr>
				<td colspan="3"><input type="number" id="numero" name="numero" 
					placeholder="Numero" size="10" 
					value="<c:if test="${not empty cliente }">${cliente.numero }</c:if>">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Cadastrar" id="button" name="button">
				<td><input type="submit" value="Atualizar" id="button" name="button">
				<td><input type="submit" value="Excluir" id="button" name="button">
			</tr>
		</table>
		</form>
	</div>
	<div>
		<c:if test="${not empty saida }">
			<c:out value="${saida }" />
		</c:if>
		<c:if test="${not empty erro }">
			<H2 style="color:red;"><c:out value="${erro }" /></H2>
		</c:if>	
	</div>
</body>
</html>