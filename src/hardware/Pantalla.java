package hardware;

public class Pantalla {

	private int pPulgadas;
	private String pMensaje;
	
	public Pantalla(int pPulgadas) {
		setPPulgadas(pPulgadas);
		setPMensaje("");
	}
	
	public int getPPulgadas() {
		return pPulgadas;
	}

	public void setPPulgadas(int pPulgadas) {
		this.pPulgadas = pPulgadas;
	}
	
	public void getPMensaje() {
		System.out.println("\n" + pMensaje);
	}
	
	public void getPMensaje(int n) {
		System.out.println(pMensaje);
	}

	public void setPMensaje(String pMensaje) {
		this.pMensaje = pMensaje;
	}
	
	public void mostrarPMensaje(String pMensaje) {
		setPMensaje(pMensaje);
		getPMensaje();
	}
	
	public void mostrarPMensaje(String pMensaje, int n) {
		setPMensaje(pMensaje);
		getPMensaje(n);
	}

}
