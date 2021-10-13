package hardware;

public class Dispensador {

	private int dEfectivo;
	
	public Dispensador() {
		setDEfectivo(10000); // Comienza cada día cargado con 500 billetes de $20.
	}

	public int getDEfectivo() {
		return dEfectivo;
	}

	public void setDEfectivo(int dEfectivo) {
		this.dEfectivo = dEfectivo;
	}
	
	public void entregarEfectivo(int importe) {
		setDEfectivo(getDEfectivo() - importe);
	}
	
	public void recibirEfectivo(int importe) {
		setDEfectivo(getDEfectivo() + importe);
	}

}
