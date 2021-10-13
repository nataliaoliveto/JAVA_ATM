package miscellaneous;

public class Direccion {

	private String dCalle;
	private int dNumero;
	private char dDepartamento;
	private int dPiso;
	private int dCodigoPostal;
	private String dLocalidad;
	private String dProvincia;
	
	public Direccion(String dCalle, int dNumero, char dDepartamento, int dPiso, int dCodigoPostal,
			String dLocalidad, String dProvincia){
		
		setDCalle(dCalle);
		setDNumero(dNumero);
		setDDepartamento(dDepartamento);
		setDPiso(dPiso);
		setDCodigoPostal(dCodigoPostal);
		setDLocalidad(dLocalidad);
		setDProvincia(dProvincia);
	}
	
	public Direccion(String dCalle, int dNumero, int dCodigoPostal, 
			String dLocalidad, String dProvincia){
		
		setDCalle(dCalle);
		setDNumero(dNumero);
		setDDepartamento('-');
		setDPiso(0);
		setDCodigoPostal(dCodigoPostal);
		setDLocalidad(dLocalidad);
		setDProvincia(dProvincia);
	}

	public String getDCalle() {
		return dCalle;
	}

	public void setDCalle(String dCalle) {
		this.dCalle = dCalle;
	}

	public int getDNumero() {
		return dNumero;
	}

	public void setDNumero(int dNumero) {
		this.dNumero = dNumero;
	}

	public char getDDepartamento() {
		return dDepartamento;
	}

	public void setDDepartamento(char dDepartamento) {
		this.dDepartamento = dDepartamento;
	}

	public int getDPiso() {
		return dPiso;
	}

	public void setDPiso(int dPiso) {
		this.dPiso = dPiso;
	}

	public int getDCodigoPostal() {
		return dCodigoPostal;
	}

	public void setDCodigoPostal(int dCodigoPostal) {
		this.dCodigoPostal = dCodigoPostal;
	}

	public String getDLocalidad() {
		return dLocalidad;
	}

	public void setDLocalidad(String dLocalidad) {
		this.dLocalidad = dLocalidad;
	}

	public String getDProvincia() {
		return dProvincia;
	}

	public void setDProvincia(String dProvincia) {
		this.dProvincia = dProvincia;
	}
	
	public String toString() {
		return 	"Calle: " + getDCalle() + 
				"\nNúmero: " + getDNumero() + 
				"\nDepartamento: " + getDDepartamento() +
				"\nPiso: " + getDPiso() + 
				"\nCódigo Postal: " + getDCodigoPostal() +
				"\nLocalidad : " + getDLocalidad() +
				"\nProvincia: " + getDProvincia(); 
		
	}

}
