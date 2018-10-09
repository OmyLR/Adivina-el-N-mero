package controladores;

import modelos.Comparacion;
import modelos.Estado;
import modelos.Intento;
import modelos.Partidas;
import utiles.Utiles;

import java.util.ArrayList;

public class Juego {
	private int numA, numB;
	private int aleatorio;
	private int oportunidades;
	private ArrayList<Intento> intentos;
	private ArrayList<Partidas> historial;
	private Estado partidaAct;
	
	public Juego(int numA, int numB, int oportunidades) {
		this.numA = numA;
		this.numB = numB;
		this.oportunidades = oportunidades;
		generarAleatorio();
		intentos = new ArrayList<Intento>();
		historial = new ArrayList<Partidas>();
		this.partidaAct = Estado.Jugando;
	}
	
	public void jugar(int num) {
		switch(partidaAct){
			case Jugando:
				intento(num);
				break;
			case Perdedor:
				perder();
				break;
			case Ganador:
				ganar();
				break;
		}
	}
	
	private void intento(int num) {
		if(Utiles.mayorQue(num, this.aleatorio)) {
			insertarIntento(num, Comparacion.Mayor);
		} else if (Utiles.mayorQue(this.aleatorio, num)){
			insertarIntento(num, Comparacion.Menor);
		} else {
			insertarIntento(num, Comparacion.Igual);
		}
	}
	
	private void insertarIntento(int num, Comparacion comp) {
		Intento intento = new Intento();
		intento.setnIntento(this.intentos.size()+1);
		intento.setnSeleccionado(num);
		intento.setResult(comp);
		intentos.add(intento);
	}
	
	public void reiniciar() {
		generarAleatorio();
		this.partidaAct = Estado.Jugando;
		this.intentos = new ArrayList<Intento>();
		this.historial = new ArrayList<Partidas>();
	}
	
	public void nuevaPartida(int numA, int numB) {
		generarAleatorio();
		this.partidaAct = Estado.Jugando;
		this.intentos = new ArrayList<Intento>();
	}
	
	private void ganar() {
		this.partidaAct = Estado.Ganador;
		insertarPartida();
	}
	
	private void perder() {
		this.partidaAct = Estado.Perdedor;
		insertarPartida();
	}
	
	private void insertarPartida() {
		Partidas partida = new Partidas();
		partida.setnIntentos(this.intentos.size());
		partida.setEstado(this.partidaAct);
		partida.setRespuesta(this.aleatorio);
		partida.setnPartida(historial.size()+1);
		historial.add(partida);
	}
	
	private void generarAleatorio() {
		this.aleatorio = (int)(Math.random()*numB)+numA;
	}

	public int getNumA() {
		return numA;
	}

	public void setNumA(int numA) {
		this.numA = numA;
	}

	public int getNumB() {
		return numB;
	}

	public void setNumB(int numB) {
		this.numB = numB;
	}

	public int getOportunidades() {
		return oportunidades;
	}

	public void setOportunidades(int oportunidades) {
		this.oportunidades = oportunidades;
	}

	public ArrayList<Intento> getIntentos() {
		return intentos;
	}

	public void setIntentos(ArrayList<Intento> intentos) {
		this.intentos = intentos;
	}

	public ArrayList<Partidas> getHistorial() {
		return historial;
	}

	public void setHistorial(ArrayList<Partidas> historial) {
		this.historial = historial;
	}
	
	
}
