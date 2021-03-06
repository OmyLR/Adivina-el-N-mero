<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="controladores.Juego" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Adivina el N�mero</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		<link rel="stylesheet" type="text/css" href="src/css/index.css">
	</head>
	<body>
		<div class="col-md-5 offset-md-3">
			<div class="row col-md-12 boxInterval">
				<form method="POST" action="jugar">
					<p> Elige un Intervalo m�nimo y m�ximo para el juego</p>
					<div class="form-group row">
						<label class="col-form-label col-md-2">M�nimo: </label>
						<div class="col-md-9">
							<input type="number" class="form-control" value="" placeholder="M�nimo" name="min">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-form-label col-md-2">M�ximo:</label>
						<div class="col-md-9">
							<input type="number" class="form-control" value="" placeholder="M�ximo" name="max">
						</div>
					</div>
					<button type="submit" class="btn btn-primary col-md-3 offset-md-8" name="accion" name="Enviar" value="nueva">Enviar</button>
				</form>
				<%
					String err = (String) request.getSession().getAttribute("error");
					if(err != null){
				%>
				<div class="col-md-10 alert alert-danger alerta">
					<%=err %>
				</div>
				
				<%  request.getSession().setAttribute("error", null);
				
					}  %>
			</div>
			
		</div>
	</body>
</html>