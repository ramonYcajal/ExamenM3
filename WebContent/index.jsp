<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Examen M3 - Antonio Santiago Ramos</title>
<link rel="stylesheet" href="./bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="./assets/styles.css">
</head>
<%@page import="java.util.ArrayList" %>


<body>
<%ArrayList<String> listadoProvincias=(ArrayList<String>)request.getSession().getAttribute("listadoProvincias"); %>
	<form action="" method="post">
		<form>
			<div class="form-group">
				<input type="text" class="form-control" name="username" required
					placeholder="Nombre destinatario"> <input type="email"
					class="form-control" name="email" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email">
				
					<label for="provincias">Provincia</label> 
					<select name="provincias" class="form-control" id="provincias">
					<%for (int i=0; i<listadoProvincias.size(); i++){%>
						<option value="<%=listadoProvincias.get(i)%>"><%=listadoProvincias.get(i)%></option>
					<%} %>
					</select>
				</div>


				<textarea placeholder="cuerpo" name="cuerpo"></textarea>
			


			<button type="submit" class="btn btn-primary">Enviar</button>
		</form>

	</form>
</body>
</html>