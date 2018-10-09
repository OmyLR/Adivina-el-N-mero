package utiles;

public class Utiles {
	
	
	public Utiles() {}
	
	public static boolean mayorQue(int numA, int numB) {
		return numA > numB;
	}
	
	public static boolean controlarNumeros(String numA, String numB) {
		
		if(numA.trim() == null || numB.trim() == null) {
			throw new Error("No has insertado un número$/");
		}
		try {
			int a = Integer.parseInt(numA);
			int b = Integer.parseInt(numB);
		}catch(NumberFormatException e) {
			throw new Error("Has insertado algo que no es un número$/");
		}
		return true;
	}
}
