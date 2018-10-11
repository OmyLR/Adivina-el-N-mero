package controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utiles.Utiles;
import modelos.Comparacion;
import modelos.Estado;
import modelos.Intento;
import modelos.Partidas;

/**
 * Servlet implementation class Jugar
 */
@WebServlet("/Jugar")
public class GameManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Juego juego = (Juego)request.getSession().getAttribute("partida");
		try {
			if(juego == null) {
				inicio(request,response);
				
			} else {
				jugar(request, response, juego);
			}
		} catch(Error e) {
			String[] err = e.getMessage().split("\\$");
			mostrarError(response, request, err[0], err[1]);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void mostrarError(HttpServletResponse response, HttpServletRequest request, String err, String ruta) throws IOException{
		request.getSession().setAttribute("error", err);
		response.sendRedirect(ruta);
	}
	
	private void crearPartida(HttpServletRequest request, int min, int max) {
		Juego admin = new Juego(min, max, 6);
		/*Intento intento = new Intento();
		intento.setnIntento(1);
		intento.setnSeleccionado(2);
		intento.setResult(Comparacion.Igual);
		admin.getIntentos().add(intento);
		Partidas partida = new Partidas();
		partida.setEstado(Estado.Ganador);
		partida.setnIntentos(2);
		partida.setnPartida(1);
		partida.setRespuesta(admin.getAleatorio());
		admin.getHistorial().add(partida);
		admin.setSolucion(true);
		admin.setPista(true);*/
		request.getSession().setAttribute("partida", admin);
	}
	
	private void inicio(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String min =  request.getParameter("min");
		String max = request.getParameter("max");
		
			if(Utiles.controlarNumeros(min, max, "/Juego")) {
				crearPartida(request, Integer.parseInt(min), Integer.parseInt(max));
				response.sendRedirect("partida");
			}
	}
	
	private void jugar(HttpServletRequest request, HttpServletResponse response, Juego juego) throws IOException {
		String ruta ="partida";
		String accion = (String) request.getParameter("accion");
		String pista = request.getParameter("pista");
		String solucion = request.getParameter("solucion");
		switch(accion) {
			case "jugar":
				String numPlayer = request.getParameter("numPlayer");
				if(pista != null && pista.equals("on")) {
					juego.setPista(true);
				} else {
					juego.setPista(false);
				}
				if(solucion != null && solucion.equals("on")) {
					juego.setSolucion(true);
				}else {
					juego.setSolucion(false);
				}
				if(Utiles.controlarNumeros(numPlayer, "0", "partida")) {
					juego.jugar(Integer.parseInt(numPlayer));
					response.sendRedirect("partida");
				}
				break;
			case "reiniciar":
				juego.reiniciar();
				response.sendRedirect("partida");
				break;
			case "nueva":
				String min =  request.getParameter("min");
				String max = request.getParameter("max");
				if(Utiles.controlarNumeros(min, max, "/Juego")) {
					juego.nuevaPartida(Integer.parseInt(min), Integer.parseInt(max));
					response.sendRedirect("partida");
				}
				
				break;
		}
	}

}
