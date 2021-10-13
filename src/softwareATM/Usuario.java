package softwareATM;

import miscellaneous.*;

public class Usuario {

	private String uNombre;
	private String uApellido;
	private int uDni;
	private Fecha uFechaNacimiento;
	private Direccion uDireccion;
	private Cuenta uCuenta;
	
	public Usuario(String uNombre, String uApellido, int uDni, Fecha uFechaNacimiento, 
			Direccion uDireccion, Cuenta uCuenta) {
		
		setUNombre(uNombre);
		setUApellido(uApellido);
		setUDni(uDni);
		setUFechaNacimiento(uFechaNacimiento);
		setUDireccion(uDireccion);
		setUCuenta(uCuenta);
	}
	
	public String getUNombre() {
		return uNombre;
	}

	public void setUNombre(String uNombre) {
		this.uNombre = uNombre;
	}

	public String getUApellido() {
		return uApellido;
	}

	public void setUApellido(String uApellido) {
		this.uApellido = uApellido;
	}

	public int getUDni() {
		return uDni;
	}

	public void setUDni(int uDni) {
		this.uDni = uDni;
	}

	public Fecha getUFechaNacimiento() {
		return uFechaNacimiento;
	}

	public void setUFechaNacimiento(Fecha uFechaNacimiento) {
		this.uFechaNacimiento = uFechaNacimiento;
	}

	public Direccion getUDireccion() {
		return uDireccion;
	}

	public void setUDireccion(Direccion uDireccion) {
		this.uDireccion = uDireccion;
	}

	public Cuenta getUCuenta() {
		return uCuenta;
	}

	public void setUCuenta(Cuenta uCuenta) {
		this.uCuenta = uCuenta;
	}
	
	public String toString() {
		
		return 	"Nombre: " + getUNombre() + 
				"\nApellido: " + getUApellido() +	
				"\nDNI: " + getUDni() + 
				"\nFecha de Nacimiento: " + getUFechaNacimiento() +
				"\nDirección: " + getUDireccion()+
				"\nCuenta: " + getUCuenta();
		
	}
	
}
