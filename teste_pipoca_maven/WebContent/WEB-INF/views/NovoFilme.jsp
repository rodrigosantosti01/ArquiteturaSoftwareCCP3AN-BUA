<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Filme</title>
</head>
<body>
	<Form action="inserir" method="post">
		<label>Filme:</label>
		<input type="text" name="titulo">
		<label>Genero:</label>
		<select name="genero.id"> 
		<c:forEach var="genero" items="${generos}">
		<option value="${genero.id}"> </option>
		</c:forEach>
		</select>
		<!-- <label>Data Lançamento:</label>
		<input type="date" name="dataLancamento">  
		<label>Diretor</label>
		<input type="text" name="diretor">
		<label>Descrição</label>
		<input type="text" name="descricao">
		<label>PostPath:</label>
		<input type="text" name="posterPath">
		<label>Popularidade:</label>
		<input type="text" name="popularidade">
		<input type="submit">  -->
	</Form>
</body>
</html>