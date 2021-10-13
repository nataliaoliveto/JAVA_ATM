package softwareATM;

public class Cuenta {

	private int cNro;
	private int cNip;
	private String cTipo;
	private String cMoneda;
	private double cSaldo;
	private boolean cBloqueada;
	
	public Cuenta(int cNro, int cNip, String cTipo, String cMoneda, double cSaldo) {
				
		setCNro(cNro);
		setCNip(cNip);
		setCTipo(cTipo);
		setCMoneda(cMoneda);
		setCSaldo(cSaldo);
		setCBloqueada(false);		
	}
	
	public int getCNro() {
		return cNro;
	}

	public void setCNro(int cNro) {
		
		// Validamos que el N�mero de Cuenta sea un entero de cinco d�gitos.
		if (cNro >= 10000 && cNro <= 99999) {
			
			this.cNro = cNro;
		
		} else {	// El N�mero de Cuenta NO es un entero de cinco d�gitos.
			throw new IllegalArgumentException("El N�mero de Cuenta debe ser un entero de cinco d�gitos.");
		}	
	}

	public int getCNip() {
		return cNip;
	}

	public void setCNip(int cNip) {
		
		// Validamos que el NIP sea un entero de cinco d�gitos.
		if (cNip >= 10000 && cNip <= 99999) {
			
			this.cNip = cNip;
			
		} else {	// El NIP NO es un entero de cinco d�gitos.
			throw new IllegalArgumentException("El NIP debe ser un entero de cinco d�gitos.");
		}	
	}

	public String getCTipo() {
		return cTipo;
	}

	public void setCTipo(String cTipo) {
		this.cTipo = cTipo;
	}

	public String getCMoneda() {
		return cMoneda;
	}

	public void setCMoneda(String cMoneda) {
		this.cMoneda = cMoneda;
	}

	public double getCSaldo() {
		return cSaldo;
	}

	public void setCSaldo(double cSaldo) {
		this.cSaldo = cSaldo;
	}

	public boolean getCBloqueada() {
		return cBloqueada;
	}

	public void setCBloqueada(boolean cBloqueada) {
		this.cBloqueada = cBloqueada;
	}
	
	public String toString() {
		return 	"N�mero: " + getCNro() + 
				"\nNIP: " + getCNip() + 
				"\nTipo: " + getCTipo() + 
				"\nMoneda: " + getCMoneda() +
				"\nSaldo : " + getCSaldo() +
				"\nBloqueada: " + getCBloqueada();
	}
	
}
