<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    <%@ page import="controladores.Juego" %>
    <%@ page import ="modelos.Intento" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Adivina el Número</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
		<link rel="stylesheet" type="text/css" href="src/css/index.css">
		<script type="text/javascript" src="src/js/guess.js"></script>
	</head>
	<body>
	<%  Juego partida = (Juego) request.getSession().getAttribute("partida"); 
		if(partida == null){
			response.sendRedirect("/Juego");
		}
	%>
		<div class="row col-md-12">
		      <div class="col-md-5 offset-md-1">
		      	<form method="POST" action="jugar">
		      		<div class="form-group row">
		      			<label class="col-md-4 col-form-label">Adivina el Número:</label>
		      			<div class="col-md-8">
		      				<input type="number" class="form-control" id="numPlayer" name="numPlayer" placeholder="Escribe tu elección...">
		      			</div>
		      		</div>
		      		<div class="row">
		      			<div class="col-md-6">
				 			<div class="col-md-12">
				   				<div class="form-check">
								  <input class="form-check-input" name="pista" type="checkbox" id="checkPista" onclick="mostrarPista()" <%
								  		out.print((partida.isPista())?"checked":"");
								  %>>
								  <label class="form-check-label" for="defaultCheck1">
									    Mostrar Pista
								  </label>
								</div>
								<div class="form-check">
								  <input class="form-check-input" type="checkbox" name="solucion" id="checkSol" onclick="mostrarSolucion()" <%
								  		out.print((partida.isSolucion())?"checked":"");
								  	
								  %>>
								  <label class="form-check-label" for="defaultCheck1">
									    Mostrar Solución
								  </label>
								</div>
								<button class="btn btn-success" type="submit" name="accion" value="jugar">Enviar</button>
								<button class="btn btn-warning" type="submit" name="accion" value="reiniciar">Reiniciar</button>
							</div>
							<div class="col-md-11 boxAdvise" id="aviso">
								Aviso: <%= partida.generarAviso()	%>
							</div>
							<div class="col-md-11 boxTip">
								<div class="col-md-1">
									Pista: 
								</div>
								<div class="col-md-11 <%
										if(partida.isPista()){
											out.print("showSol");
										} else {
											out.print("hideSol");
										}
								%>" id="pista">
									<%= partida.mostrarPista() %>
								</div> 
			      			</div>
						</div>
						<div class="col-md-6 solucion">
							<div class="col-md-12 titSol">
								Solución:
							</div>
							<div class="col-md-12 <%
									if(partida.isSolucion()){
										out.print("showSol");
									} else {
										out.print("hideSol");
									}
							%>" id="solucion">
								<%=partida.getAleatorio()%>
							</div>
						</div>
					</div>
      			</form>
      		</div>
     		<div class="col-md-2 boxOptions">
      			<div class="col-md-12 titOptions">
      				Elecciones:
      			</div>
      			<div class="col-md-12" id="elecciones">
      				<c:forEach items="${partida.getIntentos()}" var="value">
      					<c:out value="${value}"/></br>
      				</c:forEach>      				
      			</div>
      		</div>
      		<div class="col-md-3 boxTrys">
      			<div class="col-md-12 titTrys">
      				Partidas Realizadas.
      			</div>
     			<div class="col-md-12" id="partidas">
     				<c:forEach items="${partida.getHistorial()}" var="value">
      					<c:out value="${value}"/></br>
      				</c:forEach> 
      			</div>
     		</div>
     		<% if(request.getSession().getAttribute("error") != null) {%>
	     		<div class="alerta alert alert-danger col-md-4 offset-md-4">
	     			<%= (String)request.getSession().getAttribute("error") %>
	     			<%
	     				request.getSession().setAttribute("error", null);
	     			%>
	     		</div>
     		<% } %>
      	</div>
	</body>
</html>