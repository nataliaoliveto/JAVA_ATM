package hardware;

import java.util.Scanner;

public class Teclado {
	
	// El array de teclas es static ya que pertenece a la clase y no cambia su valor por instancia.
	private static int [] teTeclas = new int [10];
	private String teMaterial;
	private Scanner teScanner; 

	public Teclado(String teMaterial) {
		setTEMaterial(teMaterial);
		teScanner = new Scanner(System.in);
	}

	public int[] getTETeclas() {
		return teTeclas;
	}

	public void setTETeclas() {
		// Creamos el array de teclas con los números del 0 al 9.
		for (int i = 0; i < teTeclas.length; i++) {
			teTeclas[i] = i;
		}
	}

	public String getTEMaterial() {
		return teMaterial;
	}

	public void setTEMaterial(String teMaterial) {
		this.teMaterial = teMaterial;
	}

	public int recibirDatos() {
		
		int dato = 0;
		boolean error = true;
		
		// Al trabajar con teclado, se debe asegurar que no se ingresen letras.
	    while (error) {
	    	
	    	// Validamos que haya ingresado un número.
	        if (teScanner.hasNextInt()) {
	        	dato = teScanner.nextInt();
	        
	        } else { // No ingresó un número. Mostramos mensaje de error y solicitamos el ingreso de un número.
	        	
	        	System.out.println("Por favor, ingrese sólo números.");
	        	teScanner.next();
	            continue;
	        }	   
	        
	        error = false;
	    }
		
	    return dato;
	}
	
}
