package softwareATM;

import java.util.ArrayList;
import miscellaneous.Direccion;

public class Banco {

	private ArrayList<Usuario> bBaseDeDatos = new ArrayList<Usuario>();
	private String bNombre;
	private String bCuit;
	private Direccion bDireccion;
	private int bTelefono;
	private Atm bAtm;
	
	public Banco(String bNombre, String bCuit, Direccion bDireccion, int bTelefono,
			ArrayList<Usuario> bBaseDeDatos) {
		
		setBNombre(bNombre);
		setBCuit(bCuit);
		setBDireccion(bDireccion);
		setBTelefono(bTelefono);
		setBBaseDeDatos(bBaseDeDatos);
	}

	public String getBNombre() {
		return bNombre;
	}

	public void setBNombre(String bNombre) {
		this.bNombre = bNombre;
	}

	public String getBCuit() {
		return bCuit;
	}

	public void setBCuit(String bCuit) {
		this.bCuit = bCuit;
	}
	
	public Direccion getBDireccion() {
		return bDireccion;
	}

	public void setBDireccion(Direccion bDireccion) {
		this.bDireccion = bDireccion;
	}

	public int getBTelefono() {
		return bTelefono;
	}

	public void setBTelefono(int bTelefono) {
		this.bTelefono = bTelefono;
	}
	
	public Atm getBAtm() {
		return bAtm;
	}	

	public void setBAtm(Atm bAtm) {
		this.bAtm = bAtm;
	}
	
	public ArrayList<Usuario> getBBaseDeDatos() {
		return bBaseDeDatos;
	}	

	public void setBBaseDeDatos(ArrayList<Usuario> bBaseDeDatos) {
		this.bBaseDeDatos = bBaseDeDatos;
	}

	public String toString(){
		return 	"Nombre: " + getBNombre() + 
				"\nCUIT: " + getBCuit() +	
				"\nDirección: " + getBDireccion() + 
				"\nTeléfono: " + getBTelefono();
	}
	
}
