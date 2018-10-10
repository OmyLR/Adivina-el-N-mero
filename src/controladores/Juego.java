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
	private boolean pista, solucion;
	
	public Juego(int numA, int numB, int oportunidades) {
		this.numA = numA;
		this.numB = numB;
		this.oportunidades = oportunidades;
		generarAleatorio();
		intentos = new ArrayList<Intento>();
		historial = new ArrayList<Partidas>();
		this.partidaAct = Estado.Jugando;
		this.pista = false;
		this.solucion = false;
	}
	
	
	public void jugar(int num) {
		if(intentos.size() <= oportunidades && this.partidaAct == Estado.Jugando) {
			intento(num);
		}
	}
	
	private void intento(int num) {
		if(Utiles.mayorQue(num, this.aleatorio)) {
			insertarIntento(num, Comparacion.Mayor);
		} else if (Utiles.mayorQue(this.aleatorio, num)){
			insertarIntento(num, Comparacion.Menor);
		} else {;
			insertarIntento(num, Comparacion.Igual);
			ganar();
		}
		if(intentos.size() == oportunidades) {
			perder();
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
	
	public void nuevaPartida() {
		generarAleatorio();
		this.partidaAct = Estado.Jugando;
		this.intentos = new ArrayList<Intento>();
		this.pista = false;
		this.solucion = false;
	}
	
	private void ganar() {
		this.partidaAct = Estado.Ganador;
		insertarPartida();
		nuevaPartida();
	}
	
	private void perder() {
		this.partidaAct = Estado.Perdedor;
		insertarPartida();
		nuevaPartida();
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


	public int getAleatorio() {
		return aleatorio;
	}


	public void setAleatorio(int aleatorio) {
		this.aleatorio = aleatorio;
	}


	public Estado getPartidaAct() {
		return partidaAct;
	}


	public void setPartidaAct(Estado partidaAct) {
		this.partidaAct = partidaAct;
	}


	public boolean isPista() {
		return pista;
	}


	public void setPista(boolean pista) {
		this.pista = pista;
	}


	public boolean isSolucion() {
		return solucion;
	}


	public void setSolucion(boolean solucion) {
		this.solucion = solucion;
	}
	
	public String mostrarPista() {
		if(Utiles.mayorQue(aleatorio, (int) (this.numB/2))) {
			return " El número es mayor que "+(this.numB/2);
		}
		return "El número es menor que "+(this.numB/2);
	}
	
	public String generarAviso() {
		String aviso = "";
		if(intentos.size() > 0) {
			switch(intentos.get(intentos.size()-1).getResult()){
				case Mayor:
					aviso = "El número ingresado es mayor";
					break;
				case Menor: 
					aviso = "El número ingresado es menor";
					break;
				case Igual: 
					aviso = "Felicitaciones Has Acertado!!";
					break;
			}
		}
		
		return aviso;
	}
	
}
