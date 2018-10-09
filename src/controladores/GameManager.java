package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utiles.Utiles;

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
		Juego juego = (Juego)request.getSession().getAttribute("Partida");
		if(juego == null) {
			String min =  request.getParameter("min");
			String max = request.getParameter("max");
			try {
				if(Utiles.controlarNumeros(min, max)) {
					
				}
			} catch(Error e) {
				String[] err = e.getMessage().split("$");
				mostrarError(response, err[0], err[1]);
			}
		} else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void mostrarError(HttpServletResponse response, String err, String ruta) throws IOException{
		response.sendRedirect(ruta);
	}

}
