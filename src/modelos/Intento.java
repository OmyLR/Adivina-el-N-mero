package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Intento {
	private LocalDateTime fecha;
	private int nIntento;
	private int nSeleccionado;
	private Comparacion result;
	
	public Intento() {
		this.fecha = LocalDateTime.parse(new Date().toString(), DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss"));
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public int getnIntento() {
		return nIntento;
	}

	public void setnIntento(int nIntento) {
		this.nIntento = nIntento;
	}

	public int getnSeleccionado() {
		return nSeleccionado;
	}

	public void setnSeleccionado(int nSeleccionado) {
		this.nSeleccionado = nSeleccionado;
	}

	public Comparacion getResult() {
		return result;
	}

	public void setResult(Comparacion result) {
		this.result = result;
	}
	
	
}
