package modelos;

public class Partidas {
	private int nIntentos;
	private int nPartida;
	private int respuesta;
	private Estado estado;
	
	public Partidas() {}

	public int getnIntentos() {
		return nIntentos;
	}

	public void setnIntentos(int nIntentos) {
		this.nIntentos = nIntentos;
	}

	public int getnPartida() {
		return nPartida;
	}

	public void setnPartida(int nPartida) {
		this.nPartida = nPartida;
	}

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
